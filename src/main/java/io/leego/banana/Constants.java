package io.leego.banana;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Yihleego
 */
public final class Constants {
    public static final String ROOT_DIR_PATH = "banana";
    public static final String FONT_DIR_PATH = ROOT_DIR_PATH + "/fonts/";
    public static final int INVALID = 0;
    public static final int VALID = 1;
    public static final int END = 2;
    public static final Font DEFAULT_FONT = Font.STANDARD;
    public static final List<Integer> CODES;
    public static final List<Font> FONTS;

    static {
        CODES = Collections.unmodifiableList(codes());
        FONTS = Collections.unmodifiableList(fonts());
    }

    private Constants() {
    }

    private static List<Integer> codes() {
        List<Integer> codes = new ArrayList<>();
        // Adds ASCII codes.
        for (int i = 32; i < 127; i++) {
            codes.add(i);
        }
        // Adds extra codes.
        Collections.addAll(codes, 196, 214, 220, 223, 228, 246, 252);
        return codes;
    }

    private static List<Font> fonts() {
        List<Font> fonts = new ArrayList<>(Font.values().length);
        Collections.addAll(fonts, Font.values());
        return fonts;
    }

}
