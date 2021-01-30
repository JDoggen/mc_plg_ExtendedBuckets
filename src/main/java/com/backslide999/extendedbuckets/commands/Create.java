package com.backslide999.extendedbuckets.commands;

import com.backslide999.extendedbuckets.ExtendedBucketsPlugin;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Create {

    public Create(Player sender, String bucketTypeInput, String amountInput){
        try{
            int amount = Integer.parseInt(amountInput.trim());
            Material bucket = Material.BUCKET;
            ItemStack bucketStack = new ItemStack(bucket, amount);
            ItemMeta meta = bucketStack.getItemMeta();
            List<String> lore = new ArrayList<>();
            lore.add("Charges: 0");
            meta.setLore(lore);
            bucketStack.setItemMeta(meta);
            sender.getInventory().addItem(bucketStack);
        } catch(Exception e) {
            ExtendedBucketsPlugin.getInstance().sendPlayerDefaultWarning(sender, "reload_error");
        }
    }
}
