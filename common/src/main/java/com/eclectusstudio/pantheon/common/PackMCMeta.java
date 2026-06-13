package com.eclectusstudio.pantheon.common;

import com.eclectusstudio.pantheon.common.pack.*;

import java.util.Map;

public final class PackMCMeta {

    private PackInfo pack;
    private Features features;
    private Filter filter;
    private Overlays overlays;
    private Map<String, LanguageDefinition> language;

    private PackMCMeta() {}

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {

        private final PackMCMeta meta = new PackMCMeta();

        public Builder pack(PackInfo pack) {
            meta.pack = pack;
            return this;
        }

        public Builder features(Features features) {
            meta.features = features;
            return this;
        }

        public Builder filter(Filter filter) {
            meta.filter = filter;
            return this;
        }

        public Builder overlays(Overlays overlays) {
            meta.overlays = overlays;
            return this;
        }

        public Builder language(Map<String, LanguageDefinition> language) {
            meta.language = language;
            return this;
        }

        public PackMCMeta build() {
            return meta;
        }
    }

    public PackInfo getPack() {
        return pack;
    }

    public Features getFeatures() {
        return features;
    }

    public Filter getFilter() {
        return filter;
    }

    public Overlays getOverlays() {
        return overlays;
    }

    public Map<String, LanguageDefinition> getLanguage() {
        return language;
    }
}