package com.eclectusstudio.pantheon.common.resource.texture;

import com.eclectusstudio.pantheon.common.ResourceLocation;

public class TextureMeta {
    private final ResourceLocation location;

    private Animation animation;
    private Villager villager;
    private Gui gui;

    public TextureMeta(ResourceLocation location) {
        this.location = location;
    }

    public Animation getAnimation() {
        return animation;
    }

    public void setAnimation(Animation animation) {
        this.animation = animation;
    }

    public Villager getVillager() {
        return villager;
    }

    public void setVillager(Villager villager) {
        this.villager = villager;
    }

    public Gui getGui() {
        return gui;
    }

    public void setGui(Gui gui) {
        this.gui = gui;
    }

    public ResourceLocation getLocation() {
        return location;
    }
}
