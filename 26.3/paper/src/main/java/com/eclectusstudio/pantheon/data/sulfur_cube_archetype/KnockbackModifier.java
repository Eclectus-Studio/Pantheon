package com.eclectusstudio.pantheon.data.sulfur_cube_archetype;

public class KnockbackModifier {
    private final float horizontalPower, verticalPower;

    public KnockbackModifier(float horizontalPower, float verticalPower) {
        this.horizontalPower = horizontalPower;
        this.verticalPower = verticalPower;
    }

    public float getHorizontalPower() {
        return horizontalPower;
    }

    public float getVerticalPower() {
        return verticalPower;
    }
}
