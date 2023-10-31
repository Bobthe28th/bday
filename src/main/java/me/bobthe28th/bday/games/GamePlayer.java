package me.bobthe28th.bday.games;

import me.bobthe28th.bday.Main;
import me.bobthe28th.bday.scoreboard.ScoreboardController;
import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitRunnable;

public class GamePlayer implements Listener {

    protected final Player player;
    protected final Main plugin;
    private final ScoreboardController scoreboardController;

    private BossBar enemyHealth;
    private LivingEntity enemy;
    private final double enemyHealthCooldownMax = 4.0;
    private double enemyHeathCooldown = 0.0;
    private boolean onEnemyHealthCooldown = false;

    boolean isAlive;

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
        enemyHealth = Bukkit.createBossBar("", BarColor.RED, BarStyle.SEGMENTED_10);
        enemyHealth.setVisible(false);
        enemyHealth.addPlayer(player);
    }

    public Player getPlayer() {
        return player;
    }

    public ScoreboardController getScoreboardController() {
        return scoreboardController;
    }

    public void startEnemyHealthCooldown() {
        onEnemyHealthCooldown = true;
        new BukkitRunnable() {
            @Override
            public void run() {
                enemyHeathCooldown -= 0.1;
                enemyHeathCooldown = Math.round(enemyHeathCooldown*10.0)/10.0;
                if (enemyHeathCooldown <= 0) {
                    enemyHeathCooldown = 0;
                    enemy = null;
                    enemyHealth.setVisible(false);
                    onEnemyHealthCooldown = false;
                    this.cancel();
                }
            }
        }.runTaskTimer(plugin, 2L, 2L);
    }

    public void setEnemyHealthCooldown() {
        enemyHeathCooldown = enemyHealthCooldownMax;
        if (!onEnemyHealthCooldown) {
            startEnemyHealthCooldown();
        }
    }

    public void updateEnemyHealth(double healthProgress) {
        enemyHealth.setProgress(healthProgress);
        enemyHealth.setTitle(enemy.getName());
        enemyHealth.setVisible(true);
    }

    public void damage(LivingEntity entity, double damage) {
        AttributeInstance maxHealth = entity.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        if (maxHealth == null) return;
        double health = entity.getHealth() - damage;
        enemy = entity;
        updateEnemyHealth(Math.min(1.0,Math.max(0.0,health / maxHealth.getValue())));
        setEnemyHealthCooldown();
    }

    public void remove() {
        removeNotMap();
        plugin.getGameManager().getGamePlayers().remove(player);
    }

    public void removeNotMap() {
        HandlerList.unregisterAll(this);
    }
}
