package org.aptech.t2303e.designPattern.abstractfactorypattern.impl;

import org.aptech.t2303e.designPattern.abstractfactorypattern.Table;

public class WoodTable implements Table {
    @Override
    public void create() {
        System.err.println("create WoodTable ");
    }
}
