package dev.bopi.Utilidades;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.GameMode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.*;
import java.util.stream.Collectors;

public final class CC {

    public static final String SB_BAR = ChatColor.GRAY.toString() + ChatColor.STRIKETHROUGH + "----------------------";
    public static final String MENU_BAR = ChatColor.GRAY.toString() + ChatColor.STRIKETHROUGH + "----------------------------";
    public static final String DARK_MENU_BAR = ChatColor.DARK_GRAY.toString() + ChatColor.STRIKETHROUGH + "--------------------------------";
    public static final String CHAT_BAR = ChatColor.GRAY.toString() + ChatColor.STRIKETHROUGH + "------------------------------------------------";

    public static String translate(String value) {
        final Pattern pattern = Pattern.compile("#[a-fA-F0-9]{6}");
        Matcher matcher = pattern.matcher(value);

        while (matcher.find()) {
            String color = value.substring(matcher.start(), matcher.end());
            value = value.replace(color, net.md_5.bungee.api.ChatColor.of(color) + "");
            matcher = pattern.matcher(value);
        }
        String online = String.valueOf(Bukkit.getOnlinePlayers().size());
        String alive = String.valueOf(Bukkit.getOnlinePlayers().stream().filter(target -> target.getPlayer().getGameMode().equals(GameMode.SURVIVAL)).count());
        String espectadores = String.valueOf(Bukkit.getOnlinePlayers().stream().filter(target -> target.getPlayer().getGameMode().equals(GameMode.SPECTATOR)).count());
        value = value.replace("[online]", online); value = value.replace("[vivos]", alive); value = value.replace("[espectadores]", espectadores);
        value = value.replace("%c%", "[✔]");
        value = value.replace("%x%", "[✗]");
        value = value.replace("%lapiz%", "✐");
        value = value.replace("%musica%", "♬");
        value = value.replace("%sonido%", "♪");
        value = value.replace("%correo%", "✉");
        value = value.replace("%start%", "★");
        value = value.replace("%locked%", "☒");
        value = value.replace("%check%", "☑");
        value = value.replace("%skull%", "☠");
        value = value.replace("%pickaxe%", "⛏");
        value = value.replace("%sword%", "🗡");
        value = value.replace("%axe%", "🪓");
        value = value.replace("%swords%", "⚔");


        value = value.replace('&', ChatColor.COLOR_CHAR);
        value = ChatColor.translateAlternateColorCodes('&', value);
        return value;
    }

    public static List<String> translate(List<String> list) {
        return (List<String>)list.stream().map(CC::translate).collect(Collectors.toList());
    }

    public static String strip(String text) {
        return ChatColor.stripColor(text);
    }

    public static String text(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static void sender(CommandSender sender, String text) {
        sender.sendMessage(translate(text));
    }

    public static void message(Player player, String text) {
        player.sendMessage(translate(text));
    }

    public static void broadcast(String text) {
        Bukkit.broadcastMessage(translate(text));
    }

    public static void log(String text) {
        Bukkit.getConsoleSender().sendMessage(translate(text));
    }

    public static List<String> translateFromArray(List<String> text) {
        return text.stream().map(CC::translate).collect(Collectors.toList());
    }
}