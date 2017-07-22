package io.github.samirl.enchanted;

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
			ItemStack items = user.getInventory().getItemInMainHand();
			ItemMeta meta = items.getItemMeta();
			meta.setDisplayName(args[0]);
		} else {
			user.sendMessage("Please specify a name");
			return false;
		}
		return false;
	}

}
