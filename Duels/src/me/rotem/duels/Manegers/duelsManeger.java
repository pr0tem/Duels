package me.rotem.duels.Manegers;

import me.rotem.duels.DuelsMain;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class duelsManeger {
    private DuelsMain pl;
    private List<Player> pending = new ArrayList<>();
    private List<Player> ingame = new ArrayList<>();
    private List<String> rewards = new ArrayList<>();
    private Location spawn1;
    private Location spawn2;
    private List<ItemStack> kit = new ArrayList<>();

    public duelsManeger(DuelsMain pl) {
        this.pl = pl;
        rewards = pl.getConfig().getStringList("minigames.duels.rewards");
        spawn1 = (Location) pl.getConfig().get("minigames.duels.spawn1");
        spawn2 = (Location) pl.getConfig().get("minigames.duels.spawn2");
        kit = (List<ItemStack>) pl.getConfig().get("minigames.duels.kit");
    }

    public List<Player> getIngame() {
        return ingame;
    }

    public void StartPending(Player p) {
        pending.add(p);
        if (pending.size() == 2) {
            StartGame();
        }
    }

    public void TeleportPlayers(List<Player> p) {
        p.get(0).teleport(spawn1);
        p.get(1).teleport(spawn2);
    }

    public void StartGame() {
        ingame.addAll(pending);
        pending.clear();
        TeleportPlayers(ingame);
        for (Player i : ingame) {
            kit.forEach(m -> {
                i.getInventory().addItem(m);
            });

        }
    }

    public void setKit(Player p) {
        List<ItemStack> temp = new ArrayList<>();
        for (ItemStack i : p.getInventory()) {
            if (i != null && i != new ItemStack(Material.AIR)) {
                temp.add(i);
            }
        }
        pl.getConfig().set("minigames.duels.kit", temp);
        pl.saveConfig();
        temp.clear();
        p.sendMessage(ChatColor.DARK_BLUE + "the kit has been set");
    }
}
