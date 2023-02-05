package hystudio.gamemode;

import hystudio.deadcore;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class GamemodeCommand implements CommandExecutor {

    private Plugin plugin;

    public GamemodeCommand(deadcore plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (args.length < 1) {
            player.sendMessage(CC.translate("&4&lDEADCORE &8» &cUsage: /" + label + " <mode>"));
            return false;
        }
        FileConfiguration config = this.plugin.getConfig();
        if
        (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival") ||
                args[0].equalsIgnoreCase("s")) {
            player.setGameMode(GameMode.SURVIVAL);
            String Survival = "Config.Mensaje-Survival";
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString(Survival)));
        }
        else if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creative") ||
                args[0].equalsIgnoreCase("c")) {
            player.setGameMode(GameMode.CREATIVE);
            String Creativo = "Config.Mensaje-Creativo";
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString(Creativo)));
        }
        else if (args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("adventure") ||
                args[0].equalsIgnoreCase("a")) {
            player.setGameMode(GameMode.ADVENTURE);
            String Aventura = "Config.Mensaje-Aventura";
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString(Aventura)));
        }else if (args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spectator") ||
                args[0].equalsIgnoreCase("spc")) {
            player.setGameMode(GameMode.SPECTATOR);
            String Espectador = "Config.Mensaje-Espectador";
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString(Espectador)));
        }
        else {
            player.sendMessage(CC.translate("&cGamemode '" + args[0] + "' no encontrado"));
            return false;
        }
        return true;
    }
}
