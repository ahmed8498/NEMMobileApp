package com.example.nemmobileapp;

public class Car {

    private int ID;
    private String brand;
    private String model;
    private double pricePerDay;
    private int isTaken;
    private String imageURL;


    public Car(int ID, String brand, String model, double pricePerDay, int isTaken,String imageURL) {
        this.ID = ID;
        this.brand = brand;
        this.model = model;
        this.pricePerDay = pricePerDay;
        this.isTaken = isTaken;
        this.imageURL = imageURL;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public int getIsTaken() {
        return isTaken;
    }

    public void setIsTaken(int isTaken) {
        this.isTaken = isTaken;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
