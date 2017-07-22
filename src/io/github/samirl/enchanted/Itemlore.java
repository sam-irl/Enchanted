package io.github.samirl.enchanted;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class Itemlore implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("Only players can use this command");
			return false;
		}
		Player user = (Player) sender;
		if(args.length == 2) {
			ItemStack item = user.getInventory().getItemInMainHand();
			ItemMeta meta = item.getItemMeta();
			List<String> lore = meta.getLore();
			String name = meta.getDisplayName();
			String lore_stripped = args[1].replace('&', '\u00A7');
			String lore_final = lore_stripped.replace('^', '&');
			switch(args[0]) {
			case "1":
				lore.set(0, lore_final);
				break;
			case "2":
				lore.set(1, lore_final);
				break;
			default:
				user.sendMessage(ChatColor.RED + "Invalid lore line number, can be '1' or '2', got: " + args[0]);
				return false;
			}
			meta.setDisplayName(name);
			meta.setLore(lore);
			item.setItemMeta(meta);
		}
		if(args.length == 1) {
			if(args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("2")) {
				ItemStack item = user.getInventory().getItemInMainHand();
				ItemMeta meta = item.getItemMeta();
				List<String> lore = meta.getLore();
				String name = meta.getDisplayName();
				switch(args[0]) {
				case "1":
					lore.set(0, "");
					break;
				case "2":
					lore.set(1, "");
					break;
				}
				meta.setDisplayName(name);
				meta.setLore(lore);
				item.setItemMeta(meta);
				return true;
			} else {
				user.sendMessage(ChatColor.RED + "Invalid lore line number, can be '1' or '2', got: " + args[0]);
				return false;
			}
		}
		if(args.length == 0) {
			user.sendMessage(ChatColor.RED + "Invalid lore line number, can be '1' or '2', got:");
			return false;
		}
		if(args.length > 2) {
			user.sendMessage(ChatColor.RED + "Command should have 2 arguments, line number and Lore. Number of arguments recieved: " + args.length);
			return false;
		}
		return true;
	}

}
