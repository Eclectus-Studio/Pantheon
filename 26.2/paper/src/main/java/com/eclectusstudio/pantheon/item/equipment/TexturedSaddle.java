package com.eclectusstudio.pantheon.item.equipment;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.item.TexturedEquipmentItem;
import io.papermc.paper.datacomponent.DataComponentTypes;
import io.papermc.paper.datacomponent.item.Equippable;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static com.eclectusstudio.pantheon.utils.LocationToNamespaceKey.toKey;

public class TexturedSaddle extends TexturedEquipmentItem {
    public TexturedSaddle(ResourceLocation id, ItemStack itemStack, ResourceLocation equipmentResourceLocation) {
        super(id, itemStack, equipmentResourceLocation);

        this.setDamageOnHurt(false);
        this.setCanBeSheared(true);
    }

    @Override
    public ItemStack createStack() {
        ItemStack stack = super.createStack();
        ItemMeta meta = stack.getItemMeta();

        if (meta == null) {
            return stack;
        }

        Equippable equippableComponent = Equippable.equippable(EquipmentSlot.SADDLE)
                .assetId(toKey(getEquipmentResourceLocation()))
                .build();

        stack.setItemMeta(meta);
        stack.setData(DataComponentTypes.EQUIPPABLE, equippableComponent);

        return stack;
    }
}
