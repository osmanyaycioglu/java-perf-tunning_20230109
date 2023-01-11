package com.training.performance.java8;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Account {

    private int          amount;
    private EAccountType accountType;

    public Account() {
    }

    public Account(int amount,
                   EAccountType accountType) {
        this.amount = amount;
        this.accountType = accountType;
    }

    public static AccountBuilder builder() {
        return new AccountBuilder();
    }

    public Account setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public Account setAccountType(EAccountType accountType) {
        this.accountType = accountType;
        return this;
    }


    public static class AccountBuilder {
        private int          amount;
        private EAccountType accountType;

        AccountBuilder() {
        }

        public AccountBuilder withAmount(int amount) {
            this.amount = amount;
            return this;
        }

        public AccountBuilder withAccountType(EAccountType accountType) {
            this.accountType = accountType;
            return this;
        }

        public Account build() {
            return new Account(amount,
                               accountType);
        }

        public String toString() {
            return "Account.AccountBuilder(amount=" + this.amount + ", accountType=" + this.accountType + ")";
        }
    }
}
