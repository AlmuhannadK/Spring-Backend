package com.luminousstore.luminousstore.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderDTO {

    private String orderTrackingNumber;

    private int totalQuantity;

    private BigDecimal totalPrice;

    private String status;

}