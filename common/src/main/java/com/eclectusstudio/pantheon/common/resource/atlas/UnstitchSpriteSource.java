package com.eclectusstudio.pantheon.common.resource.atlas;

import com.eclectusstudio.pantheon.common.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class UnstitchSpriteSource implements SpriteSource {

    private final ResourceLocation resource;
    private final double divisorX;
    private final double divisorY;
    private final List<Region> regions = new ArrayList<>();

    public UnstitchSpriteSource(
            ResourceLocation resource,
            double divisorX,
            double divisorY
    ) {
        this.resource = resource;
        this.divisorX = divisorX;
        this.divisorY = divisorY;
    }

    public UnstitchSpriteSource addRegion(
            Region region
    ) {
        regions.add(region);

        return this;
    }

    @Override
    public String getType() {
        return "minecraft:unstitch";
    }

    public ResourceLocation getResource() {
        return resource;
    }

    public double getDivisorX() {
        return divisorX;
    }

    public double getDivisorY() {
        return divisorY;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public static class Region {

        private final ResourceLocation sprite;
        private final double x;
        private final double y;
        private final double width;
        private final double height;

        public Region(
                ResourceLocation sprite,
                double x,
                double y,
                double width,
                double height
        ) {
            this.sprite = sprite;
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        public ResourceLocation getSprite() {
            return sprite;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public double getWidth() {
            return width;
        }

        public double getHeight() {
            return height;
        }
    }
}
