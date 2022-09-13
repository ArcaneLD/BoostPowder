package fr.arcane.boostpowder.commands;

import fr.arcane.boostpowder.Boostpowder;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamePointCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player p = (Player) sender;
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2[BoostPowder] &6Ton nombre de points est de : " + Boostpowder.playerkills.get(p)));

        }

        return false;
    }
}
