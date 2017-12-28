package mc.beeztem.plugins.funsiesv2.helpers;

import mc.beeztem.plugins.funsiesv2.FunsiesV2;
import org.bukkit.command.CommandSender;

public class CheckPerms {
    public static boolean checkPerms(CommandSender sender, String permission, Boolean send) {
        if (sender.hasPermission(permission)) {
            return true;
        } else {
            if (send) {
                sender.sendMessage(FunsiesV2.errorColor + FunsiesV2.permError);
            }
            return false;
        }
    }
}
