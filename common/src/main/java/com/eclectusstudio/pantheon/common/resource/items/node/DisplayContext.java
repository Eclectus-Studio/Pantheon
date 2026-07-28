package com.eclectusstudio.pantheon.common.resource.items.node;

public enum DisplayContext {
    GUI("gui"),
    GROUND("ground"),
    FIXED("fixed"),
    HEAD("head"),
    FIRSTPERSON_RIGHTHAND("firstperson_righthand"),
    FIRSTPERSON_LEFTHAND("firstperson_lefthand"),
    THIRDPERSON_RIGHTHAND("thirdperson_righthand"),
    THIRDPERSON_LEFTHAND("thirdperson_lefthand");

    private final String id;

    DisplayContext(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
}