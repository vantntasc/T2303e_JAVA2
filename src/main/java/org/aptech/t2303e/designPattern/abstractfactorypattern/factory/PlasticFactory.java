package org.aptech.t2303e.designPattern.abstractfactorypattern.factory;

import org.aptech.t2303e.designPattern.abstractfactorypattern.Chair;
import org.aptech.t2303e.designPattern.abstractfactorypattern.FunitureAbstractFactory;
import org.aptech.t2303e.designPattern.abstractfactorypattern.Table;
import org.aptech.t2303e.designPattern.abstractfactorypattern.impl.PlasticChair;
import org.aptech.t2303e.designPattern.abstractfactorypattern.impl.PlasticTable;

public class PlasticFactory extends FunitureAbstractFactory {
    @Override
    public Chair createChair() {
        return new PlasticChair();
    }

    @Override
    public Table createTable() {
        return new PlasticTable();
    }
}
