package me.blazingtide.pistol.handler;

import com.google.common.collect.Maps;
import me.blazingtide.pistol.board.PistolBoard;

import java.util.Map;
import java.util.UUID;

public class ScoreboardHandler {

    private final Map<UUID, PistolBoard> boards = Maps.newHashMap();

}
