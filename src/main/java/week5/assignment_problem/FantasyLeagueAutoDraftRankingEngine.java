package main.java.week5.assignment_problem;

// File name: FantasyLeagueAutoDraftRankingEngine.java

import java.util.Arrays;

public class FantasyLeagueAutoDraftRankingEngine implements Comparable<FantasyLeagueAutoDraftRankingEngine> {

    String name;
    int matchesPlayed;
    double battingAverage;
    boolean injured;

    public FantasyLeagueAutoDraftRankingEngine(String name, int matchesPlayed,
                                               double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    public int compareTo(FantasyLeagueAutoDraftRankingEngine other) {
        return Double.compare(other.battingAverage, this.battingAverage);
    }

    static String draftAndRank(FantasyLeagueAutoDraftRankingEngine[] players) {

        int count = 0;

        for (int i = 0; i < players.length; i++) {
            if (isDraftable(players[i].matchesPlayed)
                    || isDraftable(players[i].matchesPlayed, players[i].injured)) {
                count++;
            }
        }

        FantasyLeagueAutoDraftRankingEngine[] draftable =
                new FantasyLeagueAutoDraftRankingEngine[count];

        int index = 0;

        for (int i = 0; i < players.length; i++) {
            if (isDraftable(players[i].matchesPlayed)
                    || isDraftable(players[i].matchesPlayed, players[i].injured)) {
                draftable[index] = players[i];
                index++;
            }
        }

        Arrays.sort(draftable);

        String result = "";

        for (int i = 0; i < draftable.length; i++) {
            if (i > 0) {
                result = result + " | ";
            }

            result = result + (i + 1) + ". " + draftable[i].name;
        }

        return result;
    }

    public static void main(String[] args) {

        FantasyLeagueAutoDraftRankingEngine[] players = {
            new FantasyLeagueAutoDraftRankingEngine("Virat", 15, 48.0, false),
            new FantasyLeagueAutoDraftRankingEngine("Rahul", 7, 55.0, false),
            new FantasyLeagueAutoDraftRankingEngine("Sameer", 3, 60.0, false),
            new FantasyLeagueAutoDraftRankingEngine("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
    }
}
