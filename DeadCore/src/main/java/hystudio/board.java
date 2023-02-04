package hystudio;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class board implements CommandExecutor {
    public board(deadcore kenziii) {
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player)sender;
            String pnick = player.getDisplayName();
            ScoreboardManager manager = Bukkit.getScoreboardManager();
            Scoreboard scoreboard = manager.getNewScoreboard();
            Objective objective = scoreboard.registerNewObjective("Title", "dummy");
            objective.setDisplaySlot(DisplaySlot.SIDEBAR);
            objective.setDisplayName(deadcore.colorize("#e4fbfb&lHub"));
            Score b8 = objective.getScore("   ");
            Score b7 = objective.getScore(deadcore.colorize("&f Nick: &e" + pnick));
            Score b6 = objective.getScore(deadcore.colorize("&f Conexion &e" + player.getPing()));
            Score b5 = objective.getScore(" ");
            Score b4 = objective.getScore(deadcore.colorize("&f Servidor: &aswb"));
            Score b3 = objective.getScore(deadcore.colorize("&f En lobby&a" + Bukkit.getOnlinePlayers().size() + " Jug."));
            Score b2 = objective.getScore("  ");
            Score b1 = objective.getScore(deadcore.colorize("&7  hystudio.net"));
            b8.setScore(8);
            b7.setScore(7);
            b6.setScore(6);
            b5.setScore(5);
            b4.setScore(4);
            b3.setScore(3);
            b2.setScore(2);
            b1.setScore(1);
            player.setScoreboard(scoreboard);
        }
        return false;
    }
}