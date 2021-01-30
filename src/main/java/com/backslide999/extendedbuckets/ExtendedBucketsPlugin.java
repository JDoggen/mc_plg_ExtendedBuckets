package com.backslide999.extendedbuckets;

import com.backslide999.extendedbuckets.commands.executors.ExtendedBucketsListener;
import com.backslide999.extendedbuckets.events.onBucketFill;
import com.backslide999.extendedbuckets.handlers.BucketHandler;
import com.backslide999.library.BasePlugin;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.MemorySection;
import org.bukkit.configuration.file.FileConfigurationOptions;

import java.util.List;
import java.util.logging.Logger;

public class ExtendedBucketsPlugin extends BasePlugin {

    private static ExtendedBucketsPlugin instance;
    public static ExtendedBucketsPlugin getInstance(){
        return instance;
    }
    public final Logger logger = Logger.getLogger("Minecraft");

    @Override
    public void onEnable() {
        instance = this;

        // Read config file
        this.logInfo("Reading Config file");
        this.reload();

        // Register Commands
        this.logInfo("Registering Commands");
        this.getCommand("ExtendedBuckets").setExecutor(new ExtendedBucketsListener());

        // Register Events
        this.logInfo("Registering Events");
        this.getServer().getPluginManager().registerEvents(new onBucketFill(), this);

    }

    public ConfigurationSection getConfigurationSection(String path){
        return getConfig().getConfigurationSection(path);
    }

    public void reload(){
        this.reload(null);
    }
    public void reload(CommandSender sender) {
        this.reloadConfig();
        FileConfigurationOptions config = getConfig().options().copyDefaults(true);
        saveConfig();
        Constants.reload(sender);
        BucketHandler.getInstance().loadRecipes();
    }

    public void logError(Object error){
        logger.severe("[" + this.getClass() + "]"  + error.toString());
    }
}
