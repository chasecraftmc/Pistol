package me.blazingtide.pistol.board;

import lombok.Getter;
import me.blazingtide.pistol.Pistol;
import me.blazingtide.pistol.util.ColorUtil;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

@Getter
public class PistolBoard {

    private final Pistol pistol;
    private final Player player;
    private final Scoreboard scoreboard;

    private Objective objective;

    public PistolBoard(Pistol pistol, Player player, Scoreboard scoreboard) {
        this.pistol = pistol;
        this.player = player;
        this.scoreboard = scoreboard;
    }

    public void init() {
        objective = scoreboard.registerNewObjective("test", "dummy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName(ColorUtil.translate(pistol.getAdapter().getTitle(player)));
        
    }

}
