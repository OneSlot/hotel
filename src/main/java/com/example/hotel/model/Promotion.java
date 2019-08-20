package com.example.hotel.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Promotion  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String seasonal;

    private String packagePromotion;

    //percent
    private double discount;

    private String service;

       public Promotion(){

       }

    public Promotion(String seasonal, String packagePromotion, double discount, String service) {
        this.seasonal = seasonal;
        this.packagePromotion = packagePromotion;
        this.discount = discount;
        this.service = service;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSeasonal() {
        return seasonal;
    }

    public void setSeasonal(String seasonal) {
        this.seasonal = seasonal;
    }

    public String getPackagePromotion() {
        return packagePromotion;
    }

    public void setPackagePromotion(String packagePromotion) {
        this.packagePromotion = packagePromotion;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
}
