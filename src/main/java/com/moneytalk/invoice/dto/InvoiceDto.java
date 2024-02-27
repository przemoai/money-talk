package com.moneytalk.invoice.dto;

import java.time.Instant;
import java.util.List;


public record InvoiceDto(
        long id,
        List<InvoiceItemDto> items,
        Instant createdAt,
        Instant updatedAt
) {
}
