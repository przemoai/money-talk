package com.moneytalk.invoice.domain;

import com.moneytalk.invoice.dto.InvoiceDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class InvoiceFacade {
    private final InvoiceRepository invoiceRepository;
    private final InvoiceMapper invoiceMapper;

    public List<InvoiceDto> getInvoices() {

        return invoiceMapper.toDto(invoiceRepository.findAll());
    }

    public Long insertInvoice(InvoiceDto invoiceDto) {
        Invoice invoice = invoiceMapper.toEntity(invoiceDto);
        invoiceRepository.save(invoice);
        return invoice.getId();
    }

    public Long deleteInvoiceById(Long invoiceId) {
        try {
            Invoice invoice = invoiceRepository.findById(invoiceId)
                    .orElseThrow(() -> new EntityNotFoundException("Invoice not found with ID: " + invoiceId));

            invoiceRepository.delete(invoice);
            return invoice.getId();
        } catch (EntityNotFoundException e) {
            log.warn("Invoice with ID {} not found for deletion", invoiceId);
        }
        return null;
    }

}
