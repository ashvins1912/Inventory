package product.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import product.common.ProductModel;


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
