package product.services;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import product.dao.ProductRepository;
import product.model.ProductModel;


@Service
public class ProductAddServices extends ServiceHandler<ProductModel,String> {

     final ProductRepository repository;
    ProductAddServices(ProductRepository repository,@Qualifier("validator")AddProductValidator addProductValidator){
        super(addProductValidator);
        this.repository=repository;
    }

    @Override
    protected String handleException(Exception ex) {
        logger.info("Error Caused By",ex.getCause());

        logger.info("Error Caused By",ex.getMessage());

        return "failure";
    }

    @Override
    protected String handle(ProductModel request) throws Exception {
         repository.addProduct(request);
         return "success";
    }
}
