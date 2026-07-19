package com.eclectusstudio.pantheon.common.data.damagetype;

import com.eclectusstudio.pantheon.common.ResourceLocation;

public class DamageType {
    private ResourceLocation location;
    private String deathMessage;
    private float exhaustion;
    private DamageScaling scaling;
    private DamageEffect effect;
    private DeathMessageType deathMessageType;

    public DamageType(ResourceLocation location, String deathMessage, float exhaustion, DamageScaling scaling, DamageEffect effect, DeathMessageType deathMessageType){
        this.location = location;
        this.deathMessage = deathMessage;
        this.exhaustion = exhaustion;
        this.scaling = scaling;
        this.effect = effect;
        this.deathMessageType = deathMessageType;
    }

    public ResourceLocation getLocation() {
        return location;
    }

    public String getDeathMessage() {
        return deathMessage;
    }

    public float getExhaustion() {
        return exhaustion;
    }

    public DamageScaling getScaling() {
        return scaling;
    }

    public DamageEffect getEffect() {
        return effect;
    }

    public DeathMessageType getDeathMessageType() {
        return deathMessageType;
    }
}
