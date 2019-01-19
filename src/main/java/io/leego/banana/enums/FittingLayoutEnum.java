package io.leego.banana.enums;

/**
 * @author YihLeego
 */
public enum FittingLayoutEnum {
    DEFAULT(-1, "default"),
    FULL(0, "full"),
    FITTING(1, "fitting"),
    SMUSHING(2, "smushing"),
    CONTROLLED_SMUSHING(3, "controlled_smushing");

    private final int code;
    private final String value;

    FittingLayoutEnum(int code, String value) {
        this.code = code;
        this.value = value;
    }

    public int code() {
        return code;
    }

    public String value() {
        return value;
    }

    public static FittingLayoutEnum getByCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (FittingLayoutEnum e : values()) {
            if (code == e.code) {
                return e;
            }
        }
        return null;
    }

    public static FittingLayoutEnum getByValue(String value) {
        if (value == null) {
            return null;
        }
        for (FittingLayoutEnum e : values()) {
            if (value.equalsIgnoreCase(e.value)) {
                return e;
            }
        }
        return null;
    }

    public static Integer getCodeByValue(String value) {
        if (value == null) {
            return null;
        }
        FittingLayoutEnum e = getByValue(value);
        if (e != null) {
            return e.code;
        }
        return null;
    }

}
