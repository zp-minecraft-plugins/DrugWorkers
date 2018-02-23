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

public class AccountsStore {

	private File accountsFile;
	private ArrayList<String> accounts;
	
	public AccountsStore(File file){
		this.accountsFile = file;
		this.accounts = new ArrayList<String>();
		
		if (this.accountsFile.exists() == false){
			try {
				this.accountsFile.createNewFile();
			}catch (IOException e){
				e.printStackTrace();
			}
		}
	}
	
	public void load(){
		try {
			DataInputStream input = new DataInputStream(new FileInputStream(this.accountsFile));
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			
			String line;
			
			while ((line = reader.readLine()) != null){
				if(this.accounts.contains(line) == false){
					this.accounts.add(line);
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
			FileWriter stream = new FileWriter(this.accountsFile);
			BufferedWriter out = new BufferedWriter(stream);
			
			for (String value : this.accounts){
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
		return this.accounts.contains(value);
	}
	
	public void add(String value){
		if(this.contains(value) == false){
			this.accounts.add(value + ":0");
		}	
	}
	
	public void remove(String value){
		this.accounts.remove(value);
	}
	
	public ArrayList<String> getValues(){
		return this.accounts;
	}
	
	public boolean refund(String name){
		
		if(this.accounts.contains(name)){
			
			int id = this.accounts.indexOf(name);
			String account = this.accounts.get(id);
			String[] split = account.split(":");
			String accountHolder = split[0];
			int availableWorkers = Integer.parseInt(split[1]);
			availableWorkers = availableWorkers++;
			
			this.accounts.set(id, accountHolder + ":" + availableWorkers);
			
			this.save();
			
			return true;
			
		} else {
			
			if(!this.accounts.contains(name)){
				
				return false;
			
			}
		}
		return false;
	}
	
	public boolean addWorker(String name,int amount){
		
		return false;
	}
}
