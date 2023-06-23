package com.example.ShoppingApplication;

public class Product {
    private int id;
    private String name;
    private String category;
    private String type;
    private int weight;

    public Product(int id, String name, String category, String type, int weight) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.type = type;
        this.weight = weight;
    }

    public Product() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
