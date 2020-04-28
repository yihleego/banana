package io.leego.banana.enums;

/**
 * @author Yihleego
 */
public enum FittingLayout {
    DEFAULT(-1, "default"),
    FULL(0, "full"),
    FITTING(1, "fitting"),
    SMUSHING(2, "smushing"),
    CONTROLLED_SMUSHING(3, "controlled_smushing");

    private final int code;
    private final String value;

    FittingLayout(int code, String value) {
        this.code = code;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public static FittingLayout getByCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (FittingLayout e : values()) {
            if (code == e.code) {
                return e;
            }
        }
        return null;
    }

    public static FittingLayout getByValue(String value) {
        if (value == null) {
            return null;
        }
        for (FittingLayout e : values()) {
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
        FittingLayout e = getByValue(value);
        if (e != null) {
            return e.code;
        }
        return null;
    }

}
