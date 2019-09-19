package inventory.controller;

import inventory.model.Inventory;
import inventory.service.InventoryService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/insert")
    public ResponseEntity<Boolean> insertInventory() {
        List<Inventory> inventoryList = new ArrayList<>();

        Inventory inventory = new Inventory();
        inventory.setInventoryId(123);
        inventory.setProductId(1);
        inventory.setPurchasedPrice(30);
        inventory.setSellingPrice(25);
        inventory.setInventoryStatus("Available");
        inventoryList.add(inventory);
        Boolean inserted = inventoryService.insertInventory(inventoryList);

        return ResponseEntity.ok(inserted);
    }

}
