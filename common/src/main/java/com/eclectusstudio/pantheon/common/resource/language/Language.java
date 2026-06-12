package com.eclectusstudio.pantheon.common.resource.language;

import java.util.List;

public class Language {
    private Languages language;
    private List<TranslationResult> translations;

    public Language(Languages language){
        this.language = language;
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