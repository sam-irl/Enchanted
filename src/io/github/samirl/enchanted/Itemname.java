package io.github.samirl.enchanted;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Itemname implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String args[]) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("Must be a player to use this command");
			return false;
		}
		Player user = ((Player) sender);
		if(args.length > 0) {
			String name_stripped = args[0].replace('&', '\u00A7');
			String name = name_stripped.replace('^', '&');
			ItemStack items = user.getInventory().getItemInMainHand();
			ItemMeta meta = items.getItemMeta();
			List<String> lore = meta.getLore();
			meta.setDisplayName(name);
			meta.setLore(lore);
			items.setItemMeta(meta);
		} else {
			ItemStack items = user.getInventory().getItemInMainHand();
			ItemMeta meta = items.getItemMeta();
			List<String> lore = meta.getLore();
			meta.setDisplayName("");
			meta.setLore(lore);
			items.setItemMeta(meta);
		}
		return false;
	}

}
