package com.eclectusstudio.pantheon.common.resource.fonts;

import java.util.HashMap;
import java.util.Map;

public class SpaceFontProvider extends FontProvider {

    private Map<String, Integer> advances = new HashMap<>();

    @Override
    public String getType() {
        return "space";
    }

    public Map<String, Integer> getAdvances() {
        return advances;
    }

    public void setAdvances(Map<String, Integer> advances) {
        this.advances = advances;
    }
}