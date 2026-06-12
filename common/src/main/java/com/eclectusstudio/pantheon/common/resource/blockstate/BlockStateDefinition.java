package com.eclectusstudio.pantheon.common.resource.blockstate;

import java.util.*;

public class BlockStateDefinition {

    private Map<String, VariantGroup> variants;
    private List<MultipartRule> multipart;

    public BlockStateDefinition() {}

    public BlockStateDefinition variants(Map<String, VariantGroup> variants) {
        this.variants = variants;
        return this;
    }

    public BlockStateDefinition multipart(List<MultipartRule> multipart) {
        this.multipart = multipart;
        return this;
    }
}