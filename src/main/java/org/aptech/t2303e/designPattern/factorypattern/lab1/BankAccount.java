package org.aptech.t2303e.designPattern.factorypattern.lab1;

public abstract class BankAccount {
    protected String accountId;
    protected int balance;

    public BankAccount() {
    }
    public abstract  boolean recharge(double amount );
    public abstract boolean withdraw(double amount);
}
