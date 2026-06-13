package com.eclectusstudio.pantheon.event;

import com.eclectusstudio.pantheon.common.ResourcePack;
import com.eclectusstudio.pantheon.common.ResourcePackContext;
import com.eclectusstudio.pantheon.common.ResourcePacks;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.List;

public class BuildResourcePackEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final ResourcePackContext context;

    public BuildResourcePackEvent(ResourcePackContext context) {
        this.context = context;
    }

    // PACKS
    public void pack(ResourcePack pack) {
        ResourcePacks.addPack(pack);
    }

    // CONTEXT ACCESS (bulk assets)
    public void setContext(ResourcePackContext context){
        context.
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}