package com.eclectusstudio.pantheon.common.resource.blockstate;

import java.util.List;

public class VariantGroup {

    private List<ModelVariant> variants;

    public VariantGroup(List<ModelVariant> variants) {
        this.variants = variants;
    }

    public List<ModelVariant> getVariants() {
        return variants;
    }
}