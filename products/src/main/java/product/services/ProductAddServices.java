package product.services;

import org.springframework.beans.factory.annotation.Autowired;
import product.dao.ProductRepository;
import product.model.ProductModel;

public class ProductAddServices extends ServiceHandler<ProductModel,String> {

     final ProductRepository repository;
    ProductAddServices(ProductRepository repository,AddProductValidator addProductValidator){
        super(addProductValidator);
        this.repository=repository;
    }

    @Override
    protected String handleException(Exception ex) {
        return "failure";
    }

    @Override
    protected String handle(ProductModel request) throws Exception {
         repository.addProduct(request);
         return "success";
    }
}
