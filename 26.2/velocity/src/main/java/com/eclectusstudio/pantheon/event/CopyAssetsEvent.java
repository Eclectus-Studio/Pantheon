package com.eclectusstudio.pantheon.event;

import java.io.File;

public final class CopyAssetsEvent {

    private final File packFolder;

    public CopyAssetsEvent(File packFolder) {
        this.packFolder = packFolder;
    }

    public File getPackFolder() {
        return packFolder;
    }
}
