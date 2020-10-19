package me.rotem.duels.Manegers;

import me.rotem.duels.DuelsMain;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;


import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ConfigManeger {
    private DuelsMain pl;
    private FileConfiguration pointsConfig;
    private File pointsFile;

    public ConfigManeger(DuelsMain pl) {
        this.pl = pl;
    }

    public void setUp() {
        if (!pl.getDataFolder().exists()) {
            pl.getDataFolder().mkdir();
        }
        pointsFile = new File(pl.getDataFolder(), "pointsFile.yml");
        if (!pointsFile.exists()) {
            try {
                pointsFile.createNewFile();
            } catch (IOException e) {
                Bukkit.getServer().getConsoleSender().sendMessage(Color.RED + "could not create file");
            }
        }
        pointsConfig = YamlConfiguration.loadConfiguration(pointsFile);
        Bukkit.getServer().getConsoleSender().sendMessage(Color.green + "File has been created");
    }

    public FileConfiguration getPoints() {
        return pointsConfig;
    }

    public void saveData() {
        System.out.println("mega boi");
        try {
            pointsConfig.save(pointsFile);
            System.out.println("boi25");
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "nice bobs");
        } catch (IOException e) {
            Bukkit.getServer().getConsoleSender().sendMessage(Color.green + "error while saving");
            System.out.println("boi");
        }
    }
}
