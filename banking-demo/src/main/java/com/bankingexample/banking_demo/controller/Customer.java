package com.bankingexample.banking_demo.controller;

import java.time.LocalDateTime;

public class Customer {
    //private Long id;
    private String name;
    private double balance;
    private String password;
    private String receivedFrom;
    private LocalDateTime receivedDate;
    private String transferredTo;
    private LocalDateTime transferredDate;

    public Customer() {
    }

    public Customer(String name, double balance, String password) {
        this.name = name;
        this.balance = balance;
        this.password=password;
    }
    public Customer(String name, double balance, String password, String receivedFrom, LocalDateTime receivedDate, String transferredTo, LocalDateTime transferredDate) {
        //this.id = id;
        this.password=password;
        this.name = name;
        this.balance = balance;
        this.receivedFrom = receivedFrom;
        this.receivedDate = receivedDate;
        this.transferredTo = transferredTo;
        this.transferredDate = transferredDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // public Long getId() {
    //     return id;
    // }   
    // public void setId(Long id) {
    //     this.id = id;
    // }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public String getReceivedFrom() {
        return receivedFrom;
    }
    public void setReceivedFrom(String receivedFrom) {
        this.receivedFrom = receivedFrom;
    }
    public LocalDateTime getReceivedDate() {
        return receivedDate;
    }
    public void setReceivedDate(LocalDateTime receivedDate) {
        this.receivedDate = receivedDate;
    }
    public String getTransferredTo() {
        return transferredTo;
    }
    public void setTransferredTo(String transferredTo) {
        this.transferredTo = transferredTo;
    }
    public LocalDateTime getTransferredDate() {
        return transferredDate;
    }
    public void setTransferredDate(LocalDateTime transferredDate) {
        this.transferredDate = transferredDate;
    }
}

