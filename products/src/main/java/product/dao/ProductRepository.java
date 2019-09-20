package product.dao;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.statement.Update;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import product.common.ProductModel;
import product.model.QueryConstant;

import javax.sql.DataSource;

@Repository
public class ProductRepository {

    private final Jdbi jdbi;
    Logger log = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    public ProductRepository(@Qualifier("dataSource") final DataSource dataSource) {
        this.jdbi = Jdbi.create(dataSource);
    }


    public void addProduct(ProductModel productModel) {
        log.info("Storing ");
        try (Handle handle = jdbi.open(); Update update = handle.createUpdate(QueryConstant.ADDQUERY)) {
            update.bind(0, productModel.getProduct_name());
            update.bind(1, productModel.getProduct_brand());
            update.bind(2, productModel.getProduct_type());
            update.bind(3, productModel.getBest_before());
            update.bind(4, productModel.getProduct_mrp());
            update.bind(5, productModel.getSelling_price());
            update.bind(6, productModel.getProduct_quantity());
            update.execute();
            log.info("stored");
        }


    }

    public void updateProduct(ProductModel productModel) {
        log.info("Storing ");
        try (Handle handle = jdbi.open(); Update update = handle.createUpdate(QueryConstant.UPDATEQUERY)) {
            update.bind(0, productModel.getProduct_name());
            update.bind(1, productModel.getProduct_brand());
            update.bind(2, productModel.getProduct_type());
            update.bind(3, productModel.getBest_before());
            update.bind(4, productModel.getProduct_mrp());
            update.bind(5, productModel.getSelling_price());
            update.bind(6, productModel.getProduct_quantity());
            update.bind(7, productModel.getProduct_id());

            update.execute();
            log.info("stored");
        }


    }


}
