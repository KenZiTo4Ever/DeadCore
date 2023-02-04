package hystudio.Essentials;

import hystudio.deadcore;
import java.util.ArrayList;
import java.util.List;
import hystudio.utils.CC;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

public class world implements CommandExecutor, TabCompleter {
    public world(deadcore kenziii) {
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("world"));
        if (!(sender instanceof Player)) {
            sender.sendMessage("consola no puede executar este comando!");
            return true;
        }
        Player player = (Player)sender;
        if (args.length == 0) {
            player.sendMessage(CC.translate(""));
                    player.sendMessage(deadcore.colorize("#aedddd Intenta utilizando:"));
            player.sendMessage(deadcore.colorize("#aedddd  - #c7f6d4/world day #bdbfbf- #ffffecEstablece de dia en el mundo actual"));
            player.sendMessage(deadcore.colorize("#aedddd  - #c7f6d4/world night #bdbfbf- #ffffecEstablece de noche en el dia actual "));
            player.sendMessage(CC.translate(""));
            return true;
        }
        if (args.length >= 1) {
            if (args[0].equalsIgnoreCase("day")) {
                player.getWorld().playSound(player.getLocation(), Sound.BLOCK_LAVA_POP, 10.0F, 1.0F);
                player.sendMessage(deadcore.colorize("#b0c2f2| Se ha establecido de dia en el mundo actual!"));
                player.getLocation().getWorld().setTime(1000L);
                player.getLocation().getWorld().setClearWeatherDuration(999999);
                return true;
            }
            if (args[0].equalsIgnoreCase("night")) {
                player.getWorld().playSound(player.getLocation(), Sound.BLOCK_LAVA_POP, 10.0F, 1.0F);
                player.getLocation().getWorld().setTime(13000L);
                player.sendMessage(deadcore.colorize("#b0c2f2| Se ha establecido de noche en el mundo actual!"));
                return true;
            }
        }
        return false;
    }

    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> arguments = new ArrayList<>();
        if (arguments.isEmpty()) {
            arguments.add("day");
            arguments.add("night");
            return arguments;
        }
        return null;
    }
}
