package mc.beeztem.plugins.funsiesv2.commands;

import mc.beeztem.plugins.funsiesv2.FunsiesV2;
import mc.beeztem.plugins.funsiesv2.helpers.CheckPerms;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearServer implements CommandExecutor {
    public static String requiredPermission = "funsies.clearserver";
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Boolean console;
        if (!CheckPerms.checkPerms(sender, requiredPermission, true)) {
            return true;
        }
        console = !(sender instanceof Player);
        if (console) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                p.kickPlayer(FunsiesV2.succeedColor + "Server Clear - Triggered By: " + ChatColor.GOLD + ChatColor.BOLD + sender.getName());
            }
            Bukkit.getServer().shutdown();
        } else {
            for (Player p : Bukkit.getOnlinePlayers()) {
                if (CheckPerms.checkPerms(p, requiredPermission, false)) {
                    p.sendMessage(FunsiesV2.succeedColor + "Not kicking you due to Server Clear as you have the clearserver permission");
                    p.sendMessage(FunsiesV2.succeedColor + "The Server Clear was triggered by: " + ChatColor.GOLD + ChatColor.BOLD + sender.getName());
                } else {
                    p.kickPlayer(FunsiesV2.succeedColor + "Server Clear - Triggered By: " + ChatColor.GOLD + ChatColor.BOLD + sender.getName());
                }
            }
        }
        return true;
    }
}
