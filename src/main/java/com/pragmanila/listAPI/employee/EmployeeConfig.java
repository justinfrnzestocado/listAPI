package com.pragmanila.listAPI.employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class EmployeeConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            EmployeeRepository repository)
    {
        return args ->
        {
            Employee justin = new Employee(
                    "Justin Franz",
                    "justin.estocado@pragmanila.com",
                    "09076415933",
                    LocalDate.of(1998, Month.JUNE, 11)
            );
            Employee alvin = new Employee(
                    "Mark Alvin",
                    "alvin.centino@pragmanila.com",
                    "09076415933",
                    LocalDate.of(1994, Month.MARCH, 22)
            );

            //used to save data entries in the DB
            repository.saveAll(
                    List.of(justin, alvin)
            );
        };
    }
}
