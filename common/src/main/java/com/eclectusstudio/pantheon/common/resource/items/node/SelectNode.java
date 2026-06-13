package com.eclectusstudio.pantheon.common.resource.items.node;

import java.util.List;

public class SelectNode implements ItemModelNode {

    public static class Case {

        public Object when;
        public ItemModelNode model;

        public Case(
                Object when,
                ItemModelNode model
        ) {
            this.when = when;
            this.model = model;
        }
    }

    private String property;
    private List<Case> cases;
    private ItemModelNode fallback;

    @Override
    public String type() {
        return "minecraft:select";
    }

    public SelectNode(
            String property,
            List<Case> cases,
            ItemModelNode fallback
    ) {
        this.property = property;
        this.cases = cases;
        this.fallback = fallback;
    }

    public String getProperty() {
        return property;
    }

    public List<Case> getCases() {
        return cases;
    }

    public ItemModelNode getFallback() {
        return fallback;
    }
}