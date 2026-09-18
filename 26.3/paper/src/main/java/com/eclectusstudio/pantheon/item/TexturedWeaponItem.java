package com.eclectusstudio.pantheon.item;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import static com.eclectusstudio.pantheon.utils.LocationToNamespaceKey.toKey;

import io.papermc.paper.datacomponent.DataComponentTypes;
import io.papermc.paper.registry.RegistryAccess;
import io.papermc.paper.registry.RegistryKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.damage.DamageType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public abstract class TexturedWeaponItem extends DurableTexturedItem {
    private DamageType damageType;

    private final double attackDamage;
    private final double attackSpeed;

    protected TexturedWeaponItem(
            ResourceLocation id,
            ItemStack itemStack,
            int maxDurability,
            ItemStack repairMaterial,
            DamageType damageType,
            double attackDamage,
            double attackSpeed
    ) {
        super(id, itemStack, maxDurability, repairMaterial);
        this.damageType = damageType;

        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
    }

    protected TexturedWeaponItem(
            ResourceLocation id,
            ItemStack itemStack,
            int maxDurability,
            ItemStack repairMaterial,
            ResourceLocation damageType,
            double attackDamage,
            double attackSpeed
    ) {
        super(id, itemStack, maxDurability, repairMaterial);
        this.damageType = RegistryAccess.registryAccess().getRegistry(RegistryKey.DAMAGE_TYPE).get(toKey(damageType));

        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
    }

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

    public DamageType getDamageType() {
        return damageType;
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

        if(damageType != null){
            itemStack.setData(DataComponentTypes.DAMAGE_TYPE, damageType);
        }

        return itemStack;
    }
}