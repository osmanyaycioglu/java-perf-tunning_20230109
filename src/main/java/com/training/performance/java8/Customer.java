package com.training.performance.java8;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@ToString
public class Customer {

    private String        name;
    private String        surname;
    private Integer       height;
    private String        username;
    private String        password;
    private boolean       activated;
    private LocalDateTime activatedDate;
    private List<Account> accounts;

    public Customer() {
    }

    public Customer(String name,
                    String surname,
                    Integer height,
                    String username,
                    String password,
                    boolean activated,
                    LocalDateTime activatedDate,
                    List<Account> accounts) {
        this.name = name;
        this.surname = surname;
        this.height = height;
        this.username = username;
        this.password = password;
        this.activated = activated;
        this.activatedDate = activatedDate;
        this.accounts = accounts;
    }

    public static CustomerBuilder builder() {
        return new CustomerBuilder();
    }


    public Customer setName(String name) {
        this.name = name;
        return this;
    }

    public Customer setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public Customer setHeight(Integer height) {
        this.height = height;
        return this;
    }

    public Customer setUsername(String username) {
        this.username = username;
        return this;
    }

    public Customer setPassword(String password) {
        this.password = password;
        return this;
    }

    public Customer setActivated(boolean activated) {
        this.activated = activated;
        return this;
    }

    public Customer setActivatedDate(LocalDateTime activatedDate) {
        this.activatedDate = activatedDate;
        return this;
    }

    public Customer setAccounts(List<Account> accounts) {
        this.accounts = accounts;
        return this;
    }

    public static class CustomerBuilder {
        private String        name;
        private String        surname;
        private Integer       height;
        private String        username;
        private String        password;
        private boolean       activated;
        private LocalDateTime activatedDate;
        private List<Account> accounts;

        CustomerBuilder() {
        }

        public CustomerBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public CustomerBuilder withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public CustomerBuilder withHeight(Integer height) {
            this.height = height;
            return this;
        }

        public CustomerBuilder withUsername(String username) {
            this.username = username;
            return this;
        }

        public CustomerBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public CustomerBuilder withActivated(boolean activated) {
            this.activated = activated;
            return this;
        }

        public CustomerBuilder withActivatedDate(LocalDateTime activatedDate) {
            this.activatedDate = activatedDate;
            return this;
        }

        public CustomerBuilder withAccounts(List<Account> accounts) {
            this.accounts = accounts;
            return this;
        }

        public Customer build() {
            return new Customer(name,
                                surname,
                                height,
                                username,
                                password,
                                activated,
                                activatedDate,
                                accounts);
        }

        public String toString() {
            return "Customer.CustomerBuilder(name="
                   + this.name
                   + ", surname="
                   + this.surname
                   + ", height="
                   + this.height
                   + ", username="
                   + this.username
                   + ", password="
                   + this.password
                   + ", activated="
                   + this.activated
                   + ", activatedDate="
                   + this.activatedDate
                   + ", accounts="
                   + this.accounts
                   + ")";
        }
    }
}
