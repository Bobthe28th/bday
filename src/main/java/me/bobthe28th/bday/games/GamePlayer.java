package me.bobthe28th.bday.games;

import me.bobthe28th.bday.Main;
import me.bobthe28th.bday.scoreboard.ScoreboardController;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;

public class GamePlayer implements Listener {

    private final Player player;
    private final Main plugin;
    ScoreboardController scoreboardController;

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
        for (PotionEffect effect : player.getActivePotionEffects()) {
            player.removePotionEffect(effect.getType());
        }
        scoreboardController = new ScoreboardController(this);
    }

    public Player getPlayer() {
        return player;
    }

    public ScoreboardController getScoreboardController() {
        return scoreboardController;
    }

    public void remove() {
        removeNotMap();
        plugin.getGameManager().getGamePlayers().remove(player);
    }

    public void removeNotMap() {
        HandlerList.unregisterAll(this);
    }
}
