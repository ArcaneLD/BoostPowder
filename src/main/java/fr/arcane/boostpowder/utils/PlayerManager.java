package fr.arcane.boostpowder.utils;

import fr.arcane.boostpowder.Boostpowder;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class PlayerManager {

    public static void SetPlayerInv(Player p) {

        if (Boostpowder.IsGameRunning) {

            ItemStack helmet = new ItemStack(Material.LEATHER_HELMET, 1);
            ItemMeta helmetM = helmet.getItemMeta();
            helmetM.setUnbreakable(true);
            helmetM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
            helmet.setItemMeta(helmetM);

            ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
            ItemMeta chestM = chest.getItemMeta();
            chestM.setUnbreakable(true);
            chestM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
            chest.setItemMeta(chestM);

            ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
            ItemMeta leggingsM = leggings.getItemMeta();
            leggingsM.setUnbreakable(true);
            leggingsM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
            leggings.setItemMeta(leggingsM);

            ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
            ItemMeta bootsM = boots.getItemMeta();
            bootsM.setUnbreakable(true);
            bootsM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
            boots.setItemMeta(bootsM);


            p.getInventory().setHelmet(helmet);
            p.getInventory().setChestplate(chest);
            p.getInventory().setLeggings(leggings);
            p.getInventory().setBoots(boots);


            ItemStack defense = new ItemStack(Material.SUGAR, 1);
            ItemMeta defenseM = defense.getItemMeta();
            defenseM.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lDéfense"));
            defenseM.addEnchant(Enchantment.DURABILITY, 1, true);
            defenseM.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
            defense.setItemMeta(defenseM);

            ItemStack attaque = new ItemStack(Material.SUGAR, 1);
            ItemMeta attaqueM = attaque.getItemMeta();
            attaqueM.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&4&lAttaque"));
            attaqueM.addEnchant(Enchantment.DURABILITY, 1, true);
            attaque.setItemMeta(attaqueM);

            ItemStack vitesse = new ItemStack(Material.SUGAR, 1);
            ItemMeta vitesseM = vitesse.getItemMeta();
            vitesseM.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&e&lVitesse"));
            vitesseM.addEnchant(Enchantment.DURABILITY, 1, true);
            vitesseM.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
            vitesse.setItemMeta(vitesseM);

            p.getInventory().setItem(0, defense);
            p.getInventory().setItem(1, attaque);
            p.getInventory().setItem(2, vitesse);

            ItemStack shop = new ItemStack(Material.NETHER_STAR, 1);
            ItemMeta shopM = shop.getItemMeta();
            shopM.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&1&lShop"));
            shopM.addEnchant(Enchantment.DURABILITY, 1, true);
            shop.setItemMeta(shopM);

            p.getInventory().setItem(8, shop);

        }

    }

    public static ItemStack ItemBuilder(Material m, int count , int points) {
        ItemStack i = new ItemStack(m, count);
        ItemMeta iM = i.getItemMeta();
        List<String> lore = new ArrayList<>();
        lore.add(org.bukkit.ChatColor.translateAlternateColorCodes('&', "&6&lPrix : " + points + " points"));
        iM.setLore(lore);
        i.setItemMeta(iM);

        return i;
    }

}
