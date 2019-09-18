package product.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {
    private int product_id;
    private String product_name;
    private String product_brand;
    private String product_type;
    private String best_before;
    private Double product_mrp;
    private Double selling_price;
    private Integer product_quantity;
    private Integer user_id;

}
