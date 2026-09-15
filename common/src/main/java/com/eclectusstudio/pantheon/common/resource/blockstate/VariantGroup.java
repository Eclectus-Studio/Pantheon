package com.eclectusstudio.pantheon.common.resource.blockstate;

import java.util.List;

public class VariantGroup {

    private final List<ModelVariant> variants;

    public VariantGroup(List<ModelVariant> variants) {
        this.variants = variants;
    }

    public List<ModelVariant> getVariants() {
        return variants;
    }

    public static VariantGroup of(ModelVariant... variants) {
        return new VariantGroup(List.of(variants));
    }
}
