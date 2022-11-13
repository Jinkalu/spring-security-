package com.security.main.service.impl;

import com.security.main.model.Account;
import com.security.main.model.Role;
import com.security.main.repo.AccountRepo;
import com.security.main.repo.RoleRepo;
import com.security.main.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepo accountRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder encoder;

    @Override
    public Account createAccount(Account account) {
        account.setPassword(encoder.encode(account.getPassword()));
        Role role = roleRepo.findByName("ROLE_USER");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        account.setRoles(roles);
        return accountRepo.save(account);
    }

    @Override
    public Account findByUserName(String userName) {
        return accountRepo.findByUserName(userName);
    }

    @Override
    public List<Account> getAccounts() {
        return accountRepo.findAll();
    }
}
