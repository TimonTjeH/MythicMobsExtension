package MythicMobsSpawnerCommand.SpawnerCore;

import Main.Main;
import MythicMobsSpawnerCommand.SpawnerCommands;
import io.lumine.xikage.mythicmobs.spawning.spawners.MythicSpawner;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Cooldown implements SpawnerCommands {

    @Override
    public void voerCommandUit(Player p, Main m, ArrayList<MythicSpawner> spawners, String[] strings) {
        try {
            for (MythicSpawner spawner : spawners) {
                if (strings[1].equalsIgnoreCase(spawner.getName())) {
                    p.sendMessage(m.getPrefix() + "De cooldowntijd van " + spawner.getName() + " bedraagt nog " + spawner.getRemainingCooldownSeconds() + " seconde");
                } else {
                    p.sendMessage(m.getPrefix() + "Gebruik /spawner cooldown (spawner)");
                }
            }
        }catch (Exception e){
            p.sendMessage(m.getPrefix() + "Unable to send spawner information");
        }
    }
}
