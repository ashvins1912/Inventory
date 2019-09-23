package product.services;

import common.model.ProductModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import product.dao.ProductRepository;
@Service
public class UpdateProductService extends ServiceHandler<ProductModel,String> {

    final ProductRepository repository;
    public UpdateProductService(ProductRepository repository){
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
        repository.updateProduct(request);
        return "success";
    }

}
