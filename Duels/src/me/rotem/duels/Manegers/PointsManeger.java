package me.rotem.duels.Manegers;

import me.rotem.duels.DuelsMain;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PointsManeger {
    private Map<Player, Integer> playerPoints = new HashMap<>();
    private DuelsMain pl;

    public PointsManeger(DuelsMain pl) {
        this.pl = pl;
        if (pl.getPm().getPoints().get("minigames.duels.players") == null){
            System.out.println("booga man");
            return;
        }
        for (String key : pl.getPm().getPoints().getConfigurationSection("minigames.duels.players").getKeys(false)) {
            playerPoints.put(Bukkit.getPlayer(UUID.fromString(key)), pl.getPm().getPoints().getInt("minigames.duels.players." + key));
        }
    }

    public int getPlayerInfoPoints(Player p) {
        if (playerPoints.containsKey(p)) {
            return playerPoints.get(p);
        }
        return 0;
    }

    public Map<Player, Integer> getPlayerPoints() {
        return playerPoints;
    }
}
