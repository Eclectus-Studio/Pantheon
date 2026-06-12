package com.eclectusstudio.pantheon.common.pack;

import com.eclectusstudio.pantheon.common.ResourceLocation;

import java.util.List;

public record Filter(
        List<ResourceLocation> block
) {}