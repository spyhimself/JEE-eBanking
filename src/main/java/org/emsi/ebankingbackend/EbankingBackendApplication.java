package org.emsi.ebankingbackend;

import org.emsi.ebankingbackend.dtos.BankAccountDTO;
import org.emsi.ebankingbackend.dtos.CurrentAccountDTO;
import org.emsi.ebankingbackend.dtos.CustomerDTO;
import org.emsi.ebankingbackend.dtos.SavingAccountDTO;
import org.emsi.ebankingbackend.entities.*;
import org.emsi.ebankingbackend.enums.AccountStatus;
import org.emsi.ebankingbackend.enums.OperationType;
import org.emsi.ebankingbackend.exceptions.BalanceNotSufficientException;
import org.emsi.ebankingbackend.exceptions.BankAccountNotFoundException;
import org.emsi.ebankingbackend.exceptions.CustomerNotFoundException;
import org.emsi.ebankingbackend.repositories.AccountOperationRepository;
import org.emsi.ebankingbackend.repositories.BankAccountRepository;
import org.emsi.ebankingbackend.repositories.CustomerRepository;
import org.emsi.ebankingbackend.services.BankAccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class EbankingBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbankingBackendApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BankAccountService bankAccountService) {
        return args -> {
            Stream.of("Yasser", "Imane", "Mohammed").forEach(
                    name -> {
                        CustomerDTO customerDTO = new CustomerDTO();
                        customerDTO.setName(name);
                        customerDTO.setEmail(name + "@mail.com");
                        bankAccountService.saveCustomer(customerDTO);
                    });

            bankAccountService.listCustomer().forEach(customer -> {
                try {
                    bankAccountService.saveCurrentBankAccount(Math.random() * 90000, 9000, customer.getId());
                    bankAccountService.saveSavingBankAccount(Math.random() * 120000, 5.5, customer.getId());
                    List<BankAccountDTO> bankAccounts = bankAccountService.bankAccountList();
                    for (BankAccountDTO bankAccountDTO : bankAccounts) {
                        for (int i = 0; i < 10; i++) {
                            String accountId;
                            if (bankAccountDTO instanceof SavingAccountDTO) {
                                accountId = ((SavingAccountDTO) bankAccountDTO).getId();
                            } else {
                                accountId = ((CurrentAccountDTO) bankAccountDTO).getId();
                            }
                            bankAccountService.credit(accountId, 10000 + Math.random() * 120000, "Credit");
                            bankAccountService.debit(accountId, 1000 + Math.random() * 9000, "Debit");
                        }

                }
            } catch (BankAccountNotFoundException | BalanceNotSufficientException e) {
                    e.printStackTrace();
                } catch (CustomerNotFoundException e) {
                    e.printStackTrace();
                }
                });
            };
        }

//    @Bean
    CommandLineRunner start(CustomerRepository customerRepository, BankAccountRepository bankAccountRepository,
                            AccountOperationRepository accountOperationRepository) {
        return args -> {
            Stream.of("Ayman", "Oussama", "Ziad").forEach(name -> {
                Customer customer = new Customer();
                customer.setName(name);
                customer.setEmail(name + "@gmail.com");
                customerRepository.save(customer);
            });
            customerRepository.findAll().forEach(customer -> {
                CurrentAccount currentAccount = new CurrentAccount();
                currentAccount.setId(UUID.randomUUID().toString());
                currentAccount.setBalance(Math.random() * 90000);
                currentAccount.setCreatedAt(new Date());
                currentAccount.setAccountStatus(AccountStatus.CREATED);
                currentAccount.setCustomer(customer);
                currentAccount.setOverDraft(9000);
                bankAccountRepository.save(currentAccount);

                SavingAccount savingAccount = new SavingAccount();
                savingAccount.setId(UUID.randomUUID().toString());
                savingAccount.setBalance(Math.random() * 90000);
                savingAccount.setCreatedAt(new Date());
                savingAccount.setAccountStatus(AccountStatus.CREATED);
                savingAccount.setCustomer(customer);
                savingAccount.setInterestRate(4.5);
                bankAccountRepository.save(savingAccount);
            });
            bankAccountRepository.findAll().forEach(acc -> {
                for (int i = 0; i < 10; i++) {
                    AccountOperation accountOperation = new AccountOperation();
                    accountOperation.setOperationDate(new Date());
                    accountOperation.setAmount(Math.random() * 12000);
                    accountOperation.setType(Math.random() > .5 ? OperationType.DEBIT : OperationType.CREDIT);
                    accountOperation.setBankAccount(acc);
                    accountOperationRepository.save(accountOperation);
                }

            });

        };
    }

}
