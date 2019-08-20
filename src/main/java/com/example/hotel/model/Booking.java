package com.example.hotel.model;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bookingNumber;
    private int numbersOfAdults;
    private int numberOfChildren;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fromStart;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate toend;
    private boolean bookingCancelled;
    private double inAdvance;
    private double fullCharges;


    public Booking(){

    }

    public Booking(String bookingNumber, int numbersOfAdults, int numberOfChildren, LocalDate from, LocalDate to, boolean bookingCancelled, double inAdvance, double fullCharges) {
        this.bookingNumber = bookingNumber;
        this.numbersOfAdults = numbersOfAdults;
        this.numberOfChildren = numberOfChildren;
        this.fromStart = from;
        this.toend = to;
        this.bookingCancelled = bookingCancelled;
        this.inAdvance = inAdvance;
        this.fullCharges = fullCharges;
    }

    @ManyToOne
   private UserProfile userProfile;





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public int getNumbersOfAdults() {
        return numbersOfAdults;
    }

    public void setNumbersOfAdults(int numbersOfAdults) {
        this.numbersOfAdults = numbersOfAdults;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setNumberOfChildren(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public LocalDate getFrom() {
        return fromStart;
    }

    public void setFrom(LocalDate from) {
        this.fromStart = from;
    }

    public LocalDate getTo() {
        return toend;
    }

    public void setTo(LocalDate to) {
        this.toend = to;
    }

    public boolean isBookingCancelled() {
        return bookingCancelled;
    }

    public void setBookingCancelled(boolean bookingCancelled) {
        this.bookingCancelled = bookingCancelled;
    }

    public double getInAdvance() {
        return inAdvance;
    }

    public void setInAdvance(double inAdvance) {
        this.inAdvance = inAdvance;
    }

    public double getFullCharges() {
        return fullCharges;
    }

    public void setFullCharges(double fullCharges) {
        this.fullCharges = fullCharges;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }



}
