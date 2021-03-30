package com.pragmanila.listAPI.employee;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity //to map the class in the database or hibernate
@Table //to create table statement in the DB
public class Employee {
    //using spring data JPA for connecting in the DB
    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1 //increment by 1 in ID
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence"
    )

    private Long id;
    private String name;
    private String email;
    private String pnm;
    private LocalDate dob;

    @Transient //no need to become a column in DB
    private Integer age;

    public Employee() {
    }

    public Employee(Long id,
                    String name,
                    String email,
                    String pnm,
                    LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.pnm = pnm;
        this.dob = dob;
    }

    public Employee(String name,
                    String email,
                    String pnm,
                    LocalDate dob) {
        this.name = name;
        this.email = email;
        this.pnm = pnm;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPnm() {
        return pnm;
    }

    public void setPnm(String pnm) {
        this.pnm = pnm;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", pnm='" + pnm + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
