package com.eclectusstudio.pantheon.data.sulfur_cube_archetype;

public class Explosion {
    private final boolean causesFire;
    private final int fuse;
    private final int power;

    public Explosion(boolean causesFire, int fuse, int power) {
        this.causesFire = causesFire;
        this.fuse = fuse;
        this.power = power;
    }

    public boolean isCausesFire() {
        return causesFire;
    }

    public int getFuse() {
        return fuse;
    }

    public int getPower() {
        return power;
    }
}
