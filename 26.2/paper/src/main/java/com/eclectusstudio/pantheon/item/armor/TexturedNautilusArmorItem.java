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

public class TexturedNautilusArmorItem extends TexturedArmorItem {
    RegistryKeySet<EntityType> customSet = RegistrySet.keySet(
            RegistryKey.ENTITY_TYPE,
            TypedKey.create(RegistryKey.ENTITY_TYPE, EntityType.NAUTILUS.getKey()),
            TypedKey.create(RegistryKey.ENTITY_TYPE, EntityType.ZOMBIE_NAUTILUS.getKey())
    );

    public TexturedNautilusArmorItem(ResourceLocation id, ItemStack itemStack, int maxDamage, ItemStack repairIngredient, Equipment equipment,double armor, double armorToughness) {
        super(id, itemStack, maxDamage, repairIngredient, equipment, EquipmentSlot.BODY, armor, armorToughness, null);
        this.setAllowedEntities(customSet);
    }

    public TexturedNautilusArmorItem(ResourceLocation id, ItemStack itemStack, int maxDamage, ItemStack repairIngredient, ResourceLocation equipmentResourceLocation, double armor, double armorToughness) {
        super(id, itemStack, maxDamage, repairIngredient, equipmentResourceLocation, EquipmentSlot.BODY, armor, armorToughness, null);
        this.setAllowedEntities(customSet);
    }
}
