package me.rotem.duels.Events;

import me.rotem.duels.DuelsMain;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;


public class PlayerDeath implements Listener {
    private DuelsMain pl;
    private Location main;

    public PlayerDeath(DuelsMain pl) {
        this.pl = pl;
        main = (Location) pl.getConfig().get("minigames.duels.mainspawn");
    }

    @EventHandler
    public void playerdeath(PlayerDeathEvent e) {
        Player p = e.getEntity();
        if (p.getKiller().getType() == p.getType()) {
            Player killer = p.getKiller();
            if (pl.getManeger().getIngame().contains(p) && pl.getManeger().getIngame().contains(killer)) {
                p.teleport(main);
                killer.teleport(main);
                if (pl.getManeger().getIngame().contains(killer)) {
                    if (pl.getPointsManeger().getPlayerPoints().containsKey(killer)) {
                        pl.getPointsManeger().getPlayerPoints().put(killer, pl.getPointsManeger().getPlayerPoints().get(killer) + 1);
                    } else {
                        pl.getPointsManeger().getPlayerPoints().put(killer, 1);
                    }
                    pl.getPm().getPoints().set("minigames.duels.players." + killer.getUniqueId(), pl.getPointsManeger().getPlayerInfoPoints(killer));
                    pl.getPm().saveData();
                }
                pl.getManeger().getIngame().remove(p);
                pl.getManeger().getIngame().remove(killer);
                Bukkit.broadcastMessage(killer.getDisplayName() + "has killed" + p.getDisplayName());
            }
        }
    }
}
