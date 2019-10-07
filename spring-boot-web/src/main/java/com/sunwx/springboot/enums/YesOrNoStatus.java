package com.sunwx.springboot.enums;

public enum YesOrNoStatus implements SimpleEnum{
    y("是"), n("否");
    private final String disName;

    YesOrNoStatus(String disName) {
        this.disName = disName;
    }

    public String getDisName() {
        return disName;
    }
}
