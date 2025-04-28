package model;

public class item {
    private Integer itemCode;
    private String itemName;
    private Integer itemQty;
    private Double itemPrice;

    public item() {
    }

    public item(Integer itemCode, String itemName, Integer itemQty, Double itemPrice) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.itemQty = itemQty;
        this.itemPrice = itemPrice;
    }

    public Integer getItemCode() {
        return itemCode;
    }

    public void setItemCode(Integer itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getItemQty() {
        return itemQty;
    }

    public void setItemQty(Integer itemQty) {
        this.itemQty = itemQty;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public String toString() {
        return "item{" +
                "itemCode=" + itemCode +
                ", itemName='" + itemName + '\'' +
                ", itemQty=" + itemQty +
                ", itemPrice=" + itemPrice +
                '}';
    }
}
