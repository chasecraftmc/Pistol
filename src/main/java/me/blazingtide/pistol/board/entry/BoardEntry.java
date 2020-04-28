package me.blazingtide.pistol.board.entry;

import lombok.Data;

@Data
public class BoardEntry {

    private final String id;
    private final String fullString;

    private final String prefix;
    private final String suffix;

    public static BoardEntry of(String id, String line) {

    }

}
