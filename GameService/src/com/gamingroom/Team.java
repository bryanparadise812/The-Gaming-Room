package com.gamingroom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** A team belongs to a game and can have multiple players. */
public class Team extends Entity {
    private final long gameId;
    private final List<Player> players = new ArrayList<>();

    public Team(long id, String name, long gameId) {
        super(id, name);
        this.gameId = gameId;
    }

    public long getGameId() {
        return gameId;
    }

    /* package */ void addPlayer(Player player) {
        players.add(player);
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}

