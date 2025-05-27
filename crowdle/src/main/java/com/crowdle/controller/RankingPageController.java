package com.crowdle.controller;

import com.crowdle.dao.RankingDAO;
import com.crowdle.dao.RankingDTO;
import com.crowdle.utility.HibernateUtility;
import com.crowdle.utility.PageMenagerUtility;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
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
    @FXML public Button backButton;
    @FXML public TableColumn<RankingDTO,String> usernameTableColumn;
    @FXML public TableColumn<RankingDTO,Integer> pointsTableColumn;
    @FXML public TableColumn<RankingDTO,String> nameTableColumn;

    @FXML
    public void initialize() throws FileNotFoundException {
        Image iconImg = new Image(new FileInputStream("images/icon_crowdle.png"));
        iconImageView.setImage(iconImg);

        usernameTableColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        pointsTableColumn.setCellValueFactory(new PropertyValueFactory<>("points"));
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        ObservableList<RankingDTO> rankingObservableList = FXCollections.observableArrayList(RankingDAO.getRanking());
        rankingTableView.setItems(rankingObservableList);

    }

    public void backButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) backButton.getScene().getWindow();
        PageMenagerUtility.goToStartPage(stage);

    }
}
