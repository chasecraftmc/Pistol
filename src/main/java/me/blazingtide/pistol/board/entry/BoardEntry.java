package me.blazingtide.pistol.board.entry;

import lombok.Data;
import org.bukkit.ChatColor;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

@Data
public class BoardEntry {

    private final String id;
    private final String fullString;

    private final String prefix;
    private final String suffix;

    private final Team team;

    public static BoardEntry of(Scoreboard scoreboard, String id, String line) {
        final Team team = scoreboard.getTeam(id);
        final String prefix = line.length() > 16 ? line.substring(0, 16) : line;
        final String suffix = line.length() > 16 ? ChatColor.getLastColors(prefix) + line.substring(16, Math.min(16, line.length())) : "";

        team.setPrefix(prefix);
        team.setSuffix(suffix);

        return new BoardEntry(id, line, prefix, suffix, team);
    }

}
