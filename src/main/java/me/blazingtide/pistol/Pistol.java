package me.blazingtide.pistol;

import com.google.common.collect.Maps;
import lombok.Getter;
import me.blazingtide.pistol.adapter.PistolAdapter;
import me.blazingtide.pistol.board.PistolBoard;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Map;
import java.util.UUID;

/**
 * Main handler class for library.
 * <p>
 * To begin do "new Pistol(javaPlugin, adapter);"
 */
@Getter
public class Pistol {

    private final JavaPlugin plugin;
    private final PistolAdapter adapter;

    private final Map<UUID, PistolBoard> boards = Maps.newHashMap();

    /**
     * @param plugin  the JavaPlugin that's using this API
     * @param adapter the adapter for reading the lines of a scoreboard
     */
    public Pistol(JavaPlugin plugin, PistolAdapter adapter) {
        this.plugin = plugin;
        this.adapter = adapter;
    }
}
