package inventory.dao;

import inventory.model.Inventory;
import inventory.model.Product;
import java.util.Date;
import java.util.List;

public interface InventoryDao {

    Date getCurrentDate();

    Product getProduct(Product product);

    int insertInventory(List<Inventory> inventoryList);

    int udpateInventory(Inventory inventory);

}
