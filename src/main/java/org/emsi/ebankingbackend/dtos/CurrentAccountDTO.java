package org.emsi.ebankingbackend.dtos;

import jakarta.persistence.Id;
import lombok.Data;
import org.emsi.ebankingbackend.enums.AccountStatus;

import java.util.Date;

@Data
public class CurrentAccountDTO extends BankAccountDTO {
    private String id;
    private double balance;
    private Date createdAt;
    private AccountStatus accountStatus;
    private CustomerDTO customerDTO;
    private double interestRate;
}
