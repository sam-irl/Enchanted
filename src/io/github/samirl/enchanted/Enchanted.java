package io.github.samirl.enchanted;

import org.bukkit.plugin.java.JavaPlugin;

public class Enchanted extends JavaPlugin {
	@Override
	public void onEnable() {
		this.getCommand("overenchant").setExecutor(new Overenchant());
		this.getCommand("itemname").setExecutor(new Itemname());
		this.getCommand("itemlore").setExecutor(new Itemlore());
	}
	@Override
	public void onDisable() {
		
	}

}
