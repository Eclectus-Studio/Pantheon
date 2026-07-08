package com.eclectusstudio.pantheon.common.resource.fonts;

public abstract class FontProvider {

    private FontFilter filter;

    public FontFilter getFilter() {
        return filter;
    }

    public void setFilter(FontFilter filter) {
        this.filter = filter;
    }

    public abstract String getType();
}