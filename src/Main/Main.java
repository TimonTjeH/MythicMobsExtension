package Main;

import MythicMobsSpawnerCommand.Files.Messages;
import MythicMobsSpawnerCommand.SpawnerCommand;
import io.lumine.xikage.mythicmobs.MythicMobs;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {

    private MythicMobs core;
    private String prefixConfigName = "prefix";
    private String groupMythicSpawnerName = "Group Mythic Mobs";
    private Messages m;

    @Override
    public void onEnable() {
        core = MythicMobs.inst();
        getLogger().info("Extension has been enabled");
        loadConfig();
        loadCommands();
        m = new Messages(this);
    }

    @Override
    public void onDisable() {
        getLogger().info("Extension has been disabled");
    }

    private void loadCommands(){
        getCommand("spawner").setExecutor(new SpawnerCommand(this, core));
        getCommand("MythicMobsExtension").setExecutor(new CoreCommand(this));
    }

    private void loadConfig(){
        getConfig().options().copyDefaults(true);

        saveDefaultConfig();
    }



    public FileConfiguration getMessagesYml(){
        return m.getMessages();
    }

    public String getGroupMythicSpawner() {
        return (String) getConfig().get(groupMythicSpawnerName);
    }

    public String getPrefix() {
        return ChatColor.translateAlternateColorCodes('&', (String)  getConfig().get(prefixConfigName));
    }
}
