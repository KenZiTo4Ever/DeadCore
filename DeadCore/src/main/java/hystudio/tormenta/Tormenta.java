package hystudio.tormenta;

import hystudio.deadcore;
import hystudio.utils.CC;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
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
                players.sendTitle(CC.translate("&2&lTORMENTA TOXICA"),CC.translate("&fHa comenzado ten cuidado!"),20,20,20);
                p.performCommand("bbt start tormenta");
                world.setStorm(true);
                world.setWeatherDuration(20*60*5);
                Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "effect give @e[type=minecraft:iron_golem] minecraft:strength 100000 5 true");
                Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "effect give @e[type=minecraft:enderman] minecraft:strength 100000 5 true");
                Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "effect give @e[type=minecraft:zombie] minecraft:strength 100000 5 true");
                Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "effect give @e[type=minecraft:piglin] minecraft:strength 100000 5 true");
                Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "effect give @e[type=minecraft:husk] minecraft:strength 100000 5 true");
                Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "effect give @e[type=minecraft:polar_bear] minecraft:strength 100000 5 true");
                Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "effect give @e[type=minecraft:drowned] minecraft:strength 100000 5 true");
                players.sendMessage(CC.translate(""));
                players.sendMessage(CC.translate("&a&lMOBS | &fLos mobs han sido modificados &e⚠ Cuidado ⚠"));
                players.sendMessage(CC.translate(""));
                players.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(CC.translate("&2Tormenta Activada!")));
                p.performCommand("owooniichan");
            }
        }
        return false;
    }
    }
