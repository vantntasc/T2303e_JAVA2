package org.aptech.t2303e.designPattern.factorypattern.lab1;

public class Lab1 {
    public static void main(String[] args) {
//        BankAccount bankAccount = new JCBAccount();  // init object inside class of instance
//        BankAccount hybridAccount = new HybridAccount();
//        BankAccount visaAccount = new VisaAccount();
        CardType cardType  = CardType.VISA;
        BankAccount  bankAccount = null;
        switch (cardType){
            case VISA :
                bankAccount = new VisaAccount();
            case JCB :
                bankAccount = new JCBAccount();
            case HYBRID:
                bankAccount = new HybridAccount();
            case BLACK:
                bankAccount = null;
        }
        bankAccount.withdraw(1.1);
    }
}
