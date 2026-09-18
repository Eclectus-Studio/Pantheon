package com.eclectusstudio.pantheon.item.consumable;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.item.TexturedItem;
import io.papermc.paper.datacomponent.DataComponentTypes;
import io.papermc.paper.datacomponent.item.FoodProperties;
import org.bukkit.inventory.ItemStack;

public class TexturedFoodItem extends TexturedItem {
    private final boolean canAlwaysEat;
    private final float saturation;
    private final int nutrition;

    public TexturedFoodItem(ResourceLocation id, ItemStack itemStack, boolean canAlwaysEat, float saturation, int nutrition) {
        super(id, itemStack);
        this.canAlwaysEat = canAlwaysEat;
        this.saturation = saturation;
        this.nutrition = nutrition;
    }

    @Override
    public ItemStack createStack() {
        ItemStack stack = super.createStack();

        FoodProperties.Builder food = FoodProperties.food()
                .canAlwaysEat(canAlwaysEat)
                .nutrition(nutrition)
                .saturation(saturation);

        stack.setData(DataComponentTypes.FOOD, food);

        return stack;
    }

    public boolean isCanAlwaysEat() {
        return canAlwaysEat;
    }

    public float getSaturation() {
        return saturation;
    }

    public int getNutrition() {
        return nutrition;
    }
}
