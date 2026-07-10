package com.eclectusstudio.pantheon.item.equipment;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.item.TexturedEquipmentItem;
import io.papermc.paper.datacomponent.DataComponentTypes;
import io.papermc.paper.datacomponent.item.Equippable;
import org.bukkit.Material;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static com.eclectusstudio.pantheon.utils.LocationToNamespaceKey.toKey;

public class TexturedChestplateItem extends TexturedEquipmentItem {
    public TexturedChestplateItem(ResourceLocation id, ItemStack itemStack, ResourceLocation equipmentResourceLocation) {
        super(id, itemStack, equipmentResourceLocation);

        this.setDamageOnHurt(true);
        this.setEquipOnInteract(true);
        this.setMaxDurability(1000);
        this.setRepairIngredient(ItemStack.of(Material.IRON_INGOT));
    }

    @Override
    public ItemStack createStack() {
        // 1. Run the superclass to handle Model, Durability, Repairs, and basic Equippable settings
        ItemStack stack = super.createStack();
        ItemMeta meta = stack.getItemMeta();

        if (meta == null) {
            return stack;
        }

        stack.setData(DataComponentTypes.GLIDER);

        // 3. Apply the custom 3D Equipment Model/Texture
        Equippable equippableComponent = Equippable.equippable(EquipmentSlot.CHEST)
                .assetId(toKey(getEquipmentResourceLocation()))
                .build();

        stack.setData(DataComponentTypes.EQUIPPABLE, equippableComponent);

        stack.setItemMeta(meta);
        return stack;
    }
}
