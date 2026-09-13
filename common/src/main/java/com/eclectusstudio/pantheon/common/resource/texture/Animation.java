package com.eclectusstudio.pantheon.common.resource.texture;

import java.awt.*;
import java.util.List;

public class Animation {

    private Boolean interpolate;
    private Integer width;
    private Integer height;
    private Integer frametime;
    private List<Frame> frames;

    public Boolean getInterpolate() {
        return interpolate;
    }

    public void setInterpolate(Boolean interpolate) {
        this.interpolate = interpolate;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getFrametime() {
        return frametime;
    }

    public void setFrametime(Integer frametime) {
        this.frametime = frametime;
    }

    public List<Frame> getFrames() {
        return frames;
    }

    public void setFrames(List<Frame> frames) {
        this.frames = frames;
    }
}
