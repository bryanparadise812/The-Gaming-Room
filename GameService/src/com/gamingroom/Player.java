package com.gamingroom;

/** A player belongs to a team. */
public class Player extends Entity {
    private final long teamId;

    public Player(long id, String name, long teamId) {
        super(id, name);
        this.teamId = teamId;
    }

    public long getTeamId() {
        return teamId;
    }
}
