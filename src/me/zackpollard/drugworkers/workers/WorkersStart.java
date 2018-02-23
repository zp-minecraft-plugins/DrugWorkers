package me.zackpollard.drugworkers.workers;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.block.Sign;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Crops;

import me.zackpollard.drugworkers.DrugWorkers;

public class WorkersStart implements Runnable{
	
	private DrugWorkers plugin;
	private Integer i = 0;
	
	public WorkersStart(DrugWorkers plugin){
		this.plugin = plugin;
	}
	
	public void run(){
		
		Bukkit.broadcastMessage("Farmers Have Tried To Work");
		
		for(String worker : plugin.workersStore.getValues()){
			
			String[] split = worker.split(":");
			
			Integer x = Integer.parseInt(split[0]);
			Integer y = Integer.parseInt(split[1]);
			Integer z = Integer.parseInt(split[2]);
			World world = Bukkit.getWorld(split[3]);
			Block block = world.getBlockAt(x, y, z);
			
			Bukkit.broadcastMessage("Farmer tried to work at X" + x + " Y" + y + " Z" + z + "at World " + world);
			
			Sign sign = (Sign) null;
			
			if(block.getType().equals(Material.WALL_SIGN)){
				
				sign = (Sign) block.getState();
				
			} else {
				
				if(!block.getType().equals(Material.WALL_SIGN)){
					
					continue;
					
				}
			}
			
			if(sign != null){
				
				Bukkit.broadcastMessage("11");
				
				String line1 = sign.getLine(0);
				String line3 = sign.getLine(2);
				
				if(line1.equals("[Worker]") && line3.equals("Tier 1")){
					
					Bukkit.broadcastMessage("12");
					
					if(sign.getBlock().getRelative(0, -1, 0).getType().equals(Material.CHEST)){
						
						Bukkit.broadcastMessage("13");
						
						Block chestblock = block.getRelative(0, -1, 0);
						
						Chest chest = (Chest) chestblock.getState();
						
						Bukkit.broadcastMessage("10");
						if(chestblock.getData() == 2){ //Chest is facing north
							
							Bukkit.broadcastMessage("1");
							
							for (i = -1; i >= -5; i--){
								
								Block crop = chestblock.getRelative(0, 0, i);
								
								Bukkit.broadcastMessage("2");
								
								Bukkit.broadcastMessage(crop.getType().toString());
								
								if(crop.getType().equals(Material.CROPS)){
									
									Bukkit.broadcastMessage("2b");
									
									Crops crops = (Crops) crop.getState();
									
									Bukkit.broadcastMessage("Crop type" + crops.getItemType().toString());
									
									if(crops.getItemType().equals(Material.WHEAT)){
									
										Bukkit.broadcastMessage("3");
										
										crop.setType(Material.AIR);
										
										Bukkit.broadcastMessage("4");
											
											ItemStack itemstack = new ItemStack(Material.WHEAT, 1);
											
											Bukkit.broadcastMessage("5");
											
											chest.getInventory().addItem(itemstack);
											
											Bukkit.broadcastMessage("6");
											
											continue;
											
									}
									
									if(crop.getType().equals(Material.BROWN_MUSHROOM)){
										
										crop.setType(Material.AIR);
										
										ItemStack itemstack = new ItemStack(Material.BROWN_MUSHROOM, 1);
										
										chest.getInventory().addItem(itemstack);
										
									}
								}
							}
						}
						
						if(chestblock.getData() == 3){ //Chest is facing south
							
							Bukkit.broadcastMessage("7");
							
						}
						
						if(chestblock.getData() == 4){ //Chest is facing west
							
							Bukkit.broadcastMessage("8");
							
						}
						
						if(chestblock.getData() == 5){ //Chest is facing east
							
							Bukkit.broadcastMessage("8");
							
						}
					}
				}
			}
		}
	}
}