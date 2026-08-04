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

public class TexturedHorseArmorItem extends TexturedArmorItem {
    RegistryKeySet<EntityType> customSet = RegistrySet.keySet(
            RegistryKey.ENTITY_TYPE,
            TypedKey.create(RegistryKey.ENTITY_TYPE, EntityType.HORSE.getKey()),
            TypedKey.create(RegistryKey.ENTITY_TYPE, EntityType.ZOMBIE_HORSE.getKey()),
            TypedKey.create(RegistryKey.ENTITY_TYPE, EntityType.SKELETON_HORSE.getKey())
    );

    public TexturedHorseArmorItem(ResourceLocation id, ItemStack itemStack, Equipment equipment, EquipmentSlot slot, double armor, double armorToughness, Integer enchantability) {
        super(id, itemStack, null, null, equipment, slot, armor, armorToughness, enchantability);
        this.setAllowedEntities(customSet);
    }

    public TexturedHorseArmorItem(ResourceLocation id, ItemStack itemStack, ResourceLocation equipmentResourceLocation, EquipmentSlot slot, double armor, double armorToughness, Integer enchantability) {
        super(id, itemStack, null, null, equipmentResourceLocation, slot, armor, armorToughness, enchantability);
        this.setAllowedEntities(customSet);
    }
}
