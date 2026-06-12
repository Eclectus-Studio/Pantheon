package com.eclectusstudio.pantheon.common.resource.items.node;

public class ConditionNode implements ItemModelNode {

    private String property;
    private ItemModelNode onTrue;
    private ItemModelNode onFalse;

    @Override
    public String type() {
        return "minecraft:condition";
    }

    public ConditionNode(String property, ItemModelNode onTrue, ItemModelNode onFalse) {
        this.property = property;
        this.onTrue = onTrue;
        this.onFalse = onFalse;
    }
}