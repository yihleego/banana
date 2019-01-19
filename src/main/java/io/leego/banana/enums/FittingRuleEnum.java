package io.leego.banana.enums;

/**
 * @author YihLeego
 */
public enum FittingRuleEnum {
    V_LAYOUT_SMUSHING(16384, "vLayout", FittingLayoutEnum.SMUSHING.code()),
    V_LAYOUT_FITTING(8192, "vLayout", FittingLayoutEnum.FITTING.code()),
    V_RULE5(4096, "vRule5", 1),
    V_RULE4(2048, "vRule4", 1),
    V_RULE3(1024, "vRule3", 1),
    V_RULE2(512, "vRule2", 1),
    V_RULE1(256, "vRule1", 1),
    H_LAYOUT_SMUSHING(128, "hLayout", FittingLayoutEnum.SMUSHING.code()),
    H_LAYOUT_FITTING(64, "hLayout", FittingLayoutEnum.FITTING.code()),
    H_RULE6(32, "hRule6", 1),
    H_RULE5(16, "hRule5", 1),
    H_RULE4(8, "hRule4", 1),
    H_RULE3(4, "hRule3", 1),
    H_RULE2(2, "hRule2", 1),
    H_RULE1(1, "hRule1", 1);

    private final int code;
    private final String key;
    private final int value;

    FittingRuleEnum(int code, String key, int value) {
        this.code = code;
        this.key = key;
        this.value = value;
    }

    public int code() {
        return code;
    }

    public String key() {
        return key;
    }

    public int value() {
        return value;
    }
}
