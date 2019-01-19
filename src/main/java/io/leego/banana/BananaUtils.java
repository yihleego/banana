package io.leego.banana;

import io.leego.banana.bean.FittingRule;
import io.leego.banana.bean.FlfHolder;
import io.leego.banana.bean.Option;
import io.leego.banana.enums.AnsiEnum;
import io.leego.banana.enums.FittingLayoutEnum;
import io.leego.banana.enums.FittingRuleEnum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author YihLeego
 */
public final class BananaUtils {
    public static final FittingLayoutEnum LAYOUT_DEFAULT = FittingLayoutEnum.DEFAULT;
    public static final FittingLayoutEnum LAYOUT_FULL = FittingLayoutEnum.FULL;
    public static final FittingLayoutEnum LAYOUT_FITTING = FittingLayoutEnum.FITTING;
    public static final FittingLayoutEnum LAYOUT_SMUSH_U = FittingLayoutEnum.SMUSHING;
    public static final FittingLayoutEnum LAYOUT_SMUSH_R = FittingLayoutEnum.CONTROLLED_SMUSHING;

    private static final int DEFAULT = LAYOUT_DEFAULT.code();
    private static final int FULL = LAYOUT_FULL.code();
    private static final int FITTING = LAYOUT_FITTING.code();
    private static final int SMUSHING = LAYOUT_SMUSH_U.code();
    private static final int CONTROLLED_SMUSHING = LAYOUT_SMUSH_R.code();
    private static final String EMPTY = "";
    private static final String BLANK = " ";
    private static final String INVALID = "invalid";
    private static final String VALID = "valid";
    private static final String END = "end";
    private static final String RULE_2_EXP = "|/\\[]{}()<>";
    private static final String RULE_3_EXP = "| /\\ [] {} () <>";
    private static final String RULE_4_EXP = "[] {} ()";
    private static final String RULE_5_EXP = "/\\ \\/ ><";
    private static final String ROOT_DIR_PATH = "banana/";
    private static final String FLF_DIR_PATH = ROOT_DIR_PATH + "flf/";
    private static final String FLF_NAME_PATH = ROOT_DIR_PATH + "FLF_NAME";
    private static final String STANDARD_FLF = "Standard";
    private static final String FLF_EXTENSION = ".flf";
    private static Map<String, FlfHolder> flfMap = new HashMap<>();

    private BananaUtils() {
    }

    /**
     * Get all fonts
     * @return fonts
     */
    public static List<String> fonts() {
        List<String> fontList = new ArrayList<>(300);
        try (InputStream inputStream = BananaUtils.class.getClassLoader().getResourceAsStream(FLF_NAME_PATH)) {
            if (inputStream == null) {
                return fontList;
            }
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader dataReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = dataReader.readLine()) != null) {
                fontList.add(line.substring(0, line.lastIndexOf('.')));
            }
            dataReader.close();
            inputStreamReader.close();
        } catch (IOException ignored) {
        }
        return fontList;
    }

    /**
     * Convert text to FIGlet using standard font
     * @param text text
     * @return FIGlet
     */
    public static String bananaify(String text) {
        return bananaify(text, null);
    }

    /**
     * Convert text to FIGlet using standard font
     * @param text             text
     * @param horizontalLayout {@link FittingLayoutEnum}
     * @param verticalLayout   {@link FittingLayoutEnum}
     * @return FIGlet
     */
    public static String bananaify(String text, FittingLayoutEnum horizontalLayout, FittingLayoutEnum verticalLayout) {
        return bananaify(text, null, horizontalLayout, verticalLayout);
    }

    /**
     * Convert text to FIGlet using custom font
     * @param text text
     * @param font font
     * @return FIGlet
     */
    public static String bananaify(String text, String font) {
        return bananaify(text, font, (FittingLayoutEnum) null, null);
    }

    /**
     * Convert text to FIGlet using custom font
     * @param text             text
     * @param font             font
     * @param horizontalLayout option: 0(default), 1(full), 2(fitting), 3(smushing), 4(controlled_smushing)
     * @param verticalLayout   option: 0(default), 1(full), 2(fitting), 3(smushing), 4(controlled_smushing)
     * @return FIGlet
     */
    public static String bananaify(String text, String font, Integer horizontalLayout, Integer verticalLayout) {
        return bananaify(
                text, font,
                FittingLayoutEnum.getByCode(horizontalLayout),
                FittingLayoutEnum.getByCode(verticalLayout)
        );
    }

    /**
     * Convert text to FIGlet using custom font
     * @param text             text
     * @param font             font
     * @param horizontalLayout {@link FittingLayoutEnum}
     * @param verticalLayout   {@link FittingLayoutEnum}
     * @return FIGlet
     */
    public static String bananaify(String text, String font, FittingLayoutEnum horizontalLayout, FittingLayoutEnum verticalLayout) {
        String[] texts = bananaifyArray(text, font, horizontalLayout, verticalLayout);
        if (texts == null) {
            return null;
        }
        if (texts.length == 0) {
            return EMPTY;
        }
        StringBuilder sb = new StringBuilder();
        for (String s : texts) {
            sb.append(s).append("\n");
        }
        if (sb.length() > 1) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }


    /**
     * Convert text to FIGlet using standard font and ANSI escape code
     * @param text text
     * @param e    {@link AnsiEnum}
     * @return FIGlet
     */
    public static String bananansi(String text, AnsiEnum e) {
        if (e == null) {
            return bananaify(text);
        }
        return e.ansi() + bananaify(text) + AnsiEnum.NORMAL.ansi();
    }

    /**
     * Convert text to FIGlet using standard font and ANSI escape code
     * @param text  text
     * @param enums {@link AnsiEnum} array
     * @return FIGlet
     */
    public static String bananansi(String text, AnsiEnum... enums) {
        return bananansi(text, null, null, null, enums);
    }

    /**
     * Convert text to FIGlet using standard font and ANSI escape code
     * @param text             text
     * @param horizontalLayout {@link FittingLayoutEnum}
     * @param verticalLayout   {@link FittingLayoutEnum}
     * @param enums            {@link AnsiEnum} array
     * @return FIGlet
     */
    public static String bananansi(String text, FittingLayoutEnum horizontalLayout, FittingLayoutEnum verticalLayout, AnsiEnum... enums) {
        return bananansi(text, null, horizontalLayout, verticalLayout, enums);
    }

    /**
     * Convert text to FIGlet using custom font and ANSI escape code
     * @param text  text
     * @param font  font
     * @param enums {@link AnsiEnum} array
     * @return FIGlet
     */
    public static String bananansi(String text, String font, AnsiEnum... enums) {
        return bananansi(text, font, null, null, enums);
    }

    /**
     * Convert text to FIGlet using custom font and ANSI escape code
     * @param text             text
     * @param font             font
     * @param horizontalLayout {@link FittingLayoutEnum}
     * @param verticalLayout   {@link FittingLayoutEnum}
     * @param enums            {@link AnsiEnum} array
     * @return FIGlet
     */
    public static String bananansi(String text, String font, FittingLayoutEnum horizontalLayout, FittingLayoutEnum verticalLayout, AnsiEnum... enums) {
        return AnsiEnum.multiple(bananaify(text, font, horizontalLayout, verticalLayout), enums);
    }


    /**
     * Generate text array of FIGlet
     * @param text             text
     * @param font             font
     * @param horizontalLayout {@link FittingLayoutEnum}
     * @param verticalLayout   {@link FittingLayoutEnum}
     * @return Text array of FIGlet
     */
    public static String[] bananaifyArray(String text, String font, FittingLayoutEnum horizontalLayout, FittingLayoutEnum verticalLayout) {
        return generateText(text, font, horizontalLayout, verticalLayout);
    }


    private static String[] generateText(String text, String font, FittingLayoutEnum horizontalLayout, FittingLayoutEnum verticalLayout) {
        FlfHolder holder;
        try {
            holder = getHolder(font);
        } catch (IOException e) {
            holder = null;
        }
        if (holder == null) {
            return new String[0];
        }
        Option option = holder.getOption();
        Map<Integer, String[]> figCharMap = holder.getFigCharMap();
        setHorizontalLayout(option, horizontalLayout);
        setVerticalLayout(option, verticalLayout);

        String[] lines = text.split("\n");
        String[][] texts = new String[lines.length][];
        for (int i = 0; i < lines.length; i++) {
            texts[i] = generateFigTextLine(lines[i], figCharMap, option);
        }
        String[] output = texts[0];
        for (int i = 1; i < texts.length; i++) {
            output = smushVerticalFigLines(output, texts[i], option);
        }
        return output;
    }

    private static String[] generateFigTextLine(String text, Map<Integer, String[]> figCharMap, Option option) {
        int overlap = 0;
        String[] outputFigText = new String[option.getHeight()];

        for (int i = 0; i < option.getHeight(); i++) {
            outputFigText[i] = EMPTY;
        }
        for (int charIndex = 0; charIndex < text.length(); charIndex++) {
            String[] figChar = figCharMap.get((int) text.charAt(charIndex));
            if (figChar != null) {
                if (option.getFittingRule().gethLayout() != FULL) {
                    overlap = 10000;
                    for (int i = 0; i < option.getHeight(); i++) {
                        overlap = Math.min(overlap, getHorizontalSmushLength(outputFigText[i], figChar[i], option));
                    }
                    overlap = (overlap == 10000) ? 0 : overlap;
                }
                outputFigText = horizontalSmush(outputFigText, figChar, overlap, option);
            }
        }
        for (int i = 0; i < outputFigText.length; i++) {
            outputFigText[i] = outputFigText[i].replace(option.getHardBlank(), BLANK);
        }
        return outputFigText;
    }

    private static FlfHolder getHolder(String font) throws IOException {
        FlfHolder holder;
        if (font == null) {
            font = STANDARD_FLF;
        }
        holder = flfMap.get(font);
        if (holder != null) {
            return holder;
        }

        String path = FLF_DIR_PATH + font + FLF_EXTENSION;
        Option option = new Option();
        StringBuilder sbComment = new StringBuilder();
        Map<Integer, String[]> figCharMap = new HashMap<>(192);
        List<String> dataList = new ArrayList<>(3072);

        InputStream inputStream = BananaUtils.class.getClassLoader().getResourceAsStream(path);
        if (inputStream == null) {
            return null;
        }
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader dataReader = new BufferedReader(inputStreamReader);
        String[] headerData = dataReader.readLine().split(BLANK);

        option.setHardBlank(headerData[0].substring(5));
        option.setHeight(Integer.parseInt(headerData[1]));
        option.setBaseline(Integer.parseInt(headerData[2]));
        option.setMaxLength(Integer.parseInt(headerData[3]));
        option.setOldLayout(Integer.parseInt(headerData[4]));
        option.setNumCommentLines(Integer.parseInt(headerData[5]));
        option.setPrintDirection(headerData.length > 6 ? Integer.parseInt(headerData[6]) : 0);
        option.setFullLayout(headerData.length > 7 ? Integer.parseInt(headerData[7]) : null);
        option.setCodeTagCount(headerData.length > 8 ? Integer.parseInt(headerData[8]) : null);
        option.setFittingRule(getSmushingRules(option.getOldLayout(), option.getFullLayout()));

        String line;
        // read comment
        int num = 0;
        while ((line = dataReader.readLine()) != null) {
            sbComment.append(line).append("\n");
            if (++num >= option.getNumCommentLines()) {
                break;
            }
        }
        // read data
        while ((line = dataReader.readLine()) != null) {
            dataList.add(line);
        }
        dataReader.close();
        inputStreamReader.close();
        inputStream.close();

        // ascii code: 32 = space (' '), 126 = tilde ('~')
        List<Integer> charCodeList = new ArrayList<>();
        for (int i = 32; i <= 126; i++) {
            charCodeList.add(i);
        }
        // extra codes
        // Collections.addAll(charCodeList,196, 214, 220, 228, 246, 252, 223);

        String mark = dataList.get(0).substring(dataList.get(0).length() - 1);
        if (isEmpty(mark)) {
            mark = "@";
        }
        int height = option.getHeight();
        for (int i = 0; i < charCodeList.size(); i++) {
            String[] fig = new String[height];
            figCharMap.put(charCodeList.get(i), fig);
            for (int j = 0; j < height; j++) {
                fig[j] = dataList.get(i * height + j).replace(mark, EMPTY);
            }
        }
        holder = new FlfHolder(font, sbComment.toString().trim(), option, figCharMap);
        flfMap.put(font, holder);
        return holder;
    }

    private static void setHorizontalLayout(Option option, FittingLayoutEnum layout) {
        if (layout == null || layout.code() == DEFAULT) {
            return;
        }
        if (layout.code() == FULL) {
            option.getFittingRule().set(FULL, false, false, false, false, false, false);
        } else if (layout.code() == FITTING) {
            option.getFittingRule().set(FITTING, false, false, false, false, false, false);
        } else if (layout.code() == SMUSHING) {
            option.getFittingRule().set(SMUSHING, false, false, false, false, false, false);
        } else if (layout.code() == CONTROLLED_SMUSHING) {
            option.getFittingRule().set(CONTROLLED_SMUSHING, true, true, true, true, true, true);
        }
    }

    private static void setVerticalLayout(Option option, FittingLayoutEnum layout) {
        if (layout == null || layout.code() == DEFAULT) {
            return;
        }
        if (layout.code() == FULL) {
            option.getFittingRule().set(FULL, false, false, false, false, false);
        } else if (layout.code() == FITTING) {
            option.getFittingRule().set(FITTING, false, false, false, false, false);
        } else if (layout.code() == SMUSHING) {
            option.getFittingRule().set(SMUSHING, false, false, false, false, false);
        } else if (layout.code() == CONTROLLED_SMUSHING) {
            option.getFittingRule().set(CONTROLLED_SMUSHING, true, true, true, true, true);
        }
    }

    private static String[] horizontalSmush(String[] textBlock1, String[] textBlock2, int overlap, Option opts) {
        String[] outputFig = new String[opts.getHeight()];

        for (int i = 0; i < opts.getHeight(); i++) {
            String txt1 = textBlock1[i];
            String txt2 = textBlock2[i];
            int len1 = txt1.length();
            int len2 = txt2.length();
            int overlapStart = len1 - overlap;
            String piece1 = substr(txt1, 0, Math.max(0, overlapStart));
            StringBuilder piece2 = new StringBuilder();

            // determine overlap piece
            String seg1 = substr(txt1, Math.max(0, len1 - overlap), overlap);
            String seg2 = substr(txt2, 0, Math.min(overlap, len2));

            for (int j = 0; j < overlap; j++) {
                String ch1 = (j < len1) ? substr(seg1, j, 1) : BLANK;
                String ch2 = (j < len2) ? substr(seg2, j, 1) : BLANK;
                if (!BLANK.equals(ch1) && !BLANK.equals(ch2)) {
                    if (opts.getFittingRule().gethLayout() == FITTING) {
                        piece2.append(uniSmush(ch1, ch2, opts.getHardBlank()));
                    } else if (opts.getFittingRule().gethLayout() == SMUSHING) {
                        piece2.append(uniSmush(ch1, ch2, opts.getHardBlank()));
                    } else {
                        String nextCh = EMPTY;
                        nextCh = (isEmpty(nextCh) && opts.getFittingRule().ishRule1())
                                ? hRule1Smush(ch1, ch2, opts.getHardBlank()) : nextCh;
                        nextCh = (isEmpty(nextCh) && opts.getFittingRule().ishRule2())
                                ? hRule2Smush(ch1, ch2) : nextCh;
                        nextCh = (isEmpty(nextCh) && opts.getFittingRule().ishRule3())
                                ? hRule3Smush(ch1, ch2) : nextCh;
                        nextCh = (isEmpty(nextCh) && opts.getFittingRule().ishRule4())
                                ? hRule4Smush(ch1, ch2) : nextCh;
                        nextCh = (isEmpty(nextCh) && opts.getFittingRule().ishRule5())
                                ? hRule5Smush(ch1, ch2) : nextCh;
                        nextCh = (isEmpty(nextCh) && opts.getFittingRule().ishRule6())
                                ? hRule6Smush(ch1, ch2, opts.getHardBlank()) : nextCh;
                        nextCh = isEmpty(nextCh)
                                ? uniSmush(ch1, ch2, opts.getHardBlank()) : nextCh;
                        piece2.append(nextCh);
                    }
                } else {
                    piece2.append(uniSmush(ch1, ch2, opts.getHardBlank()));
                }
            }
            String piece3 = overlap >= len2 ? EMPTY : substr(txt2, overlap, Math.max(0, len2 - overlap));
            outputFig[i] = piece1 + piece2.toString() + piece3;
        }
        return outputFig;
    }

    /**
     * main horizontal smush routines (excluding rules)
     */
    private static int getHorizontalSmushLength(String txt1, String txt2, Option opts) {
        if (opts.getFittingRule().gethLayout() == FULL) {
            return 0;
        }
        int len1 = txt1.length();
        int len2 = txt2.length();
        int curDist = 1;
        int maxDist = txt1.length();
        boolean breakAfter = false;
        boolean validSmush = false;
        if (len1 == 0) {
            return 0;
        }
        while (curDist <= maxDist) {
            boolean skip = false;
            String seg1 = substr(txt1, len1 - curDist, len1);
            String seg2 = substr(txt2, 0, Math.min(curDist, len2));
            for (int i = 0; i < Math.min(curDist, len2); i++) {
                String ch1 = substr(seg1, i, 1);
                String ch2 = substr(seg2, i, 1);
                if (!BLANK.equals(ch1) && !BLANK.equals(ch2)) {
                    if (opts.getFittingRule().gethLayout() == FITTING) {
                        curDist = curDist - 1;
                        skip = true;
                        break;
                    } else if (opts.getFittingRule().gethLayout() == SMUSHING) {
                        if (ch1.equals(opts.getHardBlank()) || ch2.equals(opts.getHardBlank())) {
                            // universal smushing does not smush hardblanks
                            curDist = curDist - 1;
                        }
                        skip = true;
                        break;
                    } else {
                        // we know we need to break, but we need to check if our smushing rules will allow us to smush the overlapped characters
                        breakAfter = true;
                        // the below checks will let us know if we can smush these characters
                        validSmush = false;

                        validSmush = opts.getFittingRule().ishRule1()
                                ? isNotEmpty(hRule1Smush(ch1, ch2, opts.getHardBlank())) : validSmush;
                        validSmush = !validSmush && opts.getFittingRule().ishRule2()
                                ? isNotEmpty(hRule2Smush(ch1, ch2)) : validSmush;
                        validSmush = !validSmush && opts.getFittingRule().ishRule3()
                                ? isNotEmpty(hRule3Smush(ch1, ch2)) : validSmush;
                        validSmush = !validSmush && opts.getFittingRule().ishRule4()
                                ? isNotEmpty(hRule4Smush(ch1, ch2)) : validSmush;
                        validSmush = !validSmush && opts.getFittingRule().ishRule5()
                                ? isNotEmpty(hRule5Smush(ch1, ch2)) : validSmush;
                        validSmush = !validSmush && opts.getFittingRule().ishRule6()
                                ? isNotEmpty(hRule6Smush(ch1, ch2, opts.getHardBlank())) : validSmush;
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

    /**
     * This method takes in the oldLay and newLayout data from
     * the FIGfont header file and returns the layout information.
     */
    private static FittingRule getSmushingRules(Integer oldLayout, Integer newLayout) {
        Map<String, Integer> rules = new HashMap<>();
        FittingRuleEnum[] fittingRules = FittingRuleEnum.values();
        int val = newLayout != null ? newLayout : oldLayout;
        for (FittingRuleEnum fittingRule : fittingRules) {
            int code = fittingRule.code();
            String name = fittingRule.key();
            int value = fittingRule.value();
            if (val >= code) {
                val -= code;
                if (!rules.containsKey(name)) {
                    rules.put(name, value);
                }
            } else if (!FittingRuleEnum.H_LAYOUT_SMUSHING.key().equals(name)
                    && !FittingRuleEnum.V_LAYOUT_SMUSHING.key().equals(name)) {
                rules.put(name, 0);
            }
        }
        FittingRule rule = FittingRule.build(
                rules.get(FittingRuleEnum.H_LAYOUT_SMUSHING.key()),
                equals(rules.get(FittingRuleEnum.H_RULE1.key()), 1),
                equals(rules.get(FittingRuleEnum.H_RULE2.key()), 1),
                equals(rules.get(FittingRuleEnum.H_RULE3.key()), 1),
                equals(rules.get(FittingRuleEnum.H_RULE4.key()), 1),
                equals(rules.get(FittingRuleEnum.H_RULE5.key()), 1),
                equals(rules.get(FittingRuleEnum.H_RULE6.key()), 1),
                rules.get(FittingRuleEnum.V_LAYOUT_SMUSHING.key()),
                equals(rules.get(FittingRuleEnum.V_RULE1.key()), 1),
                equals(rules.get(FittingRuleEnum.V_RULE2.key()), 1),
                equals(rules.get(FittingRuleEnum.V_RULE3.key()), 1),
                equals(rules.get(FittingRuleEnum.V_RULE4.key()), 1),
                equals(rules.get(FittingRuleEnum.V_RULE5.key()), 1)
        );
        if (rule.gethLayout() == null) {
            if (oldLayout == 0) {
                rule.sethLayout(FITTING);
            } else if (oldLayout == -1) {
                rule.sethLayout(FULL);
            } else if (rule.ishRule1()
                    || rule.ishRule2()
                    || rule.ishRule3()
                    || rule.ishRule4()
                    || rule.ishRule5()
                    || rule.ishRule6()) {
                rule.sethLayout(CONTROLLED_SMUSHING);
            } else {
                rule.sethLayout(SMUSHING);
            }
        } else if (rule.gethLayout() == SMUSHING
                && rule.ishRule1()
                || rule.ishRule2()
                || rule.ishRule3()
                || rule.ishRule4()
                || rule.ishRule5()
                || rule.ishRule6()) {
            rule.sethLayout(CONTROLLED_SMUSHING);
        }
        if (rule.getvLayout() == null) {
            if (rule.isvRule1()
                    || rule.isvRule2()
                    || rule.isvRule3()
                    || rule.isvRule4()
                    || rule.isvRule5()) {
                rule.setvLayout(CONTROLLED_SMUSHING);
            } else {
                rule.setvLayout(FULL);
            }
        } else if (rule.getvLayout() == SMUSHING
                && rule.isvRule1()
                || rule.isvRule2()
                || rule.isvRule3()
                || rule.isvRule4()
                || rule.isvRule5()) {
            rule.setvLayout(CONTROLLED_SMUSHING);
        }
        return rule;
    }

    private static String[] smushVerticalFigLines(String[] output, String[] lines, Option opts) {
        int len1 = output[0].length();
        int len2 = lines[0].length();
        int overlap;
        if (len1 > len2) {
            padLines(lines, len1 - len2);
        } else if (len2 > len1) {
            padLines(output, len2 - len1);
        }
        overlap = getVerticalSmushDist(output, lines, opts);
        return verticalSmush(output, lines, overlap, opts);
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

    private static int getVerticalSmushDist(String[] lines1, String[] lines2, Option opts) {
        int curDist = 1;
        int maxDist = lines1.length;
        int len1 = lines1.length;
        String[] subLines1;
        String[] subLines2;
        while (curDist <= maxDist) {
            subLines1 = slice(lines1, Math.max(0, len1 - curDist), len1);
            subLines2 = slice(lines2, 0, Math.min(maxDist, curDist));

            String result = "";
            for (int i = 0; i < subLines2.length; i++) {
                String ret = canVerticalSmush(subLines1[i], subLines2[i], opts);
                if (END.equals(ret)) {
                    result = ret;
                } else if (INVALID.equals(ret)) {
                    result = ret;
                    break;
                } else if (EMPTY.equals(result)) {
                    result = VALID;
                }
            }
            if (INVALID.equals(result)) {
                curDist--;
                break;
            }
            if (END.equals(result)) {
                break;
            }
            if (VALID.equals(result)) {
                curDist++;
            }
        }
        return Math.min(maxDist, curDist);
    }

    /**
     * txt1 - A line of text
     * txt2 - A line of text
     * opts - FIGlet options array
     * About: Takes in two lines of text and returns one of the following:
     * "valid" - These lines can be smushed together given the current smushing rules
     * "end" - The lines can be smushed, but we're at a stopping point
     * "invalid" - The two lines cannot be smushed together
     */
    private static String canVerticalSmush(String txt1, String txt2, Option opts) {
        if (opts.getFittingRule().getvLayout() == FULL) {
            return INVALID;
        }
        int len = Math.min(txt1.length(), txt2.length());
        String ch1;
        String ch2;
        boolean endSmush = false;
        boolean validSmush;
        if (len == 0) {
            return INVALID;
        }

        for (int i = 0; i < len; i++) {
            ch1 = substr(txt1, i, 1);
            ch2 = substr(txt2, i, 1);
            if (!BLANK.equals(ch1) && !BLANK.equals(ch2)) {
                if (opts.getFittingRule().getvLayout() == FITTING) {
                    return INVALID;
                } else if (opts.getFittingRule().getvLayout() == SMUSHING) {
                    return END;
                } else {
                    if (isNotEmpty(vRule5Smush(ch1, ch2))) {
                        continue;
                    }
                    // rule 5 allow for "super" smushing, but only if we're not already ending this smush
                    validSmush = false;
                    validSmush = (opts.getFittingRule().isvRule1())
                            ? isNotEmpty(vRule1Smush(ch1, ch2)) : validSmush;
                    validSmush = (!validSmush && opts.getFittingRule().isvRule2())
                            ? isNotEmpty(vRule2Smush(ch1, ch2)) : validSmush;
                    validSmush = (!validSmush && opts.getFittingRule().isvRule3())
                            ? isNotEmpty(vRule3Smush(ch1, ch2)) : validSmush;
                    validSmush = (!validSmush && opts.getFittingRule().isvRule4())
                            ? isNotEmpty(vRule4Smush(ch1, ch2)) : validSmush;
                    endSmush = true;
                    if (!validSmush) {
                        return INVALID;
                    }
                }
            }
        }
        if (endSmush) {
            return END;
        } else {
            return VALID;
        }
    }

    private static String[] verticalSmush(String[] lines1, String[] lines2, int overlap, Option opts) {
        int len1 = lines1.length;
        int len2 = lines2.length;
        String[] piece1 = slice(lines1, 0, Math.max(0, len1 - overlap));
        String[] piece21 = slice(lines1, Math.max(0, len1 - overlap), len1);
        String[] piece22 = slice(lines2, 0, Math.min(overlap, len2));
        String line;
        String[] piece2 = new String[piece21.length];
        String[] piece3;
        for (int i = 0; i < piece21.length; i++) {
            if (i >= len2) {
                line = piece21[i];
            } else {
                line = verticallySmushLines(piece21[i], piece22[i], opts);
            }
            piece2[i] = line;
        }
        piece3 = slice(lines2, Math.min(overlap, len2), len2);
        return concat(piece1, piece2, piece3);
    }

    private static String verticallySmushLines(String line1, String line2, Option opts) {
        int len = Math.min(line1.length(), line2.length());
        String ch1;
        String ch2;
        String validSmush = "";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < len; i++) {
            ch1 = substr(line1, i, 1);
            ch2 = substr(line2, i, 1);
            if (!BLANK.equals(ch1) && !BLANK.equals(ch2)) {
                if (opts.getFittingRule().getvLayout() == FITTING) {
                    result.append(uniSmush(ch1, ch2, null));
                } else if (opts.getFittingRule().getvLayout() == SMUSHING) {
                    result.append(uniSmush(ch1, ch2, null));
                } else {
                    validSmush = (opts.getFittingRule().isvRule5())
                            ? vRule5Smush(ch1, ch2) : validSmush;
                    validSmush = (isEmpty(validSmush) && opts.getFittingRule().isvRule1())
                            ? vRule1Smush(ch1, ch2) : validSmush;
                    validSmush = (isEmpty(validSmush) && opts.getFittingRule().isvRule2())
                            ? vRule2Smush(ch1, ch2) : validSmush;
                    validSmush = (isEmpty(validSmush) && opts.getFittingRule().isvRule3())
                            ? vRule3Smush(ch1, ch2) : validSmush;
                    validSmush = (isEmpty(validSmush) && opts.getFittingRule().isvRule4())
                            ? vRule4Smush(ch1, ch2) : validSmush;
                    result.append(validSmush);
                }
            } else {
                result.append(uniSmush(ch1, ch2, null));
            }
        }
        return result.toString();
    }

    /* The [vh]Rule[1-6]Smush functions return the smushed character OR false if the two characters can't be smushed */

    /**
     * Rule 1: EQUAL CHARACTER SMUSHING (code value 1)
     * Two sub-characters are smushed into a single sub-character
     * if they are the same.  This rule does not smush hardblanks.
     * (See rule 6 on hardblanks below)
     */
    private static String hRule1Smush(String ch1, String ch2, String hardBlank) {
        if (ch1.equals(ch2) && !ch1.equals(hardBlank)) {
            return ch1;
        }
        return EMPTY;
    }

    /**
     * Rule 2: UNDERSCORE SMUSHING (code value 2)
     * An underscore ("_") will be replaced by any of:
     * "|", "/", "\", "[", "]", "{", "}", "(", ")", "<" or ">".
     */
    private static String hRule2Smush(String ch1, String ch2) {
        return commonRule2Smush(ch1, ch2);
    }

    /**
     * Rule 3: HIERARCHY SMUSHING (code value 4)
     * A hierarchy of six classes is used: "|", "/\", "[]", "{}", "()", and "<>".
     * When two smushing sub-characters are from different classes,
     * the one from the latter class will be used.
     */
    private static String hRule3Smush(String ch1, String ch2) {
        return commonRule3Smush(ch1, ch2);
    }

    /**
     * Rule 4: OPPOSITE PAIR SMUSHING (code value 8)
     * Smushes opposing brackets ("[]" or "]["), braces ("{}" or "}{")
     * and parentheses ("()" or ")(") together, replacing
     * any such pair with a vertical bar ("|").
     */
    private static String hRule4Smush(String ch1, String ch2) {
        int r4Pos1 = RULE_4_EXP.indexOf(ch1);
        int r4Pos2 = RULE_4_EXP.indexOf(ch2);
        if ((r4Pos1 != -1 && r4Pos2 != -1) && (Math.abs(r4Pos1 - r4Pos2) <= 1)) {
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
    private static String hRule5Smush(String ch1, String ch2) {
        int r5Pos1 = RULE_5_EXP.indexOf(ch1);
        int r5Pos2 = RULE_5_EXP.indexOf(ch2);
        if ((r5Pos1 != -1 && r5Pos2 != -1) && (r5Pos2 - r5Pos1) == 1) {
            if (r5Pos1 == 0) {
                return "|";
            } else if (r5Pos1 == 3) {
                return "Y";
            } else if (r5Pos1 == 6) {
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
    private static String hRule6Smush(String ch1, String ch2, String hardBlank) {
        if (ch1.equals(hardBlank) && ch2.equals(hardBlank)) {
            return hardBlank;
        }
        return EMPTY;
    }

    /**
     * Rule 1: EQUAL CHARACTER SMUSHING (code value 256)
     * Same as horizontal smushing rule 1.
     */
    private static String vRule1Smush(String ch1, String ch2) {
        if (ch1.equals(ch2)) {
            return ch1;
        }
        return EMPTY;
    }

    /**
     * Rule 2: UNDERSCORE SMUSHING (code value 512)
     * Same as horizontal smushing rule 2.
     */
    private static String vRule2Smush(String ch1, String ch2) {
        return commonRule2Smush(ch1, ch2);
    }

    /**
     * Rule 3: HIERARCHY SMUSHING (code value 1024)
     * Same as horizontal smushing rule 3.
     */
    private static String vRule3Smush(String ch1, String ch2) {
        return commonRule3Smush(ch1, ch2);
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
    private static String vRule4Smush(String ch1, String ch2) {
        if (("-".equals(ch1) && "_".equals(ch2)) || ("_".equals(ch1) && "-".equals(ch2))) {
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
    private static String vRule5Smush(String ch1, String ch2) {
        if ("|".equals(ch1) && "|".equals(ch2)) {
            return "|";
        }
        return EMPTY;
    }

    private static String commonRule2Smush(String ch1, String ch2) {
        if ("_".equals(ch1) && RULE_2_EXP.contains(ch2)) {
            return ch2;
        } else if ("_".equals(ch2) && RULE_2_EXP.contains(ch1)) {
            return ch1;
        }
        return EMPTY;
    }

    private static String commonRule3Smush(String ch1, String ch2) {
        int r3Pos1 = RULE_3_EXP.indexOf(ch1);
        int r3Pos2 = RULE_3_EXP.indexOf(ch2);
        if ((r3Pos1 != -1 && r3Pos2 != -1) && (r3Pos1 != r3Pos2 && Math.abs(r3Pos1 - r3Pos2) != 1)) {
            return substr(RULE_3_EXP, Math.max(r3Pos1, r3Pos2), 1);
        }
        return EMPTY;
    }

    /**
     * Universal smushing simply overrides the sub-character from the
     * earlier FIGcharacter with the sub-character from the later
     * FIGcharacter.  This produces an "overlapping" effect with some
     * FIGfonts, wherin the latter FIGcharacter may appear to be "in front".
     */
    private static String uniSmush(String ch1, String ch2, String hardBlank) {
        if ((BLANK.equals(ch2) || EMPTY.equals(ch2))
                || (ch2.equals(hardBlank) && !BLANK.equals(ch1))) {
            return ch1;
        }
        return ch2;
    }

    /**
     * Concat string array, for example:<pre>
     *  pieces[0]:
     *   _ ____  _____
     *  / |___ \|___ /
     *  | | __) | |_ \
     *  | |/ __/ ___) |
     *  |_|_____|____/
     *
     *  pieces[1]:
     *  | ___| / /_
     *  |___ \| '_ \
     *   ___) | (_) |
     *  |____/ \___/
     *
     *  result:
     *   _ ____  _____
     *  / |___ \|___ /
     *  | | __) | |_ \
     *  | |/ __/ ___) |
     *  |_|_____|____/
     *  | ___| / /_
     *  |___ \| '_ \
     *   ___) | (_) |
     *  |____/ \___/
     *
     * @param pieces FIGlet line array
     * @return Combined FIGlet
     */
    private static String[] concat(String[]... pieces) {
        if (pieces == null || pieces.length == 0) {
            return new String[0];
        }
        int length = 0;
        for (String[] piece : pieces) {
            length += piece.length;
        }
        String[] result = new String[length];
        int i = 0;
        for (String[] piece : pieces) {
            for (String s : piece) {
                result[i++] = s;
            }
        }
        return result;
    }

    /**
     * Returns a string that is a substring of this string.
     * @param s      string
     * @param start  the beginning index
     * @param length the length of specified substring
     * @return the specified substring
     */
    private static String substr(String s, int start, int length) {
        if (isEmpty(s)) {
            return EMPTY;
        }
        return s.substring(start, Math.min(start + length, s.length()));
    }

    /**
     * Returns a section of an array.
     * @param array array
     * @param start the beginning of the specified portion of the array
     * @param end   the end of the specified portion of the array
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
     * Checks if a String is empty ("") or null.
     * @param s string
     * @return <code>true</code> if the String is empty or null
     */
    private static boolean isEmpty(String s) {
        return null == s || EMPTY.equals(s);
    }

    /**
     * Checks if a String is not empty ("") and not null.
     * @param s string
     * @return <code>true</code> if the String is not empty and not null
     */
    private static boolean isNotEmpty(String s) {
        return !isEmpty(s);
    }

    /**
     * Returns {@code true} if the arguments are equal to each other
     * and {@code false} otherwise.
     * @param o1 an object
     * @param o2 an object to be compared with {@code a} for equality
     * @return {@code true} if the arguments are equal to each other
     * and {@code false} otherwise
     */
    private static boolean equals(Object o1, Object o2) {
        return Objects.equals(o1, o2);
    }

}
