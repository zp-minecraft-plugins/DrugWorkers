package me.zackpollard.drugworkers.listeners;

import java.util.logging.Logger;

import me.zackpollard.drugworkers.DrugWorkers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class WorkerPlace implements Listener{
	public static DrugWorkers plugin;
	public final Logger logger = Logger.getLogger("Minecraft");
	public WorkerPlace(DrugWorkers instance){
		plugin = instance;
		Bukkit.getServer().getPluginManager().registerEvents(this,instance);
	}
	@EventHandler(ignoreCancelled = true)
	public void onPlayerInteract(PlayerInteractEvent event){
		
		Block block = event.getClickedBlock();
		Player player = event.getPlayer();
		String name = player.getName();
		String signname = player.getName();
		if(name.length() > 15) signname = name.substring(0,15);
		
		if(block.getType().equals(Material.WALL_SIGN)){
			
			Sign sign = (Sign) block.getState();
		
			if(plugin.placeWorker.contains(name)){
				
				if(!sign.getLine(1).equals("[Worker]")){
					
					if(block.getRelative(0, -1, 0).getType().equals(Material.CHEST)){
						
						Integer x = block.getX();
						Integer y = block.getY();
						Integer z = block.getZ();
						World world = block.getWorld();
						
						plugin.workersStore.add(x, y, z, world);
						
						plugin.workersStore.save();
						
						sign.setLine(0, "[Worker]");
						sign.setLine(1, signname);
						sign.setLine(2, "Tier 1");
						
						sign.update(true);
						
						plugin.placeWorker.remove(name);
						
					} else {
						
						if(!block.getRelative(0, -1, 0).getType().equals(Material.CHEST)){
							
							plugin.accountsStore.refund(name);
							
							player.sendMessage(ChatColor.RED + "You can't add a worker if there is no chest below the sign!");
							
						}
						
					}
					
				} else {
					
					if(sign.getLine(1).equals("[Worker]")){
						
						plugin.accountsStore.refund(name);
						
						player.sendMessage(ChatColor.RED + "You can't add a worker where one already exists!");
						
						return;
						
					}
				}
			}
		}
	}
}