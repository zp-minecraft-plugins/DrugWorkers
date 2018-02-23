package me.zackpollard.drugworkers;

import java.io.File;
import java.util.ArrayList;

import me.zackpollard.drugworkers.listeners.WorkerPlace;
import me.zackpollard.drugworkers.listeners.WorkerProtection;
import me.zackpollard.drugworkers.util.AccountsStore;
import me.zackpollard.drugworkers.util.WorkersStore;
import me.zackpollard.drugworkers.workers.WorkersStart;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class DrugWorkers extends JavaPlugin {
	
	public WorkersStore workersStore;
	public AccountsStore accountsStore;
	public ArrayList<String> placeWorker = new ArrayList<String>();
	
    public void onDisable() {
    	
    }

    public void onEnable() {

		this.getCommand("worker").setExecutor(new DWCommand(this));
		
		new WorkerProtection(this);
		new WorkerPlace(this);
		
		String pluginFolder = this.getDataFolder().getAbsolutePath();
		new File(pluginFolder).mkdirs();
		this.workersStore = new WorkersStore(new File(pluginFolder + File.separator + "workers.txt"));
		this.workersStore.load();
		
		this.accountsStore = new AccountsStore(new File(pluginFolder + File.separator + "accounts.txt"));
		this.accountsStore.load();
		
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new WorkersStart(this), 20 * 10, 20 * 10 );
    	
    }
}