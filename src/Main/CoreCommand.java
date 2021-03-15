package Main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CoreCommand implements CommandExecutor {

    private Main m;

    public CoreCommand(Main m) {
        this.m = m;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        Player p = (Player) commandSender;

        if(command.getName().equals("MythicMobsExtension")){
            if(p.hasPermission("MythicMobsExtension.Admin")) {
                if (strings.length == 1) {
                    if (strings[0].equals("reload")) {
                        Bukkit.getPluginManager().disablePlugin(m);
                        Bukkit.getPluginManager().enablePlugin(m);
                        p.sendMessage(m.getPrefix() + "Plugin has been reloaded");
                    } else if (strings[0].equals("help")) {
                        p.sendMessage("     MythicMobExtension");
                        p.sendMessage("§c§l=-=-=-=-=-=-=-=-=-=-=");
                        p.sendMessage(m.getPrefix() + "/mme reload");
                        p.sendMessage(m.getPrefix() + "/spawner list");
                        p.sendMessage(m.getPrefix() + "/spawner cooldowns");
                        p.sendMessage(m.getPrefix() + "/spawner cooldown (spawner)");
                        p.sendMessage("§c§l=-=-=-=-=-=-=-=-=-=-=");
                    } else {
                        p.sendMessage(m.getPrefix() + "use /mme help");
                    }
                } else {
                    p.sendMessage(m.getPrefix() + "use /mme help");
                }
            }
        }
        return false;
    }
}
