package org.aptech.t2303e.entity.consts;

public enum DataType {
    VARCHAR("VARCHAR"),
    INT("INT"),
    DATE("DATE")
    ;
    public final String val;
    private  DataType(String val) {
        this.val = val;
    }
}
