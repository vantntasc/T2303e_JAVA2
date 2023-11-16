package org.aptech.t2303e.designPattern.factorypattern.lab2;

import org.aptech.t2303e.designPattern.factorypattern.lab1.BankAccount;
import org.aptech.t2303e.designPattern.factorypattern.lab1.CardType;

public class Client {
    public static void main(String[] args) {
        BankAccount bankAccount = BankAccountFactory.getAccount(CardType.VISA); // super class
        bankAccount.withdraw(1.1);
    }
}
