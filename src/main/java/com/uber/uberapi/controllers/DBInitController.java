package com.uber.uberapi.controllers;

import com.uber.uberapi.models.*;
import com.uber.uberapi.repositories.*;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/db-init")
@RestController
@Builder
public class DBInitController {
//    @Autowired
//    private PasswordEncoder passwordEncoder;
    @Autowired
    private PassengerRepository passengerRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private ColorRepository colorRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private CarRepository carRepository;

    @GetMapping("")
    public String initDB() {
        // this will delete the rows
        // it will not reset the sequence numbers
        passengerRepository.deleteAll();
        driverRepository.deleteAll();
        accountRepository.deleteAll();
        carRepository.deleteAll();
        colorRepository.deleteAll();
        roleRepository.deleteAll();

        Color white = Color.builder().name("white").build();
        Color black = Color.builder().name("black").build();
        Color yellow = Color.builder().name("yellow").build();
        colorRepository.save(white);
        colorRepository.save(black);
        colorRepository.save(yellow);

        Role driver = Role.builder().name("ROLE_DRIVER").description("Driver").build();
        Role passenger = Role.builder().name("ROLE_PASSENGER").description("Passenger").build();
        Role admin = Role.builder().name("ROLE_ADMIN").description("Admin").build();
        roleRepository.save(driver);
        roleRepository.save(passenger);
        roleRepository.save(admin);

        Driver luffy = Driver.builder()
                .name("Monkey D. Luffy")
                .account(Account.builder()
                        .username("0000")
                        .password("1111")
                        .role(driver)
                        .build())
                .car(Car.builder()
                        .brandAndModel("Large Ship")
                        .color(yellow)
                        .carType(CarType.XL)
                        .plateNumber("Thousand Sunny")
                        .build())
                .gender(Gender.MALE)
                .phoneNumber("0000")
                .build();
        Driver zoro = Driver.builder()
                .name("Roronoa Zoro")
                .account(Account.builder()
                        .username("0001")
                        .password("1111")
                        .role(driver)
                        .build())
                .car(Car.builder()
                        .brandAndModel("Caravel")
                        .color(white)
                        .carType(CarType.Sedan)
                        .plateNumber("Going Merry")
                        .build())
                .gender(Gender.MALE)
                .phoneNumber("0001")
                .build();
        driverRepository.save(luffy);
        driverRepository.save(zoro);

        Passenger usopp = Passenger.builder()
                .account(Account.builder()
                        .username("0002")
                        .password("1111")
                        .role(passenger)
                        .build())
                .gender(Gender.MALE)
                .phoneNumber("0002")
                .build();

        Passenger nami = Passenger.builder()
                .account(Account.builder()
                        .username("0004")
                        .password("1111")
                        .role(passenger)
                        .build())
                .gender(Gender.FEMALE)
                .phoneNumber("0004")
                .build();
        passengerRepository.save(usopp);
        passengerRepository.save(nami);

        Account sanji = Account.builder()
                .username("0003")
                .role(admin)
                .password("1111")
                .build();
        accountRepository.save(sanji);
        return "success";
    }
}
