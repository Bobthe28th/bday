package me.bobthe28th.ctf.games;

import me.bobthe28th.ctf.Main;

public abstract class Game {

    protected GameState state = GameState.LOBBY;
    protected final Main plugin;
    protected final GameManager manager;

    protected GameMap map;

    public Game(Main plugin) {
        this.plugin = plugin;
        this.manager = plugin.getGameManager();
    }

    public abstract void onPlayerJoin(GamePlayer player);
    public abstract void onPlayerLeave(GamePlayer player);

    public abstract void start();

    public abstract void disable();

    public void end() {
        disable();
        state = GameState.END;
    }

    public GameState getState() {
        return state;
    }
}
