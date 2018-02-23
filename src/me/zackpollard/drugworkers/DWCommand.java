package me.zackpollard.drugworkers;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DWCommand implements CommandExecutor {
	DrugWorkers plugin;
	public DWCommand(DrugWorkers plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(args.length == 0){
			sender.sendMessage(ChatColor.RED + "Incorrect usage!");
			CMDHelp(sender);
			return true;
		}
		if(args.length == 1 && args[0].equalsIgnoreCase("help")){
			CMDHelp(sender);
			return true;
		}
		if(args.length == 1 && args[0].equalsIgnoreCase("place")){
			
			plugin.placeWorker.add(sender.getName().toString());
			
			sender.sendMessage("Please punch the sign where you would like your worker");
			
			
			
			return true;
		}
		if(args.length == 1 && args[0].equalsIgnoreCase("upgrade")){
			return true;
		}
		if(args.length == 1 && args[0].equalsIgnoreCase("prices")){
			return true;
		}
		/*
		if(args.length == 1 && args[0].equalsIgnoreCase("list")){
		}
		if(args.length == 2 && args[0].equalsIgnoreCase("create")){	
		}
		if(args.length == 2 && args[0].equalsIgnoreCase("cancel")){
		}
		if(args.length == 2 && args[0].equalsIgnoreCase("join")){
		}
		*/
		sender.sendMessage(ChatColor.RED + "Incorrect Usage!");
		CMDHelp(sender);
		
		return true;
	}
	
	private void CMDHelp(CommandSender sender){
		
		sender.sendMessage(ChatColor.GOLD + "############ DrugsWorker Help ############");
		sender.sendMessage(ChatColor.AQUA + "/workers purchase    " + ChatColor.DARK_AQUA + "Purchase a Tier 1 Worker");
		sender.sendMessage(ChatColor.AQUA + "/workers upgrade     " + ChatColor.DARK_AQUA + "Upgrade your current worker to the next tier");
		sender.sendMessage(ChatColor.AQUA + "/workers prices      " + ChatColor.DARK_AQUA + "View prices to purchase/upgrade workers");
		
	}

}
