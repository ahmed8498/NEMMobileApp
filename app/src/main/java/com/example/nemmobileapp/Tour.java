package com.example.nemmobileapp;

public class Tour {
    int tourID;
    String tourName;
    String tourLocation;
    int tourTotalTickets;
    double ticketPrice;
    String image;


    public Tour(int tourID, String tourName, String tourLocation, int tourTotalTickets, double ticketPrice, String image) {
        this.tourID = tourID;
        this.tourName = tourName;
        this.tourLocation = tourLocation;
        this.tourTotalTickets = tourTotalTickets;
        this.ticketPrice = ticketPrice;
        this.image = image;
    }

    public int getTourID() {
        return tourID;
    }

    public void setTourID(int tourID) {
        this.tourID = tourID;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public String getTourLocation() {
        return tourLocation;
    }

    public void setTourLocation(String tourLocation) {
        this.tourLocation = tourLocation;
    }

    public int getTourTotalTickets() {
        return tourTotalTickets;
    }

    public void setTourTotalTickets(int tourTotalTickets) {
        this.tourTotalTickets = tourTotalTickets;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
