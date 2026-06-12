package com.eclectusstudio.pantheon.common.resource.items.node;

import java.util.List;

public class RangeDispatchNode implements ItemModelNode {

    public static class Entry {
        public float threshold;
        public ItemModelNode model;

        public Entry(float threshold, ItemModelNode model) {
            this.threshold = threshold;
            this.model = model;
        }
    }

    private String property;
    private List<Entry> entries;

    @Override
    public String type() {
        return "minecraft:range_dispatch";
    }

    public RangeDispatchNode(String property, List<Entry> entries) {
        this.property = property;
        this.entries = entries;
    }
}