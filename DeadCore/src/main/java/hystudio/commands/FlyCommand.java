package hystudio.commands;

import hystudio.deadcore;
import hystudio.utils.CC;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class FlyCommand implements CommandExecutor {

    private Plugin plugin;

    public FlyCommand(deadcore plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            CC.log("&c&l| &r&eEste comando no se puede ejecutar por medio de consola");
            return false;
        }
        FileConfiguration config = this.plugin.getConfig();
        Player p = (Player)sender;
        if (args.length == 0)
            if (p.hasPermission("deadcore.fly")) {
                if (p.getAllowFlight()) {
                    p.setAllowFlight(false);
                    String FlyOFF = "Config.Fly-Desactivado";
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString(FlyOFF)));
                } else if (!p.getAllowFlight()) {
                    p.setAllowFlight(true);
                    String FlyON = "Config.Fly-Activado";
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString(FlyON)));
                }
            } else {
                String NoPerms = "Config.Fly-SinPermisos";
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString(NoPerms)));
            }
        return true;
    }
}
