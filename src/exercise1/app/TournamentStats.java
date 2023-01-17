package exercise1.app;

import exercise1.comaparators.SortByNameAscComparator;
import exercise1.comaparators.SortByPointsAscComparator;
import exercise1.comaparators.SortBySurnameAscComparator;
import exercise1.model.Player;
import exercise1.model.SortOrder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TournamentStats {
    private static final int SORT_BY_NAME = 1;
    private static final int SORT_BY_SURNAME = 2;
    private static final int SORT_BY_POINTS = 3;

    private static final int SORT_ASC = 1;
    private static final int SORT_DESC = 2;

    public static List<Player> readPlayers(Scanner scanner) {
        List<Player> players = new ArrayList<>();

        while (true) {
            System.out.println("Podaj wynik kolejnego gracza (lub stop):");
            String playerData = scanner.nextLine();

            if (playerData.equalsIgnoreCase("STOP")) {
                break;
            }

            String[] split = playerData.split(" ");
            if (split.length != 3) {
                System.out.println("Nieprawidłowe dane");
                continue;
            }

            int points;
            try {
                points = Integer.parseInt(split[2]);
            } catch (NumberFormatException e) {
                System.out.println("Nieprawidłowe dane");
                continue;
            }

            Player player = new Player(split[0], split[1], points);
            players.add(player);
        }
        return players;
    }

    public static SortOrder readSortOrder(Scanner scanner) {
        System.out.print("Po jakim parametrze posortować? ");
        System.out.printf("(%d - imię, %d - nazwisko, %d - wynik)\n", SORT_BY_NAME, SORT_BY_SURNAME, SORT_BY_POINTS);
        int sortBy = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Sortować rosnąco czy malejąco? ");
        System.out.printf("(%d - rosnąco, %d - malejąco)\n" , SORT_ASC, SORT_DESC);
        int order = scanner.nextInt();
        scanner.nextLine();
        SortOrder sortOrder = new SortOrder(sortBy, order);
        return sortOrder;
    }

    public static void sortPlayerList(List<Player> players, SortOrder sortOrder) {

        Comparator<Player> nameComparator = new SortByNameAscComparator();
        Comparator<Player> surnameComparator = new SortBySurnameAscComparator();
        Comparator<Player> pointsComparator = new SortByPointsAscComparator();

        if (sortOrder.getSortOrder() == SORT_DESC) {
            nameComparator = nameComparator.reversed();
            surnameComparator = surnameComparator.reversed();
            pointsComparator = pointsComparator.reversed();
        }

        switch (sortOrder.getSortBy()) {
            case SORT_BY_NAME:
                players.sort(nameComparator);
                break;
            case SORT_BY_SURNAME:
                players.sort(surnameComparator);
                break;
            case SORT_BY_POINTS:
                players.sort(pointsComparator);
                break;
            default:
                throw new IllegalArgumentException("Sort by: " + sortOrder.getSortBy() + " not supported");
        }
    }


}

