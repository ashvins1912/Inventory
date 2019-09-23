package inventory.controller;

import inventory.model.Inventory;
import inventory.model.Product;
import inventory.service.InventoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/available-stock/{productId}/{quantity}")
    public ResponseEntity getAvailableStock(@PathVariable("productId") Integer prodductId,
        @PathVariable("quantity") Integer quantity) {
        Product product = new Product();
        product.setId(prodductId);
        product.setQuantity(quantity);
        List<Inventory> availableInventory = inventoryService.fetchAvailableInventory(product);
        if(CollectionUtils.isEmpty(availableInventory) || availableInventory.size() < quantity) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Stock Quantity not available");
        }
        return ResponseEntity.status(HttpStatus.OK).body(availableInventory);
    }

    @PostMapping("/insert")
    public ResponseEntity insertInventory(@RequestBody List<Inventory> listOfInventories) {
        try {
            inventoryService.insertInventory(listOfInventories);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(ex.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body("Sucess");
    }

    @PostMapping("/update")
    public ResponseEntity updateInventory(@RequestBody  Inventory  inventory) {
        try {
            inventoryService.udpateInventory(inventory);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(ex.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body("Sucess");
    }

}
