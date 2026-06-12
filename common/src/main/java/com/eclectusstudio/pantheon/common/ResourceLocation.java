package com.eclectusstudio.pantheon.common;

public class ResourceLocation {
    private String namespace;
    private String path;
    public ResourceLocation(String namespace, String path){
        this.namespace = namespace;
        this.path = path;
    }

    public String getNamespace() {
        return namespace;
    }

    public String getPath() {
        return path;
    }
}
