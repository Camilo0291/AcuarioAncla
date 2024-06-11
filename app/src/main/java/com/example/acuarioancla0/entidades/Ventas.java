package com.example.acuarioancla0.entidades;

public class Ventas {
    private int saleId;
    private String saleDate;
    private double saleTotal;
    private String salePayMethod;
    private int saleIdUser;
    private int saleIdCustomer;

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public double getSaleTotal() {
        return saleTotal;
    }

    public void setSaleTotal(double saleTotal) {
        this.saleTotal = saleTotal;
    }

    public String getSalePayMethod() {
        return salePayMethod;
    }

    public void setSalePayMethod(String salePayMethod) {
        this.salePayMethod = salePayMethod;
    }

    public int getSaleIdUser() {
        return saleIdUser;
    }

    public void setSaleIdUser(int saleIdUser) {
        this.saleIdUser = saleIdUser;
    }

    public int getSaleIdCustomer() {
        return saleIdCustomer;
    }

    public void setSaleIdCustomer(int saleIdCustomer) {
        this.saleIdCustomer = saleIdCustomer;
    }
}
