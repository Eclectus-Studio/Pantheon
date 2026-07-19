package com.eclectusstudio.pantheon.common.data_common.mob_variant.spawn_condition;


public class SpawnCondition {
    private int priority;

    private Condition condition;

    public SpawnCondition(int priority, Condition condition) {
        this.priority = priority;
        this.condition = condition;
    }

    public Condition getCondition() {
        return condition;
    }

    public int getPriority() {
        return priority;
    }
}