package com.gamingroom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** A game can have one or more teams. */
public class Game extends Entity {
    private final List<Team> teams = new ArrayList<>();

    public Game(long id, String name) {
        super(id, name);
    }

    /* package */ void addTeam(Team team) {
        teams.add(team);
    }

    public List<Team> getTeams() {
        return Collections.unmodifiableList(teams);
    }
}

