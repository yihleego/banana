package io.leego.banana.bean;

import java.util.List;
import java.util.Map;

/**
 * @author YihLeego
 */
public class FlfHolder {
    private String name;
    private String comment;
    private Option option;
    private List<String> dataList;
    private Map<Integer, String[]> figCharMap;

    public FlfHolder() {
    }

    public FlfHolder(String name, Option option, Map<Integer, String[]> figCharMap) {
        this.name = name;
        this.option = option;
        this.figCharMap = figCharMap;
    }

    public FlfHolder(String name, String comment, Option option, Map<Integer, String[]> figCharMap) {
        this.name = name;
        this.comment = comment;
        this.option = option;
        this.figCharMap = figCharMap;
    }

    public FlfHolder(String name, String comment, Option option, List<String> dataList, Map<Integer, String[]> figCharMap) {
        this.name = name;
        this.comment = comment;
        this.dataList = dataList;
        this.option = option;
        this.figCharMap = figCharMap;
    }

    public Map<Integer, String[]> getFigCharMap() {
        return figCharMap;
    }

    public void setFigCharMap(Map<Integer, String[]> figCharMap) {
        this.figCharMap = figCharMap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<String> getDataList() {
        return dataList;
    }

    public void setDataList(List<String> dataList) {
        this.dataList = dataList;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }
}
