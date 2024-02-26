package com.moneytalk.invoice.domain;

import org.springframework.data.jpa.repository.JpaRepository;

interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
