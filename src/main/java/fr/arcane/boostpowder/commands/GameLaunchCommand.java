package fr.arcane.boostpowder.commands;

import fr.arcane.boostpowder.Boostpowder;
import fr.arcane.boostpowder.utils.PlayerManager;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class GameLaunchCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!Boostpowder.IsGameRunning) {
            Boostpowder.plugin.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&2[BoostPowder] &6Game Lancée !"));
            Boostpowder.setGameRunning(true);

            for (Player p : Boostpowder.plugin.getServer().getOnlinePlayers()) {
                p.getInventory().clear();
                PlayerManager.SetPlayerInv(p);
                p.setGameMode(GameMode.SURVIVAL);
                Boostpowder.playerloc.put(p, p.getLocation());

                p.teleport(Boostpowder.getMapConfigValue(p.getWorld()));
                p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 200, 200));
                p.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 900000, 9));
                p.setFoodLevel(20);
                p.setHealth(20);

            }


        } else {
            Boostpowder.plugin.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&2[BoostPowder] &6Game Arrétée !"));
            Boostpowder.setGameRunning(false);

            for (Player p : Boostpowder.plugin.getServer().getOnlinePlayers()) {
                p.getInventory().clear();
                p.setGameMode(GameMode.CREATIVE);
                p.teleport(Boostpowder.playerloc.get(p));
                Boostpowder.playerloc.remove(p);
                p.removePotionEffect(PotionEffectType.SATURATION);
            }
        }



        return false;
    }
}
