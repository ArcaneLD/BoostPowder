package fr.arcane.boostpowder;

import fr.arcane.boostpowder.commands.GameLaunchCommand;
import fr.arcane.boostpowder.commands.GameLocCommand;
import fr.arcane.boostpowder.commands.GamePointCommand;
import fr.arcane.boostpowder.commands.SetGamePointCommand;
import fr.arcane.boostpowder.events.HeldItemEvent;
import fr.arcane.boostpowder.events.KillPlayerEvent;
import fr.arcane.boostpowder.events.ShopEvent;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class Boostpowder extends JavaPlugin {

    public static Boostpowder plugin;
    public static boolean IsGameRunning = false;

    public static HashMap<Player, Location> playerloc = new HashMap<>();
    public static HashMap<Player, Integer> playerkills = new HashMap<>();

    @Override
    public void onEnable() {

        loadconfig();
        plugin = this;
        getServer().getPluginManager().registerEvents(new HeldItemEvent(), this);
        getServer().getPluginManager().registerEvents(new KillPlayerEvent(), this);
        getServer().getPluginManager().registerEvents(new ShopEvent(), this);

        this.getCommand("gamelaunch").setExecutor(new GameLaunchCommand());
        this.getCommand("setgameloc").setExecutor(new GameLocCommand());
        this.getCommand("gamepoint").setExecutor(new GamePointCommand());
        this.getCommand("setplayerpoint").setExecutor(new SetGamePointCommand());

        System.out.println("[Boostpowder] Enabled");

    }

    @Override
    public void onDisable() {
        System.out.println("[Boostpowder] Disabled");
    }

    public void loadconfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
    public static void setMapConfigValue(String Map, Location coords) {
        plugin.getConfig().set(Map + ".loc.world", coords.getWorld().getName());
        plugin.getConfig().set(Map + ".loc.x", coords.getX());
        plugin.getConfig().set(Map + ".loc.y", coords.getY());
        plugin.getConfig().set(Map + ".loc.z", coords.getZ()); // construction de la loc
        plugin.saveConfig(); //save
    }
    public static Location getMapConfigValue(World world) {
        Location loc;
        String Map = world.getName();

        double x = plugin.getConfig().getDouble(Map + ".loc.x");
        double y = plugin.getConfig().getDouble(Map + ".loc.y");
        double z = plugin.getConfig().getDouble(Map + ".loc.z"); // recuperation de la loc depuis la config

        loc = new Location(world, x,y,z);

        return loc;
    }

    public static void setGameRunning(boolean value) {
        IsGameRunning = value;
    }


}
