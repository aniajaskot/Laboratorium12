package exercise1.main;

import exercise1.app.FileUtils;
import exercise1.app.TournamentStats;
import exercise1.model.Player;
import exercise1.model.SortOrder;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Player> players = TournamentStats.readPlayers(scanner);
        SortOrder sortOrder = TournamentStats.readSortOrder(scanner);
        try {
            TournamentStats.sortPlayerList(players, sortOrder);
            FileUtils.writeToStatsFile(players, "stats.csv");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println("Błąd zapisu do pliku");
        } finally {
            scanner.close();
        }
    }

}
