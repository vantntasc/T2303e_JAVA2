package org.aptech.t2303e.designPattern.abstractfactorypattern.factory;

import org.aptech.t2303e.designPattern.abstractfactorypattern.FunitureAbstractFactory;
import org.aptech.t2303e.designPattern.abstractfactorypattern.MaterialType;

public class FunitureFactory {
    public  static FunitureAbstractFactory getFactory(MaterialType materialType){
        switch (materialType){
            case WOOD: return  new WoodFactory();
            case PLASTIC: return new PlasticFactory();
            default: throw new IllegalArgumentException();
        }
    }
}
