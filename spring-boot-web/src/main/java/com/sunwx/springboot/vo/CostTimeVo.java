package com.sunwx.springboot.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CostTimeVo {

    private Integer costTime;
    private String executeDate;

    private String taskCode;

    private String startTime;
    private String endTime;

}
