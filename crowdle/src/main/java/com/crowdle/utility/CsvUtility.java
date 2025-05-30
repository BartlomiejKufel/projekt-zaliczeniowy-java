package com.crowdle.utility;

import com.crowdle.dao.RankingDTO;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvUtility {




    public static void exportRanking(List<RankingDTO> players, Stage primaryStage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Zapisz ranking do CSV");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("CSV Files", "*.csv")
        );
        fileChooser.setInitialFileName("ranking.csv");
        File file = fileChooser.showSaveDialog(primaryStage);

        if (file != null) {
            try (FileWriter writer = new FileWriter(file)) {
                writer.append("Username,Rank,Points\n");

                for (RankingDTO player : players) {
                    writer.append(player.getUsername()).append(",");
                    writer.append(player.getName()).append(",");
                    writer.append(String.valueOf(player.getPoints())).append("\n");
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
