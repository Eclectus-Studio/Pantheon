package com.eclectusstudio.pantheon.common.resource.fonts;

import com.eclectusstudio.pantheon.common.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class UnihexFontProvider extends FontProvider {

    private ResourceLocation hexFile;
    private List<UnihexSizeOverride> sizeOverrides = new ArrayList<>();

    @Override
    public String getType() {
        return "unihex";
    }

    public ResourceLocation getHexFile() {
        return hexFile;
    }

    public void setHexFile(ResourceLocation hexFile) {
        this.hexFile = hexFile;
    }

    public List<UnihexSizeOverride> getSizeOverrides() {
        return sizeOverrides;
    }

    public void setSizeOverrides(List<UnihexSizeOverride> sizeOverrides) {
        this.sizeOverrides = sizeOverrides;
    }
}