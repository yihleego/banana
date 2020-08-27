package io.leego.banana;

/**
 * @author Yihleego
 */
public class Option {
    private Integer baseline;
    private Integer codeTagCount;
    private Rule rule;
    private Integer fullLayout;
    private String hardBlank;
    private Integer height;
    private Integer maxLength;
    private Integer numCommentLines;
    private Integer oldLayout;
    private Integer printDirection;

    public Option() {
    }

    public Option(Integer baseline, Integer codeTagCount, Rule rule,
                  Integer fullLayout, String hardBlank, Integer height,
                  Integer maxLength, Integer numCommentLines, Integer oldLayout, Integer printDirection) {
        this.baseline = baseline;
        this.codeTagCount = codeTagCount;
        this.rule = rule;
        this.fullLayout = fullLayout;
        this.hardBlank = hardBlank;
        this.height = height;
        this.maxLength = maxLength;
        this.numCommentLines = numCommentLines;
        this.oldLayout = oldLayout;
        this.printDirection = printDirection;
    }

    public Option copy() {
        return new Option(baseline, codeTagCount, rule != null ? rule.copy() : null,
                fullLayout, hardBlank, height,
                maxLength, numCommentLines, oldLayout, printDirection);
    }

    public Integer getBaseline() {
        return baseline;
    }

    public void setBaseline(Integer baseline) {
        this.baseline = baseline;
    }

    public Integer getCodeTagCount() {
        return codeTagCount;
    }

    public void setCodeTagCount(Integer codeTagCount) {
        this.codeTagCount = codeTagCount;
    }

    public Rule getRule() {
        return rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }

    public Integer getFullLayout() {
        return fullLayout;
    }

    public void setFullLayout(Integer fullLayout) {
        this.fullLayout = fullLayout;
    }

    public String getHardBlank() {
        return hardBlank;
    }

    public void setHardBlank(String hardBlank) {
        this.hardBlank = hardBlank;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
    }

    public Integer getNumCommentLines() {
        return numCommentLines;
    }

    public void setNumCommentLines(Integer numCommentLines) {
        this.numCommentLines = numCommentLines;
    }

    public Integer getOldLayout() {
        return oldLayout;
    }

    public void setOldLayout(Integer oldLayout) {
        this.oldLayout = oldLayout;
    }

    public Integer getPrintDirection() {
        return printDirection;
    }

    public void setPrintDirection(Integer printDirection) {
        this.printDirection = printDirection;
    }
}

