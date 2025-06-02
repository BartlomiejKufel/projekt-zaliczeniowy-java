package com.crowdle.utility;

import com.crowdle.dao.RankingDTO;
import com.crowdle.model.Questions;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvUtility {




    public static void exportRankingToCSV(List<RankingDTO> players, Stage primaryStage) {
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


    public static List<Questions> loadQuestionsFromCSV(Stage primaryStage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Wybierz plik CSV");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("CSV Files", "*.csv")
        );
        File file = fileChooser.showOpenDialog(primaryStage);


        List<Questions> questions = new ArrayList<>();
        if (file != null) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                boolean firstLine = true;

                while ((line = br.readLine()) != null) {
                    if (firstLine) {
                        firstLine = false;
                        continue;
                    }

                    String[] values = line.split(",");
                    String content = values[0];
                    String answerA = values[1];
                    String answerB = values[2];
                    String answerC = values[3];
                    String answerD = values[4];
                    String correctAnswer = values[5];
                    int topicId = Integer.parseInt(values[6]);
                    int difficultyId = Integer.parseInt(values[7]);


                    questions.add(new Questions(content, answerA,answerB,answerC,answerD,correctAnswer,topicId,difficultyId));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        return questions;
    }

}
