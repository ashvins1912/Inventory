package product.model;

public class QueryConstant {

    public static final String ADDQUERY="INSERT INTO nokia_inventory.product (product_name,product_brand,product_type," +
            "best_before,product_mrp,selling_price,user_id) VALUES (?,?,?,?,?,?,?)";

    public static final String UPDATEQUERY="  UPDATE  nokia_inventory.product  SET product_name = ? ,product_brand = ? " +
            ",product_type = ? ,best_before = ? ,product_mrp = ? ,selling_price = ? ,user_id = ? where product_id = ?";

}
