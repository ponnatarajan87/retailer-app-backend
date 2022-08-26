package com.retailerapp.model;

import lombok.Data;

@Data
public class CustomerTransaction {
    private String customerName;
    private String transactionDate;
    private int price;
    private int rewardPoints;
}
