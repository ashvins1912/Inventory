package product.common;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

public class ProductModel {
    private int product_id;
    @NotNull
    private String product_name;
    @NotNull
    private String product_brand;
    @NotNull
    private String product_type;

    public ProductModel() {
    }

    @NotNull
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp best_before;
    @NotNull
    private Double product_mrp;
    @NotNull
    private Double selling_price;
    @NotNull
    private Integer product_quantity;

    public ProductModel(int product_id, String product_name, String product_brand, String product_type, String best_before, Double product_mrp, Double selling_price, Integer product_quantity, Integer user_id) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_brand = product_brand;
        this.product_type = product_type;

        this.product_mrp = product_mrp;
        this.selling_price = selling_price;
        this.product_quantity = product_quantity;
        this.user_id = user_id;
    }

    private Integer user_id;

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_brand() {
        return product_brand;
    }

    public void setProduct_brand(String product_brand) {
        this.product_brand = product_brand;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }



    public Double getProduct_mrp() {
        return product_mrp;
    }

    public Timestamp getBest_before() {
        return best_before;
    }

    public void setBest_before(Timestamp best_before) {
        this.best_before = best_before;
    }

    public void setProduct_mrp(Double product_mrp) {
        this.product_mrp = product_mrp;
    }

    public Double getSelling_price() {
        return selling_price;
    }

    public void setSelling_price(Double selling_price) {
        this.selling_price = selling_price;
    }

    public Integer getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(Integer product_quantity) {
        this.product_quantity = product_quantity;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
