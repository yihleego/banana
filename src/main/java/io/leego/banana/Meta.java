package io.leego.banana;

import java.util.Map;

/**
 * @author Yihleego
 */
public class Meta {
    private Font font;
    private Option option;
    private Map<Integer, String[]> figletMap;
    private String comment;

    public Meta(Font font, Option option, Map<Integer, String[]> figletMap, String comment) {
        this.font = font;
        this.option = option;
        this.figletMap = figletMap;
        this.comment = comment;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    public Map<Integer, String[]> getFigletMap() {
        return figletMap;
    }

    public void setFigletMap(Map<Integer, String[]> figletMap) {
        this.figletMap = figletMap;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
