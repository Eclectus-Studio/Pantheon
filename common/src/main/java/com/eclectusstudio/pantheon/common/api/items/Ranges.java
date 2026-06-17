package com.eclectusstudio.pantheon.common.api.items;

import com.eclectusstudio.pantheon.common.resource.items.node.ItemModelNode;
import com.eclectusstudio.pantheon.common.resource.items.node.RangeDispatchNode;

import java.util.Arrays;

public final class Ranges {

    private Ranges() {}

    public static RangeDispatchNode.Entry entry(
            float threshold,
            ItemModelNode node
    ) {
        return new RangeDispatchNode.Entry(
                threshold,
                node
        );
    }

    public static RangeDispatchNode range(
            String property,
            RangeDispatchNode.Entry... entries
    ) {
        return new RangeDispatchNode(
                property,
                Arrays.asList(entries)
        );
    }
}