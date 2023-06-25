package org.emsi.ebankingbackend.dtos;

import lombok.Data;

import java.util.List;
@Data
public class AccountHistoryDTO {
    private String accountId;
    private List<AccountOperationDTO> accountOperationDTOs;
    private int currentPage;
    private int totalPages;
    private int sizePage;
    private double balance;
}
