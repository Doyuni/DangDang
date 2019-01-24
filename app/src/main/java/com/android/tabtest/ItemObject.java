package com.android.tabtest;

public class ItemObject {
    private String image;
    private String name;
    private String price;
    private String link;

    public ItemObject(String image, String name, String price, String link) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.link = link;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
