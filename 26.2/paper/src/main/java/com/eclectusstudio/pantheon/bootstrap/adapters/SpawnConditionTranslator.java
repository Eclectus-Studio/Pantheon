package com.eclectusstudio.pantheon.bootstrap.adapters;

import com.eclectusstudio.pantheon.common.data_common.mob_variant.spawn_condition.BiomeCondition;
import com.eclectusstudio.pantheon.common.data_common.mob_variant.spawn_condition.Condition;
import com.eclectusstudio.pantheon.common.data_common.mob_variant.spawn_condition.ConditionTarget;
import com.eclectusstudio.pantheon.common.data_common.mob_variant.spawn_condition.MoonBrightnessCondition;
import com.eclectusstudio.pantheon.common.data_common.mob_variant.spawn_condition.SpawnCondition;
import com.eclectusstudio.pantheon.common.data_common.mob_variant.spawn_condition.StructureCondition;
import io.papermc.paper.registry.data.util.Conversions;
import net.minecraft.advancements.predicates.MinMaxBounds;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceKey;
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
            SpawnCondition pantheonEntry, Conversions conversions
    ) {
        Condition condition = pantheonEntry.getCondition();

        if (condition == null) {
            return PriorityProvider.alwaysTrue(pantheonEntry.getPriority());
        }

        net.minecraft.world.entity.variant.SpawnCondition nmsCondition = toNmsCondition(condition, conversions);
        return PriorityProvider.single(nmsCondition, pantheonEntry.getPriority());
    }

    private static net.minecraft.world.entity.variant.SpawnCondition toNmsCondition(Condition condition, Conversions conversions) {
        return switch (condition.getType()) {
            case "biome" -> toBiomeCheck((BiomeCondition) condition, conversions);
            case "structure" -> toStructureCheck((StructureCondition) condition, conversions);
            case "moon_brightness" -> toMoonBrightnessCheck((MoonBrightnessCondition) condition);
            default -> throw new IllegalArgumentException("Unknown spawn condition type: " + condition.getType());
        };
    }

    private static BiomeCheck toBiomeCheck(BiomeCondition condition, Conversions conversions) {
        return new BiomeCheck(toHolderSet(condition.getBiomes(), Registries.BIOME, conversions));
    }

    private static StructureCheck toStructureCheck(StructureCondition condition, Conversions conversions) {
        return new StructureCheck(toHolderSet(condition.getStructures(), Registries.STRUCTURE, conversions));
    }

    private static MoonBrightnessCheck toMoonBrightnessCheck(MoonBrightnessCondition condition) {
        return new MoonBrightnessCheck(MinMaxBounds.Doubles.between(condition.getMin(), condition.getMax()));
    }

    private static <T> HolderSet<T> toHolderSet(
            List<ConditionTarget> targets, ResourceKey<Registry<T>> registryKey, Conversions conversions
    ) {
        if (targets.isEmpty()) {
            throw new IllegalArgumentException("Condition target list is empty");
        }

        RegistryOps.RegistryInfoLookup lookup = conversions.lookup();
        RegistryOps.RegistryInfo<T> info = lookup.<T>lookup(registryKey)
                .orElseThrow(() -> new IllegalStateException("No registry info available for " + registryKey));
        HolderGetter<T> getter = info.getter();

        if (targets.get(0).isTag()) {
            TagKey<T> tagKey = TagKey.create(registryKey, toMcIdentifier(targets.get(0).location()));
            return getter.getOrThrow(tagKey);
        }

        List<Holder<T>> holders = targets.stream()
                .map(t -> (Holder<T>) getter.getOrThrow(ResourceKey.create(registryKey, toMcIdentifier(t.location()))))
                .collect(Collectors.toList());

        return HolderSet.direct(holders);
    }

    private static Identifier toMcIdentifier(com.eclectusstudio.pantheon.common.ResourceLocation loc) {
        return Identifier.fromNamespaceAndPath(loc.getNamespace(), loc.getPath());
    }
}