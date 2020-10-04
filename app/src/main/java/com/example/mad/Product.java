package com.example.mad;

public class Product {

    private String pid;
    private String name;
    private Integer price;
    private String sizes;
    private String colors;

    public Product() {
    }

    public Product(String pid, String name, Integer price, String sizes, String colors) {
        this.pid = pid;
        this.name = name;
        this.price = price;
        this.sizes = sizes;
        this.colors = colors;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public String getSizes() {
        return sizes;
    }

    public void setSizes(String sizes) {
        this.sizes = sizes;
    }
}
