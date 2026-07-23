package com.eclectusstudio.pantheon.common;

import com.eclectusstudio.pantheon.common.pack.*;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public final class PackMCMeta {

    private String description;

    private Float packFormat;
    private FormatRange supportedFormats;

    private final List<String> features = new ArrayList<>();
    private final List<FilterRule> filters = new ArrayList<>();
    private final List<OverlayEntry> overlays = new ArrayList<>();
    private final Map<String, LanguageDefinition> languages = new LinkedHashMap<>();

    private PackMCMeta() {}

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {

        private final PackMCMeta meta = new PackMCMeta();

        public Builder description(String description) {
            meta.description = description;
            return this;
        }

        public Builder packFormat(float format) {
            meta.packFormat = format;
            return this;
        }

        public Builder supports(float minFormat, float maxFormat) {
            meta.supportedFormats = new FormatInterval(
                    minFormat,
                    maxFormat
            );
            return this;
        }

        public Builder addFeature(String featureFlag) {
            meta.features.add(featureFlag);
            return this;
        }

        public Builder addFilter(String namespaceRegex, String pathRegex) {
            meta.filters.add(
                    new FilterRule(
                            namespaceRegex,
                            pathRegex
                    )
            );
            return this;
        }

        public Builder addOverlay(
                String directory,
                int minFormat,
                int maxFormat
        ) {
            meta.overlays.add(
                    new OverlayEntry(
                            directory,
                            new FormatInterval(
                                    minFormat,
                                    maxFormat
                            )
                    )
            );

            return this;
        }

        public Builder addLanguage(
                String code,
                String name,
                String region,
                boolean bidirectional
        ) {
            meta.languages.put(
                    code,
                    new LanguageDefinition(
                            name,
                            region,
                            bidirectional
                    )
            );

            return this;
        }

        public PackMCMeta build() {
            return meta;
        }
    }

    public String getDescription() {
        return description;
    }

    public Float getPackFormat() {
        return packFormat;
    }

    public FormatRange getSupportedFormats() {
        return supportedFormats;
    }

    public List<String> getFeatures() {
        return Collections.unmodifiableList(features);
    }

    public List<FilterRule> getFilters() {
        return Collections.unmodifiableList(filters);
    }

    public List<OverlayEntry> getOverlays() {
        return Collections.unmodifiableList(overlays);
    }

    public Map<String, LanguageDefinition> getLanguages() {
        return Collections.unmodifiableMap(languages);
    }
}