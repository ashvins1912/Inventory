package product.services;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import product.common.ProductModel;
import product.dao.ProductRepository;

@Service
public class AddProductService  extends ServiceHandler<ProductModel,String>{

    final ProductRepository repository;
    AddProductService(ProductRepository repository){
        this.repository=repository;
    }

    @Override
    protected String handleException(Exception ex) {
        logger.info("Error Caused By",ex.getCause());

        logger.info("Error Caused By",ex.getMessage());
        //need to throw custom exceptions
        return "failure";
    }

    @Override
    @Transactional
    protected String handle(ProductModel request)  {
        repository.addProduct(request);
        return "success";
    }
}
