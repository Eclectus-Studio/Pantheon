package com.eclectusstudio.pantheon.item.consumable;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import io.papermc.paper.datacomponent.DataComponentTypes;
import io.papermc.paper.datacomponent.item.Consumable;
import io.papermc.paper.datacomponent.item.UseRemainder;
import org.bukkit.inventory.ItemStack;

public class TexturedDrinkItem extends TexturedFoodItem{
    private final float consumeSeconds;
    private final boolean hasConsumeParticles;

    private final ItemStack useRemainderItem;

    public TexturedDrinkItem(ResourceLocation id, ItemStack itemStack, boolean canAlwaysEat, float saturation, int nutrition, float consumeSeconds, ItemStack useRemainderItem) {
        super(id, itemStack, canAlwaysEat, saturation, nutrition);
        this.consumeSeconds = consumeSeconds;
        this.useRemainderItem = useRemainderItem;
        this.hasConsumeParticles = true;
    }

    public TexturedDrinkItem(ResourceLocation id, ItemStack itemStack, boolean canAlwaysEat, float saturation, int nutrition, float consumeSeconds, boolean hasConsumeParticles, ItemStack useRemainderItem) {
        super(id, itemStack, canAlwaysEat, saturation, nutrition);
        this.consumeSeconds = consumeSeconds;
        this.hasConsumeParticles = hasConsumeParticles;
        this.useRemainderItem = useRemainderItem;
    }

    @Override
    public ItemStack createStack() {
        ItemStack stack = super.createStack();

        Consumable.Builder consumableComponent = Consumable.consumable()
                .consumeSeconds(consumeSeconds)
                .hasConsumeParticles(hasConsumeParticles);

        UseRemainder useRemainder = UseRemainder.useRemainder(useRemainderItem);

        stack.setData(DataComponentTypes.CONSUMABLE, consumableComponent);
        stack.setData(DataComponentTypes.USE_REMAINDER, useRemainder);

        return stack;
    }
}
