package com.eclectusstudio.pantheon.commands;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.item.Item;
import com.eclectusstudio.pantheon.registry.ItemRegistry;
import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.List;

public class GetCustomItemCommand implements BasicCommand {

    @Override
    public void execute(CommandSourceStack source, String[] args) {

        if (!(source.getSender() instanceof Player player)) {
            source.getSender().sendMessage("Players only.");
            return;
        }

        if (args.length != 1) {
            player.sendMessage("/getitem <id>");
            return;
        }

        Item item = ItemRegistry.get(
                ResourceLocation.fromString(args[0])
        );

        if (item == null) {
            player.sendMessage("Unknown item.");
            return;
        }

        player.getInventory().addItem(item.createStack());

        player.sendMessage(
                Component.text("Given " + item.getId())
        );
    }

    @Override
    public Collection<String> suggest(
            CommandSourceStack source,
            String[] args
    ) {

        if (args.length != 1) {
            return List.of();
        }

        String current = args[0].toLowerCase();

        return ItemRegistry.getItems()
                .stream()
                .map(item -> item.getId().toString())
                .filter(id -> id.toLowerCase().startsWith(current))
                .toList();
    }
}