package io.leego.banana;

/**
 * @author Yihleego
 */
public enum Ansi {
    /** Font-Colors. */
    BLACK("30"),
    RED("31"),
    GREEN("32"),
    YELLOW("33"),
    BLUE("34"),
    PURPLE("35"),
    CYAN("36"),
    WHITE("37"),
    /** Background-Colors. */
    BG_BLACK("40"),
    BG_RED("41"),
    BG_GREEN("42"),
    BG_YELLOW("43"),
    BG_BLUE("44"),
    BG_PURPLE("45"),
    BG_CYAN("46"),
    BG_WHITE("47"),
    /** Others. */
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

    Ansi(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getAnsi() {
        return "\033[" + code + "m";
    }

    public static String ansify(String text, Ansi style) {
        if (text == null || "".equals(text) || style == null) {
            return text;
        }
        return style.getAnsi() + text + NORMAL.getAnsi();
    }

    public static String ansify(String text, Ansi... styles) {
        if (text == null || "".equals(text) || styles == null || styles.length == 0) {
            return text;
        }
        int count = 0;
        StringBuilder sb = new StringBuilder("\033[");
        for (Ansi style : styles) {
            if (style != null) {
                sb.append(style.getCode()).append(";");
            } else {
                count++;
            }
        }
        if (count == styles.length) {
            return text;
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.append("m").append(text).append(NORMAL.getAnsi()).toString();
    }
}
