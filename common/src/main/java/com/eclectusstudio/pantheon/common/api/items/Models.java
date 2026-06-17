package com.eclectusstudio.pantheon.common.api.items;

public final class Models {

    private Models() {}

    public static SimpleItemBuilder generated() {
        return new SimpleItemBuilder(
                VanillaModelParent.GENERATED
        );
    }

    public static SimpleItemBuilder handheld() {
        return new SimpleItemBuilder(
                VanillaModelParent.HANDHELD
        );
    }

    public static SimpleItemBuilder handheldRod() {
        return new SimpleItemBuilder(
                VanillaModelParent.HANDHELD_ROD
        );
    }

    public static ItemModelBuilder model() {
        return new ItemModelBuilder();
    }
}