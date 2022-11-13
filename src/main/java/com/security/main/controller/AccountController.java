package com.security.main.controller;

import com.security.main.model.Account;
import com.security.main.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/accounts")
public class AccountController {
    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account){
        Account newAccount=accountService.createAccount(account);
        return ResponseEntity.created(getLocation(newAccount.getId()))
                .body(newAccount);
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAccount(){
        return ResponseEntity.ok(accountService.getAccounts());
    }

    protected static URI getLocation(Long id){
        return fromCurrentRequest().path("{id}")
                .buildAndExpand(id)
                .toUri();
    }
}
