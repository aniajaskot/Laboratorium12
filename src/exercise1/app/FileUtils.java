package exercise1.app;

import exercise1.model.Player;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileUtils {

    public static void writeToStatsFile(List<Player> players, String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

        for (Player player : players) {
            String playerAsString = String.format("%s %s;%d", player.getName(), player.getSurname(), player.getPoints());
            writer.write(playerAsString);
            writer.newLine();
        }
        writer.close();
    }
}
