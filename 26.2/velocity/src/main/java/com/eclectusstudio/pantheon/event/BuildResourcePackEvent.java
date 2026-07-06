package com.eclectusstudio.pantheon.event;

import com.eclectusstudio.pantheon.common.ResourcePack;
import com.eclectusstudio.pantheon.common.ResourcePacks;

public final class BuildResourcePackEvent {

    public void buildResourcePack(ResourcePack pack) {
        ResourcePacks.addPack(pack);
    }
}