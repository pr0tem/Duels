package me.rotem.duels.commands;

import me.rotem.duels.DuelsMain;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class play implements CommandExecutor {
    private DuelsMain pl;

    public play(DuelsMain pl) {
        this.pl = pl;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This plugin is for Players only!");
            return true;
        }
        Player p = (Player) sender;
        if (args[0].equalsIgnoreCase("duels")) {
            pl.getManeger().StartPending(p);
            p.sendMessage(ChatColor.GREEN + "Waiting for players...");
        } else {
            p.sendMessage(ChatColor.GREEN + "Minigame does not exist");
        }
        return true;
    }
}