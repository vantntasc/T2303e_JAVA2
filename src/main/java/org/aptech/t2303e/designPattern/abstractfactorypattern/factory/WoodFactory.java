package org.aptech.t2303e.designPattern.abstractfactorypattern.factory;

import org.aptech.t2303e.designPattern.abstractfactorypattern.Chair;
import org.aptech.t2303e.designPattern.abstractfactorypattern.FunitureAbstractFactory;
import org.aptech.t2303e.designPattern.abstractfactorypattern.Table;
import org.aptech.t2303e.designPattern.abstractfactorypattern.impl.WoodChair;
import org.aptech.t2303e.designPattern.abstractfactorypattern.impl.WoodTable;

public class WoodFactory extends FunitureAbstractFactory {
    @Override
    public Chair createChair() {
        return new WoodChair();
    }

    @Override
    public Table createTable() {
        return new WoodTable();
    }
}
