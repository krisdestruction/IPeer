package net.hcherndon.ipeer;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import net.md_5.bungee.BungeeCord;

public class LogCore {
private static File file;
	
	public static void ipExist(){
		  try{
			  file = new File("plugins/IPeer/ips.dat");
			  if(!file.exists()){
				  File dir = new File("plugins/IPeer/");
			      dir.mkdirs();
			      file.createNewFile();
			      System.out.println("[IPeer] ips.dat does not Exists! Creating it now!");
			  }else{
				  System.out.println("[IPeer] ips.dat Exists! We are good! Let's keep some kids out!");
			  }
			  }catch (Exception e){
			   e.printStackTrace();
			   System.out.println("[IPeer] This error was caused by IPeer! Please do not let this go unnoticed!" +
				  		" Report this error this to hcherndon on Spigotmc.org!");
			  }
		  	}
		  
		  public static void ipRead(){
			  file = new File("plugins/IPeer/ips.dat");
			  if(file.canRead()){
				  System.out.println("[IPeer] IPeer Logger can read!");
			  }else{
				  System.out.println("[IPeer] IPeer Logger can not read! Forcing Readable!");
				  file.setReadable(true);
			  }
		  }
		  
		  public static void ipWrite(){
			  file = new File("plugins/IPeer/ips.dat");
			  if(file.canWrite()){
				  System.out.println("[IPeer] IPeer Logger can write!");
			  }else{
				  System.out.println("[IPeer] IPeer Logger can not write! Forcing Writable!");
				  file.setWritable(true);
				  }
		  }
		  
		  public static void ipExecute(){
			  file = new File("plugins/IPeer/ips.dat");
			  if(file.canExecute()){
				  System.out.println("[IPeer] IPeer Logger can execute!");
			  }else{
				  System.out.println("[IPeer] IPeer Logger can not execute! Forcing Executable!");
				  file.setExecutable(true);
			  }
		  }
		  
		  public static void ipSize(){
			  file = new File("plugins/IPeer/ips.dat");
			  System.out.println("[IPeer] The ips.dat files size is currently: " + file.getTotalSpace());
		  }
		  
		  public static void ipPath(){
			  file = new File("plugins/IPeer/ips.dat");
			  System.out.println("[IPeer] IPeer Logger file path is: " + file.getPath());
		  }
		  
		  public static void logIP(String player){
			  try{
				  String ip = cleanIP(BungeeCord.getInstance().getPlayer(player).getAddress().toString());
				  PrintWriter writer = new PrintWriter(new FileWriter(new File("plugins/IPeer/ips.dat"),true));
				  writer.println(player + ":" + ip);
				  writer.close();
				  System.out.println("[IPeer] has logged " + player + "'s ip as " + ip + "!");
			  }catch(Exception e){
				  e.printStackTrace();
				  System.out.println("[IPeer] This error was caused by IPeer! Please do not let this go unnoticed!" +
					  		" Report this error this to hcherndon on Spigotmc.org!");
			  }
		  }
		  
		  public static String cleanIP(String ip){
				String[] step1 = ip.split(":");
				String step2 = step1[0];
				String step3 = step2.replaceAll("/", "");
				return step3;
			}

}
