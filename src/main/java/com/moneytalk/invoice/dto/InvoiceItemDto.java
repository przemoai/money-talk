package com.moneytalk.invoice.dto;


import java.math.BigDecimal;

public record InvoiceItemDto(
        String name,
        BigDecimal price,
        long amount) {
}
