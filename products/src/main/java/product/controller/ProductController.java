package product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import product.model.ProductModel;
import product.services.ProductAddServices;

@RestController
public class ProductController {

    @Autowired
    ProductAddServices addservice;

    @GetMapping(value = "/hello")
    ResponseEntity<String> getFirstCall() {
        return ResponseEntity.ok("Hello product");
    }

    @PostMapping (value = "/add")
    ResponseEntity<String> addProduct(@RequestBody ProductModel productModel){
        return ResponseEntity.ok(addservice.handleRequest(productModel));
    }

}
