package com.eclectusstudio.pantheon.common.api.items;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.common.resource.items.node.*;
import com.eclectusstudio.pantheon.common.resource.items.tints.TintSource;

import java.util.Arrays;

public final class Nodes {

    private Nodes() {}

    public static EmptyNode empty() {
        return new EmptyNode();
    }

    public static ModelNode model(
            ResourceLocation model
    ) {
        return new ModelNode(model);
    }

    public static ModelNode model(
            ResourceLocation model,
            TintSource... tints
    ) {
        return new ModelNode(
                model,
                Arrays.asList(tints)
        );
    }

    public static CompositeNode composite(
            ItemModelNode... nodes
    ) {
        return new CompositeNode(
                Arrays.asList(nodes)
        );
    }

    public static ConditionNode condition(
            String property,
            ItemModelNode onTrue,
            ItemModelNode onFalse
    ) {
        return new ConditionNode(
                property,
                onTrue,
                onFalse
        );
    }
}