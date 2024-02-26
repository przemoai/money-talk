package com.moneytalk.invoice.resources;


import com.moneytalk.invoice.domain.InvoiceFacade;
import com.moneytalk.invoice.dto.InvoiceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/invoice/")
@RequiredArgsConstructor
class InvoiceController {
    private final InvoiceFacade invoiceFacade;

    @GetMapping
    List<InvoiceDto> getInvoices(){
        return invoiceFacade.getInvoices();
    }

    @PostMapping
    Long insertInvoice(@RequestBody InvoiceDto invoiceDto){
        return invoiceFacade.insertInvoice(invoiceDto);
    }

    @DeleteMapping("/{invoiceId}")
    Long deleteInvoice(@PathVariable Long invoiceId){
        return invoiceFacade.deleteInvoiceById(invoiceId);
    }
}
