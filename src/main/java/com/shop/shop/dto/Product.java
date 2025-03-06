package com.shop.shop.dto;

public class Product {
    private String name;
    private String imageUrl;
    private long createdAt;
    private int id;
    private int price;

    public Product(String name, String imageUrl, int id, int price, long createdAt) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.id = id;
        this.price = price;
        this.createdAt = createdAt;
    }

    public Product() {
        super();
    }

    @Override
    public String toString() {
        return "Product [name=" + name + ", imageUrl=" + imageUrl + ", id=" + id + ", price=" + price + ", createdAt=" + createdAt + "]";
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }
}
