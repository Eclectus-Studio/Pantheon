package com.eclectusstudio.pantheon.common.resource.texts;

import com.eclectusstudio.pantheon.common.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class Credits {

    private final ResourceLocation location;

    private final List<Section> sections = new ArrayList<>();

    public Credits(ResourceLocation location) {
        this.location = location;
    }

    public Credits addSection(Section section) {
        sections.add(section);
        return this;
    }

    public ResourceLocation getLocation() {
        return location;
    }

    public List<Section> getSections() {
        return sections;
    }

    public static class Section {

        private final String section;
        private final List<Discipline> disciplines = new ArrayList<>();

        public Section(String section) {
            this.section = section;
        }

        public Section addDiscipline(Discipline discipline) {
            disciplines.add(discipline);
            return this;
        }

        public String getSection() {
            return section;
        }

        public List<Discipline> getDisciplines() {
            return disciplines;
        }
    }

    public static class Discipline {

        private final String discipline;
        private final List<Title> titles = new ArrayList<>();

        public Discipline(String discipline) {
            this.discipline = discipline;
        }

        public Discipline addTitle(Title title) {
            titles.add(title);
            return this;
        }

        public String getDiscipline() {
            return discipline;
        }

        public List<Title> getTitles() {
            return titles;
        }
    }

    public static class Title {

        private final String title;
        private final List<String> names = new ArrayList<>();

        public Title(String title) {
            this.title = title;
        }

        public Title addName(String name) {
            names.add(name);
            return this;
        }

        public Title addNames(String... names) {
            for (String name : names) {
                this.names.add(name);
            }

            return this;
        }

        public String getTitle() {
            return title;
        }

        public List<String> getNames() {
            return names;
        }
    }
}
