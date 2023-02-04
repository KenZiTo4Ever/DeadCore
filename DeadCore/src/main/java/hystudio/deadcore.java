package hystudio;

import hystudio.Essentials.heal;
import hystudio.Essentials.world;
import hystudio.commands.FlyCommand;
import hystudio.commands.HyHub;
import hystudio.commands.SetSpawn;
import hystudio.commands.tpall;
import hystudio.events.ChatFormat;
import hystudio.events.PlayerJoin;
import hystudio.events.PlayerQuit;
import hystudio.gamemode.GamemodeCommand;
import hystudio.tormenta.Tormenta;
import hystudio.utils.CC;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class deadcore extends JavaPlugin {
    private String rutaConfig;

    @Override
    public void onEnable() {
        CC.log("&8&m------------------------------------------");
        CC.log("");
        CC.log("  &cDeadCore &aEncendido &fCreate by &3Hy Studio");
        CC.log("Author: &bKenzii - Hy Studio");
        CC.log("Version: &b1.0 BETA");
        CC.log("Joined: &bhttps://discord.gg/gwGKjbQybh");
        CC.log("");
        CC.log("&8&m------------------------------------------");
        RegisterCommands();
        registerConfig();
        RegisterEvents();
    }

    @Override
    public void onDisable() {
        CC.log("&8&m------------------------------------------");
        CC.log("");
        CC.log("  &cDeadCore &cApagado &fCreate by &3Hy Studio");
        CC.log("Author: &bKenzii - Hy Studio");
        CC.log("Version: &b1.0 BETA");
        CC.log("Joined: &bhttps://discord.gg/gwGKjbQybh");
        CC.log("");
        CC.log("&8&m------------------------------------------");
    }
    public void RegisterCommands() {
        getCommand("gm").setExecutor(new GamemodeCommand(this));
        getCommand("fly").setExecutor(new FlyCommand(this));
        getCommand("deadcore").setExecutor(new HyHub(this));
        getCommand("set").setExecutor(new SetSpawn(this));
        getCommand("world").setExecutor(new world(this));
        getCommand("heal").setExecutor(new heal(this));
        getCommand("tpall").setExecutor(new tpall(this));
        getCommand("sb").setExecutor(new board(this));
        getCommand("tormenta").setExecutor(new Tormenta(this));




    }
    public void RegisterEvents() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new PlayerJoin(this), (Plugin)this);
        pm.registerEvents(new PlayerQuit(this), (Plugin)this);
        pm.registerEvents(new ChatFormat(this), (Plugin)this);

    }
    public void registerConfig() {
        File config = new File(getDataFolder(), "config.yml");
        this.rutaConfig = config.getPath();
        if (!config.exists()) {
            getConfig().options().copyDefaults(true);
            saveConfig();
        }
    }
    public static String colorize(String text) {
        final Pattern pattern = Pattern.compile("#[a-fA-F0-9]{6}");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String color = text.substring(matcher.start(), matcher.end());
            text = text.replace(color, net.md_5.bungee.api.ChatColor.of(color) + "");
            matcher = pattern.matcher(text);
        }

        text = text.replace('&', ChatColor.COLOR_CHAR);
        text = ChatColor.translateAlternateColorCodes('&', text);
        return text;
    }
}
