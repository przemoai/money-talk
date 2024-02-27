package com.moneytalk.invoice.data;

import com.moneytalk.invoice.dto.InvoiceDto;
import com.moneytalk.invoice.dto.InvoiceItemDto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

public class TestData {

    public static InvoiceDto createSampleInvoiceDto() {
        InvoiceItemDto item1 = new InvoiceItemDto(1L, "Item 1", BigDecimal.valueOf(10.00), BigDecimal.valueOf(0.1),
                BigDecimal.valueOf(10.00), BigDecimal.valueOf(1.00), BigDecimal.valueOf(11.00));

        InvoiceItemDto item2 = new InvoiceItemDto(2L, "Item 2", BigDecimal.valueOf(20.00), BigDecimal.valueOf(0.2),
                BigDecimal.valueOf(20.00), BigDecimal.valueOf(4.00), BigDecimal.valueOf(24.00));

        List<InvoiceItemDto> items = Arrays.asList(item1, item2);

        return new InvoiceDto(1L, items, Instant.now(), Instant.now());
    }

    public static InvoiceDto createEmptyInvoiceDto() {
        return new InvoiceDto(1L, List.of(), Instant.now(), Instant.now());
    }

    public static InvoiceItemDto createSampleInvoiceItemDto() {
        return new InvoiceItemDto(1L, "Sample Item", BigDecimal.valueOf(15.00), BigDecimal.valueOf(0.15),
                BigDecimal.valueOf(15.00), BigDecimal.valueOf(2.25), BigDecimal.valueOf(17.25));
    }
}

