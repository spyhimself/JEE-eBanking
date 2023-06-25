package org.emsi.ebankingbackend.dtos;

import jakarta.persistence.*;
import lombok.Data;
import org.emsi.ebankingbackend.enums.AccountStatus;

import java.util.Date;

@Data
public class SavingAccountDTO {
    @Id
    private String id;
    private double balance;
    private Date createdAt;
    private AccountStatus accountStatus;
    private CustomerDTO customerDTO;
    private double overDraft;
}
