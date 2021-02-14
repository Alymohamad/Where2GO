package com.example.springboot.models;

public class Location {

    private String name;
    private String type;
    private String address;
    private Double latitude;
    private Double longitude;
    private int ratingsNum;
    private float rating;
    private boolean openNow;

    public Location(){
    }
    public Location(String name, String address, Double latitude, Double longitude, int ratingsNum, float rating, boolean openNow, String type) {
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.ratingsNum = ratingsNum;
        this.rating = rating;
        this.type = type;
        this.openNow = openNow;
        //API Key nicht schocken als konstante dort einfach machen oder eigene endpoint get apikey machen
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public int getRatingsNum() {
        return ratingsNum;
    }

    public void setRatingsNum(int ratingsNum) {
        this.ratingsNum = ratingsNum;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isOpenNow() {
        return openNow;
    }

    public void setOpenNow(boolean openNow) {
        this.openNow = openNow;
    }

    @Override
    public String toString() {
        return "LocationResponse{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", adress='" + address + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", ratingsNum=" + ratingsNum +
                ", rating=" + rating +
                ", openNow=" + openNow +
                '}';
    }
}

