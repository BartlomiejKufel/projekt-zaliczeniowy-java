package com.crowdle.controller;

import com.crowdle.dao.NotificationsDAO;
import com.crowdle.model.Notifications;
import javafx.fxml.FXML;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class NotificationPageController {
    @FXML public GridPane root;
    @FXML public ImageView iconImageView;
    @FXML public TreeView<String> notificationTreeView;

    @FXML
    public void initialize() throws FileNotFoundException {
        Image iconImg = new Image(new FileInputStream("images/icon_crowdle.png"));
        iconImageView.setImage(iconImg);

        List<Notifications> notifications = NotificationsDAO.getNotifications();

        if(notifications != null){
            TreeItem<String> news = new TreeItem<>("Powiadomienia");
            for (Notifications ns : notifications){
                TreeItem<String> titleItem = new TreeItem<>(ns.getTitle()+" "+ns.getCreatedAt());
                TreeItem<String> messageItem = new TreeItem<>(ns.getMessage());
                titleItem.getChildren().add(messageItem);
                news.getChildren().add(titleItem);
            }
            notificationTreeView.setRoot(news);
            notificationTreeView.setShowRoot(false);
        }

    }



}
