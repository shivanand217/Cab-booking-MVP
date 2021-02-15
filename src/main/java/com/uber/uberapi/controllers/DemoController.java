package com.uber.uberapi.controllers;

import com.uber.uberapi.models.Account;
import com.uber.uberapi.repositories.AccountRepository;
import com.uber.uberapi.repositories.DriverRepository;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Builder
public class DemoController implements CommandLineRunner {
    @Autowired
    DriverRepository driverRepository;

    @Autowired
    AccountRepository accountRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Demo controller running...");

        Account account1 = Account.builder()
                                .username("ajay_dspod")
                                .password("123")
                                .build();
        System.out.println("account id is " + account1.getId());
        accountRepository.save(account1);
        System.out.println("account id is " + account1.getId());
    }
}
