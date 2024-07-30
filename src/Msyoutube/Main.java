package Msyoutube;

import java.io.File;
import java.util.stream.Collectors;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		ConsoleCommandSender b = Bukkit.getConsoleSender();
		b.sendMessage("§8=-=-=-=-=-=-=-=-=-=-=-=-=-==-");
		b.sendMessage("§7Versao:7-a1.0");
		b.sendMessage("§7Autor: §9yurirp4");
		b.sendMessage("§bSkype: Filipe Silva amy");
		b.sendMessage("§7stats Do Plugin: §aAtivo");
		b.sendMessage("§8=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		if (!new File(getDataFolder(), "config.yml").exists()) {
			saveDefaultConfig();
		}
	}

	@Override
	public void onDisable() {
		ConsoleCommandSender b = Bukkit.getConsoleSender();
		b.sendMessage("§8=-=-=-=-=-=-=-=-=-=-=-=-=-==-");
		b.sendMessage("§7Versao:§a1.0");
		b.sendMessage("§7Autor: §9yurirp4");
		b.sendMessage("§bSkype: Filipe Silva amy");
		b.sendMessage("§7stats Do Plugin: §cDesativo");
		b.sendMessage("§8=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player p = (Player) sender;
		if (command.getName().equalsIgnoreCase("youtuber")) {
			Inventory inv = Bukkit.createInventory(null, 9, "§cYoutuber");
			ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 4);
			ItemStack y = new ItemStack(Material.FIREBALL);
			ItemStack vidro2 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 1);
			ItemStack vidro3 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 3);
			ItemStack vidro4 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
			ItemStack vidro5 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 1);
			ItemMeta ymeta = y.getItemMeta();
			ymeta.setDisplayName("§cYoutuber");
			ymeta.setLore(
				    getConfig().getStringList("Lore")
				        .stream()
				        .map(string -> string.replaceAll("&", "§"))
				        .collect(Collectors.toList()));
			y.setItemMeta(ymeta);
			inv.setItem(0, vidro3);
			inv.setItem(1, vidro2);
			inv.setItem(2, vidro);
			inv.setItem(3, vidro4);
			inv.setItem(4, y);
			inv.setItem(5, vidro4);
			inv.setItem(6, vidro3);
			inv.setItem(7, vidro);
			inv.setItem(8, vidro5);

			p.openInventory(inv);
			p.playSound(p.getLocation(), Sound.ANVIL_USE, 5f, 5f);
		}

		return false;
	}
	@EventHandler
	public void click(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		 if (e.getInventory().getTitle().equals("§cYoutuber"))
		    e.setCancelled(true);
		    if (e.getCurrentItem().getType() == Material.FIREBALL) {
		    	p.sendMessage("§a§m<---------------->");
		    	for(int i = 0; i<getConfig().getStringList("Youtuber").size(); i++)
		    	p.sendMessage(getConfig().getStringList("Youtuber").get(i).replace("&", "§"));
		    	p.sendMessage("§a§m<---------------->");
				p.closeInventory();
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.f, 5.f);
			}
		}
	}