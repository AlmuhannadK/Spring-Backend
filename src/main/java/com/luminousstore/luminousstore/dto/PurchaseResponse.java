package com.luminousstore.luminousstore.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;

@Data
public class PurchaseResponse {
    @NonNull
    private String orderTrackingNumber;
}
