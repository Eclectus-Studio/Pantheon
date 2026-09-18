package com.eclectusstudio.pantheon.commands;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.item.Item;
import com.eclectusstudio.pantheon.registry.ItemRegistry;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.tree.LiteralCommandNode;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;

public class GetCustomItemCommand {

    public static LiteralCommandNode<CommandSourceStack> create() {
        return Commands.literal("getitem")
                .then(
                        Commands.argument("id", StringArgumentType.string())
                                .suggests((context, builder) -> {
                                    String current = builder.getRemainingLowerCase();

                                    ItemRegistry.getItems().stream()
                                            .map(item -> item.getId().toString())
                                            .filter(id -> id.toLowerCase().startsWith(current))
                                            .forEach(builder::suggest);

                                    return builder.buildFuture();
                                })
                                .executes(context -> {
                                    if (!(context.getSource().getSender() instanceof Player player)) {
                                        context.getSource().getSender().sendMessage(
                                                Component.text("Players only.")
                                        );
                                        return 0;
                                    }

                                    String id = StringArgumentType.getString(
                                            context,
                                            "id"
                                    );

                                    Item item = ItemRegistry.get(
                                            ResourceLocation.fromString(id)
                                    );

                                    if (item == null) {
                                        player.sendMessage(
                                                Component.text("Unknown item.")
                                        );
                                        return 0;
                                    }

                                    player.getInventory().addItem(
                                            item.createStack()
                                    );

                                    player.sendMessage(
                                            Component.text(
                                                    "Given " + item.getId()
                                            )
                                    );

                                    return 1;
                                })
                )
                .build();
    }
}
