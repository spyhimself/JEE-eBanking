package org.emsi.ebankingbackend.entities;

import lombok.Data;

import java.util.Date;

public class BankAccount {

    private String id;
    private double balance;
    private Date createdAt;
    private AccountStatus accountStatus;
}
