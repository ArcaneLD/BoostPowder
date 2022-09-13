package fr.arcane.boostpowder.events;

import fr.arcane.boostpowder.Boostpowder;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;

public class HeldItemEvent implements Listener {

    @EventHandler
    public void onItemHeld(PlayerItemHeldEvent e) {
        if (Boostpowder.IsGameRunning) {

            Player p = e.getPlayer();

            int newslot = e.getNewSlot();

            ItemStack newitem = e.getPlayer().getInventory().getItem(newslot);

            if (Objects.requireNonNull(newitem).getType() == Material.SUGAR) {
                    if (Objects.requireNonNull(newitem.getItemMeta()).getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&a&lDéfense"))) {

                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2[BoostPowder] &6Tu as séléctionné la &l&aDéfense"));

                        new BukkitRunnable() {

                            @Override
                            public void run() {
                                if (Objects.requireNonNull(p.getItemInHand().getItemMeta()).getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&a&lDéfense"))) {
                                    p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 60, 3));
                                    p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 60, 2));
                                } else {
                                    p.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
                                    p.removePotionEffect(PotionEffectType.SLOW);
                                    this.cancel();
                                }

                            }
                        }.runTaskTimer(Boostpowder.plugin, 0L, 10L);


                    } else if (Objects.requireNonNull(newitem.getItemMeta()).getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&4&lAttaque"))) {


                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2[BoostPowder] &6Tu as séléctionné l'&4&lAttaque"));

                        new BukkitRunnable() {

                            @Override
                            public void run() {
                                if (Objects.requireNonNull(p.getItemInHand().getItemMeta()).getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&4&lAttaque"))) {
                                    p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 60, 1));

                                } else {
                                    p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
                                    this.cancel();
                                }

                            }
                        }.runTaskTimer(Boostpowder.plugin, 0L, 10L);


                    } else if (Objects.requireNonNull(newitem.getItemMeta()).getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&e&lVitesse"))) {


                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2[BoostPowder] &6Tu as séléctionné la &e&lVitesse"));

                        new BukkitRunnable() {

                            @Override
                            public void run() {
                                if (Objects.requireNonNull(p.getItemInHand().getItemMeta()).getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&e&lVitesse"))) {
                                    p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 60, 5));

                                } else {
                                    p.removePotionEffect(PotionEffectType.SPEED);
                                    this.cancel();
                                }

                            }
                        }.runTaskTimer(Boostpowder.plugin, 0L, 10L);


                    }
                }

        }

    }
}
