package com.eclectusstudio.pantheon;

import com.eclectusstudio.pantheon.data.banner_pattern.BannerPattern;
import com.eclectusstudio.pantheon.data.cat_variant.CatVariant;
import com.eclectusstudio.pantheon.data.chicken_variant.ChickenVariant;
import com.eclectusstudio.pantheon.data.cow_variant.CowVariant;
import com.eclectusstudio.pantheon.data.damage_type.DamageType;
import com.eclectusstudio.pantheon.data.decoratedpotpattern.DecoratedPotPattern;
import com.eclectusstudio.pantheon.data.frog_variant.FrogVariant;
import com.eclectusstudio.pantheon.data.jukebox_song.JukeboxSong;
import com.eclectusstudio.pantheon.data.painting_variant.PaintingVariant;
import com.eclectusstudio.pantheon.data.pig_variant.PigVariant;
import com.eclectusstudio.pantheon.data.sulfur_cube_archetype.SulfurCubeArchetype;
import com.eclectusstudio.pantheon.data.trim_material.TrimMaterial;
import com.eclectusstudio.pantheon.data.trim_pattern.TrimPattern;
import com.eclectusstudio.pantheon.data.villager_trade.VillagerTrade;
import com.eclectusstudio.pantheon.data.wolf_sound_variant.WolfSoundVariant;
import com.eclectusstudio.pantheon.data.wolf_variant.WolfVariant;
import com.eclectusstudio.pantheon.data.world_clock.WorldClock;
import com.eclectusstudio.pantheon.data.zombie_nautilus_variant.ZombieNautilusVariant;

import java.util.ArrayList;
import java.util.List;

public class Datapack {
    private final List<CatVariant> catVariants;
    private final List<ChickenVariant> chickenVariants;
    private final List<CowVariant> cowVariants;
    private final List<DamageType> damageTypes;
    private final List<FrogVariant> frogVariants;
    private final List<JukeboxSong> jukeboxSongs;
    private final List<PaintingVariant> paintingVariants;
    private final List<PigVariant> pigVariants;
    private final List<SulfurCubeArchetype> sulfurCubeArchetypes;
    private final List<WolfSoundVariant> wolfSoundVariants;
    private final List<WolfVariant> wolfVariants;
    private final List<WorldClock> worldClocks;
    private final List<ZombieNautilusVariant> zombieNautilusVariants;
    private final List<TrimMaterial> trimMaterials;
    private final List<TrimPattern> trimPatterns;
    private final List<BannerPattern> bannerPatterns;
    private final List<DecoratedPotPattern> decoratedPotPatterns;
    private final List<VillagerTrade> villagerTrades;

    public Datapack(){
        catVariants = new ArrayList<>();
        chickenVariants = new ArrayList<>();
        cowVariants = new ArrayList<>();
        damageTypes = new ArrayList<>();
        frogVariants = new ArrayList<>();
        jukeboxSongs = new ArrayList<>();
        paintingVariants = new ArrayList<>();
        pigVariants = new ArrayList<>();
        sulfurCubeArchetypes = new ArrayList<>();
        wolfSoundVariants = new ArrayList<>();
        wolfVariants = new ArrayList<>();
        worldClocks = new ArrayList<>();
        zombieNautilusVariants = new ArrayList<>();
        trimMaterials = new ArrayList<>();
        trimPatterns = new ArrayList<>();
        bannerPatterns = new ArrayList<>();
        decoratedPotPatterns = new ArrayList<>();
        villagerTrades = new ArrayList<>();
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

    public void addPaintingVariant(PaintingVariant variant) {
        paintingVariants.add(variant);
    }

    public void addPigVariant(PigVariant variant){
        pigVariants.add(variant);
    }

    public void addSulfurCubeArchetype(SulfurCubeArchetype sulfurCubeArchetype){
        sulfurCubeArchetypes.add(sulfurCubeArchetype);
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

    public void addTrimMaterial(TrimMaterial trimMaterial) {
        trimMaterials.add(trimMaterial);
    }

    public void addTrimPatterns(TrimPattern trimPattern) {
        trimPatterns.add(trimPattern);
    }

    public void addBannerPattern(BannerPattern bannerPattern){
        bannerPatterns.add(bannerPattern);
    }

    public void addDecoratedPotPattern(DecoratedPotPattern decoratedPotPattern){
        decoratedPotPatterns.add(decoratedPotPattern);
    }

    public void addVillagerTrade(VillagerTrade villagerTrade){
        villagerTrades.add(villagerTrade);
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

    public List<PaintingVariant> getPaintingVariants() {
        return paintingVariants;
    }

    public List<PigVariant> getPigVariants() {
        return pigVariants;
    }

    public List<SulfurCubeArchetype> getSulfurCubeArchetypes() {
        return sulfurCubeArchetypes;
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

    public List<TrimMaterial> getTrimMaterials() {
        return trimMaterials;
    }

    public List<TrimPattern> getTrimPatterns() {
        return trimPatterns;
    }

    public List<BannerPattern> getBannerPatterns() {
        return bannerPatterns;
    }

    public List<DecoratedPotPattern> getDecoratedPotPatterns() {
        return decoratedPotPatterns;
    }

    public List<VillagerTrade> getVillagerTrades() {
        return villagerTrades;
    }
}
