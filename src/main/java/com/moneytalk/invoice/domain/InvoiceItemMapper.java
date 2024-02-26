package com.moneytalk.invoice.domain;

import com.moneytalk.invoice.dto.InvoiceItemDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
interface InvoiceItemMapper {
    InvoiceItemDto toDto(InvoiceItem invoiceItem);

    List<InvoiceItemDto> toDto(List<InvoiceItem> invoiceItemEntities);

    InvoiceItem toEntity(InvoiceItemDto invoiceItemDto);

    List<InvoiceItem> toEntity(List<InvoiceItemDto> invoiceItemDtoList);
}
