package org.aptech.t2303e.designPattern.abstractfactorypattern;

import org.aptech.t2303e.designPattern.abstractfactorypattern.factory.FunitureFactory;

public class Client {
    public static void main(String[] args) {
        FunitureAbstractFactory factory = FunitureFactory.getFactory(MaterialType.WOOD);
        Chair chair = factory.createChair();
        Table table = factory.createTable();
        System.err.println(chair);
        System.err.println(table);
    }
}
