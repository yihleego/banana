package io.leego.banana;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Banana is a FIGlet utility for Java.
 * FIGlet is a computer program that generates text banners,
 * in a variety of typefaces, composed of letters made up of
 * conglomerations of smaller ASCII characters.
 * @author Yihleego
 */
public final class BananaUtils {
    private static final String EMPTY = "";
    private static final String BLANK = " ";
    private static final ConcurrentMap<Font, Meta> cache = new ConcurrentHashMap<>();

    private BananaUtils() {
    }

    /**
     * Returns all fonts.
     * @return all fonts.
     */
    public static List<Font> fonts() {
        return Constants.FONTS;
    }

    /**
     * Returns the FIGlet of the text.
     * @param text the original text.
     * @return the FIGlet of the text.
     */
    public static String bananaify(String text) {
        return bananaify(text, null, null, null);
    }

    /**
     * Returns the FIGlet of the text.
     * @param text             the original text.
     * @param horizontalLayout the horizontal layout.
     * @param verticalLayout   the vertical layout.
     * @return the FIGlet of the text.
     */
    public static String bananaify(String text, Layout horizontalLayout, Layout verticalLayout) {
        return bananaify(text, null, horizontalLayout, verticalLayout);
    }

    /**
     * Returns the FIGlet of the text with the specified font.
     * @param text the original text.
     * @param font the specified font.
     * @return the FIGlet of the text.
     */
    public static String bananaify(String text, Font font) {
        return bananaify(text, font, null, null);
    }

    /**
     * Returns the FIGlet of the text with the specified font.
     * @param text             the original text.
     * @param font             the specified font.
     * @param horizontalLayout the horizontal layout.
     * @param verticalLayout   the vertical layout.
     * @return the FIGlet of the text.
     */
    public static String bananaify(String text, Font font, Layout horizontalLayout, Layout verticalLayout) {
        String[] lines = generateFiglet(text, font, horizontalLayout, verticalLayout);
        if (lines == null || lines.length == 0) {
            return EMPTY;
        }
        StringBuilder sb = new StringBuilder();
        for (String s : lines) {
            sb.append(s).append('\n');
        }
        if (sb.length() > 1) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    /**
     * Returns the FIGlet of the text with the specified styles.
     * @param text   the original text.
     * @param styles the specified styles.
     * @return the FIGlet of the text.
     */
    public static String bananansi(String text, Ansi... styles) {
        return bananansi(text, null, null, null, styles);
    }

    /**
     * Returns the FIGlet of the text with the specified styles.
     * @param text             the original text.
     * @param horizontalLayout the horizontal layout.
     * @param verticalLayout   the vertical layout.
     * @param styles           the specified styles.
     * @return the FIGlet of the text.
     */
    public static String bananansi(String text, Layout horizontalLayout, Layout verticalLayout, Ansi... styles) {
        return bananansi(text, null, horizontalLayout, verticalLayout, styles);
    }

    /**
     * Returns the FIGlet of the text with the specified font and styles.
     * @param text   the original text.
     * @param font   the specified font.
     * @param styles the specified styles.
     * @return the FIGlet of the text.
     */
    public static String bananansi(String text, Font font, Ansi... styles) {
        return bananansi(text, font, null, null, styles);
    }

    /**
     * Returns the FIGlet of the text with the specified font and styles.
     * @param text             the original text.
     * @param font             the specified font.
     * @param horizontalLayout the horizontal layout.
     * @param verticalLayout   the vertical layout.
     * @param styles           the specified styles.
     * @return the FIGlet of the text.
     */
    public static String bananansi(String text, Font font, Layout horizontalLayout, Layout verticalLayout, Ansi... styles) {
        String[] lines = generateFiglet(text, font, horizontalLayout, verticalLayout);
        if (lines == null || lines.length == 0) {
            return EMPTY;
        }
        StringBuilder sb = new StringBuilder();
        for (String s : lines) {
            sb.append(Ansi.ansify(s, styles)).append('\n');
        }
        if (sb.length() > 1) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    /**
     * Returns the FIGlet of the text with the specified font.
     * @param text             the original text.
     * @param font             the specified font.
     * @param horizontalLayout the horizontal layout.
     * @param verticalLayout   the vertical layout.
     * @return the FIGlet of the text.
     */
    public static String[] generateFiglet(String text, Font font, Layout horizontalLayout, Layout verticalLayout) {
        if (text == null) {
            return new String[0];
        }
        Meta meta = getMeta(font);
        if (meta == null) {
            return new String[0];
        }
        Option option = setLayout(meta.getOption(), horizontalLayout, verticalLayout);
        String[] lines = text.split("\\r?\\n");
        String[][] figletLines = new String[lines.length][];
        for (int i = 0; i < lines.length; i++) {
            figletLines[i] = generateFigletLine(lines[i], meta.getFigletMap(), option);
        }
        String[] output = figletLines[0];
        for (int i = 1; i < figletLines.length; i++) {
            output = smushVerticalFigletLines(output, figletLines[i], option);
        }
        return output;
    }

    private static Meta getMeta(Font font) {
        if (font == null) {
            font = Constants.DEFAULT_FONT;
        }
        Meta cachedMeta = cache.get(font);
        if (cachedMeta != null) {
            return cachedMeta;
        }
        Meta newMeta = buildMeta(font);
        if (newMeta != null) {
            cache.putIfAbsent(font, newMeta);
            return newMeta;
        }
        return null;
    }

    private static Meta buildMeta(Font font) {
        // Reads file content.
        List<String> data = new ArrayList<>();
        try {
            String path = Constants.FONT_DIR_PATH + font.getFilename();
            InputStream inputStream = BananaUtils.class.getClassLoader().getResourceAsStream(path);
            if (inputStream == null) {
                return null;
            }
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, font.getCharset());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                data.add(line);
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load font \"" + font.getName() + "\"", e);
        }
        // Builds option.
        Option option = new Option();
        String[] header = data.get(0).split(BLANK);
        option.setHardBlank(header[0].substring(5, 6));
        option.setHeight(Integer.parseInt(header[1]));
        option.setBaseline(Integer.parseInt(header[2]));
        option.setMaxLength(Integer.parseInt(header[3]));
        option.setOldLayout(Integer.parseInt(header[4]));
        option.setNumCommentLines(Integer.parseInt(header[5]));
        option.setPrintDirection(header.length > 6 ? Integer.parseInt(header[6]) : 0);
        option.setFullLayout(header.length > 7 ? Integer.parseInt(header[7]) : null);
        option.setCodeTagCount(header.length > 8 ? Integer.parseInt(header[8]) : null);
        option.setRule(getSmushRule(option.getOldLayout(), option.getFullLayout()));
        // Reads comment.
        StringBuilder comment = new StringBuilder();
        int num = 0;
        while (++num <= option.getNumCommentLines()) {
            comment.append(data.get(num)).append("\n");
        }
        // Builds FIGlet map.
        List<Integer> codes = Constants.CODES;
        int height = option.getHeight();
        Map<Integer, String[]> figletMap = new HashMap<>(codes.size());
        String mark = data.get(num).substring(data.get(num).length() - 1);
        if (isEmpty(mark)) {
            mark = "@";
        }
        for (int i = 0; i < codes.size(); i++) {
            Integer code = codes.get(i);
            if (i * height + num >= data.size()) {
                break;
            }
            String[] figlet = new String[height];
            figletMap.put(code, figlet);
            for (int j = 0; j < height; j++) {
                int row = i * height + j + num;
                if (row >= data.size()) {
                    figletMap.remove(code);
                    break;
                }
                figlet[j] = data.get(row).replace(mark, EMPTY);
            }
        }
        data.clear();
        return new Meta(font, option, figletMap, comment.toString());
    }

    private static String[] generateFigletLine(String text, Map<Integer, String[]> figletMap, Option option) {
        int height = option.getHeight();
        String[] output = new String[height];
        for (int i = 0; i < height; i++) {
            output[i] = EMPTY;
        }
        for (int index = 0; index < text.length(); index++) {
            String[] figlet = figletMap.get((int) text.charAt(index));
            if (figlet == null) {
                continue;
            }
            int overlap = 0;
            if (option.getRule().getHorizontalLayout() != Layout.FULL) {
                int length = Integer.MAX_VALUE;
                for (int i = 0; i < height; i++) {
                    length = Math.min(length, getHorizontalSmushLength(output[i], figlet[i], option));
                }
                overlap = length == Integer.MAX_VALUE ? 0 : length;
            }
            output = smushHorizontal(output, figlet, overlap, option);
        }
        for (int i = 0; i < output.length; i++) {
            output[i] = output[i].replace(option.getHardBlank(), BLANK);
        }
        return output;
    }

    private static Option setLayout(Option option, Layout horizontalLayout, Layout verticalLayout) {
        if ((horizontalLayout == null || horizontalLayout == Layout.DEFAULT)
                && (verticalLayout == null || verticalLayout == Layout.DEFAULT)) {
            return option;
        }
        Option newOption = option.copy();
        setHorizontalLayout(newOption, horizontalLayout);
        setVerticalLayout(newOption, verticalLayout);
        return newOption;
    }

    private static void setHorizontalLayout(Option option, Layout layout) {
        if (layout == null || layout == Layout.DEFAULT) {
            return;
        }
        Rule rule = option.getRule();
        if (layout == Layout.FULL) {
            rule.setHorizontal(Layout.FULL, false, false, false, false, false, false);
        } else if (layout == Layout.FITTED) {
            rule.setHorizontal(Layout.FITTED, false, false, false, false, false, false);
        } else if (layout == Layout.SMUSH_U) {
            rule.setHorizontal(Layout.SMUSH_U, false, false, false, false, false, false);
        } else if (layout == Layout.SMUSH_R) {
            rule.setHorizontal(Layout.SMUSH_R, true, true, true, true, true, true);
        }
    }

    private static void setVerticalLayout(Option option, Layout layout) {
        if (layout == null || layout == Layout.DEFAULT) {
            return;
        }
        Rule rule = option.getRule();
        if (layout == Layout.FULL) {
            rule.setVertical(Layout.FULL, false, false, false, false, false);
        } else if (layout == Layout.FITTED) {
            rule.setVertical(Layout.FITTED, false, false, false, false, false);
        } else if (layout == Layout.SMUSH_U) {
            rule.setVertical(Layout.SMUSH_U, false, false, false, false, false);
        } else if (layout == Layout.SMUSH_R) {
            rule.setVertical(Layout.SMUSH_R, true, true, true, true, true);
        }
    }

    private static String[] smushHorizontal(String[] figlet1, String[] figlet2, int overlap, Option option) {
        int height = option.getHeight();
        Rule rule = option.getRule();
        String hardBlank = option.getHardBlank();
        String[] output = new String[height];
        for (int i = 0; i < height; i++) {
            String text1 = figlet1[i];
            String text2 = figlet2[i];
            int len1 = text1.length();
            int len2 = text2.length();
            int overlapStart = len1 - overlap;
            StringBuilder piece = new StringBuilder();
            piece.append(substr(text1, 0, Math.max(0, overlapStart)));
            // Determines overlap piece.
            String seg1 = substr(text1, Math.max(0, len1 - overlap), overlap);
            String seg2 = substr(text2, 0, Math.min(overlap, len2));
            for (int j = 0; j < overlap; j++) {
                String ch1 = j < len1 ? substr(seg1, j, 1) : BLANK;
                String ch2 = j < len2 ? substr(seg2, j, 1) : BLANK;
                if (!BLANK.equals(ch1) && !BLANK.equals(ch2)) {
                    if (rule.getHorizontalLayout() == Layout.FITTED) {
                        piece.append(smushUniversal(ch1, ch2, hardBlank));
                    } else if (rule.getHorizontalLayout() == Layout.SMUSH_U) {
                        piece.append(smushUniversal(ch1, ch2, hardBlank));
                    } else {
                        String nextCh = EMPTY;
                        if (isEmpty(nextCh) && rule.isHorizontal1())
                            nextCh = smushHorizontalRule1(ch1, ch2, hardBlank);
                        if (isEmpty(nextCh) && rule.isHorizontal2())
                            nextCh = smushHorizontalRule2(ch1, ch2);
                        if (isEmpty(nextCh) && rule.isHorizontal3())
                            nextCh = smushHorizontalRule3(ch1, ch2);
                        if (isEmpty(nextCh) && rule.isHorizontal4())
                            nextCh = smushHorizontalRule4(ch1, ch2);
                        if (isEmpty(nextCh) && rule.isHorizontal5())
                            nextCh = smushHorizontalRule5(ch1, ch2);
                        if (isEmpty(nextCh) && rule.isHorizontal6())
                            nextCh = smushHorizontalRule6(ch1, ch2, hardBlank);
                        if (isEmpty(nextCh))
                            nextCh = smushUniversal(ch1, ch2, hardBlank);
                        piece.append(nextCh);
                    }
                } else {
                    piece.append(smushUniversal(ch1, ch2, hardBlank));
                }
            }
            if (overlap < len2) {
                piece.append(substr(text2, overlap, Math.max(0, len2 - overlap)));
            }
            output[i] = piece.toString();
        }
        return output;
    }

    private static int getHorizontalSmushLength(String text1, String text2, Option option) {
        Rule rule = option.getRule();
        String hardBlank = option.getHardBlank();
        if (rule.getHorizontalLayout() == Layout.FULL) {
            return 0;
        }
        int len1 = text1.length();
        int len2 = text2.length();
        int curDist = 1;
        int maxDist = text1.length();
        boolean breakAfter = false;
        boolean validSmush = false;
        if (len1 == 0) {
            return 0;
        }
        while (curDist <= maxDist) {
            boolean skip = false;
            String seg1 = substr(text1, len1 - curDist, len1);
            String seg2 = substr(text2, 0, Math.min(curDist, len2));
            for (int i = 0; i < Math.min(curDist, len2); i++) {
                String ch1 = substr(seg1, i, 1);
                String ch2 = substr(seg2, i, 1);
                if (!BLANK.equals(ch1) && !BLANK.equals(ch2)) {
                    if (rule.getHorizontalLayout() == Layout.FITTED) {
                        curDist = curDist - 1;
                        skip = true;
                        break;
                    } else if (rule.getHorizontalLayout() == Layout.SMUSH_U) {
                        if (equals(ch1, hardBlank) || equals(ch2, hardBlank)) {
                            curDist = curDist - 1;
                        }
                        skip = true;
                        break;
                    } else {
                        breakAfter = true;
                        validSmush = false;
                        if (rule.isHorizontal1())
                            validSmush = isNotEmpty(smushHorizontalRule1(ch1, ch2, hardBlank));
                        if (!validSmush && rule.isHorizontal2())
                            validSmush = isNotEmpty(smushHorizontalRule2(ch1, ch2));
                        if (!validSmush && rule.isHorizontal3())
                            validSmush = isNotEmpty(smushHorizontalRule3(ch1, ch2));
                        if (!validSmush && rule.isHorizontal4())
                            validSmush = isNotEmpty(smushHorizontalRule4(ch1, ch2));
                        if (!validSmush && rule.isHorizontal5())
                            validSmush = isNotEmpty(smushHorizontalRule5(ch1, ch2));
                        if (!validSmush && rule.isHorizontal6())
                            validSmush = isNotEmpty(smushHorizontalRule6(ch1, ch2, hardBlank));
                        if (!validSmush) {
                            curDist = curDist - 1;
                            skip = true;
                            break;
                        }
                    }
                }
            }
            if (skip) {
                break;
            }
            if (breakAfter) {
                break;
            }
            curDist++;
        }
        return Math.min(maxDist, curDist);
    }

    private static Rule getSmushRule(Integer oldLayout, Integer newLayout) {
        Map<String, Integer> rules = new HashMap<>();
        RuleEnum[] ruleEnums = RuleEnum.values();
        int layout = newLayout != null ? newLayout : oldLayout;
        for (RuleEnum rule : ruleEnums) {
            String key = rule.getKey();
            int code = rule.getCode();
            int value = rule.getValue();
            if (layout >= code) {
                layout -= code;
                if (!rules.containsKey(key)) {
                    rules.put(key, value);
                }
            } else if (!equals(RuleEnum.HORIZONTAL_LAYOUT_SMUSH.getKey(), key)
                    && !equals(RuleEnum.VERTICAL_LAYOUT_SMUSH.getKey(), key)) {
                rules.put(key, 0);
            }
        }
        Rule rule = new Rule(
                Layout.get(rules.get(RuleEnum.HORIZONTAL_LAYOUT_SMUSH.getKey())),
                equals(rules.get(RuleEnum.HORIZONTAL_1.getKey()), 1),
                equals(rules.get(RuleEnum.HORIZONTAL_2.getKey()), 1),
                equals(rules.get(RuleEnum.HORIZONTAL_3.getKey()), 1),
                equals(rules.get(RuleEnum.HORIZONTAL_4.getKey()), 1),
                equals(rules.get(RuleEnum.HORIZONTAL_5.getKey()), 1),
                equals(rules.get(RuleEnum.HORIZONTAL_6.getKey()), 1),
                Layout.get(rules.get(RuleEnum.VERTICAL_LAYOUT_SMUSH.getKey())),
                equals(rules.get(RuleEnum.VERTICAL_1.getKey()), 1),
                equals(rules.get(RuleEnum.VERTICAL_2.getKey()), 1),
                equals(rules.get(RuleEnum.VERTICAL_3.getKey()), 1),
                equals(rules.get(RuleEnum.VERTICAL_4.getKey()), 1),
                equals(rules.get(RuleEnum.VERTICAL_5.getKey()), 1)
        );
        if (rule.getHorizontalLayout() == null) {
            if (oldLayout == 0) {
                rule.setHorizontalLayout(Layout.FITTED);
            } else if (oldLayout == -1) {
                rule.setHorizontalLayout(Layout.FULL);
            } else if (rule.isHorizontal1()
                    || rule.isHorizontal2()
                    || rule.isHorizontal3()
                    || rule.isHorizontal4()
                    || rule.isHorizontal5()
                    || rule.isHorizontal6()) {
                rule.setHorizontalLayout(Layout.SMUSH_R);
            } else {
                rule.setHorizontalLayout(Layout.SMUSH_U);
            }
        } else if (rule.getHorizontalLayout() == Layout.SMUSH_U
                && rule.isHorizontal1()
                || rule.isHorizontal2()
                || rule.isHorizontal3()
                || rule.isHorizontal4()
                || rule.isHorizontal5()
                || rule.isHorizontal6()) {
            rule.setHorizontalLayout(Layout.SMUSH_R);
        }
        if (rule.getVerticalLayout() == null) {
            if (rule.isVertical1()
                    || rule.isVertical2()
                    || rule.isVertical3()
                    || rule.isVertical4()
                    || rule.isVertical5()) {
                rule.setVerticalLayout(Layout.SMUSH_R);
            } else {
                rule.setVerticalLayout(Layout.FULL);
            }
        } else if (rule.getVerticalLayout() == Layout.SMUSH_U
                && rule.isVertical1()
                || rule.isVertical2()
                || rule.isVertical3()
                || rule.isVertical4()
                || rule.isVertical5()) {
            rule.setVerticalLayout(Layout.SMUSH_R);
        }
        return rule;
    }

    private static String[] smushVerticalFigletLines(String[] figlet1, String[] figlet2, Option option) {
        int len1 = figlet1[0].length();
        int len2 = figlet2[0].length();
        int overlap;
        if (len1 > len2) {
            padLines(figlet2, len1 - len2);
        } else if (len2 > len1) {
            padLines(figlet1, len2 - len1);
        }
        overlap = getVerticalSmushDist(figlet1, figlet2, option);
        return smushVertical(figlet1, figlet2, overlap, option);
    }

    private static void padLines(String[] lines, int numSpaces) {
        StringBuilder padding = new StringBuilder();
        for (int i = 0; i < numSpaces; i++) {
            padding.append(BLANK);
        }
        String padded = padding.toString();
        for (int i = 0; i < lines.length; i++) {
            lines[i] += padded;
        }
    }

    private static int getVerticalSmushDist(String[] figlet1, String[] figlet2, Option option) {
        int curDist = 1;
        int maxDist = figlet1.length;
        int len1 = figlet1.length;
        String[] subLines1;
        String[] subLines2;
        while (curDist <= maxDist) {
            subLines1 = slice(figlet1, Math.max(0, len1 - curDist), len1);
            subLines2 = slice(figlet2, 0, Math.min(maxDist, curDist));
            int result = Constants.VALID;
            for (int i = 0; i < subLines2.length; i++) {
                int ret = canSmushVertical(subLines1[i], subLines2[i], option);
                if (Constants.END == ret) {
                    result = ret;
                } else if (Constants.INVALID == ret) {
                    result = ret;
                    break;
                }
            }
            if (Constants.INVALID == result) {
                curDist--;
                break;
            }
            if (Constants.END == result) {
                break;
            }
            curDist++;
        }
        return Math.min(maxDist, curDist);
    }

    /**
     * Takes in two lines of text and returns one of the following:
     * "valid" - These lines can be smushed together given the current smushing rules.
     * "end" - The lines can be smushed, but we're at a stopping point.
     * "invalid" - The two lines cannot be smushed together.
     * @param line1  A line of text.
     * @param line2  A line of text.
     * @param option the option.
     */
    private static int canSmushVertical(String line1, String line2, Option option) {
        Rule rule = option.getRule();
        if (rule.getVerticalLayout() == Layout.FULL) {
            return Constants.INVALID;
        }
        int len = Math.min(line1.length(), line2.length());
        String ch1;
        String ch2;
        boolean endSmush = false;
        boolean validSmush;
        if (len == 0) {
            return Constants.INVALID;
        }
        for (int i = 0; i < len; i++) {
            ch1 = substr(line1, i, 1);
            ch2 = substr(line2, i, 1);
            if (!BLANK.equals(ch1) && !BLANK.equals(ch2)) {
                if (rule.getVerticalLayout() == Layout.FITTED) {
                    return Constants.INVALID;
                } else if (rule.getVerticalLayout() == Layout.SMUSH_U) {
                    return Constants.END;
                } else {
                    if (isNotEmpty(smushVerticalRule5(ch1, ch2))) {
                        continue;
                    }
                    // rule 5 allow for "super" smushing, but only if we're not already ending this smush
                    validSmush = false;
                    if (rule.isVertical1())
                        validSmush = isNotEmpty(smushVerticalRule1(ch1, ch2));
                    if (!validSmush && rule.isVertical2())
                        validSmush = isNotEmpty(smushVerticalRule2(ch1, ch2));
                    if (!validSmush && rule.isVertical3())
                        validSmush = isNotEmpty(smushVerticalRule3(ch1, ch2));
                    if (!validSmush && rule.isVertical4())
                        validSmush = isNotEmpty(smushVerticalRule4(ch1, ch2));
                    endSmush = true;
                    if (!validSmush) {
                        return Constants.INVALID;
                    }
                }
            }
        }
        if (endSmush) {
            return Constants.END;
        } else {
            return Constants.VALID;
        }
    }

    private static String[] smushVertical(String[] figlet1, String[] figlet2, int overlap, Option option) {
        int len1 = figlet1.length;
        int len2 = figlet2.length;
        String[] piece1 = slice(figlet1, 0, Math.max(0, len1 - overlap));
        String[] piece21 = slice(figlet1, Math.max(0, len1 - overlap), len1);
        String[] piece22 = slice(figlet2, 0, Math.min(overlap, len2));
        String line;
        String[] piece2 = new String[piece21.length];
        String[] piece3;
        for (int i = 0; i < piece21.length; i++) {
            if (i >= len2) {
                line = piece21[i];
            } else {
                line = smushVerticalLines(piece21[i], piece22[i], option);
            }
            piece2[i] = line;
        }
        piece3 = slice(figlet2, Math.min(overlap, len2), len2);
        return concat(piece1, piece2, piece3);
    }

    private static String smushVerticalLines(String line1, String line2, Option option) {
        Rule rule = option.getRule();
        int len = Math.min(line1.length(), line2.length());
        String ch1;
        String ch2;
        String validSmush = EMPTY;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < len; i++) {
            ch1 = substr(line1, i, 1);
            ch2 = substr(line2, i, 1);
            if (!BLANK.equals(ch1) && !BLANK.equals(ch2)) {
                if (rule.getVerticalLayout() == Layout.FITTED) {
                    result.append(smushUniversal(ch1, ch2, null));
                } else if (rule.getVerticalLayout() == Layout.SMUSH_U) {
                    result.append(smushUniversal(ch1, ch2, null));
                } else {
                    if (rule.isVertical5())
                        validSmush = smushVerticalRule5(ch1, ch2);
                    if (isEmpty(validSmush) && rule.isVertical1())
                        validSmush = smushVerticalRule1(ch1, ch2);
                    if (isEmpty(validSmush) && rule.isVertical2())
                        validSmush = smushVerticalRule2(ch1, ch2);
                    if (isEmpty(validSmush) && rule.isVertical3())
                        validSmush = smushVerticalRule3(ch1, ch2);
                    if (isEmpty(validSmush) && rule.isVertical4())
                        validSmush = smushVerticalRule4(ch1, ch2);
                    result.append(validSmush);
                }
            } else {
                result.append(smushUniversal(ch1, ch2, null));
            }
        }
        return result.toString();
    }

    /**
     * Rule 1: EQUAL CHARACTER SMUSHING (code value 1)
     * Two sub-characters are smushed into a single sub-character
     * if they are the same.  This rule does not smush hardblanks.
     * (See rule 6 on hardblanks below)
     */
    private static String smushHorizontalRule1(String s1, String s2, String hardBlank) {
        if (equals(s1, s2) && !equals(s1, hardBlank)) {
            return s1;
        }
        return EMPTY;
    }

    /**
     * Rule 2: UNDERSCORE SMUSHING (code value 2)
     * An underscore ("_") will be replaced by any of:
     * "|", "/", "\", "[", "]", "{", "}", "(", ")", "<" or ">".
     */
    private static String smushHorizontalRule2(String s1, String s2) {
        String rule = "|/\\[]{}()<>";
        if (equals("_", s1)) {
            if (rule.contains(s2)) {
                return s2;
            }
        } else if (equals("_", s2)) {
            if (rule.contains(s1)) {
                return s1;
            }
        }
        return EMPTY;
    }

    /**
     * Rule 3: HIERARCHY SMUSHING (code value 4)
     * A hierarchy of six classes is used: "|", "/\", "[]", "{}", "()", and "<>".
     * When two smushing sub-characters are from different classes,
     * the one from the latter class will be used.
     */
    private static String smushHorizontalRule3(String s1, String s2) {
        String rule = "| /\\ [] {} () <>";
        int pos1 = rule.indexOf(s1);
        int pos2 = rule.indexOf(s2);
        if (pos1 != -1 && pos2 != -1 && pos1 != pos2 && Math.abs(pos1 - pos2) != 1) {
            return substr(rule, Math.max(pos1, pos2), 1);
        }
        return EMPTY;
    }

    /**
     * Rule 4: OPPOSITE PAIR SMUSHING (code value 8)
     * Smushes opposing brackets ("[]" or "]["), braces ("{}" or "}{")
     * and parentheses ("()" or ")(") together, replacing
     * any such pair with a vertical bar ("|").
     */
    private static String smushHorizontalRule4(String s1, String s2) {
        String rule = "[] {} ()";
        int pos1 = rule.indexOf(s1);
        int pos2 = rule.indexOf(s2);
        if (pos1 != -1 && pos2 != -1 && Math.abs(pos1 - pos2) <= 1) {
            return "|";
        }
        return EMPTY;
    }

    /**
     * Rule 5: BIG X SMUSHING (code value 16)
     * Smushes "/\" into "|", "\/" into "Y", and "><" into "X".
     * Note that "<>" is not smushed in any way by this rule.
     * The name "BIG X" is historical; originally all three pairs
     * were smushed into "X".
     */
    private static String smushHorizontalRule5(String s1, String s2) {
        String rule = "/\\ \\/ ><";
        int pos1 = rule.indexOf(s1);
        int pos2 = rule.indexOf(s2);
        if (pos1 != -1 && pos2 != -1 && pos2 - pos1 == 1) {
            if (pos1 == 0) {
                return "|";
            } else if (pos1 == 3) {
                return "Y";
            } else if (pos1 == 6) {
                return "X";
            }
        }
        return EMPTY;
    }

    /**
     * Rule 6: HARDBLANK SMUSHING (code value 32)
     * Smushes two hardblanks together, replacing them with a single hardblank.
     * (See "Hardblanks" below.)
     */
    private static String smushHorizontalRule6(String s1, String s2, String hardBlank) {
        if (equals(s1, hardBlank) && equals(s2, hardBlank)) {
            return hardBlank;
        }
        return EMPTY;
    }

    /**
     * Rule 1: EQUAL CHARACTER SMUSHING (code value 256)
     * Same as horizontal smushing rule 1.
     */
    private static String smushVerticalRule1(String s1, String s2) {
        if (equals(s1, s2)) {
            return s1;
        }
        return EMPTY;
    }

    /**
     * Rule 2: UNDERSCORE SMUSHING (code value 512)
     * Same as horizontal smushing rule 2.
     */
    private static String smushVerticalRule2(String s1, String s2) {
        String rule = "|/\\[]{}()<>";
        if (equals("_", s1)) {
            if (rule.contains(s2)) {
                return s2;
            }
        } else if (equals("_", s2)) {
            if (rule.contains(s1)) {
                return s1;
            }
        }
        return EMPTY;
    }

    /**
     * Rule 3: HIERARCHY SMUSHING (code value 1024)
     * Same as horizontal smushing rule 3.
     */
    private static String smushVerticalRule3(String s1, String s2) {
        String rule = "| /\\ [] {} () <>";
        int pos1 = rule.indexOf(s1);
        int pos2 = rule.indexOf(s2);
        if (pos1 != -1 && pos2 != -1 && pos1 != pos2 && Math.abs(pos1 - pos2) != 1) {
            return substr(rule, Math.max(pos1, pos2), 1);
        }
        return EMPTY;
    }

    /**
     * Rule 4: HORIZONTAL LINE SMUSHING (code value 2048)
     * Smushes stacked pairs of "-" and "_", replacing them with
     * a single "=" sub-character.  It does not matter which is
     * found above the other.  Note that vertical smushing rule 1
     * will smush IDENTICAL pairs of horizontal lines, while this
     * rule smushes horizontal lines consisting of DIFFERENT
     * sub-characters.
     */
    private static String smushVerticalRule4(String s1, String s2) {
        if ((equals("-", s1) && equals("_", s2)) || (equals("_", s1) && equals("-", s2))) {
            return "=";
        }
        return EMPTY;
    }

    /**
     * Rule 5: VERTICAL LINE SUPERSMUSHING (code value 4096)
     * This one rule is different from all others, in that it
     * "supersmushes" vertical lines consisting of several
     * vertical bars ("|").  This creates the illusion that
     * FIGcharacters have slid vertically against each other.
     * Supersmushing continues until any sub-characters other
     * than "|" would have to be smushed.  Supersmushing can
     * produce impressive results, but it is seldom possible,
     * since other sub-characters would usually have to be
     * considered for smushing as soon as any such stacked
     * vertical lines are encountered.
     */
    private static String smushVerticalRule5(String s1, String s2) {
        if (equals("|", s1) && equals("|", s2)) {
            return "|";
        }
        return EMPTY;
    }

    /**
     * Universal smushing simply overrides the sub-character from the
     * earlier FIGcharacter with the sub-character from the later
     * FIGcharacter.  This produces an "overlapping" effect with some
     * FIGfonts, wherin the latter FIGcharacter may appear to be "in front".
     */
    private static String smushUniversal(String s1, String s2, String hardBlank) {
        if (equals(BLANK, s2) || equals(EMPTY, s2)) {
            return s1;
        } else if (equals(s2, hardBlank) && !equals(BLANK, s1)) {
            return s1;
        } else {
            return s2;
        }
    }

    /**
     * Combines string array.
     * @param texts the tests.
     * @return the combined string array.
     */
    private static String[] concat(String[]... texts) {
        if (texts == null || texts.length == 0) {
            return new String[0];
        }
        int length = 0;
        for (String[] piece : texts) {
            length += piece.length;
        }
        String[] result = new String[length];
        int i = 0;
        for (String[] piece : texts) {
            for (String s : piece) {
                result[i++] = s;
            }
        }
        return result;
    }

    /**
     * Returns a string that is a substring of this string.
     * @param s      the string.
     * @param start  the beginning index.
     * @param length the length of specified substring.
     * @return the specified substring.
     */
    private static String substr(String s, int start, int length) {
        if (isEmpty(s)) {
            return EMPTY;
        }
        return s.substring(start, Math.min(start + length, s.length()));
    }

    /**
     * Returns a section of an array.
     * @param array the array.
     * @param start the beginning of the specified portion of the array.
     * @param end   the end of the specified portion of the array.
     */
    private static String[] slice(String[] array, int start, int end) {
        String[] result = new String[end - start];
        int index = 0;
        for (int i = start; i < end; i++) {
            result[index++] = array[i];
        }
        return result;
    }

    /**
     * Checks whether the given {@code String} is empty.
     * @param s the candidate String.
     * @return {@code true} if the {@code String} is empty.
     */
    private static boolean isEmpty(String s) {
        return null == s || EMPTY.equals(s);
    }

    /**
     * Checks that the given {@code String} is neither {@code null} nor of length 0.
     * @param s the string.
     * @return <code>true</code> if the String is not empty and not null.
     */
    private static boolean isNotEmpty(String s) {
        return !isEmpty(s);
    }

    /**
     * Returns {@code true} if the arguments are equal to each other
     * and {@code false} otherwise.
     * @param a an object.
     * @param b an object to be compared with {@code a} for equality
     * @return {@code true} if the arguments are equal to each other
     * and {@code false} otherwise.
     */
    private static boolean equals(Object a, Object b) {
        return (a == b) || (a != null && a.equals(b));
    }

}
