package mc.beeztem.plugins.funsiesv2;

import mc.beeztem.plugins.funsiesv2.commands.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class FunsiesV2 extends JavaPlugin {

    //Misc
    public static String prefix = "[FunsiesV2] ";
    public static String adminPrefix = ChatColor.RED + "[ADMIN ONLY]: ";

    //Colors
    public static ChatColor errorColor = ChatColor.RED;
    public static ChatColor succeedColor = ChatColor.GREEN;

    //Error Messages
    public static String permError = "Invalid Permissions";
    public static String personErrorSpec = "Please specify a player.";
    public static String personErrorNF = "Player not found.";
    public static String noMessageError = "Please specify a message";
    public static String noOptionError = "Please specify an option";

    //Success Messages
    public static String fakeopsucceed = "Player successfully fake opped!";
    public static String fakedeopsucceed = "Player successfully fake deopped!";

    @Override
    public void onEnable() {
        Bukkit.getLogger().info(prefix + "FunsiesV2 Enabled");
        ////Config Stuff - Just in case
        getConfig().options().copyDefaults(true);
        saveConfig();



        ////Trolling Commands
        //FakeOp Command
        FakeOp fakeOp = new FakeOp();
        getCommand("fakeop").setExecutor(fakeOp);

        //FakeDeOp Command
        FakeDeop fakeDeop = new FakeDeop();
        getCommand("fakedeop").setExecutor(fakeDeop);

        ///Fake Commands
        FakeCommands fakeCommands = new FakeCommands();
        getCommand("fake").setExecutor(fakeCommands);

        ////Moderation Commands
        //AdminChat Command
        AdminChat adminChat = new AdminChat();
        getCommand("adminchat").setExecutor(adminChat);

        //ClearServer Command
        ClearServer clearServer = new ClearServer();
        getCommand("clearserver").setExecutor(clearServer);

    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info(prefix + "FunsiesV2 Disabled");
    }
}
