package fr.arcane.boostpowder.events;

import fr.arcane.boostpowder.Boostpowder;
import fr.arcane.boostpowder.utils.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ShopEvent implements Listener {

    @EventHandler
    public void onShopRightClick(PlayerInteractEvent e) {
        if (Boostpowder.IsGameRunning) {
            Player p = e.getPlayer();
            if (p.getItemInHand().getType() == Material.NETHER_STAR) {
                Inventory inv = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', "&1Shop"));

                inv.setItem(4, new ItemStack(Material.BARRIER));




                inv.setItem(11, PlayerManager.ItemBuilder(Material.IRON_AXE, 1, 4));
                inv.setItem(15, PlayerManager.ItemBuilder(Material.BEDROCK, 1, 20));

                inv.setItem(19, PlayerManager.ItemBuilder(Material.STONE_PICKAXE, 1, 4));
                inv.setItem(20, PlayerManager.ItemBuilder(Material.IRON_PICKAXE, 1, 6));
                inv.setItem(21, PlayerManager.ItemBuilder(Material.NETHERITE_PICKAXE, 1, 10));
                inv.setItem(23, PlayerManager.ItemBuilder(Material.WHITE_WOOL, 32, 2));
                inv.setItem(24, PlayerManager.ItemBuilder(Material.OAK_PLANKS, 16, 5));
                inv.setItem(25, PlayerManager.ItemBuilder(Material.OBSIDIAN, 4, 10));

                inv.setItem(38, PlayerManager.ItemBuilder(Material.ARROW, 8, 4));
                inv.setItem(42, PlayerManager.ItemBuilder(Material.WATER_BUCKET, 1, 6));

                inv.setItem(42, PlayerManager.ItemBuilder(Material.EGG, 16, 2));
                inv.setItem(42, PlayerManager.ItemBuilder(Material.SNOWBALL, 8, 6));
                inv.setItem(42, PlayerManager.ItemBuilder(Material.BOW, 1, 8));
                inv.setItem(42, PlayerManager.ItemBuilder(Material.LAVA_BUCKET, 1, 6));
                inv.setItem(42, PlayerManager.ItemBuilder(Material.FLINT_AND_STEEL, 1, 8));
                inv.setItem(42, PlayerManager.ItemBuilder(Material.FIRE_CHARGE, 1, 1));

                p.openInventory(inv);



            }
        }
    }

    @EventHandler
    public void onInteract(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (p.getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&1Shop"))) {
            if (Boostpowder.IsGameRunning) {
                e.setCancelled(true);
                ItemStack i = e.getCurrentItem();
                int points = Boostpowder.playerkills.get(p);
                if (i.getType() == Material.BARRIER) {
                    p.closeInventory();
                }
                if (i.getType() == Material.IRON_AXE && points >= 4) {
                    Boostpowder.playerkills.put(p, Boostpowder.playerkills.get(p) - 4);
                    p.getInventory().addItem(i);
                }
                if (i.getType() == Material.STONE_PICKAXE && points >= 4) {
                    Boostpowder.playerkills.put(p, Boostpowder.playerkills.get(p) - 4);
                    p.getInventory().addItem(i);
                }
                if (i.getType() == Material.IRON_PICKAXE && points >= 6) {
                    Boostpowder.playerkills.put(p, Boostpowder.playerkills.get(p) - 6);
                    p.getInventory().addItem(i);
                }
                if (i.getType() == Material.NETHERITE_PICKAXE && points >= 10) {
                    Boostpowder.playerkills.put(p, Boostpowder.playerkills.get(p) - 10);
                    p.getInventory().addItem(i);
                }


                if (i.getType() == Material.BEDROCK && points >= 20) {
                    Boostpowder.playerkills.put(p, Boostpowder.playerkills.get(p) - 20);
                    p.getInventory().addItem(i);
                }
                if (i.getType() == Material.WHITE_WOOL && points >= 2) {
                    Boostpowder.playerkills.put(p, Boostpowder.playerkills.get(p) - 2);
                    p.getInventory().addItem(i);
                }
                if (i.getType() == Material.OAK_PLANKS && points >= 5) {
                    Boostpowder.playerkills.put(p, Boostpowder.playerkills.get(p) - 5);
                    p.getInventory().addItem(i);
                }
                if (i.getType() == Material.OBSIDIAN && points >= 10) {
                    Boostpowder.playerkills.put(p, Boostpowder.playerkills.get(p) - 10);
                    p.getInventory().addItem(i);
                }


                if (i.getType() == Material.ARROW && points >= 4) {
                    Boostpowder.playerkills.put(p, Boostpowder.playerkills.get(p) - 4);
                    p.getInventory().addItem(i);
                }
                if (i.getType() == Material.EGG && points >= 2) {
                    Boostpowder.playerkills.put(p, Boostpowder.playerkills.get(p) - 2);
                    p.getInventory().addItem(i);
                }
                if (i.getType() == Material.SNOWBALL && points >= 6) {
                    Boostpowder.playerkills.put(p, Boostpowder.playerkills.get(p) - 6);
                    p.getInventory().addItem(i);
                }
                if (i.getType() == Material.BOW && points >= 8) {
                    Boostpowder.playerkills.put(p, Boostpowder.playerkills.get(p) - 8);
                    p.getInventory().addItem(i);
                }

                if (i.getType() == Material.WATER_BUCKET && points >= 6) {
                    Boostpowder.playerkills.put(p, Boostpowder.playerkills.get(p) - 6);
                    p.getInventory().addItem(i);
                }
                if (i.getType() == Material.LAVA_BUCKET && points >= 6) {
                    Boostpowder.playerkills.put(p, Boostpowder.playerkills.get(p) - 6);
                    p.getInventory().addItem(i);
                }
                if (i.getType() == Material.FLINT_AND_STEEL && points >= 8) {
                    Boostpowder.playerkills.put(p, Boostpowder.playerkills.get(p) - 8);
                    p.getInventory().addItem(i);
                }
                if (i.getType() == Material.FIRE_CHARGE && points >= 1) {
                    Boostpowder.playerkills.put(p, Boostpowder.playerkills.get(p) - 1);
                    p.getInventory().addItem(i);
                }
            }
        }



    }
}
