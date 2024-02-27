package com.moneytalk.invoice.dto;


import java.math.BigDecimal;

public record InvoiceItemDto(
        long id,
        String name,
        BigDecimal price,
        BigDecimal taxPercentage,
        BigDecimal amount,
        BigDecimal taxTotalCost,
        BigDecimal itemTotalCost) {
}
