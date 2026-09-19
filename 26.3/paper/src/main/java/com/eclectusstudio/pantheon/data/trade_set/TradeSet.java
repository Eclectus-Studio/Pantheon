package com.eclectusstudio.pantheon.data.trade_set;

import com.eclectusstudio.pantheon.common.ResourceLocation;

import java.util.List;

public class TradeSet {
    //TODO random sequence

    private final List<ResourceLocation> villagerTrades;

    private final int amount;

    private final boolean allowDuplicate;


    public TradeSet(List<ResourceLocation> villagerTrades, int amount, boolean allowDuplicate) {
        this.villagerTrades = villagerTrades;
        this.amount = amount;
        this.allowDuplicate = allowDuplicate;
    }

    public List<ResourceLocation> getVillagerTrades() {
        return villagerTrades;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isAllowDuplicate() {
        return allowDuplicate;
    }
}
