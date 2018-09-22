package io.leego.banana;

import java.util.List;
import java.util.Map;

/**
 * Created by YihLeego on 2018.09.23 02:41
 *
 * @author YihLeego
 * @version 1.0.0
 */
public class FlfHolder {
    private String name;
    private String comment;
    private List<String> dataList;
    private Option option;
    private Map<Integer, String[]> figCharMap;

    public FlfHolder() {
    }

    public FlfHolder(String name, String comment, Option option, Map<Integer, String[]> figCharMap) {
        this.name = name;
        this.comment = comment;
        this.option = option;
        this.figCharMap = figCharMap;
    }

    public FlfHolder(String name, String comment, List<String> dataList, Option option, Map<Integer, String[]> figCharMap) {
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
