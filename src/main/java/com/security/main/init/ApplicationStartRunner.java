package com.security.main.init;

import com.security.main.model.Role;
import com.security.main.repo.RoleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static java.util.Arrays.asList;


@Component
@RequiredArgsConstructor
public class ApplicationStartRunner implements CommandLineRunner {
    private final RoleRepo roleRepo;

    @Override
    public void run(String... args) throws Exception {
        Role role = new Role(1L, "123", "ROLE_USER");
        Role role2 = new Role(2L, "124", "ROLE_ADMIN");
        roleRepo.saveAll(asList(role, role2));
    }
}
