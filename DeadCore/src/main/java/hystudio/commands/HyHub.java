package hystudio.commands;

import hystudio.deadcore;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class HyHub implements Listener, CommandExecutor {
    private deadcore plugin;

    public HyHub(deadcore plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command comando, String label, String[] args) {
        if (!(sender instanceof Player)) {
            dev.bopi.Utilidades.CC.log("Este comando no se puede ejecutar en consola!");
            return false;
        }
        Player p = (Player)sender;
        FileConfiguration config = this.plugin.getConfig();
        if (args.length == 0) {
            p.sendMessage(dev.bopi.Utilidades.CC.translate("&8&m--------------------------------------------"));
            p.sendMessage(dev.bopi.Utilidades.CC.translate(""));
            p.sendMessage(deadcore.colorize("#fb0000&lD&#eb0505&lE&#db0909&lA&#cb0e0e&lD&#bb1313&lC&#ab1818&lO&#9b1c1c&lR&#8b2121&lE\n"));
            p.sendMessage(dev.bopi.Utilidades.CC.translate(""));
            p.sendMessage(dev.bopi.Utilidades.CC.translate("&b/Fly &f- Activa el modo de vuelo"));
            p.sendMessage(dev.bopi.Utilidades.CC.translate("&b/gm &f- Activa el modo de juego (0,1,2,3)"));
            p.sendMessage(dev.bopi.Utilidades.CC.translate("&b/set flyspawn &f- Poner el lobby"));
            p.sendMessage(dev.bopi.Utilidades.CC.translate("&b/world &f- (day / night) poner dia o noche"));
            p.sendMessage(dev.bopi.Utilidades.CC.translate("&b/heal &f- Cura tus heridas"));
            p.sendMessage(dev.bopi.Utilidades.CC.translate("&b/tpall &f- Manda a todos a tu posicion"));
            p.sendMessage(dev.bopi.Utilidades.CC.translate("&b/hyhub reload &f- Recarga la configuracion del plugin"));
            p.sendMessage(dev.bopi.Utilidades.CC.translate("&b/sb &f- Activa la scoreboad"));
            p.sendMessage(dev.bopi.Utilidades.CC.translate(""));
            p.sendMessage(dev.bopi.Utilidades.CC.translate("&8&m--------------------------------------------"));


        } else if (args[0].equalsIgnoreCase("reload")) {
            String reload = "Config.reload";
            p.sendMessage(deadcore.colorize(("#5a45fb&lS&#6051fb&lI&#655cfb&lS&#6b68fb&lT&#7073fc&lE&#767ffc&lM&#7b8bfc&lA &#8196fc&lR&#86a2fc&lE&#8cadfc&lL&#91b9fc&lO&#97c5fc&lG&#9cd0fd&lE&#a2dcfd&lA&#a7e7fd&lD&#adf3fd&lO")));
            this.plugin.reloadConfig();
        }
        return false;
    }
}