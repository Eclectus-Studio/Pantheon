package com.eclectusstudio.pantheon.bootstrap;

import com.eclectusstudio.pantheon.bootstrap.adapters.CatVariantAdapter;
import io.papermc.paper.plugin.bootstrap.BootstrapContext;
import io.papermc.paper.plugin.bootstrap.PluginBootstrap;
import io.papermc.paper.registry.RegistryKey;
import io.papermc.paper.registry.TypedKey;
import io.papermc.paper.registry.event.RegistryEvents;
import org.bukkit.entity.Cat;

import static com.eclectusstudio.pantheon.utils.LocationToNamespaceKey.toKey;

public class PantheonBootstrap implements PluginBootstrap {
    @Override
    public void bootstrap(BootstrapContext context) {
        var manager = context.getLifecycleManager();

        manager.registerEventHandler(RegistryEvents.CAT_VARIANT.compose().newHandler(event -> {
            for (var variant : DatapackSubmission.getDatapack().getCatVariants()) {
                TypedKey<Cat.Type> key = toTypedKey(variant.getLocation(), RegistryKey.CAT_VARIANT);
                event.registry().register(key, builder -> CatVariantAdapter.apply(variant, builder));
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