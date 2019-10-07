package com.sunwx.springboot.enums;

public enum LogicStatus implements SimpleEnum{
    enable("启用"), disable("停用"), del("删除");
    private final String disName;

    LogicStatus(String disName) {
        this.disName = disName;
    }

    public String getDisName() {
        return disName;
    }
}
