package net.hcherndon.ipeer;

import com.google.common.eventbus.Subscribe;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;

public class IPeer extends Plugin implements Listener{
	public void onEnable(){
		System.out.println("[IPeer] is now loaded! Initializing start up scripts!");
		LogCore.ipExist();
		LogCore.ipRead();
		LogCore.ipWrite();
		LogCore.ipExecute();
		LogCore.ipPath();
		LogCore.ipSize();
		System.out.println("[IPeer] files put! Registering Events!");
		BungeeCord.getInstance().getPluginManager().registerListener(this);
		System.out.println("[IPeer] is now up and running! Any errors found, PLEASE help us out! Report them to hcherndon at spigotmc.org!");
	}
	
	public void onDisable(){
		System.out.println("[IPeer] is now disabled! :(");
	}
	
	@Subscribe
	public void onJoin(ServerConnectEvent e){
		if(e.getPlayer() instanceof ProxiedPlayer){
			LogCore.logIP(e.getPlayer().getName());
		}
	}
}
