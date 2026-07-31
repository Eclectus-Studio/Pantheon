package com.eclectusstudio.pantheon.item.painting;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.common.data.painting_variant.PaintingVariant;
import com.eclectusstudio.pantheon.item.TexturedItem;
import io.papermc.paper.datacomponent.DataComponentTypes;
import io.papermc.paper.registry.RegistryAccess;
import io.papermc.paper.registry.RegistryKey;
import org.bukkit.Art;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import static com.eclectusstudio.pantheon.utils.LocationToNamespaceKey.toKey;

public class TexturedPaintingVariantItem extends TexturedItem {
    private final ResourceLocation paintingvariant;

    protected TexturedPaintingVariantItem(ResourceLocation id, ItemStack itemStack, PaintingVariant variant) {
        if(itemStack.getType() != Material.PAINTING){
            throw new IllegalArgumentException("Painting variants must be item type of painting");
        }

        super(id, itemStack);
        paintingvariant = variant.getAssetID();
    }

    protected TexturedPaintingVariantItem(ResourceLocation id, ItemStack itemStack, ResourceLocation variant) {
        super(id, itemStack);
        paintingvariant = variant;
    }

    public ResourceLocation getPaintingvariant() {
        return paintingvariant;
    }

    @Override
    public ItemStack createStack() {
        ItemStack stack = super.createStack();

        Art art = RegistryAccess.registryAccess().getRegistry(RegistryKey.PAINTING_VARIANT).get(toKey(paintingvariant));

        stack.setData(DataComponentTypes.PAINTING_VARIANT, art);

        return stack;
    }
}
