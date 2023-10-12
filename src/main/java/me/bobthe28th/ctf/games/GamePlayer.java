package me.bobthe28th.ctf.games;

import me.bobthe28th.ctf.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;

public class GamePlayer implements Listener {

    Player player;
    Main plugin;
//    ScoreboardController scoreboardController;
//    MoveOption moveOption = MoveOption.ALL;

//    BukkitTask hotbarTask;
//    TextComponent hotbar = new TextComponent("\ue241");

    public GamePlayer(Main plugin, Player player) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        this.player = player;
        this.plugin = plugin;
        this.player.setLevel(0);
        this.player.setExp(0.0F);
        this.player.setFoodLevel(20);
        this.player.setSaturation(0F);
        this.player.setGlowing(false);
        this.player.setInvisible(false);
        this.player.setPlayerListHeaderFooter("Deez", "Nuts");
//        scoreboardController = new ScoreboardController(this);
        for (PotionEffect effect : player.getActivePotionEffects()) {
            player.removePotionEffect(effect.getType());
        }
    }

    public Player getPlayer() {
        return player;
    }

    public void remove() {
        removeNotMap();
        plugin.getGameManager().getGamePlayers().remove(player);
    }

    public void removeNotMap() {
//        scoreboardController.remove();
        HandlerList.unregisterAll(this);
    }
}
