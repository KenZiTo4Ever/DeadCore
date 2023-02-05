package hystudio.commands;

import hystudio.deadcore;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class SetSpawn implements CommandExecutor {

    private deadcore plugin;

    public SetSpawn(deadcore plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command comando, String label, String[] args) {
        if (!(sender instanceof Player)) {
            dev.bopi.Utilidades.CC.log("&cEste comando no se puede ejecutar en consola");
            return false;
        }
        if (args.length == 0) {
            sender.sendMessage(dev.bopi.Utilidades.CC.translate("&4&lDEADCORE &8» &fEl uso correcto del comando es /set flyspawn"));
        } else if (args.length == 1 &&
                args[0].equalsIgnoreCase("flyspawn")) {
            Player player = (Player)sender;
            Location l = player.getLocation();
            double x = l.getX();
            double y = l.getY();
            double z = l.getZ();
            float yaw = l.getYaw();
            float pitch = l.getPitch();
            FileConfiguration config = this.plugin.getConfig();
            config.set("Location.Spawn.x", Double.valueOf(x));
            config.set("Location.Spawn.y", Double.valueOf(y));
            config.set("Location.Spawn.z", Double.valueOf(z));
            config.set("Location.Spawn.yaw", Float.valueOf(yaw));
            config.set("Location.Spawn.pitch", Float.valueOf(pitch));
            String world = l.getWorld().getName();
            config.set("Location.Spawn.world", world);
            this.plugin.saveConfig();
            sender.sendMessage(dev.bopi.Utilidades.CC.translate("&e&l| &fSpawn añadido correctamente!"));
        }
        return false;
    }
}
