package io.github.samirl.enchanted;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

public class Overenchant implements CommandExecutor {
	private Enchantment enchant;

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String args[]) {
		boolean isValid;
		int level;
		if(args.length == 0) {
			return false;
		}
		if(!(sender instanceof Player)) {
			sender.sendMessage("Must be a player.");
			return false;
		}
		Player user = ((Player) sender);
		if(((Player) user).getInventory().getItemInMainHand().equals(null)) {
			user.sendMessage("You can't enchant air.");
			return false;
		}
		if(args[0].equalsIgnoreCase("list")) {
			user.sendMessage("A list of valid names for enchantments may be found at this website:");
			user.sendMessage("https://gist.github.com/sam-irl/0c51754461e75f29c918a472320cd784");
			return true;
		}
		if(args.length == 1) {
			sender.sendMessage("Please specify a level");
			return false;
		}
		isValid = true;
		switch(args[0].toLowerCase()) {
		case "arrowdamage":
		case "power":
			enchant = Enchantment.ARROW_DAMAGE;
			break;
		case "arrowfire":
		case "firearrow":
		case "flame":
			enchant = Enchantment.ARROW_FIRE;
			break;
		case "arrowknockback":
		case "arrowkb":
		case "punch":
			enchant = Enchantment.ARROW_KNOCKBACK;
			break;
		case "infinitearrow":
		case "infinitearrows":
		case "infinityarrow":
		case "arrowinfinity":
		case "infinity":
			enchant = Enchantment.ARROW_INFINITE;
			break;
		case "alldamage":
		case "damageall":
		case "sharpness":
		case "sharp":
			enchant = Enchantment.DAMAGE_ALL;
			break;
		case "arthopods":
		case "arthopod":
		case "baneofarthopods":
		case "baneofarthopod":
		case "bane":
			enchant = Enchantment.DAMAGE_ARTHROPODS;
			break;
		case "undeaddamage":
		case "undead":
		case "smite":
			enchant = Enchantment.DAMAGE_UNDEAD;
			break;
		case "digspeed":
		case "dig":
		case "efficiency":
			enchant = Enchantment.DIG_SPEED;
			break;
		case "durability":
		case "dura":
		case "unbreaking":
		case "unbreak":
			enchant = Enchantment.DURABILITY;
			break;
		case "fireaspect":
		case "fire":
			enchant = Enchantment.FIRE_ASPECT;
			break;
		case "knockback":
		case "kb":
		case "woosh":
			enchant = Enchantment.KNOCKBACK;
			break;
		case "blockslootbonus":
		case "blocklootbonus":
		case "blocksloot":
		case "blockloot":
		case "fortune":
			enchant = Enchantment.LOOT_BONUS_BLOCKS;
			break;
		case "mobslootbonus":
		case "moblootbonus":
		case "mobsloot":
		case "mobloot":
		case "looting":
			enchant = Enchantment.LOOT_BONUS_MOBS;
			break;
		case "oxygen":
		case "respiration":
		case "breathing":
		case "respire":
			enchant = Enchantment.OXYGEN;
			break;
		case "protection":
		case "protect":
			enchant = Enchantment.PROTECTION_ENVIRONMENTAL;
			break;
		case "explosionprotection":
		case "explosionprotect":
		case "blastprotect":
		case "blastprotection":
			enchant = Enchantment.PROTECTION_EXPLOSIONS;
			break;
		case "fallprotection":
		case "fallprotect":
		case "featherfall":
		case "featherfalling":
			enchant = Enchantment.PROTECTION_FALL;
			break;
		case "fireprotection":
		case "fireprotect":
			enchant = Enchantment.PROTECTION_FIRE;
			break;
		case "projectileprotect":
		case "projprotect":
		case "projprotection":
		case "projectileprotection":
			enchant = Enchantment.PROTECTION_PROJECTILE;
			break;
		case "silktouch":
			enchant = Enchantment.SILK_TOUCH;
			break;
		case "waterworker":
		case "aquaaffinity":
		case "aqua":
		case "waterspeed":
			enchant = Enchantment.WATER_WORKER;
			break;
		case "frostwalker":
		case "frostwalk":
		case "icewalker":
		case "icewalk":
			enchant = Enchantment.FROST_WALKER;
			break;
		case "luck":
		case "lucky":
			enchant = Enchantment.LUCK;
			break;
		case "lure":
			enchant = Enchantment.LURE;
			break;
		case "mending":
		case "repair":
			enchant = Enchantment.MENDING;
			break;
		case "sweepingedge":
		case "sweepedge":
		case "sweeping":
		case "sweep":
		case "swoosh":
			enchant = Enchantment.SWEEPING_EDGE;
			break;
		case "thorns":
		case "ouch":
			enchant = Enchantment.THORNS;
			break;
		case "vanishing":
		case "vanish":
			enchant = Enchantment.VANISHING_CURSE;
			break;
		case "binding":
		case "bind":
			enchant = Enchantment.BINDING_CURSE;
			break;
		default:			
			isValid = false;			
		}
		if(args[1].equalsIgnoreCase("clear") || args[1].equalsIgnoreCase("remove")) {
			user.getInventory().getItemInMainHand().removeEnchantment(enchant);
			return true;
		} else {
			level = Integer.parseInt(args[1]);
		}
		if(!isValid) {
			user.sendMessage("That's not an enchantment, see /overenchant list for valid options");
			return false;
		}
		if(level > 127 || level < 1) {
			user.sendMessage("Invalid enchantment level, must be between 1 and 127");
			return false;
		}
		((Player) user).getInventory().getItemInMainHand().addUnsafeEnchantment(enchant, level);
		return true;
	}

}
