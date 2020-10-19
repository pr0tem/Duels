package me.rotem.duels;

import me.rotem.duels.Events.PlayerClick;
import me.rotem.duels.Events.PlayerDeath;
import me.rotem.duels.Events.PlayerJoin;
import me.rotem.duels.Manegers.ConfigManeger;
import me.rotem.duels.Manegers.PointsManeger;
import me.rotem.duels.Manegers.duelsManeger;
import me.rotem.duels.commands.Duels;
import me.rotem.duels.commands.Points;
import me.rotem.duels.commands.Shop;
import me.rotem.duels.commands.play;
import org.bukkit.plugin.java.JavaPlugin;


public class DuelsMain extends JavaPlugin {
    private duelsManeger maneger;
    private ConfigManeger pm;
    private PointsManeger pointsManeger;

    public void onEnable() {
        loadUtils();
    }


    private void loadCommands() {
        getCommand("play").setExecutor(new play(this));
        getCommand("shop").setExecutor(new Shop(this));
        getCommand("duels").setExecutor(new Duels(this));
        getCommand("points").setExecutor(new Points(this));
    }

    private void loadEvents() {
        getServer().getPluginManager().registerEvents(new PlayerDeath(this), this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(this), this);
        getServer().getPluginManager().registerEvents(new PlayerClick(this), this);
    }

    private void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    private void loadManegers() {
        pm = new ConfigManeger(this);
        pm.setUp();
        maneger = new duelsManeger(this);
        pointsManeger = new PointsManeger(this);
    }

    public duelsManeger getManeger() {
        return maneger;
    }

    public ConfigManeger getPm() {
        return pm;
    }

    public PointsManeger getPointsManeger() {
        return pointsManeger;
    }

    private void loadUtils() {
        loadCommands();
        loadConfig();
        loadManegers();
        loadEvents();
    }
}
