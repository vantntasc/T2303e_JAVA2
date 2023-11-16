package org.aptech.t2303e.designPattern.factorypattern.lab1;

import java.util.UUID;

public class HybridAccount extends BankAccount{
    public HybridAccount() {
        super();
        this.accountId = UUID.randomUUID().toString();
        this.balance = 0;
    }
    @Override
    public boolean recharge(double amount) {
        System.err.println("Recharge HybridAccount , amount = " + amount);
        return false;
    }

    @Override
    public boolean withdraw(double amount) {
        System.err.println("withdraw HybridAccount , amount = " + amount);
        return false;
    }
}
