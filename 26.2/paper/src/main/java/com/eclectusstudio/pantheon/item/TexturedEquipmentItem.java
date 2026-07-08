package com.eclectusstudio.pantheon.item;

import com.eclectusstudio.pantheon.Pantheon;
import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.common.resource.equipment.Equipment;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.EquipmentSlotGroup;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.components.EquippableComponent;
import org.bukkit.persistence.PersistentDataType;

import java.util.Collection;

import static com.eclectusstudio.pantheon.utils.LocationToNamespaceKey.toKey;

public class TexturedEquipmentItem extends Item {

    private final ResourceLocation equipmentResourceLocation;

    private Sound equipSound;
    private Sound shearingSound;

    private ResourceLocation cameraOverlay;
    private Collection<EntityType> allowedEntities;

    private boolean dispensable = true;
    private boolean swappable = true;
    private boolean damageOnHurt = true;
    private boolean equipOnInteract = false;
    private boolean canBeSheared = false;

    // New parameters for durability and repairs
    private Integer maxDurability = null;
    private ItemStack repairIngredient = null;

    public TexturedEquipmentItem(
            ResourceLocation id,
            ItemStack itemStack,
            Equipment equipment
    ) {
        super(id, itemStack);
        this.equipmentResourceLocation = equipment.getLocation();
    }

    public TexturedEquipmentItem(
            ResourceLocation id,
            ItemStack itemStack,
            ResourceLocation equipmentResourceLocation
    ) {
        super(id, itemStack);
        this.equipmentResourceLocation = equipmentResourceLocation;
    }

    public ResourceLocation getEquipmentResourceLocation() {
        return equipmentResourceLocation;
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

    // Getters and Setters for Durability & Repairs
    public Integer getMaxDurability() {
        return maxDurability;
    }

    public void setMaxDurability(Integer maxDurability) {
        this.maxDurability = maxDurability;
    }

    public ItemStack getRepairIngredient() {
        return repairIngredient;
    }

    public void setRepairIngredient(ItemStack repairIngredient) {
        this.repairIngredient = repairIngredient;
    }

    @Override
    public ItemStack createStack() {
        ItemStack stack = getItemStack().clone();
        ItemMeta meta = stack.getItemMeta();

        if (meta == null) {
            return stack;
        }

        meta.setItemModel(toKey(getId()));

        // Handle Max Durability Component via Damageable Meta interface
        if (maxDurability != null) {
            if (meta instanceof Damageable damageable) {
                // If it natively supports damage (Sword, Elytra, etc.)
                damageable.setMaxDamage(maxDurability);
            } else {
                // For non-damageable items (e.g., Paper, Gold Nugget, Stick),
                // we use modern Paper Data Components to force it to have durability.
                stack.setData(io.papermc.paper.datacomponent.DataComponentTypes.MAX_DAMAGE, maxDurability);

                // Refresh meta to recognize the newly injected data component
                meta = stack.getItemMeta();
            }
        }

        // Handle Anvil Repair Ingredients Component via standard meta interface
        if (repairIngredient != null) {
            stack.isRepairableBy(repairIngredient);
        }

        // Handle Equippable Component
        EquippableComponent equippable = meta.getEquippable();
        if (equippable != null) {
            if (equipSound != null) {
                equippable.setEquipSound(equipSound);
            }

            if (cameraOverlay != null) {
                equippable.setCameraOverlay(toKey(cameraOverlay));
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
                equippable.setShearingSound(shearingSound);
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