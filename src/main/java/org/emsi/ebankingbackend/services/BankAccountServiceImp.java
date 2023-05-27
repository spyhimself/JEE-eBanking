package org.emsi.ebankingbackend.services;

import lombok.extern.slf4j.Slf4j;
import org.emsi.ebankingbackend.entities.BankAccount;
import org.emsi.ebankingbackend.entities.CurrentAccount;
import org.emsi.ebankingbackend.entities.Customer;
import org.emsi.ebankingbackend.entities.SavingAccount;
import org.emsi.ebankingbackend.exceptions.BankAccountNotFoundException;
import org.emsi.ebankingbackend.exceptions.CustomerNotFoundException;
import org.emsi.ebankingbackend.repositories.AccountOperationRepository;
import org.emsi.ebankingbackend.repositories.BankAccountRepository;
import org.emsi.ebankingbackend.repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@Slf4j
public class BankAccountServiceImp implements BankAccountService {
    private CustomerRepository customerRepository;
    private BankAccountRepository bankAccountRepository;
    private AccountOperationRepository accountOperationRepository;

    public BankAccountServiceImp(CustomerRepository customerRepository, BankAccountRepository bankAccountRepository, AccountOperationRepository accountOperationRepository) {
        this.customerRepository = customerRepository;
        this.bankAccountRepository = bankAccountRepository;
        this.accountOperationRepository = accountOperationRepository;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        log.info("Saving new Customer");
        return customerRepository.save(customer);
    }

    @Override
    public CurrentAccount saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId) throws CustomerNotFoundException {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        CurrentAccount currentAccount = new CurrentAccount();
        if (customer == null)
            throw new CustomerNotFoundException("Customer not found");
        currentAccount.setId(UUID.randomUUID().toString());
        currentAccount.setCreatedAt(new Date());
        currentAccount.setBalance(initialBalance);
        currentAccount.setCustomer(customer);
        currentAccount.setOverDraft(overDraft);

        return bankAccountRepository.save(currentAccount);
    }

    @Override
    public SavingAccount saveSavingBankAccount(double initialBalance, double interestRate, Long customerId) throws CustomerNotFoundException {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        SavingAccount savingAccount = new SavingAccount();
        if (customer == null)
            throw new CustomerNotFoundException("Customer not found");
        savingAccount.setId(UUID.randomUUID().toString());
        savingAccount.setCreatedAt(new Date());
        savingAccount.setBalance(initialBalance);
        savingAccount.setCustomer(customer);
        savingAccount.setInterestRate(interestRate);

        return bankAccountRepository.save(savingAccount);
    }


    @Override
    public List<Customer> listCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public BankAccount getBankAccount(String accountId) throws BankAccountNotFoundException {
        BankAccount bankAccount = bankAccountRepository.findById(accountId).orElseThrow(
                () -> new BankAccountNotFoundException("BankAccount not found")
        );
        return bankAccount;
    }

    @Override
    public void debit(String accountId, double amount, String description) {

    }

    @Override
    public void credit(String accountId, double amount, String description) {

    }

    @Override
    public void transfer(String accountIdSource, String accountIdDest, double amount) {

    }
}
