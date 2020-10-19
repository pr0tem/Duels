package me.rotem.duels.commands;

import me.rotem.duels.DuelsMain;
import me.rotem.duels.Manegers.duelsManeger;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class Duels implements CommandExecutor {
    private DuelsMain pl;
    private List<ItemStack> kit = new ArrayList<>();
    public Duels(DuelsMain pl) {
        this.pl = pl;
        kit = (List<ItemStack>) pl.getConfig().get("minigames.duels.kit");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This plugin is for Players only!");
            return true;
        }
        Player p = (Player) sender;
        if (args[0].equalsIgnoreCase("set")){
            if (args[1].equalsIgnoreCase("spawn1")){
                pl.getConfig().set("minigames.duels.spawn1", p.getLocation());
                pl.saveConfig();
                p.sendMessage(ChatColor.LIGHT_PURPLE + "spawn point 1 has been set");
            }
            if (args[1].equalsIgnoreCase("spawn2")){
                pl.getConfig().set("minigames.duels.spawn2", p.getLocation());
                pl.saveConfig();
                p.sendMessage(ChatColor.LIGHT_PURPLE + "spawn point 2 has been set");
            }
            if (args[1].equalsIgnoreCase("kit")) {
                pl.getManeger().setKit(p);
            }
            if (args[1].equalsIgnoreCase("mainspawn")) {
                pl.getConfig().set("minigames.duels.mainspawn", p.getLocation());
                pl.saveConfig();
                p.sendMessage(ChatColor.GREEN + "Main spawn set");
            }
        }
        if (args[0].equalsIgnoreCase("kit")) {
           kit.forEach(i -> {
               p.getInventory().addItem(i);
           });

        }
        return true;
    }
}