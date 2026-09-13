package com.eclectusstudio.pantheon.common.resource.texture;

public class Villager {

    private Hat hat;

    public Hat getHat() {
        return hat;
    }

    public void setHat(Hat hat) {
        this.hat = hat;
    }

    public enum Hat {
        FULL,
        PARTIAL,
        DEFAULT
    }
}
