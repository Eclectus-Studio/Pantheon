package com.eclectusstudio.pantheon.data.villager_trade;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import org.bukkit.inventory.ItemStack;

public class VillagerTrade {
    private final ResourceLocation location;

    private final Want want;
    private Want additionalWant;

    private final ItemStack gives;

    private final ResourceLocation givenItemModifier;

    private final int maxUses;
    private final int reputationDiscount;
    private final int xp;

    // TODO merchant predicate

    public VillagerTrade(ResourceLocation location, Want want, Want additionalWant, ItemStack gives, ResourceLocation givenItemModifier, int maxUses, int reputationDiscount, int xp) {
        this.location = location;
        this.want = want;
        this.additionalWant = additionalWant;
        this.gives = gives;
        this.givenItemModifier = givenItemModifier;
        this.maxUses = maxUses;
        this.reputationDiscount = reputationDiscount;
        this.xp = xp;
    }

    public VillagerTrade(ResourceLocation location, Want want, ItemStack gives, ResourceLocation givenItemModifier, int maxUses, int reputationDiscount, int xp) {
        this.location = location;
        this.want = want;
        this.gives = gives;
        this.givenItemModifier = givenItemModifier;
        this.maxUses = maxUses;
        this.reputationDiscount = reputationDiscount;
        this.xp = xp;
    }

    public void setAdditionalWant(Want additionalWant) {
        this.additionalWant = additionalWant;
    }

    public ResourceLocation getLocation() {
        return location;
    }

    public Want getWant() {
        return want;
    }

    public Want getAdditionalWant() {
        return additionalWant;
    }

    public ItemStack getGives() {
        return gives;
    }

    public ResourceLocation getGivenItemModifier() {
        return givenItemModifier;
    }

    public int getMaxUses() {
        return maxUses;
    }

    public int getReputationDiscount() {
        return reputationDiscount;
    }

    public int getXp() {
        return xp;
    }
}
