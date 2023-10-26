package me.bobthe28th.ctf.games.ctf;

import me.bobthe28th.ctf.Main;
import me.bobthe28th.ctf.games.Game;
import me.bobthe28th.ctf.games.GamePlayer;
import me.bobthe28th.ctf.games.GameState;

public class CTF extends Game {

    public CTF(Main plugin) {
        super(plugin);
    }

    @Override
    public void onPlayerJoin(GamePlayer player) {

    }

    @Override
    public void onPlayerLeave(GamePlayer player) {

    }

    @Override
    public void start() {
        state = GameState.TEAMSELECT;
    }

    @Override
    public void disable() {

    }
}
