package com.eclectusstudio.pantheon.common.resource.blockstate;

public class MultipartRule {

    private Condition when;
    private VariantGroup apply;

    public MultipartRule(Condition when, VariantGroup apply) {
        this.when = when;
        this.apply = apply;
    }
}