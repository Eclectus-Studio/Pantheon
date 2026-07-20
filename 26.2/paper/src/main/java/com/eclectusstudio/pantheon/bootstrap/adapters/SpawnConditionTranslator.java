package com.eclectusstudio.pantheon.bootstrap.adapters;

import com.eclectusstudio.pantheon.common.data_common.mob_variant.spawn_condition.BiomeCondition;
import com.eclectusstudio.pantheon.common.data_common.mob_variant.spawn_condition.Condition;
import com.eclectusstudio.pantheon.common.data_common.mob_variant.spawn_condition.ConditionTarget;
import com.eclectusstudio.pantheon.common.data_common.mob_variant.spawn_condition.MoonBrightnessCondition;
import com.eclectusstudio.pantheon.common.data_common.mob_variant.spawn_condition.SpawnCondition;
import com.eclectusstudio.pantheon.common.data_common.mob_variant.spawn_condition.StructureCondition;
import net.minecraft.advancements.predicates.MinMaxBounds;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.variant.BiomeCheck;
import net.minecraft.world.entity.variant.MoonBrightnessCheck;
import net.minecraft.world.entity.variant.PriorityProvider;
import net.minecraft.world.entity.variant.SpawnContext;
import net.minecraft.world.entity.variant.StructureCheck;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.structure.Structure;

import java.util.List;
import java.util.stream.Collectors;

final class SpawnConditionTranslator {

    private SpawnConditionTranslator() {}

    static List<PriorityProvider.Selector<SpawnContext, net.minecraft.world.entity.variant.SpawnCondition>> toSelectors(
            SpawnCondition pantheonEntry
    ) {
        Condition condition = pantheonEntry.getCondition();

        if (condition == null) {
            return PriorityProvider.alwaysTrue(pantheonEntry.getPriority());
        }

        net.minecraft.world.entity.variant.SpawnCondition nmsCondition = toNmsCondition(condition);
        return PriorityProvider.single(nmsCondition, pantheonEntry.getPriority());
    }

    private static net.minecraft.world.entity.variant.SpawnCondition toNmsCondition(Condition condition) {
        return switch (condition.getType()) {
            case "biome" -> toBiomeCheck((BiomeCondition) condition);
            case "structure" -> toStructureCheck((StructureCondition) condition);
            case "moon_brightness" -> toMoonBrightnessCheck((MoonBrightnessCondition) condition);
            default -> throw new IllegalArgumentException("Unknown spawn condition type: " + condition.getType());
        };
    }

    private static BiomeCheck toBiomeCheck(BiomeCondition condition) {
        Registry<Biome> biomeRegistry = MinecraftServer.getServer().registryAccess().lookupOrThrow(Registries.BIOME);
        return new BiomeCheck(toHolderSet(condition.getBiomes(), biomeRegistry, Registries.BIOME));
    }

    private static StructureCheck toStructureCheck(StructureCondition condition) {
        Registry<Structure> structureRegistry = MinecraftServer.getServer().registryAccess().lookupOrThrow(Registries.STRUCTURE);
        return new StructureCheck(toHolderSet(condition.getStructures(), structureRegistry, Registries.STRUCTURE));
    }

    private static MoonBrightnessCheck toMoonBrightnessCheck(MoonBrightnessCondition condition) {
        return new MoonBrightnessCheck(MinMaxBounds.Doubles.between(condition.getMin(), condition.getMax()));
    }

    private static <T> HolderSet<T> toHolderSet(
            List<ConditionTarget> targets,
            Registry<T> registry,
            ResourceKey<Registry<T>> registryKey
    ) {
        // Assumes all targets are the same kind (all tags, or all direct IDs) — vanilla's own
        // `biomes`/`structures` field also only supports one or the other per condition, not a mix.
        if (targets.isEmpty()) {
            throw new IllegalArgumentException("Condition target list is empty");
        }

        if (targets.get(0).isTag()) {
            ConditionTarget tagTarget = targets.get(0);
            TagKey<T> tagKey = TagKey.create(registryKey, toMcIdentifier(tagTarget.location()));

            return registry.get(tagKey) // Optional<HolderSet.Named<T>>
                    .<HolderSet<T>>map(named -> named)
                    .orElseThrow(() -> new IllegalArgumentException("Unknown tag: " + tagKey));
        }

        List<Holder<T>> holders = targets.stream()
                .map(t -> {
                    ResourceKey<T> key = ResourceKey.create(registryKey, toMcIdentifier(t.location()));
                    return registry.get(key) // Optional<Holder.Reference<T>>
                            .<Holder<T>>map(h -> h)
                            .orElseThrow(() -> new IllegalArgumentException("Unknown entry: " + key));
                })
                .collect(Collectors.toList());

        return HolderSet.direct(holders);
    }

    private static Identifier toMcIdentifier(com.eclectusstudio.pantheon.common.ResourceLocation loc) {
        return Identifier.fromNamespaceAndPath(loc.getNamespace(), loc.getPath());
    }
}