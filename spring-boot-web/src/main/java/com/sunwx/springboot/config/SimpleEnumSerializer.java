package com.sunwx.springboot.config;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.sunwx.springboot.enums.SimpleEnum;

import java.io.IOException;

public class SimpleEnumSerializer extends StdSerializer<SimpleEnum> {
    public SimpleEnumSerializer() {
        super(SimpleEnum.class);
    }

    @Override
    public void serialize(SimpleEnum value, JsonGenerator generator, SerializerProvider provider)
            throws IOException {
        generator.writeStartObject();
        generator.writeFieldName("ordinal");
        generator.writeNumber(value.ordinal());
        generator.writeFieldName("name");
        generator.writeString(value.name());
        generator.writeFieldName("disName");
        generator.writeString(value.getDisName());
        generator.writeEndObject();
    }
}
