package hystudio.events;
import hystudio.deadcore;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {
    private deadcore plugin;

    public PlayerJoin(deadcore plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void Join(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("hystudio.joinfly") || player.isOp()) {
            FileConfiguration config = this.plugin.getConfig();
            if (config.contains("Location.Spawn.z")) {
                double x = Double.valueOf(config.getString("Location.Spawn.x")).doubleValue();
                double y = Double.valueOf(config.getString("Location.Spawn.y")).doubleValue();
                double z = Double.valueOf(config.getString("Location.Spawn.z")).doubleValue();
                float yaw = Float.valueOf(config.getString("Location.Spawn.yaw")).floatValue();
                float pitch = Float.valueOf(config.getString("Location.Spawn.pitch")).floatValue();
                World world = this.plugin.getServer().getWorld(config.getString("Location.Spawn.world"));
                Location l = new Location(world, x, y, z, yaw, pitch);
                player.getInventory().clear();
                String title = "Config.Mensaje-Titulo";
                 String subtitle = "Config.Mensaje-Subtitle";
                player.sendTitle(ChatColor.translateAlternateColorCodes('&', config.getString(title)), (ChatColor.translateAlternateColorCodes('&', config.getString(subtitle))),20,20,20);
                event.setJoinMessage(deadcore.colorize("#d8f8e1| ") + event.getPlayer().getName() + " ha ingresado al servidor");
                player.teleport(l);
                player.setAllowFlight(true);
                if (player.getAllowFlight())
                    player.setFlying(true);
            }
        }
    }

}
