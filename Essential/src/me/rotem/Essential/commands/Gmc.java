package me.rotem.Essential.commands;

import me.rotem.Essential.Essential;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gmc implements CommandExecutor {
    private Essential pl;

    public Gmc(Essential pl) {
        this.pl = pl;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This plugin is for Players only!");
            return true;
        }

        Player p = (Player) sender;
        if (args.length == 0) {
            if (p.getGameMode() == GameMode.SURVIVAL) {
                p.setGameMode(GameMode.CREATIVE);
                p.sendMessage(ChatColor.GREEN + "survival");
                return true;
            }
        }
        else {
            p.sendMessage(ChatColor.RED + "lil nigga tryna cheat");
        }

        return false;
    }
}
