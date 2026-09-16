package com.eclectusstudio.pantheon.data.villager_trade;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import io.papermc.paper.datacomponent.DataComponentType;

import java.util.List;

public class Want {
    private final ResourceLocation item;
    private final int count;
    private final List<DataComponentType> dataComponentType;

    public Want(ResourceLocation item, int count, List<DataComponentType> dataComponentType) {
        this.item = item;
        this.count = count;
        this.dataComponentType = dataComponentType;
    }

    public ResourceLocation getItem() {
        return item;
    }

    public int getCount() {
        return count;
    }

    public List<DataComponentType> getDataComponentType() {
        return dataComponentType;
    }
}
