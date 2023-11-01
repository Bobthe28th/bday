package me.bobthe28th.bday.scoreboard;

import me.bobthe28th.bday.games.GamePlayer;
import org.bukkit.Bukkit;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreboardController {

    GamePlayer player;
    Scoreboard scoreboard;

    public ScoreboardController(GamePlayer player) {
        this.player = player;
        if (Bukkit.getScoreboardManager() != null) {
            scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
            player.getPlayer().setScoreboard(scoreboard);
        }
    }

    public void remove() {
        //TODO
    }

    public Scoreboard getScoreboard() {
        return scoreboard;
    }
}
