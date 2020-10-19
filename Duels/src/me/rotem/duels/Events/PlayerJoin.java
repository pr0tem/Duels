package me.rotem.duels.Events;

import me.rotem.duels.DuelsMain;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class PlayerJoin implements Listener {
    private DuelsMain pl;
    private Location spawn;

    public PlayerJoin(DuelsMain pl) {
        this.pl = pl;
        spawn = (Location) pl.getConfig().get("minigames.duels.mainspawn");
    }

    @EventHandler
    public void playerJoin(PlayerJoinEvent e) {
        spawn.getWorld().setSpawnLocation(spawn.getBlockX(), spawn.getBlockY() + 1, spawn.getBlockZ());
    }
}

