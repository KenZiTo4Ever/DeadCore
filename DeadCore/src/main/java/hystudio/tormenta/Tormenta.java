package hystudio.tormenta;

import hystudio.deadcore;
import hystudio.utils.delay;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.EntityEffect;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class Tormenta implements CommandExecutor {
    private Bukkit plugin;

    public Tormenta(deadcore deadcore) {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        World world = this.plugin.getServer().getWorld("world");
        String locX = String.valueOf(p.getLocation().getBlockX());
        String locY = String.valueOf(p.getLocation().getBlockY());
        String locZ = String.valueOf(p.getLocation().getBlockZ());
        if (args[0].equalsIgnoreCase("1")){
            for (Player players : Bukkit.getOnlinePlayers()) {
                players.sendTitle(dev.bopi.Utilidades.CC.translate("&2&lTORMENTA TOXICA"), dev.bopi.Utilidades.CC.translate("&fHa comenzado ten cuidado!"),20,20,20);
                players.sendMessage(dev.bopi.Utilidades.CC.translate(""));
                players.sendMessage(dev.bopi.Utilidades.CC.translate("&a&lMOBS | &fLos mobs han sido modificados &e⚠ Cuidado ⚠"));
                players.sendMessage(dev.bopi.Utilidades.CC.translate(""));
                players.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(dev.bopi.Utilidades.CC.translate("&2Tormenta Activada!")));
            }

            p.performCommand("bbt start tormenta");
            world.setStorm(true);
            world.setWeatherDuration(20605);
            for (Entity entity : world.getEntities()) {
                entity.playEffect(EntityEffect.HURT);
                new delay(() -> {
                    for (Player players : Bukkit.getOnlinePlayers()) {

                        /* Ahorita falta añadir efectos */
                    }

                }, 20 * 2);
            }
        }
        return false;
    }
    }
