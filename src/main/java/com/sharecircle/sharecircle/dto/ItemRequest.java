
package com.sharecircle.sharecircle.dto;

public class ItemRequest {

    private String name;
    private String description;
    private String category;
    private double price;
    private String condition;
    private String location;
    private String imageUrl;

    public ItemRequest() {
    }

    public ItemRequest(String name, String description,
                       String category, double price,
                       String condition, String location,
                       String imageUrl) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.condition = condition;
        this.location = location;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
