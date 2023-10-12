package me.bobthe28th.ctf.games;

import me.bobthe28th.ctf.Main;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class GameManager {

    Main plugin;
    boolean pvp = false;
    boolean breakBlocks = false;
    public HashMap<Player,GamePlayer> gamePlayers = new HashMap<>();

    public GameManager(Main plugin) {
        this.plugin = plugin;
    }

    public HashMap<Player, GamePlayer> getGamePlayers() {
        return gamePlayers;
    }
}
