package com.eclectusstudio.pantheon.item;

import com.eclectusstudio.pantheon.Pantheon;
import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.common.resource.equipment.Equipment;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.EquipmentSlotGroup;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.components.EquippableComponent;
import org.bukkit.persistence.PersistentDataType;

import java.util.Collection;

import static com.eclectusstudio.pantheon.utils.LocationToNamespaceKey.toKey;

public class TexturedEquipmentItem extends Item {

    private final Equipment equipment;

    private final EquipmentSlotGroup slotGroup;

    private Sound equipSound;
    private Sound shearingSound;

    private ResourceLocation cameraOverlay;
    private Collection<EntityType> allowedEntities;

    private boolean dispensable = true;
    private boolean swappable = true;
    private boolean damageOnHurt = true;
    private boolean equipOnInteract = false;
    private boolean canBeSheared = false;

    protected TexturedEquipmentItem(
            ResourceLocation id,
            ItemStack itemStack,
            Equipment equipment, EquipmentSlotGroup slotGroup
    ) {
        super(id, itemStack);
        this.equipment = equipment;
        this.slotGroup = slotGroup;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public Sound getEquipSound() {
        return equipSound;
    }

    public void setEquipSound(Sound equipSound) {
        this.equipSound = equipSound;
    }

    public Sound getShearingSound() {
        return shearingSound;
    }

    public void setShearingSound(Sound shearingSound) {
        this.shearingSound = shearingSound;
    }

    public ResourceLocation getCameraOverlay() {
        return cameraOverlay;
    }

    public void setCameraOverlay(ResourceLocation cameraOverlay) {
        this.cameraOverlay = cameraOverlay;
    }

    public Collection<EntityType> getAllowedEntities() {
        return allowedEntities;
    }

    public void setAllowedEntities(Collection<EntityType> allowedEntities) {
        this.allowedEntities = allowedEntities;
    }

    public void setAllowedEntities(EntityType entityType) {
        this.allowedEntities = java.util.List.of(entityType);
    }

    public boolean isDispensable() {
        return dispensable;
    }

    public void setDispensable(boolean dispensable) {
        this.dispensable = dispensable;
    }

    public boolean isSwappable() {
        return swappable;
    }

    public void setSwappable(boolean swappable) {
        this.swappable = swappable;
    }

    public boolean isDamageOnHurt() {
        return damageOnHurt;
    }

    public void setDamageOnHurt(boolean damageOnHurt) {
        this.damageOnHurt = damageOnHurt;
    }

    public boolean isEquipOnInteract() {
        return equipOnInteract;
    }

    public void setEquipOnInteract(boolean equipOnInteract) {
        this.equipOnInteract = equipOnInteract;
    }

    public boolean canBeSheared() {
        return canBeSheared;
    }

    public void setCanBeSheared(boolean canBeSheared) {
        this.canBeSheared = canBeSheared;
    }

    @Override
    public ItemStack createStack() {
        ItemStack stack = getItemStack().clone();

        ItemMeta meta = stack.getItemMeta();

        meta.setItemModel(toKey(getId()));

        EquippableComponent equippable = meta.getEquippable();

        if (equippable != null) {

            if (equipSound != null) {
                equippable.setEquipSound(
                        equipSound
                );
            }

            if (cameraOverlay != null) {
                equippable.setCameraOverlay(
                        toKey(cameraOverlay)
                );
            }

            if (allowedEntities != null) {
                equippable.setAllowedEntities(allowedEntities);
            }

            equippable.setDispensable(dispensable);
            equippable.setSwappable(swappable);
            equippable.setDamageOnHurt(damageOnHurt);
            equippable.setEquipOnInteract(equipOnInteract);
            equippable.setCanBeSheared(canBeSheared);

            if (shearingSound != null) {
                equippable.setShearingSound(
                        shearingSound
                );
            }


            meta.setEquippable(equippable);
        }

        meta.getPersistentDataContainer().set(
                Pantheon.customItemKey,
                PersistentDataType.STRING,
                getId().toString()
        );

        stack.setItemMeta(meta);

        return stack;
    }
}