package com.eclectusstudio.pantheon.common.resource.blockstate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Condition {

    private final Map<String, String> states = new HashMap<>();

    private List<Condition> and;
    private List<Condition> or;

    public Condition state(String key, String value) {
        states.put(key, value);
        return this;
    }

    public static Condition and(Condition... conditions) {
        Condition c = new Condition();
        c.and = Arrays.asList(conditions);
        return c;
    }

    public static Condition or(Condition... conditions) {
        Condition c = new Condition();
        c.or = Arrays.asList(conditions);
        return c;
    }

    public Map<String, String> getStates() {
        return states;
    }

    public List<Condition> getAnd() {
        return and;
    }

    public List<Condition> getOr() {
        return or;
    }
}
