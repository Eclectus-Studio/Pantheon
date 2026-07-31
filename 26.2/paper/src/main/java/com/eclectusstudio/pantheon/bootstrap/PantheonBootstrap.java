package com.eclectusstudio.pantheon.bootstrap;

import com.eclectusstudio.pantheon.bootstrap.adapters.damage.DamageTypeAdapter;
import com.eclectusstudio.pantheon.bootstrap.adapters.jukeboxsong.JukeboxSongAdapter;
import com.eclectusstudio.pantheon.bootstrap.adapters.painting.PaintingVariantAdapter;
import com.eclectusstudio.pantheon.bootstrap.adapters.variants.*;
import io.papermc.paper.plugin.bootstrap.BootstrapContext;
import io.papermc.paper.plugin.bootstrap.PluginBootstrap;
import io.papermc.paper.registry.RegistryKey;
import io.papermc.paper.registry.TypedKey;
import io.papermc.paper.registry.event.RegistryEvents;
import org.bukkit.entity.*;

import static com.eclectusstudio.pantheon.utils.LocationToNamespaceKey.toKey;

public class PantheonBootstrap implements PluginBootstrap {
    @Override
    public void bootstrap(BootstrapContext context) {
        var manager = context.getLifecycleManager();

        // Animal Variants
        manager.registerEventHandler(RegistryEvents.CAT_VARIANT.compose().newHandler(event -> {
            var conversions = ConversionsExtractor.from(event.registry());

            for (var variant : DatapackSubmission.getDatapack().getCatVariants()) {
                TypedKey<Cat.Type> key = toTypedKey(variant.getLocation(), RegistryKey.CAT_VARIANT);
                event.registry().register(key, builder -> CatVariantAdapter.apply(variant, builder, conversions));
            }
        }));

        manager.registerEventHandler(RegistryEvents.CHICKEN_VARIANT.compose().newHandler(event -> {
            var conversions = ConversionsExtractor.from(event.registry());

            for (var variant : DatapackSubmission.getDatapack().getChickenVariants()) {
                TypedKey<Chicken.Variant> key = toTypedKey(variant.getLocation(), RegistryKey.CHICKEN_VARIANT);
                event.registry().register(key, builder -> ChickenVariantAdapter.apply(variant, builder, conversions));
            }
        }));

        manager.registerEventHandler(RegistryEvents.COW_VARIANT.compose().newHandler(event -> {
            var conversions = ConversionsExtractor.from(event.registry());

            for (var variant : DatapackSubmission.getDatapack().getCowVariants()) {
                TypedKey<Cow.Variant> key = toTypedKey(variant.getLocation(), RegistryKey.COW_VARIANT);
                event.registry().register(key, builder -> CowVariantAdapter.apply(variant, builder, conversions));
            }
        }));

        manager.registerEventHandler(RegistryEvents.FROG_VARIANT.compose().newHandler(event -> {
            var conversions = ConversionsExtractor.from(event.registry());

            for (var variant : DatapackSubmission.getDatapack().getFrogVariants()) {
                TypedKey<Frog.Variant> key = toTypedKey(variant.getLocation(), RegistryKey.FROG_VARIANT);
                event.registry().register(key, builder -> FrogVariantAdapter.apply(variant, builder, conversions));
            }
        }));

        manager.registerEventHandler(RegistryEvents.PIG_VARIANT.compose().newHandler(event -> {
            var conversions = ConversionsExtractor.from(event.registry());

            for (var variant : DatapackSubmission.getDatapack().getPigVariants()) {
                TypedKey<Pig.Variant> key = toTypedKey(variant.getLocation(), RegistryKey.PIG_VARIANT);
                event.registry().register(key, builder -> PigVariantAdapter.apply(variant, builder, conversions));
            }
        }));

        manager.registerEventHandler(RegistryEvents.WOLF_VARIANT.compose().newHandler(event -> {
            var conversions = ConversionsExtractor.from(event.registry());

            for (var variant : DatapackSubmission.getDatapack().getWolfVariants()) {
                TypedKey<Wolf.Variant> key = toTypedKey(variant.getLocation(), RegistryKey.WOLF_VARIANT);
                event.registry().register(key, builder -> WolfVariantAdapter.apply(variant, builder, conversions));
            }
        }));

        manager.registerEventHandler(RegistryEvents.ZOMBIE_NAUTILUS_VARIANT.compose().newHandler(event -> {
            var conversions = ConversionsExtractor.from(event.registry());

            for (var variant : DatapackSubmission.getDatapack().getZombieNautilusVariants()) {
                TypedKey<ZombieNautilus.Variant> key = toTypedKey(variant.getLocation(), RegistryKey.ZOMBIE_NAUTILUS_VARIANT);
                event.registry().register(key, builder -> ZombieNautilusVariantAdapter.apply(variant, builder, conversions));
            }
        }));

        // Damage Types
        manager.registerEventHandler(RegistryEvents.DAMAGE_TYPE.compose().newHandler(event -> {
            for (var damageType : DatapackSubmission.getDatapack().getDamageTypes()) {
                TypedKey<org.bukkit.damage.DamageType> key = toTypedKey(damageType.getLocation(), RegistryKey.DAMAGE_TYPE);
                event.registry().register(key, builder -> DamageTypeAdapter.apply(damageType, builder));
            }
        }));

        // Paintings
        manager.registerEventHandler(RegistryEvents.PAINTING_VARIANT.compose().newHandler(event -> {
            for (var variant : DatapackSubmission.getDatapack().getPaintingVariants()) {
                TypedKey<org.bukkit.Art> key = toTypedKey(variant.getAssetID(), RegistryKey.PAINTING_VARIANT);
                event.registry().register(key, builder -> PaintingVariantAdapter.apply(variant, builder));
            }
        }));

        // Jukebox songs
        manager.registerEventHandler(RegistryEvents.JUKEBOX_SONG.compose().newHandler(event -> {
            for (var song : DatapackSubmission.getDatapack().getJukeboxSongs()) {
                TypedKey<org.bukkit.JukeboxSong> key = toTypedKey(song.getLocation(), RegistryKey.JUKEBOX_SONG);
                event.registry().register(key, builder -> JukeboxSongAdapter.apply(song, builder));
            }
        }));
    }

    public static <T> TypedKey<T> toTypedKey(
            com.eclectusstudio.pantheon.common.ResourceLocation location,
            RegistryKey<T> registryKey
    ) {
        return TypedKey.create(registryKey, toKey(location));
    }
}