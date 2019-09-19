package inventory.dao;

import inventory.model.Product;

public interface ProductDao {

    int updateProductQuantity(Product product);

}
