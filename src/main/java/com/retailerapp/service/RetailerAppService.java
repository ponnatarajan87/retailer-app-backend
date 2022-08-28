package com.retailerapp.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.retailerapp.model.CustomerTransaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
@Slf4j
public class RetailerAppService {
    public List<CustomerTransaction> getAllTransactions() {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<CustomerTransaction>> typeReference = new TypeReference<>() {};
        List<CustomerTransaction> customerTransactionList = null;

        try {
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/customerTransactions.json");
            customerTransactionList = mapper.readValue(inputStream, typeReference);

            customerTransactionList = customerTransactionList.stream().
                    map(element -> {
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
            log.info("IOException occurred in RetailerAppService.getAllTransactions()..."+ioException.getMessage());
        }
        return customerTransactionList;
    }
}
