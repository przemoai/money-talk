package com.moneytalk.invoice.domain;

import com.moneytalk.invoice.dto.InvoiceDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = InvoiceItemMapper.class)
interface InvoiceMapper {
    InvoiceDto toDto(Invoice invoice);

    List<InvoiceDto> toDto(List<Invoice> invoiceEntities);

    Invoice toEntity(InvoiceDto invoiceDto);

    List<Invoice> toEntity(List<InvoiceDto> invoiceDtos);
}
