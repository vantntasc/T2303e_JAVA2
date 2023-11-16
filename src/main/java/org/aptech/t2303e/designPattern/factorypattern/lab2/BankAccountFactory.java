package org.aptech.t2303e.designPattern.factorypattern.lab2;

import org.aptech.t2303e.designPattern.factorypattern.lab1.*;

public class BankAccountFactory {
    public static final BankAccount getAccount(CardType cardType){
        switch (cardType){
            case VISA :
                return  new VisaAccount();
            case JCB :
                return new JCBAccount();
            case HYBRID:
                return new HybridAccount();
            case BLACK:
                return new BlackAccount();
            default:
                throw  new IllegalArgumentException();
        }
    }
}
