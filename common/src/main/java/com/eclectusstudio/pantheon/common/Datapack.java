package com.eclectusstudio.pantheon.common;

import com.eclectusstudio.pantheon.common.data.cat_variant.CatVariant;
import com.eclectusstudio.pantheon.common.data.chicken_variant.ChickenVariant;
import com.eclectusstudio.pantheon.common.data.cow_variant.CowVariant;
import com.eclectusstudio.pantheon.common.data.damage_type.DamageType;
import com.eclectusstudio.pantheon.common.data.frog_variant.FrogVariant;
import com.eclectusstudio.pantheon.common.data.jukebox_song.JukeboxSong;
import com.eclectusstudio.pantheon.common.data.pig_variant.PigVariant;
import com.eclectusstudio.pantheon.common.data.wolf_sound_variant.WolfSoundVariant;
import com.eclectusstudio.pantheon.common.data.wolf_variant.WolfVariant;
import com.eclectusstudio.pantheon.common.data.world_clock.WorldClock;
import com.eclectusstudio.pantheon.common.data.zombie_nautilus_variant.ZombieNautilusVariant;

import java.util.ArrayList;
import java.util.List;

public class Datapack {
    private final List<CatVariant> catVariants;
    private final List<ChickenVariant> chickenVariants;
    private final List<CowVariant> cowVariants;
    private final List<DamageType> damageTypes;
    private final List<FrogVariant> frogVariants;
    private final List<JukeboxSong> jukeboxSongs;
    private final List<PigVariant> pigVariants;
    private final List<WolfSoundVariant> wolfSoundVariants;
    private final List<WolfVariant> wolfVariants;
    private final List<WorldClock> worldClocks;
    private final List<ZombieNautilusVariant> zombieNautilusVariants;

    public Datapack(){
        catVariants = new ArrayList<>();
        chickenVariants = new ArrayList<>();
        cowVariants = new ArrayList<>();
        damageTypes = new ArrayList<>();
        frogVariants = new ArrayList<>();
        jukeboxSongs = new ArrayList<>();
        pigVariants = new ArrayList<>();
        wolfSoundVariants = new ArrayList<>();
        wolfVariants = new ArrayList<>();
        worldClocks = new ArrayList<>();
        zombieNautilusVariants = new ArrayList<>();
    }

    public void addCatVariant(CatVariant variant){
        catVariants.add(variant);
    }

    public void addChickenVariant(ChickenVariant variant){
        chickenVariants.add(variant);
    }

    public void addCowVariants(CowVariant variant){
        cowVariants.add(variant);
    }

    public void addDamageType(DamageType type){
         damageTypes.add(type);
    }

    public void addFrogVariant(FrogVariant variant){
        frogVariants.add(variant);
    }

    public void addJukeboxSong(JukeboxSong song){
        jukeboxSongs.add(song);
    }

    public void addPigVariant(PigVariant variant){
        pigVariants.add(variant);
    }

    public void addWolfSoundVariant(WolfSoundVariant soundVariant){
        wolfSoundVariants.add(soundVariant);
    }

    public void addWofVariant(WolfVariant variant){
        wolfVariants.add(variant);
    }

    public void addWorldClock(WorldClock clock){
        worldClocks.add(clock);
    }

    public void addZombieNautilusVariant(ZombieNautilusVariant variant){
        zombieNautilusVariants.add(variant);
    }

    public List<CatVariant> getCatVariants() {
        return catVariants;
    }

    public List<ChickenVariant> getChickenVariants() {
        return chickenVariants;
    }

    public List<CowVariant> getCowVariants() {
        return cowVariants;
    }

    public List<DamageType> getDamageTypes() {
        return damageTypes;
    }

    public List<FrogVariant> getFrogVariants() {
        return frogVariants;
    }

    public List<JukeboxSong> getJukeboxSongs() {
        return jukeboxSongs;
    }

    public List<PigVariant> getPigVariants() {
        return pigVariants;
    }

    public List<WolfSoundVariant> getWolfSoundVariants() {
        return wolfSoundVariants;
    }

    public List<WolfVariant> getWolfVariants() {
        return wolfVariants;
    }

    public List<WorldClock> getWorldClocks() {
        return worldClocks;
    }

    public List<ZombieNautilusVariant> getZombieNautilusVariants() {
        return zombieNautilusVariants;
    }
}
