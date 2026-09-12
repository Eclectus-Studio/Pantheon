package com.eclectusstudio.pantheon.common.resource.regioncompliance;

import com.eclectusstudio.pantheon.common.ResourceLocation;

import java.util.Locale;

public class RegionComplianceWarning {

    private final ResourceLocation resourceLocation;
    private final String region;

    private Integer delay;
    private int period;
    private String title;
    private String message;

    public RegionComplianceWarning(
            ResourceLocation resourceLocation,
            Locale locale,
            int period,
            String title,
            String message
    ) {
        this.resourceLocation = resourceLocation;
        this.region = locale.getISO3Country();
        this.period = period;
        this.title = title;
        this.message = message;
    }

    public RegionComplianceWarning(
            ResourceLocation resourceLocation,
            Locale locale,
            int delay,
            int period,
            String title,
            String message
    ) {
        this.resourceLocation = resourceLocation;
        this.region = locale.getISO3Country();
        this.delay = delay;
        this.period = period;
        this.title = title;
        this.message = message;
    }

    public ResourceLocation getResourceLocation() {
        return resourceLocation;
    }

    public String getRegion() {
        return region;
    }

    public Integer getDelay() {
        return delay;
    }

    public int getPeriod() {
        return period;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }
}
