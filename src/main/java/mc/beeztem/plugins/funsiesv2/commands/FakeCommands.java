package mc.beeztem.plugins.funsiesv2.commands;

import mc.beeztem.plugins.funsiesv2.FunsiesV2;
import mc.beeztem.plugins.funsiesv2.helpers.CheckPerms;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FakeCommands implements CommandExecutor{
    public static String requiredPermission = "funsies.troll";

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!CheckPerms.checkPerms(sender, requiredPermission, true)) {
            return true;
        }
        if (args.length == 0) {
            sender.sendMessage(FunsiesV2.errorColor + FunsiesV2.noOptionError);
            return false;
        }
        if (args.length == 1) {
            sender.sendMessage(FunsiesV2.errorColor + FunsiesV2.personErrorSpec);
            return false;
        }

        Player pl = Bukkit.getPlayer(args[1]);

        if (pl == null) {
            sender.sendMessage(FunsiesV2.errorColor + FunsiesV2.personErrorNF);
            return true;
        }
        switch (args[0]) {
                case "op":
                    pl.sendMessage(ChatColor.YELLOW + "You are now op!");
                    sender.sendMessage(FunsiesV2.succeedColor + FunsiesV2.fakeopsucceed);
                    break;
                case "deop":
                    pl.sendMessage(ChatColor.YELLOW + "You are no longer op!");
                    sender.sendMessage(FunsiesV2.succeedColor + FunsiesV2.fakedeopsucceed);
                    break;



        }
        return true;
    }
}
