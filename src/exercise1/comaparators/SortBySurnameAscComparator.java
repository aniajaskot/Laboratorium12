package exercise1.comaparators;

import exercise1.model.Player;

import java.util.Comparator;

public class SortBySurnameAscComparator implements Comparator<Player> {

    @Override
    public int compare(Player o1, Player o2) {
        return o1.getSurname().compareTo(o2.getSurname());
    }
}