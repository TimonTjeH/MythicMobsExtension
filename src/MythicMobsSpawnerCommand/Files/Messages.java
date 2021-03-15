package MythicMobsSpawnerCommand.Files;

import Main.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Messages {

    private File f;
    private FileConfiguration config;
    private Main m;

    public Messages(Main m) {

        if(m.getDataFolder().exists()){
            m.getDataFolder().mkdir();
        }
        this.m = m;
        f = new File(m.getDataFolder(), "messages.yml");
        if(!f.exists()){
            try{
                f.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        config = YamlConfiguration.loadConfiguration(f);

        try{
            config.save(f);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public FileConfiguration getMessages() {
        return config;
    }
}
