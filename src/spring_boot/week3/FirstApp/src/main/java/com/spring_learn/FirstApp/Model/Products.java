package com.spring_learn.FirstApp.Model;

public class Products {

    private int prodId;
    private String prodName;
    private int price;

    public Products(int prodId, String prodName,int price ) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.price = price;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
