package com.eclectusstudio.pantheon.common.resource.language;

public class TranslationResult {
    private TranslationKey key;
    private String result;

    public TranslationResult(TranslationKey key, String result){
        this.key = key;
        this.result = result;
    }

    public TranslationKey getKey() {
        return key;
    }

    public String getResult() {
        return result;
    }
}
