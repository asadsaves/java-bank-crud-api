package com.example.bankapi.service;

import com.example.bankapi.model.Account;
import com.example.bankapi.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankService {
    @Autowired
    private AccountRepository repository;

    public List<Account> getAllAccounts() {
        return repository.findAll();
    }

    public Optional<Account> getAccountById(String id) {
        return repository.findById(id);
    }

    public Account createAccount(Account account) {
        return repository.save(account);
    }

    public Account updateAccount(String id, Account account) {
        if (repository.existsById(id)) {
            account.setId(id);
            return repository.save(account);
        } else {
            return null;
        }
    }

    public void deleteAccount(String id) {
        repository.deleteById(id);
    }
}
