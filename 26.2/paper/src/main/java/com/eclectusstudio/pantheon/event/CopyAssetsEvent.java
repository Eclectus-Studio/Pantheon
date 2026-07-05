package com.eclectusstudio.pantheon.event;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.io.File;

public class CopyAssetsEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private File packFolder;

    public CopyAssetsEvent(File packFolder){
        this.packFolder = packFolder;
    }

    public File getPackFolder() {
        return packFolder;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
