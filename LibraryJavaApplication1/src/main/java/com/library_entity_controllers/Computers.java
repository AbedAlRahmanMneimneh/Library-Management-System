package com.library_entity_controllers;

public class Computers {
    private int computerId;
    private String brand,processor,graphicsCard;
    private boolean available;
    private int branchId;

    public Computers(int computerId, String brand, String processor, String graphicsCard, boolean available, int branchId) {
        this.computerId = computerId;
        this.brand = brand;
        this.processor = processor;
        this.graphicsCard = graphicsCard;
        this.available = available;
        this.branchId = branchId;
    }

    public int getComputerId() {
        return computerId;
    }

    public void setComputerId(int computerId) {
        this.computerId = computerId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }
}
