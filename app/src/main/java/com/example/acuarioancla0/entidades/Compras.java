package com.example.acuarioancla0.entidades;

public class Compras {
    private int id;
    private String purchaseMethodPay;
    private String purchaseTotal;
    private String purchaseUserId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPurchaseMethodPay() {
        return purchaseMethodPay;
    }

    public void setPurchaseMethodPay(String purchaseMethodPay) {
        this.purchaseMethodPay = purchaseMethodPay;
    }

    public String getPurchaseTotal() {
        return purchaseTotal;
    }

    public void setPurchaseTotal(String purchaseTotal) {
        this.purchaseTotal = purchaseTotal;
    }


    public String getPurchaseUserId() {
        return purchaseUserId;
    }

    public void setPurchaseUserId(String purchaseUserId) {
        this.purchaseUserId = purchaseUserId;
    }
}
