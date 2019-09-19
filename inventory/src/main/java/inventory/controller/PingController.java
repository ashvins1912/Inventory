package inventory.controller;

import inventory.dao.InventoryDao;
import inventory.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    @Autowired
    private InventoryDao inventoryDao;


    @GetMapping(value = "/ping")
    ResponseEntity<Product> ping(@RequestParam("id") Integer id) {
        Product product = new Product();
        product.setId(id);
        Product daoProduct = inventoryDao.getProduct(product);
        return ResponseEntity.ok(daoProduct);
    }

}
