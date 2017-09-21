package com.app.eateapplication.model;

/**
 * Created by best tech on 9/7/2017.
 */

public class Food {

    private String Name;
    private String Image;
    private String Description;
    private String Price;
    private String discount;
    private String MenuId;

    public Food() {
    }

    public Food(String name, String image, String description, String price, String discount, String menuId) {
        Name = name;
        Image = image;
        Description = description;
        Price = price;
        this.discount = discount;
        MenuId = menuId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getMenuId() {
        return MenuId;
    }

    public void setMenuId(String menuId) {
        MenuId = menuId;
    }
}
