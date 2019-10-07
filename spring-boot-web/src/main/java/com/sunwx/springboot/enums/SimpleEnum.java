package com.sunwx.springboot.enums;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sunwx.springboot.config.SimpleEnumSerializer;


@JsonSerialize(using = SimpleEnumSerializer.class)
public interface SimpleEnum {
    int ordinal();

    String name();

    String getDisName();
}