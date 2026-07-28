package com.eclectusstudio.pantheon.item;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import static com.eclectusstudio.pantheon.utils.LocationToNamespaceKey.toKey;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public abstract class TexturedWeaponItem extends DurableTexturedItem {

    private final double attackDamage;
    private final double attackSpeed;

    protected TexturedWeaponItem(
            ResourceLocation id,
            ItemStack itemStack,
            int maxDurability,
            ItemStack repairMaterial,
            double attackDamage,
            double attackSpeed
    ) {
        super(id, itemStack, maxDurability, repairMaterial);

        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
    }

    public double getAttackDamage() {
        return attackDamage;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    @Override
    public ItemStack createStack(){
        ItemStack itemStack = super.createStack().clone();

        ItemMeta meta = itemStack.getItemMeta();

        AttributeModifier attackDamageModifier = new AttributeModifier(
                toKey(new ResourceLocation(this.getId().getNamespace(), "damage_weapon")),
                attackDamage,
                AttributeModifier.Operation.ADD_NUMBER
        );

        AttributeModifier attackSpeedModifier = new AttributeModifier(
                toKey(new ResourceLocation(this.getId().getNamespace(), "weapon_speed")),
                attackSpeed,
                AttributeModifier.Operation.ADD_NUMBER
        );

        meta.addAttributeModifier(Attribute.ATTACK_DAMAGE, attackDamageModifier);
        meta.addAttributeModifier(Attribute.ATTACK_SPEED, attackSpeedModifier);

        itemStack.setItemMeta(meta);

        return itemStack;
    }
}