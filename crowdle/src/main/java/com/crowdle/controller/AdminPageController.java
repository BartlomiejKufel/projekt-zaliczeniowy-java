package com.crowdle.controller;

import com.crowdle.dao.UsersDAO;
import com.crowdle.model.Users;
import com.crowdle.utility.PageMenagerUtility;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class AdminPageController {
    @FXML public GridPane root;
    @FXML public Button backButton;
    @FXML public TableView<Users> usersTableView;
    @FXML public ImageView iconImageView;
    @FXML public Button notificationButton;
    @FXML public TableColumn<Users, Integer> idTableColumn;
    @FXML public TableColumn<Users, String> usernameTableColumn;
    @FXML public TableColumn<Users, String> emailTableColumn;
    @FXML public TableColumn<Users, String> createdAtTableColumn;
    @FXML public TableColumn<Users, String> adminTableColumn;
    @FXML public Label informationLabel;
    @FXML public Label selectedLabel;
    @FXML public Button deleteButton;
    @FXML public Button editButton;


    @FXML
    public void initialize() throws FileNotFoundException {
        Image iconImg = new Image(new FileInputStream("images/icon_crowdle.png"));
        iconImageView.setImage(iconImg);


        idTableColumn.setCellValueFactory(new PropertyValueFactory<>("userId"));
        usernameTableColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        emailTableColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        createdAtTableColumn.setCellValueFactory(new PropertyValueFactory<>("createdAt"));
        adminTableColumn.setCellValueFactory(new PropertyValueFactory<>("isAdmin"));


        ObservableList<Users> rankingObservableList = FXCollections.observableArrayList(UsersDAO.getUsers());
        usersTableView.setItems(rankingObservableList);

        selectedLabel.setVisible(false);
        deleteButton.setVisible(false);
        editButton.setVisible(false);

        usersTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                informationLabel.setText("Wybrałeś użytkownika");
                selectedLabel.setText("id: " + newSelection.getUserId());
                selectedLabel.setVisible(true);
                editButton.setVisible(true);
                if(!newSelection.isAdmin()){
                    deleteButton.setVisible(true);
                }
            } else {
                informationLabel.setText("Nie wybrałeś użytkownika");
                selectedLabel.setVisible(false);
                deleteButton.setVisible(false);
                editButton.setVisible(false);
            }
        });

    }


    public void backButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) backButton.getScene().getWindow();
        PageMenagerUtility.goToStartPage(stage);
    }
}
