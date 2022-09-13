package fr.arcane.boostpowder.commands;

import fr.arcane.boostpowder.Boostpowder;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GameLocCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player p = (Player) sender;
            Boostpowder.setMapConfigValue(p.getWorld().getName(), p.getLocation());
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2[BoostPowder] &6Point Set."));

        }

        return false;
    }
}
