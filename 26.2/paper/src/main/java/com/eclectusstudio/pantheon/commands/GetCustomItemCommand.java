package com.eclectusstudio.pantheon.commands;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.item.Item;
import com.eclectusstudio.pantheon.registry.ItemRegistry;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class GetCustomItemCommand implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(
            @NotNull CommandSender sender,
            @NotNull Command command,
            @NotNull String label,
            @NotNull String[] args
    ) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage("Players only.");
            return true;
        }

        if (args.length != 1) {
            player.sendMessage("/getitem <id>");
            return true;
        }

        Item item = ItemRegistry.get(
                ResourceLocation.fromString(args[0])
        );

        if (item == null) {
            player.sendMessage("Unknown item.");
            return true;
        }

        player.getInventory().addItem(
                item.createStack()
        );

        player.sendMessage("Given " + item.getId());

        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(
            @NotNull CommandSender sender,
            @NotNull Command command,
            @NotNull String alias,
            @NotNull String[] args
    ) {

        if (args.length == 1) {

            String current = args[0].toLowerCase();

            List<String> suggestions = new ArrayList<>();

            for (Item item : ItemRegistry.getItems()) {

                String id = item.getId().toString();

                if (id.toLowerCase().startsWith(current)) {
                    suggestions.add(id);
                }
            }

            return suggestions;
        }

        return List.of();
    }
}