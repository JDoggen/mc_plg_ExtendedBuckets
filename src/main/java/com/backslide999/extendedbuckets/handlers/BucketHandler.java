package com.backslide999.extendedbuckets.handlers;

import com.backslide999.extendedbuckets.ExtendedBucketsPlugin;
import com.backslide999.extendedbuckets.containers.ExtendedBucket;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BucketHandler {

    private static BucketHandler instance;

    private BucketHandler()
    { }

    synchronized public static BucketHandler getInstance()
    {
        if (instance == null)
        {
            instance = new BucketHandler();
        }
        return instance;
    }

    public void loadRecipes(){
        removeExisitingRecipes();

        ExtendedBucketsPlugin.getInstance().logWarning("Creating recipes");
        ConfigurationSection configSection = ExtendedBucketsPlugin.getInstance().getConfigurationSection("buckets");
        Set<String> buckets = configSection.getKeys(false);
        // TODO DO NOT RESET, INSTEAD KEEP TRACK OF ACTIVE RECIPES
        Bukkit.resetRecipes();
        for(String bucket : buckets) {
            try {
                ExtendedBucketsPlugin.getInstance().logWarning("com.backslide999.extendedbuckets.items." + bucket.toLowerCase());
                NamespacedKey key = new NamespacedKey(ExtendedBucketsPlugin.getInstance(),"com.backslide999.extendedbuckets.items." + bucket.toLowerCase());
                Material material = Material.BUCKET;
                ItemStack result = new ItemStack(material, 1);
                ItemMeta meta = result.getItemMeta();
                List<String> lore = new java.util.ArrayList<>();
                lore.add(ChatColor.AQUA + bucket);
                meta.setLore(lore);
                result.setItemMeta(meta);
                ShapedRecipe recipe = new ShapedRecipe(key, result);
                recipe.shape("A.A", ".A.");
                recipe.setIngredient('A', new ItemStack(Material.IRON_BLOCK));
                Bukkit.addRecipe(recipe);
            } catch(IllegalArgumentException iae){
                ExtendedBucketsPlugin.getInstance().logError("Found illegal name [" + bucket + "] Should be of type [a-z0-9/._-]!");
            }
        }
    }

    private void removeExisitingRecipes(){
//        Iterator<Recipe> iterator = Bukkit.recipeIterator();
//        while(iterator.hasNext()){
//            Recipe recipe = iterator.next();
//            ItemStack result = recipe.getResult();
//            ItemMeta meta = result.getItemMeta();
//            result.addItemFlags("test");
//        }
    }
}
