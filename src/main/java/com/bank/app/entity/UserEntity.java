package com.bank.app.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Getter
@Setter
@Entity
@Table(name = "banking_core_user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String identificationNumber;

    @OneToMany(mappedBy = "user", fetch = LAZY, cascade = CascadeType.ALL)
    private List<BankAccountEntity> accounts;

    public UserEntity(String firstName, String lastName, String email, String identificationNumber, List<BankAccountEntity> accounts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.identificationNumber = identificationNumber;
        this.accounts = accounts;
    }

    public UserEntity() {

    }
}
