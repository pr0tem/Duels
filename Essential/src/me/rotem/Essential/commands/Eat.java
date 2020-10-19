package me.rotem.Essential.commands;

import me.rotem.Essential.Essential;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Eat implements CommandExecutor {
    private Essential pl;

    public Eat(Essential pl) {
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
            if (p.getFoodLevel() < 20) {
                p.setFoodLevel(20);
                p.sendMessage(ChatColor.GREEN + "You have been slapped in the butt");
            }
        } else {
            p.sendMessage(ChatColor.RED + "lil nigga tryna cheat");
        }
        return false;
    }
}


