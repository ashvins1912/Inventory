package inventory.controller;

import inventory.model.Inventory;
import inventory.service.InventoryService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/insert")
    public ResponseEntity insertInventory(@RequestBody List<Inventory> listOfInventories) {
        Boolean inserted = false;
        try {
            inserted = inventoryService.insertInventory(listOfInventories);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(ex.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body("Sucess");
    }

    @PostMapping("/update")
    public ResponseEntity updateInventory(@RequestBody  Inventory  inventory) {
        Boolean updated = false;
        try {
            updated = inventoryService.udpateInventory(inventory);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(ex.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body("Sucess");
    }

}
