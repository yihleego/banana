package io.leego.banana.enums;

/**
 * @author YihLeego
 */
public enum AnsiEnum {
    /** font color */
    BLACK("30"),
    RED("31"),
    GREEN("32"),
    YELLOW("33"),
    BLUE("34"),
    PURPLE("35"),
    CYAN("36"),
    WHITE("37"),
    /** background color */
    B_BLACK("40"),
    B_RED("41"),
    B_GREEN("42"),
    B_YELLOW("43"),
    B_BLUE("44"),
    B_PURPLE("45"),
    B_CYAN("46"),
    B_WHITE("47"),
    /** other */
    NORMAL("0"),
    BOLD("1"),
    FAINT("2"),
    ITALIC("3"),
    UNDERLINE("4"),
    SLOW_BLINK("5"),
    RAPID_BLINK("6"),
    REVERSE_VIDEO("7"),
    CONCEAL("8"),
    CROSSED_OUT("9"),
    PRIMARY("10");

    private final String code;

    AnsiEnum(String code) {
        this.code = code;
    }

    public String code() {
        return code;
    }

    public String ansi() {
        return "\033[" + code + "m";
    }

    public static String multiple(AnsiEnum... enums) {
        if (enums == null || enums.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder("\033[");
        for (AnsiEnum e : enums) {
            if (e == null) {
                continue;
            }
            sb.append(e.code()).append(";");
        }
        return sb.append("m").toString();
    }

    public static String multiple(String text, AnsiEnum... enums) {
        if (text == null || "".equals(text)) {
            return text;
        }
        if (enums == null || enums.length == 0) {
            return text;
        }
        StringBuilder sb = new StringBuilder("\033[");
        for (AnsiEnum e : enums) {
            if (e == null) {
                continue;
            }
            sb.append(e.code()).append(";");
        }
        return sb.append("m").append(text).append(NORMAL.ansi()).toString();
    }
}
