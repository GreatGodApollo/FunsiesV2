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

public class FakeDeop implements CommandExecutor {

    public static String requiredPermission = "funsies.troll";
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!CheckPerms.checkPerms(sender, requiredPermission, true)) {
            return true;
        }
        if (args.length == 0) {
            sender.sendMessage(FunsiesV2.errorColor + FunsiesV2.personErrorSpec + "fake deop!");
            return false;
        }
        Player pl = Bukkit.getServer().getPlayer(args[0]);

        if (pl == null) {
            sender.sendMessage(FunsiesV2.errorColor + FunsiesV2.personErrorNF);
            return true;
        }

        pl.sendMessage(ChatColor.YELLOW + "You are no longer op!");
        sender.sendMessage(FunsiesV2.succeedColor + FunsiesV2.fakedeopsucceed);
        return true;
    }
}
