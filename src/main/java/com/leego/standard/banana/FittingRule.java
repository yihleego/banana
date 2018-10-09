package com.leego.standard.banana;

/**
 * Created by YihLeego on 2018.09.23 02:41
 *
 * @author YihLeego
 * @version 1.0.0
 */
public class FittingRule {

    private Integer hLayout;
    private boolean hRule1;
    private boolean hRule2;
    private boolean hRule3;
    private boolean hRule4;
    private boolean hRule5;
    private boolean hRule6;
    private Integer vLayout;
    private boolean vRule1;
    private boolean vRule2;
    private boolean vRule3;
    private boolean vRule4;
    private boolean vRule5;

    public FittingRule() {
    }

    public FittingRule(Integer hLayout, boolean hRule1, boolean hRule2, boolean hRule3, boolean hRule4, boolean hRule5, boolean hRule6, Integer vLayout, boolean vRule1, boolean vRule2, boolean vRule3, boolean vRule4, boolean vRule5) {
        this.hLayout = hLayout;
        this.hRule1 = hRule1;
        this.hRule2 = hRule2;
        this.hRule3 = hRule3;
        this.hRule4 = hRule4;
        this.hRule5 = hRule5;
        this.hRule6 = hRule6;
        this.vLayout = vLayout;
        this.vRule1 = vRule1;
        this.vRule2 = vRule2;
        this.vRule3 = vRule3;
        this.vRule4 = vRule4;
        this.vRule5 = vRule5;
    }

    public static FittingRule build() {
        return new FittingRule();
    }

    public static FittingRule build(Integer hLayout, boolean hRule1, boolean hRule2, boolean hRule3, boolean hRule4, boolean hRule5, boolean hRule6, Integer vLayout, boolean vRule1, boolean vRule2, boolean vRule3, boolean vRule4, boolean vRule5) {
        return new FittingRule(hLayout, hRule1, hRule2, hRule3, hRule4, hRule5, hRule6, vLayout, vRule1, vRule2, vRule3, vRule4, vRule5);
    }

    public Integer gethLayout() {
        return hLayout;
    }

    public void sethLayout(Integer hLayout) {
        this.hLayout = hLayout;
    }

    public boolean ishRule1() {
        return hRule1;
    }

    public void sethRule1(boolean hRule1) {
        this.hRule1 = hRule1;
    }

    public boolean ishRule2() {
        return hRule2;
    }

    public void sethRule2(boolean hRule2) {
        this.hRule2 = hRule2;
    }

    public boolean ishRule3() {
        return hRule3;
    }

    public void sethRule3(boolean hRule3) {
        this.hRule3 = hRule3;
    }

    public boolean ishRule4() {
        return hRule4;
    }

    public void sethRule4(boolean hRule4) {
        this.hRule4 = hRule4;
    }

    public boolean ishRule5() {
        return hRule5;
    }

    public void sethRule5(boolean hRule5) {
        this.hRule5 = hRule5;
    }

    public boolean ishRule6() {
        return hRule6;
    }

    public void sethRule6(boolean hRule6) {
        this.hRule6 = hRule6;
    }

    public Integer getvLayout() {
        return vLayout;
    }

    public void setvLayout(Integer vLayout) {
        this.vLayout = vLayout;
    }

    public boolean isvRule1() {
        return vRule1;
    }

    public void setvRule1(boolean vRule1) {
        this.vRule1 = vRule1;
    }

    public boolean isvRule2() {
        return vRule2;
    }

    public void setvRule2(boolean vRule2) {
        this.vRule2 = vRule2;
    }

    public boolean isvRule3() {
        return vRule3;
    }

    public void setvRule3(boolean vRule3) {
        this.vRule3 = vRule3;
    }

    public boolean isvRule4() {
        return vRule4;
    }

    public void setvRule4(boolean vRule4) {
        this.vRule4 = vRule4;
    }

    public boolean isvRule5() {
        return vRule5;
    }

    public void setvRule5(boolean vRule5) {
        this.vRule5 = vRule5;
    }
}
