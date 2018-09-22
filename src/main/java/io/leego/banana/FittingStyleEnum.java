package io.leego.banana;

/**
 * Created by YihLeego on 2018.09.22 23:00
 *
 * @author YihLeego
 * @version 1.0.0
 */
public enum FittingStyleEnum {
    FULL_WIDTH(0),
    FITTING(1),
    SMUSHING(2),
    CONTROLLED_SMUSHING(3);

    private int value;

    FittingStyleEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
