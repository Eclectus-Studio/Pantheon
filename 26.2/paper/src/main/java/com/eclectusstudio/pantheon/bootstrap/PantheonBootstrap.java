package com.eclectusstudio.pantheon.bootstrap;

import com.eclectusstudio.pantheon.bootstrap.adapters.CatVariantAdapter;
import com.eclectusstudio.pantheon.bootstrap.adapters.ChickenVariantAdapter;
import com.eclectusstudio.pantheon.bootstrap.adapters.ConversionsExtractor;
import com.eclectusstudio.pantheon.bootstrap.adapters.CowVariantAdapter;
import io.papermc.paper.plugin.bootstrap.BootstrapContext;
import io.papermc.paper.plugin.bootstrap.PluginBootstrap;
import io.papermc.paper.registry.RegistryKey;
import io.papermc.paper.registry.TypedKey;
import io.papermc.paper.registry.event.RegistryEvents;
import org.bukkit.entity.Cat;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cow;

import static com.eclectusstudio.pantheon.utils.LocationToNamespaceKey.toKey;

public class PantheonBootstrap implements PluginBootstrap {
    @Override
    public void bootstrap(BootstrapContext context) {
        var manager = context.getLifecycleManager();

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
    }

    public static <T> TypedKey<T> toTypedKey(
            com.eclectusstudio.pantheon.common.ResourceLocation location,
            RegistryKey<T> registryKey
    ) {
        return TypedKey.create(registryKey, toKey(location));
    }
}