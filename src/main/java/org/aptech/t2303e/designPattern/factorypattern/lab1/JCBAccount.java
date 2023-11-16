package org.aptech.t2303e.designPattern.factorypattern.lab1;

import java.util.UUID;

public class JCBAccount extends  BankAccount {
    @Override
    public boolean recharge(double amount) {
        System.err.println("Recharge JCBAccount , amount = " + amount);
        return false;
    }

    public JCBAccount() {
        super();
        this.accountId = UUID.randomUUID().toString();
        this.balance = 50000;
    }

    @Override
    public boolean withdraw(double amount) {
        System.err.println("withdraw JCBAccount , amount = " + amount);
        return false;
    }
}
