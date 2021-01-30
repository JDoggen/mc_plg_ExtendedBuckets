package com.backslide999.extendedbuckets.commands.executors;

import com.backslide999.extendedbuckets.ExtendedBucketsPlugin;
import com.backslide999.extendedbuckets.commands.Create;
import com.backslide999.extendedbuckets.commands.Help;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ExtendedBucketsListener implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = null;
        if(sender instanceof Player) {
            player = (Player) sender;
        }
        if(args.length == 3 && args[0].equalsIgnoreCase("create")){
            if (sender instanceof Player) {
                new Create(player, args[1], args[2]);
                return true;
            } else {
                ExtendedBucketsPlugin.getInstance().sendPlayerDefaultWarning(sender, "no_command_line");
            }
        }

        new Help(sender);
        return true;
    }
}
