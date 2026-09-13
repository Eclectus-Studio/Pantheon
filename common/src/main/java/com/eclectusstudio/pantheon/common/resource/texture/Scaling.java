package com.eclectusstudio.pantheon.common.resource.texture;

import javax.swing.border.Border;

public class Scaling {

    private Type type;
    private Integer width;
    private Integer height;
    private Boolean stretchInner;
    private Integer border;
    private Border borderSize;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
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

    public Boolean getStretchInner() {
        return stretchInner;
    }

    public void setStretchInner(Boolean stretchInner) {
        this.stretchInner = stretchInner;
    }

    public Integer getBorder() {
        return border;
    }

    public void setBorder(Integer border) {
        this.border = border;
    }

    public Border getBorderSize() {
        return borderSize;
    }

    public void setBorderSize(Border borderSize) {
        this.borderSize = borderSize;
    }

    public enum Type {
        STRETCH,
        TILE,
        NINE_SLICE
    }
}
