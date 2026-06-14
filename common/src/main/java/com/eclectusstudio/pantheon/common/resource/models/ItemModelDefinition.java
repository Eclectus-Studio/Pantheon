package com.eclectusstudio.pantheon.common.resource.models;

import com.eclectusstudio.pantheon.common.ResourceLocation;

public class ItemModelDefinition {

    private ResourceLocation parent;
    private ModelTextures textures;
    private ModelDisplay display;

    public ItemModelDefinition(ResourceLocation parent) {
        this.parent = parent;
    }

    public ResourceLocation getParent() {
        return parent;
    }

    public ModelTextures getTextures() {
        return textures;
    }

    public void setTextures(ModelTextures textures) {
        this.textures = textures;
    }

    public ModelDisplay getDisplay() {
        return display;
    }

    public void setDisplay(ModelDisplay display) {
        this.display = display;
    }
}