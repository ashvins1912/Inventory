package product.services;

import common.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ProductServices {

    @Autowired
    private   AddProductService addProductService;
    @Autowired
    private   UpdateProductService updateProduct;

    public String addProduct(ProductModel request) {
        return addProductService.handle(request);

    }

    public String updateProduct(ProductModel request) {
        return updateProduct.handle(request);

    }


}
