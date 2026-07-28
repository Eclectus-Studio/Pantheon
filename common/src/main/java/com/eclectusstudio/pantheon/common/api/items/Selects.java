package com.eclectusstudio.pantheon.common.api.items;

import com.eclectusstudio.pantheon.common.resource.items.node.ItemModelNode;
import com.eclectusstudio.pantheon.common.resource.items.node.SelectNode;
import com.eclectusstudio.pantheon.common.resource.items.node.SelectProperty;

import java.util.Arrays;
import java.util.List;

public final class Selects {

    private Selects() {}

    public static SelectNode.Case when(
            String value,
            ItemModelNode model
    ) {
        return new SelectNode.Case(
                value,
                model
        );
    }

    public static SelectNode.Case when(
            List<String> values,
            ItemModelNode model
    ) {
        return new SelectNode.Case(
                values,
                model
        );
    }

    public static SelectNode.Case when(
            ItemModelNode model,
            String... values
    ) {
        return new SelectNode.Case(
                Arrays.asList(values),
                model
        );
    }

    public static SelectNode select(
            SelectProperty property,
            ItemModelNode fallback,
            SelectNode.Case... cases
    ) {
        return new SelectNode(
                property,
                Arrays.asList(cases),
                fallback
        );
    }
}