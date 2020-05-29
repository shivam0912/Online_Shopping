package com.example.onlineshopping.ui.home;

public class HomeData {

    private String productName;
    private  String checkStock;
    private String price;
    public HomeData() {
    }

    public HomeData(String productName, String checkStock, String price) {
        this.productName = productName;
        this.checkStock = checkStock;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCheckStock() {
        return checkStock;
    }

    public void setCheckStock(String checkStock) {
        this.checkStock = checkStock;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
