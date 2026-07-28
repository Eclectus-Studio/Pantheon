package com.eclectusstudio.pantheon.common.resource.items.node;

import java.util.List;

public class SelectNode implements ItemModelNode {

    public static class Case {

        private List<String> when;
        private ItemModelNode model;

        public Case(String when, ItemModelNode model) {
            this.when = List.of(when);
            this.model = model;
        }

        public Case(List<String> when, ItemModelNode model) {
            this.when = when;
            this.model = model;
        }

        public List<String> getWhen() {
            return when;
        }

        public ItemModelNode getModel() {
            return model;
        }
    }

    private SelectProperty property;
    private List<Case> cases;
    private ItemModelNode fallback;

    @Override
    public String type() {
        return "minecraft:select";
    }

    public SelectNode(
            SelectProperty property,
            List<Case> cases,
            ItemModelNode fallback
    ) {
        this.property = property;
        this.cases = cases;
        this.fallback = fallback;
    }

    public SelectProperty getProperty() {
        return property;
    }

    public List<Case> getCases() {
        return cases;
    }

    public ItemModelNode getFallback() {
        return fallback;
    }
}