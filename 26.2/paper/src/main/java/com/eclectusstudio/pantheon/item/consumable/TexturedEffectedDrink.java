package com.eclectusstudio.pantheon.item.consumable;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import io.papermc.paper.datacomponent.DataComponentTypes;
import io.papermc.paper.datacomponent.item.Consumable;
import io.papermc.paper.datacomponent.item.consumable.ConsumeEffect;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class TexturedEffectedDrink extends TexturedDrinkItem{
    private final List<ConsumeEffect> effects;

    public TexturedEffectedDrink(ResourceLocation id, ItemStack itemStack, boolean canAlwaysEat, float saturation, int nutrition, float consumeSeconds, ItemStack useRemainderItem, List<ConsumeEffect> effects) {
        super(id, itemStack, canAlwaysEat, saturation, nutrition, consumeSeconds, useRemainderItem);
        this.effects = effects;
    }

    public TexturedEffectedDrink(ResourceLocation id, ItemStack itemStack, boolean canAlwaysEat, float saturation, int nutrition, float consumeSeconds, boolean hasConsumeParticles, ItemStack useRemainderItem, List<ConsumeEffect> effects) {
        super(id, itemStack, canAlwaysEat, saturation, nutrition, consumeSeconds, hasConsumeParticles, useRemainderItem);
        this.effects = effects;
    }

    @Override
    public ItemStack createStack() {
        ItemStack stack = super.createStack();

        Consumable consumable = stack.getData(DataComponentTypes.CONSUMABLE);

        Consumable.Builder consumableBuilder = consumable.toBuilder();
        consumableBuilder.addEffects(effects);

        Consumable buildedConsumable = consumableBuilder.build();

        stack.setData(DataComponentTypes.CONSUMABLE, buildedConsumable);

        return stack;
    }

    public List<ConsumeEffect> getEffects() {
        return effects;
    }
}
