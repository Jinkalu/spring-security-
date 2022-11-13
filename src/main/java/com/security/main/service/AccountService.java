package com.security.main.service;

import com.security.main.model.Account;

import java.util.List;

public interface AccountService {
    Account createAccount(Account account);
    Account findByUserName(String userName);
    List<Account> getAccounts();
}
