package com.crowdle.controller;

import com.crowdle.dao.RankingDTO;
import com.crowdle.utility.HibernateUtility;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import org.hibernate.Session;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class RankingPageController {

    @FXML public GridPane root;
    @FXML public ImageView iconImageView;
    @FXML public Button adminButton;
    @FXML public Button notificationButton;
    @FXML public TableView<RankingDTO> rankingTableView;

    @FXML
    public void initialize() throws FileNotFoundException {
        Image iconImg = new Image(new FileInputStream("images/icon_crowdle.png"));
        iconImageView.setImage(iconImg);

        try (Session session = HibernateUtility.getSessionFactory().openSession()) {
            List<RankingDTO> result = session.createQuery("SELECT new com.crowdle.dao.RankingDTO(u.username, r.points, rn.name) " +
                    "FROM Ranking r JOIN r.player u JOIN r.rank rn ORDER BY r.points DESC", RankingDTO.class).getResultList();

            ObservableList<RankingDTO> rankingObservableList = FXCollections.observableArrayList(result);
            rankingTableView.setItems(rankingObservableList);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }

}
