package me.blazingtide.pistol.board;

import com.google.common.collect.Maps;
import lombok.Getter;
import me.blazingtide.pistol.Pistol;
import me.blazingtide.pistol.board.entry.BoardEntry;
import me.blazingtide.pistol.util.ColorUtil;
import org.apache.commons.lang.CharUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@Getter
public class PistolBoard {

    private final Map<String, BoardEntry> entries = Maps.newHashMap();

    private final Pistol pistol;
    private final Player player;
    private final Scoreboard scoreboard;

    private Objective objective;

    public PistolBoard(Pistol pistol, Player player) {
        this.pistol = pistol;
        this.player = player;
        this.scoreboard = player.getScoreboard() != Bukkit.getScoreboardManager().getMainScoreboard() ? player.getScoreboard() : Bukkit.getScoreboardManager().getNewScoreboard();
    }

    public void init() {
        objective = scoreboard.registerNewObjective(player.getName(), "dummy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        update();
    }

    private void updateEntries() {
        buildEntries();

        player.setScoreboard(scoreboard);
    }

    private void buildEntries() {
        //Reset the scores every time you build entries
        entries.keySet().forEach(scoreboard::resetScores);
        entries.clear();

        final List<String> lines = pistol.getAdapter().getLines(player);

        //MC limits to 15 lines per scoreboard so we only want to do the first 15 lines
        for (int i = 0; i < Math.min(lines.size(), 16); i++) {
            final String line = lines.get(i);
            final BoardEntry entry = BoardEntry.of(scoreboard, findId(""), ColorUtil.translate(line));

            final Score score = objective.getScore(entry.getId());
            score.setScore(i);

            entries.put(entry.getId(), entry);
        }
    }

    /**
     * Creates a unique ID from chatcolor every time it's needed.
     *
     * @param start the start of the code.
     * @return the unique Id
     */
    private String findId(String start) {
        start += start + ChatColor.values()[ThreadLocalRandom.current().nextInt(0, ChatColor.values().length)];

        if (entries.containsKey(start) || scoreboard.getTeam(start) != null) {
            return findId(start);
        }

        return start;
    }

    public void update() {
        objective.setDisplayName(ColorUtil.translate(pistol.getAdapter().getTitle(player)));
        updateEntries();
    }
}
