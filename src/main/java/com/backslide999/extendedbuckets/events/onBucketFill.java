package com.backslide999.extendedbuckets.events;

import com.backslide999.extendedbuckets.ExtendedBucketsPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class onBucketFill implements Listener {


    @EventHandler
    public void onBlockBreak(PlayerBucketFillEvent event) {
        ExtendedBucketsPlugin.getInstance().sendPlayerInfo(event.getPlayer(), event.getBucket());
        ExtendedBucketsPlugin.getInstance().sendPlayerInfo(event.getPlayer(), event.getEventName());
        ExtendedBucketsPlugin.getInstance().sendPlayerInfo(event.getPlayer(), event.getBlock());
        ExtendedBucketsPlugin.getInstance().sendPlayerInfo(event.getPlayer(), event.getBlockClicked());
    }
}
