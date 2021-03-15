package MythicMobsSpawnerCommand;

import Main.Main;
import MythicMobsSpawnerCommand.SpawnerCore.Cooldown;
import MythicMobsSpawnerCommand.SpawnerCore.Cooldowns;
import MythicMobsSpawnerCommand.SpawnerCore.List;
import io.lumine.xikage.mythicmobs.MythicMobs;
import io.lumine.xikage.mythicmobs.spawning.spawners.MythicSpawner;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class SpawnerCommand implements CommandExecutor  {

    private MythicMobs core;
    private ArrayList<MythicSpawner> spawners;
    private Main m;
    private List l;
    private Cooldowns cooldowns;
    private Cooldown cooldown;

    public SpawnerCommand(Main m , MythicMobs core) {
        this.core = core;
        this.m = m;
        cooldown = new Cooldown();
        cooldowns = new Cooldowns();
        l = new List();
    }


    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        Player p = (Player) commandSender;

        if(command.getName().equals("spawner")){

            if(strings.length == 1) {
                spawners = core.getSpawnerManager().getSpawnersByGroup(m.getGroupMythicSpawner());

                if(strings[0].equalsIgnoreCase("cooldowns")) {
                    cooldowns.voerCommandUit(p,m , spawners,strings);
                }
                else if(strings[0].equalsIgnoreCase("list")) {
                    l.voerCommandUit(p, m, spawners,strings);
                }
                else {
                    p.sendMessage(m.getPrefix() + m.getMessagesYml().getString("unknown-command"));
                }
            }

            else if(strings.length == 2) {
                if (strings[0].equalsIgnoreCase("cooldown")) {
                    cooldown.voerCommandUit(p,m, spawners, strings);
                }
                else {
                    p.sendMessage(m.getPrefix() + m.getMessagesYml().getString("unknown-command"));
                }
            } else {
                p.sendMessage(m.getPrefix() + m.getMessagesYml().getString("unknown-command"));
            }
        }


        return false;
    }
}
