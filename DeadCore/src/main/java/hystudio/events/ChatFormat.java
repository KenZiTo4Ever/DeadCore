package hystudio.events;

import hystudio.deadcore;
import hystudio.utils.CC;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatFormat implements Listener {

    public ChatFormat(deadcore kenziii) {
    }

    @EventHandler
    public void chatFormat(AsyncPlayerChatEvent event) {
        Player p = event.getPlayer();
        event.setFormat(CC.translate("&e⚠ ") +  p.getDisplayName() + deadcore.colorize("#545454 » #AEAEAE") + event.getMessage());
    }
}

