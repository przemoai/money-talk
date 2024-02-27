package com.moneytalk.invoice.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class InvoiceItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private BigDecimal taxPercentage;
    @Column(nullable = false)
    private BigDecimal amount;
    private BigDecimal taxTotalCost;
    private BigDecimal itemTotalCost;


    @PrePersist
    public void calculateCosts() {
        if (price != null && taxPercentage != null) {
            BigDecimal taxAmount = price.multiply(taxPercentage.divide(BigDecimal.valueOf(100), RoundingMode.HALF_UP));
            taxTotalCost = taxAmount;
            itemTotalCost = price.add(taxAmount);
        } else {
            taxTotalCost = BigDecimal.ZERO;
            itemTotalCost = price == null ? BigDecimal.ZERO : price;
        }
    }
}
