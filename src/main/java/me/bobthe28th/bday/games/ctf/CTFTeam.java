package me.bobthe28th.bday.games.ctf;

import me.bobthe28th.bday.scoreboard.ScoreboardTeam;
import org.bukkit.ChatColor;
import org.bukkit.Material;

public class CTFTeam {

    private int score = 0;
    private final Material banner;

    private final ScoreboardTeam team;

    private final CTFFlag flag;

    public CTFTeam(String name, ChatColor color, Material banner) {
        team = new ScoreboardTeam(name,color);
        this.banner = banner;
        this.flag = new CTFFlag();
    }

}
