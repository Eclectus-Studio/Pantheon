package com.eclectusstudio.pantheon.item;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.common.resource.equipment.Equipment;
import static com.eclectusstudio.pantheon.utils.LocationToNamespaceKey.toKey;

import io.papermc.paper.datacomponent.DataComponentTypes;
import io.papermc.paper.datacomponent.item.Equippable;
import io.papermc.paper.registry.RegistryKey;
import io.papermc.paper.registry.TypedKey;
import io.papermc.paper.registry.keys.EnchantmentKeys;
import io.papermc.paper.registry.set.RegistryKeySet;

import io.papermc.paper.registry.set.RegistrySet;
import net.kyori.adventure.key.Key;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

public class TexturedEquipmentItem extends DurableTexturedItem {

    private final ResourceLocation equipmentResourceLocation;

    private final EquipmentSlot slot;

    private Key equipSound;
    private Key shearingSound;

    private ResourceLocation cameraOverlay;
    private RegistryKeySet<EntityType> allowedEntities;

    private boolean dispensable = true;
    private boolean swappable = true;
    private boolean damageOnHurt = true;
    private boolean equipOnInteract = false;
    private boolean canBeSheared = false;

    public TexturedEquipmentItem(
            ResourceLocation id,
            ItemStack itemStack,
            Integer maxDamage,
            ItemStack repairIngredient,
            Equipment equipment,
            EquipmentSlot slot
    ) {
        super(id, itemStack, maxDamage, repairIngredient);
        this.equipmentResourceLocation = equipment.getLocation();
        this.slot = slot;
    }

    public TexturedEquipmentItem(
            ResourceLocation id,
            ItemStack itemStack,
            Integer maxDamage,
            ItemStack repairIngredient,
            ResourceLocation equipmentResourceLocation,
            EquipmentSlot slot
    ) {
        super(id, itemStack, maxDamage, repairIngredient);
        this.equipmentResourceLocation = equipmentResourceLocation;
        this.slot = slot;
    }

    public ResourceLocation getEquipmentResourceLocation() {
        return equipmentResourceLocation;
    }

    public Key getEquipSound() {
        return equipSound;
    }

    public void setEquipSound(Key equipSound) {
        this.equipSound = equipSound;
    }

    public Key getShearingSound() {
        return shearingSound;
    }

    public void setShearingSound(Key shearingSound) {
        this.shearingSound = shearingSound;
    }

    public ResourceLocation getCameraOverlay() {
        return cameraOverlay;
    }

    public void setCameraOverlay(ResourceLocation cameraOverlay) {
        this.cameraOverlay = cameraOverlay;
    }

    public RegistryKeySet<EntityType> getAllowedEntities() {
        return allowedEntities;
    }

    public void setAllowedEntities(RegistryKeySet<EntityType> allowedEntities) {
        this.allowedEntities = allowedEntities;
    }

    public void setAllowedEntity(EntityType entityType) {
        RegistryKeySet<EntityType> customSet = RegistrySet.keySet(
                RegistryKey.ENTITY_TYPE,
                TypedKey.create(RegistryKey.ENTITY_TYPE, entityType.getKey())
        );;
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

    public void onEquip(LivingEntity entity){}

    public EquipmentSlot getSlot() {
        return slot;
    }

    @Override
    public ItemStack createStack() {
        ItemStack stack = super.createStack().clone();
        ItemMeta meta = stack.getItemMeta();

        if (meta == null) {
            return stack;
        }

        // Handle Max Durability Component via Damageable Meta interface
        if (meta instanceof Damageable damageable) {
            // If it natively supports damage (Sword, Elytra, etc.)
            damageable.setMaxDamage(super.getMaxDurability());
        } else {
            // For non-damageable items (e.g., Paper, Gold Nugget, Stick),
            stack.setData(io.papermc.paper.datacomponent.DataComponentTypes.MAX_DAMAGE, super.getMaxDurability());

            // Refresh meta
            meta = stack.getItemMeta();
        }

        // Anvil Repair Ingredients
        if (super.getRepairMaterial() != null) {
            stack.isRepairableBy(super.getRepairMaterial());
        }

        Equippable.Builder builder = Equippable.equippable(slot);

        // Handle Equippable Component
        if (builder != null) {
            builder.assetId(toKey(getEquipmentResourceLocation()));

            if (equipSound != null) {
                builder.equipSound(equipSound);
            }

            if (cameraOverlay != null) {
                builder.cameraOverlay(toKey(cameraOverlay));
            }

            if (allowedEntities != null) {
                builder.allowedEntities(allowedEntities);
            }

            builder.dispensable(dispensable);
            builder.swappable(swappable);
            builder.damageOnHurt(damageOnHurt);
            builder.equipOnInteract(equipOnInteract);
            builder.canBeSheared(canBeSheared);

            if (shearingSound != null) {
                builder.shearSound(shearingSound);
            }
        }

        stack.setItemMeta(meta);

        if(builder != null){
            stack.setData(DataComponentTypes.EQUIPPABLE, builder.build());
        }

        return stack;
    }
}