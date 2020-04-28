package me.blazingtide.pistol;

import lombok.Getter;
import me.blazingtide.pistol.adapter.PistolAdapter;
import me.blazingtide.pistol.handler.ScoreboardHandler;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main handler class for library.
 *
 * To begin do "new Pistol(javaPlugin, adapter);"
 */
@Getter
public class Pistol {

    private final JavaPlugin plugin;
    private final PistolAdapter adapter;

    private ScoreboardHandler handler = new ScoreboardHandler();

    /**
     *
     * @param plugin the JavaPlugin that's using this API
     * @param adapter the adapter for reading the lines of a scoreboard
     */
    public Pistol(JavaPlugin plugin, PistolAdapter adapter) {
        this.plugin = plugin;
        this.adapter = adapter;
    }
}
