package mc.beeztem.plugins.funsiesv2.commands;

import mc.beeztem.plugins.funsiesv2.FunsiesV2;
import mc.beeztem.plugins.funsiesv2.helpers.CheckPerms;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class AdminChat implements CommandExecutor{

    public static String requiredPermission = "funsies.adminchat";

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!CheckPerms.checkPerms(sender, requiredPermission, true)) {
            return true;
        }

        if (args.length == 0) {
            sender.sendMessage(FunsiesV2.errorColor + FunsiesV2.noMessageError);
            return false;
        }

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            str.append(args[i] + " ");
        }
        String msg = str.toString();
        Bukkit.getLogger().info("[ADMIN ONLY]: " + sender.getName() + " : " + msg);
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (p.hasPermission("funsies.adminchat")) {
                p.sendMessage(FunsiesV2.adminPrefix + ChatColor.GOLD + ChatColor.BOLD + sender.getName() + ": " + ChatColor.RESET + msg);
                return true;
            }
        }

        return true;
    }
}
