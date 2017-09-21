package com.app.eateapplication.model;

/**
 * Created by best tech on 9/10/2017.
 */

public class Order {

    private String ProductId;
    private String ProducrName;
    private String Quantity;
    private String Price;
    private String Discount;

    public Order() {
    }

    public Order(String productId, String producrName, String quantity, String price, String discount) {
        ProductId = productId;
        ProducrName = producrName;
        Quantity = quantity;
        Price = price;
        Discount = discount;
    }

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String productId) {
        ProductId = productId;
    }

    public String getProducrName() {
        return ProducrName;
    }

    public void setProducrName(String producrName) {
        ProducrName = producrName;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }
}
