package fr.arcane.boostpowder.commands;

import fr.arcane.boostpowder.Boostpowder;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetGamePointCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!args[0].isEmpty()) {
            Player p = Boostpowder.plugin.getServer().getPlayer(args[0]);
            if (!args[1].isEmpty()) {
                int points = Integer.parseInt(args[1]);
                Boostpowder.playerkills.put(p, points);
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2[BoostPowder] &6" + p.getName() + " a désormais " + points + " points !"));
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4Bad Syntaxe"));
            }
        } else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4Bad Syntaxe"));
        }


        return false;
    }
}
