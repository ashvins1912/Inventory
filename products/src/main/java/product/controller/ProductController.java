package product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import product.common.ProductModel;
import product.services.ProductServices;

@RestController
public class ProductController {

    @Autowired
    ProductServices addservice;

    @GetMapping(value = "/hello")
    ResponseEntity<String> getFirstCall() {
        return ResponseEntity.ok("Hello product");
    }

    @PostMapping (value = "/add")
    ResponseEntity<String> addProduct(@RequestBody ProductModel productModel){
        return ResponseEntity.ok(addservice.addProduct(productModel));
    }

    @PostMapping (value = "/update")
    ResponseEntity<String> updateProduct(@RequestBody  ProductModel productModel){
        return ResponseEntity.ok(addservice.updateProduct(productModel));
    }
}
