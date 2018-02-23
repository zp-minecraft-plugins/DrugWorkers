package me.zackpollard.drugworkers.listeners;

import java.util.logging.Logger;

import me.zackpollard.drugworkers.DrugWorkers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.SignChangeEvent;

public class WorkerProtection implements Listener{
	public static DrugWorkers plugin;
	public final Logger logger = Logger.getLogger("Minecraft");
	public WorkerProtection(DrugWorkers instance){
		plugin = instance;
		Bukkit.getServer().getPluginManager().registerEvents(this,instance);
	}
	@EventHandler(ignoreCancelled = true)
	public void onBlockBreak(BlockBreakEvent event){
		
		Block block = event.getBlock();
		Player player = event.getPlayer();
		String name = player.getName();
		if(name.length() > 15) name = name.substring(0,15);
		
		if(block.getType().equals(Material.CHEST)){
			
			if(block.getRelative(0, 1, 0).getType().equals(Material.WALL_SIGN)){
       			
       			Sign sign = (Sign) block.getRelative(0, 1, 0).getState();
       			
       			if(sign.getLine(0).equalsIgnoreCase("[Worker]")){
       				
       				if(sign.getLine(1).equals(name)){
       					
       					player.sendMessage(ChatColor.RED + "Type /worker remove to remove a worker");
       					
       					event.setCancelled(true);
       					
       					return;
       					
       				} else {
       					
       					if(!sign.getLine(1).equals(name)){
       						
       						player.sendMessage(ChatColor.RED + "You can't remove a worker that you don't own!");
       						
       						event.setCancelled(true);
       						
       						return;
       						
       					}
       				}
       			}
			}
		}
		
		if(block.getType().equals(Material.WALL_SIGN)){
			
			Sign sign = (Sign) event.getBlock().getState();
			
   			if(sign.getLine(0).equalsIgnoreCase("[Worker]")){
   				
   				if(sign.getLine(1).equals(name)){
   					
   					player.sendMessage(ChatColor.RED + "Type /worker remove to remove a worker");
   					
   					event.setCancelled(true);
   					
   					return;
   					
   				} else {
   					
   					if(!sign.getLine(1).equals(name)){
   						
   						player.sendMessage(ChatColor.RED + "You can't remove a worker that you don't own!");
   						
   						event.setCancelled(true);
   						
   						return;
   						
   					}
   				}
			}
		}
		
		if(block.getRelative(1, 0, 0).getType().equals(Material.WALL_SIGN)){
			
			Sign sign = (Sign) block.getRelative(1, 0, 0).getState();
			
   			if(sign.getLine(0).equalsIgnoreCase("[Worker]")){
   				
   				if(sign.getLine(1).equals(name)){
   					
   					player.sendMessage(ChatColor.RED + "Type /worker remove to remove a worker");
   					
   					event.setCancelled(true);
   					
   					return;
   					
   				} else {
   					
   					if(!sign.getLine(1).equals(name)){
   						
   						player.sendMessage(ChatColor.RED + "You can't remove a worker that you don't own!");
   						
   						event.setCancelled(true);
   						
   						return;
   						
   					}
   				}
				
			}
			
		}
		
		if(block.getRelative(-1, 0, 0).getType().equals(Material.WALL_SIGN)){
			
			Sign sign = (Sign) block.getRelative(-1, 0, 0).getState();
			
   			if(sign.getLine(0).equalsIgnoreCase("[Worker]")){
   				
   				if(sign.getLine(1).equals(name)){
   					
   					player.sendMessage(ChatColor.RED + "Type /worker remove to remove a worker");
   					
   					event.setCancelled(true);
   					
   					return;
   					
   				} else {
   					
   					if(!sign.getLine(1).equals(name)){
   						
   						player.sendMessage(ChatColor.RED + "You can't remove a worker that you don't own!");
   						
   						event.setCancelled(true);
   						
   						return;
   						
   					}
   				}
   			}
		}
		
		if(block.getRelative(0, 0, 1).getType().equals(Material.WALL_SIGN)){
			
			Sign sign = (Sign) block.getRelative(0, 0, 1).getState();
			
   			if(sign.getLine(0).equalsIgnoreCase("[Worker]")){
   				
   				if(sign.getLine(1).equals(name)){
   					
   					player.sendMessage(ChatColor.RED + "Type /worker remove to remove a worker");
   					
   					event.setCancelled(true);
   					
   					return;
   					
   				} else {
   					
   					if(!sign.getLine(1).equals(name)){
   						
   						player.sendMessage(ChatColor.RED + "You can't remove a worker that you don't own!");
   						
   						event.setCancelled(true);
   						
   						return;
   						
   					}
   				}
   			}
		}
		
		if(block.getRelative(0, 0, -1).getType().equals(Material.WALL_SIGN)){
			
			Sign sign = (Sign) block.getRelative(0, 0, -1).getState();
			
   			if(sign.getLine(0).equalsIgnoreCase("[Worker]")){
   				
   				if(sign.getLine(1).equals(name)){
   					
   					player.sendMessage(ChatColor.RED + "Type /worker remove to remove a worker");
   					
   					event.setCancelled(true);
   					
   					return;
   					
   				} else {
   					
   					if(!sign.getLine(1).equals(name)){
   						
   						player.sendMessage(ChatColor.RED + "You can't remove a worker that you don't own!");
   						
   						event.setCancelled(true);
   						
   						return;
   						
   					}
   				}
   			}
		}
	}
	
	@EventHandler(ignoreCancelled = true)
	public void onSignChange(SignChangeEvent event){
		
		Player player = event.getPlayer();
		
		if(event.getLine(0).equalsIgnoreCase("[Worker]")){
			
			player.sendMessage(ChatColor.RED + "Use /worker place to place a worker!");
				
			event.setCancelled(true);
			
		}
	}
}