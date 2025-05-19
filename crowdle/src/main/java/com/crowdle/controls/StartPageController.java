package com.crowdle.controls;

import com.crowdle.model.Users;
import com.crowdle.utility.ApplicationInfo;
import com.crowdle.utility.PageMenager;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class StartPageController {
    public Button LogoutButton;
    public Label testLabel;

    public void initialize() {
        Users newUser = Users.getUser(ApplicationInfo.LoggedUserId);
        testLabel.setText(newUser.toString());
    }



    public void LogoutButtonClick() {
        Stage stage = (Stage) LogoutButton.getScene().getWindow();
        PageMenager.GoToLoginPage(stage);

    }
}
