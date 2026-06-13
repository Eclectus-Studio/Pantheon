package com.eclectusstudio.pantheon.common;

public interface ResourceContributor {

    String namespace();

    void contribute(ResourcePackContext context);
}