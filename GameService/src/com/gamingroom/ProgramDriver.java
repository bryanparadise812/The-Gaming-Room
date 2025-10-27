package com.gamingroom;

public class ProgramDriver {

    public static void main(String[] args) {
        GameService service = GameService.getInstance();

        System.out.println("\n=== Create games ===");
        Game g1 = service.addGame("Draw It or Lose It");
        Game g2 = service.addGame("Draw It or Lose It"); // duplicate -> returns existing
        System.out.println(g1);
        System.out.println(g2); // same id/name as g1

        System.out.println("\n=== Create teams ===");
        Team t1 = service.addTeam(g1.getId(), "Red Rockets");
        Team t2 = service.addTeam(g1.getId(), "Blue Blazers");
        Team t3 = service.addTeam(g1.getId(), "Red Rockets"); // duplicate -> returns existing
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3); // same id/name as t1

        System.out.println("\n=== Create players ===");
        Player p1 = service.addPlayer(t1.getId(), "Avery");
        Player p2 = service.addPlayer(t1.getId(), "Jordan");
        Player p3 = service.addPlayer(t2.getId(), "Avery");  // duplicate -> returns existing
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3); // same id/name as p1

        System.out.println("\nCounts -> games:" + service.getGameCount()
                + ", teams:" + service.getTeamCount()
                + ", players:" + service.getPlayerCount());

        System.out.println("\nSingleton check: " + (service == GameService.getInstance()));
    }
}
