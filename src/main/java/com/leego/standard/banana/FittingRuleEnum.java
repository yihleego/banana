package com.leego.standard.banana;

/**
 * Created by YihLeego on 2018.09.22 23:00
 *
 * @author YihLeego
 * @version 1.0.0
 */
public enum FittingRuleEnum {

    VLAYOUT_SMUSHING(16384, "vLayout", BananaUtils.SMUSHING),
    VLAYOUT_FITTING(8192, "vLayout", BananaUtils.FITTING),
    VRULE5(4096, "vRule5", 1),
    VRULE4(2048, "vRule4", 1),
    VRULE3(1024, "vRule3", 1),
    VRULE2(512, "vRule2", 1),
    VRULE1(256, "vRule1", 1),
    HLAYOUT_SMUSHING(128, "hLayout", BananaUtils.SMUSHING),
    HLAYOUT_FITTING(64, "hLayout", BananaUtils.FITTING),
    HRULE6(32, "hRule6", 1),
    HRULE5(16, "hRule5", 1),
    HRULE4(8, "hRule4", 1),
    HRULE3(4, "hRule3", 1),
    HRULE2(2, "hRule2", 1),
    HRULE1(1, "hRule1", 1);

    private int code;
    private String name;
    private int value;


    FittingRuleEnum(int code, String name, int value) {
        this.code = code;
        this.name = name;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}
