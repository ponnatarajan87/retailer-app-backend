package com.retailerapp.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.retailerapp.model.CustomerTransaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins="*", maxAge=3600)
@Slf4j
public class RetailerAppController {

    @GetMapping("/getCustomerRewardPoints/{customerName}")
    public List<CustomerTransaction> getCustomerRewardPoints(@PathVariable String customerName) {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<CustomerTransaction>> typeReference = new TypeReference<>() {};
        InputStream inputStream = TypeReference.class.getResourceAsStream("/json/customerTransactions.json");
        List<CustomerTransaction> customerTransactionList = null;

        try {
            customerTransactionList = mapper.readValue(inputStream, typeReference);

            customerTransactionList = customerTransactionList.stream().
                    filter(element -> element.getCustomerName().equalsIgnoreCase(customerName))
                    .map(element -> {
                        int price = element.getPrice();
                        int rewardPoints = 0;

                        if (price > 50) {
                            rewardPoints = price - 50;
                        }
                        if (price > 100) {
                            rewardPoints += price - 100;
                        }

                        element.setRewardPoints(rewardPoints);
                        return element;
                    }).toList();
        } catch (IOException ioException) {
            log.info("IOException occurred in RetailerAppController.getRewardPts()..."+ioException.getMessage());
        }

        return customerTransactionList;
    }
}
