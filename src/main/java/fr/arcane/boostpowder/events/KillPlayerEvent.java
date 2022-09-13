package fr.arcane.boostpowder.events;

import fr.arcane.boostpowder.Boostpowder;
import fr.arcane.boostpowder.utils.PlayerManager;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class KillPlayerEvent implements Listener {

    @EventHandler
    public void OnKillPlayer(PlayerDeathEvent e) {

        if (Boostpowder.IsGameRunning) {
            if (e.getEntity().getType() == EntityType.PLAYER) {
                Player p = e.getEntity().getKiller();
                if (Boostpowder.playerkills.containsKey(p)) {
                    Boostpowder.playerkills.put(p, Boostpowder.playerkills.get(p) + 1);
                }

                e.getDrops().clear();

                Player entity = e.getEntity();
                entity.getInventory().clear();
                entity.setGameMode(GameMode.SPECTATOR);
                entity.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2[BoostPowder] &6Tu vas respawn dans 10 secondes :("));
                new BukkitRunnable() {

                    @Override
                    public void run() {

                        entity.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2[BoostPowder] &6Tu as Respawn"));
                        entity.teleport(Boostpowder.getMapConfigValue(entity.getWorld()));
                        entity.setGameMode(GameMode.SURVIVAL);
                        entity.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 200));
                        entity.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 9999999, 200));
                        PlayerManager.SetPlayerInv(entity);

                    }
                }.runTaskLater(Boostpowder.plugin, 200L);

            }

        }
    }

    @EventHandler
    public void cancelRegen(EntityRegainHealthEvent e) {
        if (e.getEntity().getType() == EntityType.PLAYER) {
            if (e.getRegainReason() == EntityRegainHealthEvent.RegainReason.SATIATED) {
                if (Boostpowder.IsGameRunning) {
                    e.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void blockAutoBreak(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if (p.getGameMode() == GameMode.SURVIVAL && Boostpowder.IsGameRunning) {
            new BukkitRunnable() {

                @Override
                public void run() {
                    e.getBlock().breakNaturally();
                }
            }.runTaskLater(Boostpowder.plugin, 1200L);
        }
    }

    @EventHandler
    public void blockAutoReplace(BlockBreakEvent e) {
        if (Boostpowder.IsGameRunning && e.getPlayer().getGameMode() == GameMode.SURVIVAL) {
            Material bm = e.getBlock().getType();
            Block b = e.getBlock();

            new BukkitRunnable() {

                @Override
                public void run() {
                    b.setType(bm);

                }
            }.runTaskLater(Boostpowder.plugin, 1200L);

        }
    }
}
