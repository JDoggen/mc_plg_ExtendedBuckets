package com.backslide999.extendedbuckets.containers;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ExtendedBucket {



    public static ExtendedBucket of(ItemStack itemStack){
        if(itemStack == null) return null;
        if(!isBucketType(itemStack.getType())) throw new RuntimeException("Material is not of type Bucket!");
        return null;
    }

    private static boolean isBucketType(Material material){
        switch(material){
            case BUCKET:
            case COD_BUCKET:
            case MILK_BUCKET:
            case LAVA_BUCKET:
            case PUFFERFISH_BUCKET:
            case SALMON_BUCKET:
            case TROPICAL_FISH_BUCKET:
            case WATER_BUCKET:
                return true;
            default:
                return false;
        }
    }
}
