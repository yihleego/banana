package io.leego.banana;

/**
 * @author Yihleego
 */
public enum RuleEnum {
    VERTICAL_LAYOUT_SMUSH("vLayout", 16384, Layout.SMUSH_U.getCode()),
    VERTICAL_LAYOUT_FITTED("vLayout", 8192, Layout.FITTED.getCode()),
    VERTICAL_5("v5", 4096, 1),
    VERTICAL_4("v4", 2048, 1),
    VERTICAL_3("v3", 1024, 1),
    VERTICAL_2("v2", 512, 1),
    VERTICAL_1("v1", 256, 1),
    HORIZONTAL_LAYOUT_SMUSH("hLayout", 128, Layout.SMUSH_U.getCode()),
    HORIZONTAL_LAYOUT_FITTED("hLayout", 64, Layout.FITTED.getCode()),
    HORIZONTAL_6("h6", 32, 1),
    HORIZONTAL_5("h5", 16, 1),
    HORIZONTAL_4("h4", 8, 1),
    HORIZONTAL_3("h3", 4, 1),
    HORIZONTAL_2("h2", 2, 1),
    HORIZONTAL_1("h1", 1, 1);

    private final String key;
    private final int code;
    private final int value;

    RuleEnum(String key, int code, int value) {
        this.code = code;
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public int getCode() {
        return code;
    }


    public int getValue() {
        return value;
    }
}
