package me.zackpollard.drugworkers.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.bukkit.World;

public class WorkersStore {

	private File workersFile;
	private ArrayList<String> workers;
	
	public WorkersStore(File file){
		this.workersFile = file;
		this.workers = new ArrayList<String>();
		
		if (this.workersFile.exists() == false){
			try {
				this.workersFile.createNewFile();
			}catch (IOException e){
				e.printStackTrace();
			}
		}
	}
	
	public void load(){
		try {
			DataInputStream input = new DataInputStream(new FileInputStream(this.workersFile));
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			
			String line;
			
			while ((line = reader.readLine()) != null){
				if(this.workers.contains(line) == false){
					this.workers.add(line);
				}
			}
			reader.close();
			input.close();
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void save(){
		try {
			FileWriter stream = new FileWriter(this.workersFile);
			BufferedWriter out = new BufferedWriter(stream);
			
			for (String value : this.workers){
				out.write(value);
				out.newLine();
			}
			out.close();
			stream.close();
			
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public boolean contains(String value){
		return this.workers.contains(value);
	}
	
	public void add(Integer x, Integer y, Integer z, World world){
		String sx = x.toString();
		String sy = y.toString();
		String sz = z.toString();
		String sworld = world.getName().toString();
		
		String location = sx + ":" + sy + ":" + sz + ":" + sworld;
		
		if(this.contains(location) == false){
			this.workers.add(location);
		}	
	}
	
	public void remove(String value){
		this.workers.remove(value);
	}
	
	public ArrayList<String> getValues(){
		return this.workers;
	}
	
}