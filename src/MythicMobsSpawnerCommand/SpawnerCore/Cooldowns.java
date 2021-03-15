package MythicMobsSpawnerCommand.SpawnerCore;

import Main.Main;
import MythicMobsSpawnerCommand.SpawnerCommands;
import io.lumine.xikage.mythicmobs.spawning.spawners.MythicSpawner;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Cooldowns implements SpawnerCommands {

    @Override
    public void voerCommandUit(Player p, Main m, ArrayList<MythicSpawner> spawners, String[] strings) {
        try {
            if (spawners.size() == 0) {
                p.sendMessage(m.getPrefix() + "Nog geen spawners in de group: " + m.getGroupMythicSpawner());
            }
            for (MythicSpawner spawner : spawners) {
                p.sendMessage(m.getPrefix() + "De cooldowntijd van " + spawner.getName() + " bedraagt nog " + spawner.getRemainingCooldownSeconds() + " seconde");
            }

        } catch (Exception e) {
            p.sendMessage(m.getPrefix() + "Unable to send spawner cooldown");
        }
    }
}
