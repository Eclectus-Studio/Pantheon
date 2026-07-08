package com.eclectusstudio.pantheon.common.resource.fonts;

import java.util.ArrayList;
import java.util.List;

public class Font {

    private final List<FontProvider> providers = new ArrayList<>();

    public List<FontProvider> getProviders() {
        return providers;
    }

    public Font addProvider(FontProvider provider) {
        providers.add(provider);
        return this;
    }
}