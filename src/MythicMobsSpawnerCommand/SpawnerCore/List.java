package MythicMobsSpawnerCommand.SpawnerCore;

import Main.Main;
import MythicMobsSpawnerCommand.SpawnerCommands;
import io.lumine.xikage.mythicmobs.spawning.spawners.MythicSpawner;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class List implements SpawnerCommands {

    @Override
    public void voerCommandUit(Player p, Main m, ArrayList<MythicSpawner> spawners, String[] strings) {
        try {
            for(int i = 0; i < spawners.size(); i++){
                p.sendMessage(m.getPrefix() + (i + 1) + ". " + spawners.get(i).getName());
            }
        }catch (Exception e){
            p.sendMessage(m.getPrefix() + "Unable to send list");
        }
    }

}