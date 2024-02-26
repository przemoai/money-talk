package com.moneytalk.invoice.dto;

import java.util.List;

public record InvoiceDto(List<InvoiceItemDto> items) {
}
