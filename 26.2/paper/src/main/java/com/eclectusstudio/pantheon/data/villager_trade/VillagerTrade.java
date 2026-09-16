package com.eclectusstudio.pantheon.data.villager_trade;

public class VillagerTrade {
    private final Want want;
    private final Want additionalWant;

    public VillagerTrade(Want want, Want additionalWant) {
        this.want = want;
        this.additionalWant = additionalWant;
    }
}
