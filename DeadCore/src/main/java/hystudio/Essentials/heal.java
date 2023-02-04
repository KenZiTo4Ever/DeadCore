package hystudio.Essentials;

import hystudio.deadcore;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class heal implements CommandExecutor {
    public heal(deadcore kenziii) {
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player)sender;
        World world = player.getWorld();
        for (Player players : Bukkit.getOnlinePlayers()) {
            if (sender instanceof Player && player.hasPermission("deadcore.utils")) {
                players.sendMessage(deadcore.colorize("#a3ffac| Has sido curado correctamente!"));
                players.setFoodLevel(20);
                world.playSound(players.getLocation(), Sound.BLOCK_LAVA_POP, 10.0F, 1.0F);
                players.setHealth(20.0D);
            }
        }
        return false;
    }
}