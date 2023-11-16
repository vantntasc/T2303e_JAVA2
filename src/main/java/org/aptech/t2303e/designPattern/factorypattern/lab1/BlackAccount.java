package org.aptech.t2303e.designPattern.factorypattern.lab1;

import java.util.UUID;

public class BlackAccount extends  BankAccount{
    public BlackAccount() {
        super();
        this.accountId = UUID.randomUUID().toString();
        this.balance = 500000000;
    }
    @Override
    public boolean recharge(double amount) {
        System.err.println("Recharge BlackAccount , amount = " + amount);
        return false;
    }

    @Override
    public boolean withdraw(double amount) {
        System.err.println("withdraw BlackAccount , amount = " + amount);
        return false;
    }
}
