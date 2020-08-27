package io.leego.banana;

/**
 * @author Yihleego
 */
public enum Layout {
    DEFAULT(-1),
    FULL(0),
    FITTED(1),
    SMUSH_U(2),
    SMUSH_R(3);

    private final int code;

    Layout(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Layout get(Integer code) {
        if (code == null) {
            return null;
        }
        for (Layout e : values()) {
            if (code == e.code) {
                return e;
            }
        }
        return null;
    }

}
