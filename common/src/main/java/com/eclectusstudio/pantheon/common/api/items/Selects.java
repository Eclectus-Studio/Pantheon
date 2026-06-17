package com.eclectusstudio.pantheon.common.api.items;

import com.eclectusstudio.pantheon.common.resource.items.node.ItemModelNode;
import com.eclectusstudio.pantheon.common.resource.items.node.SelectNode;

import java.util.Arrays;

public final class Selects {

    private Selects() {}

    public static SelectNode.Case when(
            Object value,
            ItemModelNode model
    ) {
        return new SelectNode.Case(
                value,
                model
        );
    }

    public static SelectNode select(
            String property,
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