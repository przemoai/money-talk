package com.moneytalk.invoice.domain;

import com.moneytalk.invoice.data.TestData;
import com.moneytalk.invoice.dto.InvoiceDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class InvoiceFacadeTest {

    @Mock
    private InvoiceRepository invoiceRepository;

    @Mock
    private InvoiceMapper invoiceMapper;

    @InjectMocks
    private InvoiceFacade invoiceFacade;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetInvoices() {
        // Arrange
        List<Invoice> invoices = Arrays.asList(new Invoice(), new Invoice());
        List<InvoiceDto> expectedInvoiceDtos = List.of(TestData.createSampleInvoiceDto());

        when(invoiceRepository.findAll()).thenReturn(invoices);
        when(invoiceMapper.toDto(invoices)).thenReturn(expectedInvoiceDtos);

        // Act
        List<InvoiceDto> actualInvoiceDtos = invoiceFacade.getInvoices();

        // Assert
        assertEquals(expectedInvoiceDtos, actualInvoiceDtos);
        verify(invoiceRepository, times(1)).findAll();
        verify(invoiceMapper, times(1)).toDto(invoices);
    }

    @Test
    void testUpsertInvoice() {
        // Arrange
        InvoiceDto invoiceDto = TestData.createSampleInvoiceDto();
        Invoice invoice = new Invoice();
        invoice.setId(1L);

        when(invoiceMapper.toEntity(invoiceDto)).thenReturn(invoice);
        when(invoiceRepository.save(invoice)).thenReturn(invoice);

        // Act
        Long actualInvoiceId = invoiceFacade.upsertInvoice(invoiceDto);

        // Assert
        assertEquals(invoice.getId(), actualInvoiceId);
        verify(invoiceMapper, times(1)).toEntity(invoiceDto);
        verify(invoiceRepository, times(1)).save(invoice);
    }

    @Test
    void testDeleteInvoiceById() {
        // Arrange
        Long invoiceId = 1L;
        Invoice invoice = new Invoice();
        invoice.setId(invoiceId);

        when(invoiceRepository.findById(invoiceId)).thenReturn(Optional.of(invoice));

        // Act
        Long actualInvoiceId = invoiceFacade.deleteInvoiceById(invoiceId);

        // Assert
        assertEquals(invoice.getId(), actualInvoiceId);
        verify(invoiceRepository, times(1)).findById(invoiceId);
        verify(invoiceRepository, times(1)).delete(invoice);
    }

    @Test
    void testDeleteInvoiceById_NotFound() {
        // Arrange
        Long invoiceId = 1L;

        when(invoiceRepository.findById(invoiceId)).thenReturn(Optional.empty());

        // Act
        Long actualInvoiceId = invoiceFacade.deleteInvoiceById(invoiceId);

        // Assert
        assertNull(actualInvoiceId);
        verify(invoiceRepository, times(1)).findById(invoiceId);
        verify(invoiceRepository, never()).delete(any());
    }
}