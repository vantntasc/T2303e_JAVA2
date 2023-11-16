package org.aptech.t2303e.designPattern.abstractfactorypattern.impl;

import org.aptech.t2303e.designPattern.abstractfactorypattern.Chair;

public class PlasticChair implements Chair {
    @Override
    public void create() {
        System.err.println("Create plastic chair");
    }
}
