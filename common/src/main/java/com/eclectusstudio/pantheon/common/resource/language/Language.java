package com.eclectusstudio.pantheon.common.resource.language;

import java.util.ArrayList;
import java.util.List;

public class Language {
    private final Languages language;
    private final List<TranslationResult> translations;

    public Language(Languages language){
        this.language = language;
        translations = new ArrayList<>();
    }

    public Languages getLanguage() {
        return language;
    }

    public List<TranslationResult> getTranslations() {
        return translations;
    }

    public void addTranslation(TranslationResult translationResult){
        this.translations.add(translationResult);
    }
}