package me.rotem.duels.commands;

import me.rotem.duels.DuelsMain;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Points implements CommandExecutor {
    private DuelsMain pl;

    public Points(DuelsMain pl) {
        this.pl = pl;

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This plugin is for Players only!");
            return true;
        }
        Player p = (Player) sender;
        if (args.length == 0){
            sender.sendMessage(ChatColor.WHITE + "Points:" + pl.getPointsManeger().getPlayerInfoPoints(p));
        }
        else if (args[0].equalsIgnoreCase("add")){
            try{
                if (args.length == 2){
                    int pointsToAdd = Integer.parseInt(args[1]);
                    pl.getPointsManeger().getPlayerPoints().put(p, pl.getPointsManeger().getPlayerPoints().get(p) + pointsToAdd);
                }
                else{
                    sender.sendMessage(ChatColor.RED + "Invalid Amount");
                }
            }
            catch (Exception e){
                return true;
            }

        }

        return true;
    }
}
