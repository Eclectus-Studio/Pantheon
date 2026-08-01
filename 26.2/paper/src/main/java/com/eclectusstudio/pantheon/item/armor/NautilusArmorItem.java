package com.eclectusstudio.pantheon.item.armor;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.common.resource.equipment.Equipment;
import com.eclectusstudio.pantheon.item.TexturedArmorItem;

import io.papermc.paper.registry.RegistryKey;
import io.papermc.paper.registry.TypedKey;
import io.papermc.paper.registry.set.RegistryKeySet;
import io.papermc.paper.registry.set.RegistrySet;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class NautilusArmorItem extends TexturedArmorItem {
    RegistryKeySet<EntityType> customSet = RegistrySet.keySet(
            RegistryKey.ENTITY_TYPE,
            TypedKey.create(RegistryKey.ENTITY_TYPE, EntityType.NAUTILUS.getKey()),
            TypedKey.create(RegistryKey.ENTITY_TYPE, EntityType.ZOMBIE_NAUTILUS.getKey())
    );

    public NautilusArmorItem(ResourceLocation id, ItemStack itemStack, int maxDamage, ItemStack repairIngredient, Equipment equipment, EquipmentSlot slot, double armor, double armorToughness) {
        super(id, itemStack, maxDamage, repairIngredient, equipment, slot, armor, armorToughness);
        this.setAllowedEntities(customSet);
    }

    public NautilusArmorItem(ResourceLocation id, ItemStack itemStack, int maxDamage, ItemStack repairIngredient, ResourceLocation equipmentResourceLocation, EquipmentSlot slot, double armor, double armorToughness) {
        super(id, itemStack, maxDamage, repairIngredient, equipmentResourceLocation, slot, armor, armorToughness);
        this.setAllowedEntities(customSet);
    }
}
