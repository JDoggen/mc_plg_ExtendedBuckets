package com.backslide999.extendedbuckets.commands;

import com.backslide999.extendedbuckets.ExtendedBucketsPlugin;
import org.bukkit.command.CommandSender;

import java.util.List;

public class Help {

    public Help(CommandSender sender){
        List<String> help = ExtendedBucketsPlugin.getInstance().fetchConfigStringList("messages.help");
        ExtendedBucketsPlugin.getInstance().sendPlayerInfo(sender, help);
    }
}
