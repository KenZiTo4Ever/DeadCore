package hystudio.events;
import hystudio.deadcore;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {
    private deadcore plugin;

    public PlayerQuit(deadcore plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void Join(PlayerQuitEvent event) {
        Player player = event.getPlayer(); {
            FileConfiguration config = this.plugin.getConfig();
            if (config.contains("Location.Spawn.z")) {
                event.setQuitMessage(deadcore.colorize("#d8f8e1| ") + event.getPlayer().getName() + " ha salido al servidor");
        } else {

            event.setQuitMessage(deadcore.colorize("#d8f8e1| ") + event.getPlayer().getName() + " ha salido al servidor");
        }
    }
}
}
