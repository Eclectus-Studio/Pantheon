package com.eclectusstudio.pantheon.common.resource.blockstate;

import java.util.*;

public class Condition {

    private Map<String, String> states = new HashMap<>();

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
}