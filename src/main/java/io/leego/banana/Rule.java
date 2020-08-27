package io.leego.banana;

/**
 * @author Yihleego
 */
public class Rule {
    private Layout horizontalLayout;
    private boolean horizontal1;
    private boolean horizontal2;
    private boolean horizontal3;
    private boolean horizontal4;
    private boolean horizontal5;
    private boolean horizontal6;
    private Layout verticalLayout;
    private boolean vertical1;
    private boolean vertical2;
    private boolean vertical3;
    private boolean vertical4;
    private boolean vertical5;

    public Rule() {
    }

    public Rule(Layout horizontalLayout, boolean horizontal1, boolean horizontal2, boolean horizontal3, boolean horizontal4, boolean horizontal5, boolean horizontal6,
                Layout verticalLayout, boolean vertical1, boolean vertical2, boolean vertical3, boolean vertical4, boolean vertical5) {
        this.horizontalLayout = horizontalLayout;
        this.horizontal1 = horizontal1;
        this.horizontal2 = horizontal2;
        this.horizontal3 = horizontal3;
        this.horizontal4 = horizontal4;
        this.horizontal5 = horizontal5;
        this.horizontal6 = horizontal6;
        this.verticalLayout = verticalLayout;
        this.vertical1 = vertical1;
        this.vertical2 = vertical2;
        this.vertical3 = vertical3;
        this.vertical4 = vertical4;
        this.vertical5 = vertical5;
    }

    public Rule copy() {
        return new Rule(horizontalLayout, horizontal1, horizontal2, horizontal3, horizontal4, horizontal5, horizontal6,
                verticalLayout, vertical1, vertical2, vertical3, vertical4, vertical5);
    }

    public void setHorizontal(Layout horizontalLayout, boolean horizontal1, boolean horizontal2, boolean horizontal3, boolean horizontal4, boolean horizontal5, boolean horizontal6) {
        this.horizontalLayout = horizontalLayout;
        this.horizontal1 = horizontal1;
        this.horizontal2 = horizontal2;
        this.horizontal3 = horizontal3;
        this.horizontal4 = horizontal4;
        this.horizontal5 = horizontal5;
        this.horizontal6 = horizontal6;
    }

    public void setVertical(Layout verticalLayout, boolean vertical1, boolean vertical2, boolean vertical3, boolean vertical4, boolean vertical5) {
        this.verticalLayout = verticalLayout;
        this.vertical1 = vertical1;
        this.vertical2 = vertical2;
        this.vertical3 = vertical3;
        this.vertical4 = vertical4;
        this.vertical5 = vertical5;
    }

    public Layout getHorizontalLayout() {
        return horizontalLayout;
    }

    public void setHorizontalLayout(Layout horizontalLayout) {
        this.horizontalLayout = horizontalLayout;
    }

    public boolean isHorizontal1() {
        return horizontal1;
    }

    public void setHorizontal1(boolean horizontal1) {
        this.horizontal1 = horizontal1;
    }

    public boolean isHorizontal2() {
        return horizontal2;
    }

    public void setHorizontal2(boolean horizontal2) {
        this.horizontal2 = horizontal2;
    }

    public boolean isHorizontal3() {
        return horizontal3;
    }

    public void setHorizontal3(boolean horizontal3) {
        this.horizontal3 = horizontal3;
    }

    public boolean isHorizontal4() {
        return horizontal4;
    }

    public void setHorizontal4(boolean horizontal4) {
        this.horizontal4 = horizontal4;
    }

    public boolean isHorizontal5() {
        return horizontal5;
    }

    public void setHorizontal5(boolean horizontal5) {
        this.horizontal5 = horizontal5;
    }

    public boolean isHorizontal6() {
        return horizontal6;
    }

    public void setHorizontal6(boolean horizontal6) {
        this.horizontal6 = horizontal6;
    }

    public Layout getVerticalLayout() {
        return verticalLayout;
    }

    public void setVerticalLayout(Layout verticalLayout) {
        this.verticalLayout = verticalLayout;
    }

    public boolean isVertical1() {
        return vertical1;
    }

    public void setVertical1(boolean vertical1) {
        this.vertical1 = vertical1;
    }

    public boolean isVertical2() {
        return vertical2;
    }

    public void setVertical2(boolean vertical2) {
        this.vertical2 = vertical2;
    }

    public boolean isVertical3() {
        return vertical3;
    }

    public void setVertical3(boolean vertical3) {
        this.vertical3 = vertical3;
    }

    public boolean isVertical4() {
        return vertical4;
    }

    public void setVertical4(boolean vertical4) {
        this.vertical4 = vertical4;
    }

    public boolean isVertical5() {
        return vertical5;
    }

    public void setVertical5(boolean vertical5) {
        this.vertical5 = vertical5;
    }
}
