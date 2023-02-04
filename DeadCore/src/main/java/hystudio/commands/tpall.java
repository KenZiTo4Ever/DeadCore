package hystudio.commands;


import hystudio.deadcore;
import hystudio.utils.CC;
import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class tpall implements CommandExecutor {
    public tpall(deadcore kenziii) {
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player)sender;
        World world = player.getWorld();
        if (sender instanceof Player && player.hasPermission("deadcore.utils")) {
            String locX = String.valueOf(player.getLocation().getBlockX());
            String locY = String.valueOf(player.getLocation().getBlockY());
            String locZ = String.valueOf(player.getLocation().getBlockZ());
            player.sendTitle(CC.translate("&b&lTP"), CC.translate("&fJUGADORES TELETRANSPORTADOS"),20,20,20);
                    player.sendMessage(deadcore.colorize("#dcffff | Has teletransportado a todos los jugadores a tu posicion actual!"));
            player.getWorld().playSound(player.getLocation(), Sound.BLOCK_LAVA_POP, 10.0F, 1.0F);
            world.setGameRule(GameRule.SEND_COMMAND_FEEDBACK, Boolean.valueOf(false));
            Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "minecraft:tp @a " + locX + " " + locY + " " + locZ);
        } else if (sender instanceof Player && !player.hasPermission("hystudios.utils")) {
            Player jugador = (Player)sender;
            jugador.sendMessage(deadcore.colorize("#FF0000|#FF7070 Este comando solo esta disponible para los usuarios con el permiso!"));
        } else {
            Bukkit.getConsoleSender().sendMessage(deadcore.colorize("#FF0000|#FF7070 Este comando solo esta disponible para los usuarios con el permiso!"));
        }
        return false;
    }
}
