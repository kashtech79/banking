package com.userfront.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

public class Savings {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int accountNumber;
    private BigDecimal accountBalance;

    private List<SavingsTransaction> SavingsTransactionList;
}
