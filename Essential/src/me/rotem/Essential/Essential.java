package me.rotem.Essential;

import me.rotem.Essential.commands.*;
import me.rotem.Essential.events.Events;
import me.rotem.Essential.events.IsSneaking;
import me.rotem.Essential.manager.PlayerInfo;
import org.bukkit.plugin.java.JavaPlugin;

public class Essential extends JavaPlugin
{
    private IsSneaking isSneaking;
    private PlayerInfo playerInfo;
    public void onEnable()
    {
        getCommand("feed").setExecutor(new Eat(this));
        getCommand("smite").setExecutor(new Smite(this));
        getCommand("gms").setExecutor(new Gms(this));
        getCommand("gmc").setExecutor(new Gmc(this));
        getCommand("heal").setExecutor(new Heal(this));
        getCommand("fly").setExecutor(new Fly(this));
        getServer().getPluginManager().registerEvents(new Events(this), this);
        getServer().getPluginManager().registerEvents(new IsSneaking(this), this);
        isSneaking = new IsSneaking(this);
        playerInfo = new PlayerInfo(this);
    }

    public IsSneaking getIsSneaking() {
        return isSneaking;
    }

    public PlayerInfo getPlayerInfo() {
        return playerInfo;
    }
}
