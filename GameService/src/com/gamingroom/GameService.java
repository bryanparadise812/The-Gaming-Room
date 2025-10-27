package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * GameService (Singleton + Iterator)
 *
 * Singleton: single authoritative service for creating & retrieving entities.
 * Iterator: used to scan collections to enforce unique names and to find items.
 */
public final class GameService {

    // ---- Singleton essentials ----
    private static GameService instance;
    private GameService() { }
    public static GameService getInstance() {
        if (instance == null) {
            instance = new GameService();
        }
        return instance;
    }

    // ---- Collections and id sources ----
    private static long nextGameId  = 1L;
    private static long nextTeamId  = 1L;
    private static long nextPlayerId= 1L;

    private final List<Game>   games   = new ArrayList<>();
    private final List<Team>   teams   = new ArrayList<>();
    private final List<Player> players = new ArrayList<>();

    // ----------------- Game APIs -----------------

    /** Add a game by unique name (case-insensitive). */
    public Game addGame(String name) {
        Game existing = getGame(name);
        if (existing != null) return existing;

        Game created = new Game(nextGameId++, name);
        games.add(created);
        return created;
    }

    /** Get game by id. */
    public Game getGame(long id) {
        for (Iterator<Game> it = games.iterator(); it.hasNext();) {
            Game g = it.next();
            if (g.getId() == id) return g;
        }
        return null;
    }

    /** Get game by name (case-insensitive). */
    public Game getGame(String name) {
        for (Iterator<Game> it = games.iterator(); it.hasNext();) {
            Game g = it.next();
            if (g.getName().equalsIgnoreCase(name)) return g;
        }
        return null;
    }

    /* package */ Game getGame(int index) {  // used by earlier tester code
        return games.get(index);
    }
    public int getGameCount() { return games.size(); }

    // ----------------- Team APIs -----------------

    /**
     * Add a team to a specific game, enforcing unique team names (global).
     * If you want uniqueness per game instead, change the check to only scan that game's teams.
     */
    public Team addTeam(long gameId, String teamName) {
        // enforce team name uniqueness
        Team existing = getTeam(teamName);
        if (existing != null) return existing;

        Game parent = getGame(gameId);
        if (parent == null) return null; // or throw IllegalArgumentException

        Team created = new Team(nextTeamId++, teamName, gameId);
        parent.addTeam(created);
        teams.add(created);
        return created;
    }

    public Team getTeam(long id) {
        for (Iterator<Team> it = teams.iterator(); it.hasNext();) {
            Team t = it.next();
            if (t.getId() == id) return t;
        }
        return null;
    }

    public Team getTeam(String name) {
        for (Iterator<Team> it = teams.iterator(); it.hasNext();) {
            Team t = it.next();
            if (t.getName().equalsIgnoreCase(name)) return t;
        }
        return null;
    }

    public int getTeamCount() { return teams.size(); }

    // ----------------- Player APIs -----------------

    /** Add a player to a specific team, enforcing unique player names (global). */
    public Player addPlayer(long teamId, String playerName) {
        Player existing = getPlayer(playerName);
        if (existing != null) return existing;

        Team team = getTeam(teamId);
        if (team == null) return null; // or throw

        Player created = new Player(nextPlayerId++, playerName, teamId);
        team.addPlayer(created);
        players.add(created);
        return created;
    }

    public Player getPlayer(long id) {
        for (Iterator<Player> it = players.iterator(); it.hasNext();) {
            Player p = it.next();
            if (p.getId() == id) return p;
        }
        return null;
    }

    public Player getPlayer(String name) {
        for (Iterator<Player> it = players.iterator(); it.hasNext();) {
            Player p = it.next();
            if (p.getName().equalsIgnoreCase(name)) return p;
        }
        return null;
    }

    public int getPlayerCount() { return players.size(); }
}

