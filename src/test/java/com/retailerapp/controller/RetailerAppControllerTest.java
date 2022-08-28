package com.retailerapp.controller;

import com.retailerapp.model.CustomerTransaction;
import com.retailerapp.service.RetailerAppService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RetailerAppController.class)
class RetailerAppControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    RetailerAppService retailerAppService;

    CustomerTransaction customerTransaction1 = new CustomerTransaction("Samuel Perry", "1/May/2022", 500, 0);
    CustomerTransaction customerTransaction2 = new CustomerTransaction("Samuel Perry", "10/May/2022", 100, 0);
    CustomerTransaction customerTransaction3 = new CustomerTransaction("Samuel Perry", "3/Jun/2022", 600, 0);

    @Test
    void getAllTransactionsTest() throws Exception {
        List<CustomerTransaction> customerTransactionList = Arrays.asList(customerTransaction1, customerTransaction2, customerTransaction3);

        Mockito.when(retailerAppService.getAllTransactions()).thenReturn(customerTransactionList);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/getAllTransactions")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[2].price", is(600)));
    }
}