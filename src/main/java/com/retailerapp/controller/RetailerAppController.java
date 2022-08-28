package com.retailerapp.controller;

import com.retailerapp.model.CustomerTransaction;
import com.retailerapp.service.RetailerAppService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200", maxAge=3600)
public class RetailerAppController {
    private final RetailerAppService retailerAppService;

    public RetailerAppController(RetailerAppService retailerAppService) {
        this.retailerAppService = retailerAppService;
    }

    @Operation(summary = "Get all customer transactions and calculate the reward points")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = CustomerTransaction.class)))) })
    @GetMapping("/getAllTransactions")
    public List<CustomerTransaction> getAllTransactions() {
        return retailerAppService.getAllTransactions();
    }
}
