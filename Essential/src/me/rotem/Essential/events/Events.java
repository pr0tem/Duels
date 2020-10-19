package me.rotem.Essential.events;

import me.rotem.Essential.Essential;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Events implements Listener {
    private Essential pl;
    private List<Material> ores = new ArrayList<>();
    private List<ItemStack> inv = new ArrayList<>();
    private List<ItemStack> chestinv = new ArrayList<>();

    public Events(Essential pl) {
        this.pl = pl;
        ores.add(Material.DIAMOND);
        ores.add(Material.COAL);
        ores.add(Material.EMERALD);
        ores.add(Material.IRON_INGOT);
        ores.add(Material.GOLD_INGOT);
    }

    @EventHandler
    public void stackChest(PlayerInteractEvent e) {

        if (e.getAction() == Action.LEFT_CLICK_BLOCK) {
            Player p = e.getPlayer();
            Block b = p.getTargetBlock((Set<Material>) null, 15);
            if (b.getType() == Material.CHEST) {
                Chest chest = (Chest) b.getState();
                for (ItemStack i : chest.getInventory()) {
                    if (i != null && i != new ItemStack(Material.AIR)) {
                        if (ores.contains(Material.getMaterial(i.getType().name()))) {
                            p.sendMessage(ChatColor.RED + String.valueOf(i.getAmount()));
                            int ingots = i.getAmount() % 9;
                            int blocks = (i.getAmount() - (i.getAmount() % 9)) / 9;
                            if (blocks >= 1) {
                                chest.getInventory().remove(i);
                                chest.getInventory().addItem(new ItemStack(i.getType(), ingots));
                                switch (i.getType()) {

                                    case DIAMOND:
                                        chest.getInventory().addItem(new ItemStack(Material.DIAMOND_BLOCK, blocks));
                                        break;
                                    case IRON_INGOT:
                                        chest.getInventory().addItem(new ItemStack(Material.IRON_BLOCK, blocks));
                                        break;
                                    case GOLD_INGOT:
                                        chest.getInventory().addItem(new ItemStack(Material.GOLD_BLOCK, blocks));
                                        break;
                                    case COAL:
                                        chest.getInventory().addItem(new ItemStack(Material.COAL_BLOCK, blocks));
                                        break;
                                    case EMERALD:
                                        chest.getInventory().addItem(new ItemStack(Material.EMERALD_BLOCK, blocks));
                                        break;

                                }

                            }


                        } else {
                            System.out.println(i);
                        }
                    }
                }

            }
            inv.clear();
            chestinv.clear();
            if (e.getAction() == Action.LEFT_CLICK_BLOCK && pl.getPlayerInfo().DaBigSneak()) {
                System.out.println("booga");
                if (b.getType() == Material.CHEST) {
                    Chest chest = (Chest) b.getState();
                    for (ItemStack i : p.getInventory()) {
                        if (i != null && i != new ItemStack(Material.AIR)) {
                            inv.add(i);
                        }
                    }
                    for (ItemStack i : chest.getInventory()) {
                        if (i != null && i != new ItemStack(Material.AIR)) {
                            chestinv.add(i);
                        }
                    }
                    chestinv.forEach(i -> {
                        if (inv.contains(i)) {
                            chest.getInventory().remove(i);
                            p.getInventory().addItem(i);
                        }
                    });
                }
            }
        }
    }
}
