package com.eclectusstudio.pantheon.common.resource.blockstate;

public class MultipartRule {

    private final Condition when;
    private final VariantGroup apply;

    public MultipartRule(
            Condition when,
            VariantGroup apply
    ) {
        this.when = when;
        this.apply = apply;
    }

    public Condition getWhen() {
        return when;
    }

    public VariantGroup getApply() {
        return apply;
    }
}
