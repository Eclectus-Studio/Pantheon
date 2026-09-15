package com.eclectusstudio.pantheon.common.resource.blockstate;

import com.eclectusstudio.pantheon.common.ResourceLocation;

import java.util.List;
import java.util.Map;

public class BlockStateDefinition {

    private final ResourceLocation location;

    private Map<String, VariantGroup> variants;
    private List<MultipartRule> multipart;

    public BlockStateDefinition(ResourceLocation location) {
        this.location = location;
    }

    public BlockStateDefinition variants(Map<String, VariantGroup> variants) {
        this.variants = variants;
        return this;
    }

    public BlockStateDefinition multipart(List<MultipartRule> multipart) {
        this.multipart = multipart;
        return this;
    }

    public ResourceLocation getLocation() {
        return location;
    }

    public Map<String, VariantGroup> getVariants() {
        return variants;
    }

    public List<MultipartRule> getMultipart() {
        return multipart;
    }
}
