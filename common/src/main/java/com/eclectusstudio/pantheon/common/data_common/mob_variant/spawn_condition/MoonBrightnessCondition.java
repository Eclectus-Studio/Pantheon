package com.eclectusstudio.pantheon.common.data_common.mob_variant.spawn_condition;

public class MoonBrightnessCondition implements Condition {

    private final String type = "moon_brightness";

    private final Double min;
    private final Double max;

    public MoonBrightnessCondition(Double min, Double max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public String getType() {
        return type;
    }

    public Double getMax() {
        return max;
    }

    public Double getMin() {
        return min;
    }
}