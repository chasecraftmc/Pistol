package me.blazingtide.pistol;

import me.blazingtide.pistol.adapter.PistolAdapter;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class PistolTest extends JavaPlugin {

    @Override
    public void onEnable() {
        new Pistol(this, new PistolAdapter() {
            @Override
            public String getTitle(Player player) {
                return ChatColor.values()[ThreadLocalRandom.current().nextInt(0, ChatColor.values().length)].toString() + player.getName() + " nice.";
            }

            @Override
            public List<String> getLines(Player player) {
                return Arrays.asList(
                        ThreadLocalRandom.current().nextBoolean() + "",
                        "&7&mThis is cool",
                        "&d&lHCF ---------------------------------------"
                );
            }
        });
    }
}
