package me.bobthe28th.ctf;

import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this,this);
        getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "This is a test!");
    }

}