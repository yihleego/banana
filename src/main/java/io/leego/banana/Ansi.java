package io.leego.banana;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yihleego
 */
public class Ansi {
    /** Ansi-Colors */
    public static final Ansi BLACK;
    public static final Ansi RED;
    public static final Ansi GREEN;
    public static final Ansi YELLOW;
    public static final Ansi BLUE;
    public static final Ansi PURPLE;
    public static final Ansi CYAN;
    public static final Ansi WHITE;
    /** Background-Colors */
    public static final Ansi BG_BLACK;
    public static final Ansi BG_RED;
    public static final Ansi BG_GREEN;
    public static final Ansi BG_YELLOW;
    public static final Ansi BG_BLUE;
    public static final Ansi BG_PURPLE;
    public static final Ansi BG_CYAN;
    public static final Ansi BG_WHITE;
    /** Others */
    public static final Ansi NORMAL;
    public static final Ansi BOLD;
    public static final Ansi FAINT;
    public static final Ansi ITALIC;
    public static final Ansi UNDERLINE;
    public static final Ansi SLOW_BLINK;
    public static final Ansi RAPID_BLINK;
    public static final Ansi REVERSE_VIDEO;
    public static final Ansi CONCEAL;
    public static final Ansi CROSSED_OUT;
    public static final Ansi PRIMARY;

    private static final List<Ansi> VALUES;
    private static final Map<String, Ansi> MAP;

    static {
        List<Ansi> values = new ArrayList<>();
        values.add(BLACK = new Ansi("30"));
        values.add(RED = new Ansi("31"));
        values.add(GREEN = new Ansi("32"));
        values.add(YELLOW = new Ansi("33"));
        values.add(BLUE = new Ansi("34"));
        values.add(PURPLE = new Ansi("35"));
        values.add(CYAN = new Ansi("36"));
        values.add(WHITE = new Ansi("37"));
        values.add(BG_BLACK = new Ansi("40"));
        values.add(BG_RED = new Ansi("41"));
        values.add(BG_GREEN = new Ansi("42"));
        values.add(BG_YELLOW = new Ansi("43"));
        values.add(BG_BLUE = new Ansi("44"));
        values.add(BG_PURPLE = new Ansi("45"));
        values.add(BG_CYAN = new Ansi("46"));
        values.add(BG_WHITE = new Ansi("47"));
        values.add(NORMAL = new Ansi("0"));
        values.add(BOLD = new Ansi("1"));
        values.add(FAINT = new Ansi("2"));
        values.add(ITALIC = new Ansi("3"));
        values.add(UNDERLINE = new Ansi("4"));
        values.add(SLOW_BLINK = new Ansi("5"));
        values.add(RAPID_BLINK = new Ansi("6"));
        values.add(REVERSE_VIDEO = new Ansi("7"));
        values.add(CONCEAL = new Ansi("8"));
        values.add(CROSSED_OUT = new Ansi("9"));
        values.add(PRIMARY = new Ansi("10"));
        Map<String, Ansi> map = new HashMap<>(values.size());
        for (Ansi v : values) {
            map.put(v.code, v);
        }
        VALUES = Collections.unmodifiableList(values);
        MAP = Collections.unmodifiableMap(map);
    }

    protected final String code;

    protected Ansi(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getAnsi() {
        return "\033[" + code + "m";
    }

    public static String ansify(String text, Ansi style) {
        if (text == null || text.isEmpty() || style == null) {
            return text;
        }
        return style.getAnsi() + text + NORMAL.getAnsi();
    }

    public static String ansify(String text, Ansi... styles) {
        if (text == null || text.isEmpty() || styles == null || styles.length == 0) {
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

    public static List<Ansi> values() {
        return VALUES;
    }

    public static Ansi get(String code) {
        return MAP.get(code);
    }

    public static Ansi getOrDefault(String code, Ansi defaultValue) {
        Ansi ansi;
        return (ansi = MAP.get(code)) != null ? ansi : defaultValue;
    }

}
