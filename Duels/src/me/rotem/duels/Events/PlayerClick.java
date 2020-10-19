package me.rotem.duels.Events;

import me.rotem.duels.DuelsMain;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerClick implements Listener {

    private DuelsMain pl;

    public PlayerClick(DuelsMain pl) {
        this.pl = pl;
    }


    @EventHandler
    public void shopClick(InventoryClickEvent e){

        Player p = (Player) e.getWhoClicked();
        if (e.getClickedInventory().getTitle().equalsIgnoreCase(ChatColor.AQUA + "Shop")){
            switch(e.getCurrentItem().getType()){
                case EXP_BOTTLE:
                    if (pl.getPointsManeger().getPlayerInfoPoints(p) < 5){
                        p.closeInventory();
                        pl.getPointsManeger().getPlayerPoints().put(p, pl.getPointsManeger().getPlayerPoints().get(p) + -5);
                        p.sendMessage(ChatColor.BLUE + "not enough points");
                        break;
                    }
                    p.closeInventory();
                    p.giveExpLevels(1);
                    break;

                case DIAMOND:
                    if (pl.getPointsManeger().getPlayerInfoPoints(p) < 1){
                        p.closeInventory();
                        pl.getPointsManeger().getPlayerPoints().put(p, pl.getPointsManeger().getPlayerPoints().get(p) + -1);
                        p.sendMessage(ChatColor.BLUE + "not enough points");
                        break;
                    }
                    p.closeInventory();
                    p.getInventory().addItem(new ItemStack(Material.DIAMOND));
                    break;

                case COOKED_BEEF:
                    if (pl.getPointsManeger().getPlayerInfoPoints(p) < 3){
                        p.closeInventory();
                        pl.getPointsManeger().getPlayerPoints().put(p, pl.getPointsManeger().getPlayerPoints().get(p) + -3);
                        p.sendMessage(ChatColor.BLUE + "not enough points");
                        break;
                    }
                    p.closeInventory();
                    p.getInventory().addItem(new ItemStack(Material.COOKED_BEEF, 64));
                    break;
            }


            e.setCancelled(true);
        }
    }
}
