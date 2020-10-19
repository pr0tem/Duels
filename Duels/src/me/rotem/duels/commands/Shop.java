package me.rotem.duels.commands;

import me.rotem.duels.DuelsMain;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Shop implements CommandExecutor {

    private DuelsMain pl;
    public Shop(DuelsMain pl) {
        this.pl = pl;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This plugin is for Players only!");
            return true;
        }
        Player p = ((Player) sender).getPlayer();
        Inventory gui = Bukkit.createInventory(p, 9, ChatColor.AQUA + "Shop");

        ItemStack xpBottle = new ItemStack(Material.EXP_BOTTLE);
        ItemStack diamond = new ItemStack(Material.DIAMOND);
        ItemStack steak = new ItemStack(Material.COOKED_BEEF, 64);

        ItemMeta xpMeta = xpBottle.getItemMeta();
        xpMeta.setDisplayName(ChatColor.BLUE + "Xp");
        ArrayList<String> xpLore = new ArrayList<>();
        xpLore.add(ChatColor.LIGHT_PURPLE + "Price: 5 Points");
        xpMeta.setLore(xpLore);
        xpBottle.setItemMeta(xpMeta);

        ItemMeta diaMeta = diamond.getItemMeta();
        diaMeta.setDisplayName(ChatColor.BLUE + "Diamond");
        ArrayList<String> diaLore = new ArrayList<>();
        diaLore.add(ChatColor.LIGHT_PURPLE + "Price: 1 Points");
        diaMeta.setLore(diaLore);
        diamond.setItemMeta(diaMeta);

        ItemMeta steakMeta = steak.getItemMeta();
        steakMeta.setDisplayName(ChatColor.BLUE + "64 Steaks");
        ArrayList<String> steakLore = new ArrayList<>();
        steakLore.add(ChatColor.LIGHT_PURPLE + "Price: 3 Points");
        steakMeta.setLore(steakLore);
        steak.setItemMeta(steakMeta);

        ItemStack[] shopItems = {xpBottle, diamond, steak};

        gui.setContents(shopItems);
        p.openInventory(gui);

        return true;
    }
}
