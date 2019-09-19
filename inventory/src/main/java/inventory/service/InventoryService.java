package inventory.service;

import inventory.dao.InventoryDao;
import inventory.dao.ProductDao;
import inventory.model.Inventory;
import inventory.model.Product;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventoryService {

    @Autowired
    private InventoryDao inventoryDao;

    @Autowired
    private ProductDao productDao;

    @Transactional
    public boolean insertInventory(List<Inventory> inventoryList) {
        Map<Integer, Integer> map = new HashMap<>();
        if(inventoryDao.insertInventory(inventoryList) > 0) {
            inventoryList.forEach(inventory -> {
                if(map.containsKey(inventory.getProductId())) {
                    map.put(inventory.getProductId(), map.get(inventory.getProductId()) + 1);
                } else {
                    map.put(inventory.getProductId(), 1);
                }
            });
            map.keySet().forEach(key -> {
                Product product = new Product();
                product.setId(key);
                product.setQuantity(map.get(key));
                productDao.updateProductQuantity(product);
            });
            return true;
        } else return false;
    }
}
