package inventory.model;

public class Inventory {
    private Integer id;
    private Integer inventoryId;
    private Integer productId;
    private Integer purchasedPrice;
    private Integer sellingPrice;
    private String inventoryStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getPurchasedPrice() {
        return purchasedPrice;
    }

    public void setPurchasedPrice(Integer purchasedPrice) {
        this.purchasedPrice = purchasedPrice;
    }

    public Integer getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Integer sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getInventoryStatus() {
        return inventoryStatus;
    }

    public void setInventoryStatus(String inventoryStatus) {
        this.inventoryStatus = inventoryStatus;
    }
}
