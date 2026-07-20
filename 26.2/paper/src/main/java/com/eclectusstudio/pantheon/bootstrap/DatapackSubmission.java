package com.eclectusstudio.pantheon.bootstrap;

import com.eclectusstudio.pantheon.common.Datapack;

public final class DatapackSubmission {
    private static final Datapack DATAPACK = new Datapack();

    private DatapackSubmission() {}

    public static void submit(Datapack datapack) {
        DATAPACK.getCatVariants().addAll(datapack.getCatVariants());
        DATAPACK.getChickenVariants().addAll(datapack.getChickenVariants());
        DATAPACK.getCowVariants().addAll(datapack.getCowVariants());
        DATAPACK.getDamageTypes().addAll(datapack.getDamageTypes());
        DATAPACK.getFrogVariants().addAll(datapack.getFrogVariants());
        DATAPACK.getJukeboxSongs().addAll(datapack.getJukeboxSongs());
        DATAPACK.getPigVariants().addAll(datapack.getPigVariants());
        DATAPACK.getWolfSoundVariants().addAll(datapack.getWolfSoundVariants());
        DATAPACK.getWolfVariants().addAll(datapack.getWolfVariants());
        DATAPACK.getWorldClocks().addAll(datapack.getWorldClocks());
        DATAPACK.getZombieNautilusVariants().addAll(datapack.getZombieNautilusVariants());
    }

    public static Datapack getDatapack() {
        return DATAPACK;
    }
}