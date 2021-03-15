package MythicMobsSpawnerCommand;

import Main.Main;
import io.lumine.xikage.mythicmobs.spawning.spawners.MythicSpawner;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public interface SpawnerCommands {

    void voerCommandUit(Player p, Main m, ArrayList<MythicSpawner> spawners, String[] strings);
}
