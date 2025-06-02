package com.crowdle.controller;

import com.crowdle.ApplicationInfo;
import com.crowdle.dao.RankingDAO;
import com.crowdle.dao.RankingDTO;
import com.crowdle.dao.UsersDAO;
import com.crowdle.utility.CsvUtility;
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

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class RankingPageController {

    @FXML public GridPane root;
    @FXML public ImageView iconImageView;
    @FXML public Button notificationButton;
    @FXML public TableView<RankingDTO> rankingTableView;
    @FXML public Button backButton;
    @FXML public TableColumn<RankingDTO,String> usernameTableColumn;
    @FXML public TableColumn<RankingDTO,Integer> pointsTableColumn;
    @FXML public TableColumn<RankingDTO,String> nameTableColumn;
    @FXML public Button saveButton;

    @FXML
    public void initialize() throws FileNotFoundException {
        Image iconImg = new Image(new FileInputStream("images/icon_crowdle.png"));
        iconImageView.setImage(iconImg);

        usernameTableColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        pointsTableColumn.setCellValueFactory(new PropertyValueFactory<>("points"));
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        ObservableList<RankingDTO> rankingObservableList = FXCollections.observableArrayList(RankingDAO.getRanking());
        rankingTableView.setItems(rankingObservableList);

        saveButton.setVisible(UsersDAO.getUser(ApplicationInfo.LoggedUserId).isAdmin());
    }

    @FXML
    public void backButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) backButton.getScene().getWindow();
        PageMenagerUtility.goToStartPage(stage);

    }

    @FXML
    public void saveButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) saveButton.getScene().getWindow();
        CsvUtility.exportRanking(RankingDAO.getRanking(), stage);
    }

    @FXML
    public void notificationButtonClick(ActionEvent actionEvent) {
        PageMenagerUtility.goToNotificationWindow();
    }
}
