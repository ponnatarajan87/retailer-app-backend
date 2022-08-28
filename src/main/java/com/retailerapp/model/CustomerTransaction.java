package com.retailerapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerTransaction {
    private String customerName;
    private String transactionDate;
    private int price;
    private int rewardPoints;
}
