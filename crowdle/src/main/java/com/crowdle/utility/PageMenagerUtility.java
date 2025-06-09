package com.crowdle.utility;

import com.crowdle.ApplicationInfo;
import com.crowdle.controller.AdminEditPageController;
import com.crowdle.controller.GamePageController;
import com.crowdle.controller.ScorePageController;
import com.crowdle.model.Users;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.FileInputStream;

/***********************************************************
 Klasa: PageMenagerUtility
 Info: Klasa odpowiada za przechowywanie metod, które pozwalają się poruszać pomiędzy oknami
 Metody:
 — public — static void — goToStartPage (Stage primaryStage)
 — public — static void — goToLoginPage (Stage primaryStage)
 — public — static void — goToSignUpPage (Stage primaryStage)
 — public — static void — goToSettingsPage(Stage primaryStage)
 — public — static void — goToRankingPage(Stage primaryStage)
 — public — static void — goToAdminPage(Stage primaryStage)
 — public — static boolean — goToAdminEditWindow(Users selectedUser)
 — public — static void — goToAdminNotificationPage(Stage primaryStage)
 — public — static void — goToAdminQuestionsPage(Stage primaryStage)
 — public — static void — goToNotificationWindow()
 — public — static void — goToGamemodePage(Stage primaryStage)
 — public — static void — goToGamePage(Stage primaryStage, int selectedDifficulty)
 — public — static boolean — ScoreWindow(int goodAnswers, int howMuch, int points)
 ************************************************************/
public class PageMenagerUtility {

    /***********************************************************
     Metoda: goToStartPage
     Typ Zwracany: void
     Info: przejście do strony startowej
     Argumenty:
     — Stage primaryStage
     ************************************************************/
    public static void goToStartPage(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(PageMenagerUtility.class.getResource("/com/crowdle/StartPage.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /***********************************************************
     Metoda: goToLoginPage
     Typ Zwracany: void
     Info: przejście do strony logowania
     Argumenty:
     — Stage primaryStage
     ************************************************************/
    public static void goToLoginPage(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(PageMenagerUtility.class.getResource("/com/crowdle/LoginPage.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /***********************************************************
     Metoda: goToSignUpPage
     Typ Zwracany: void
     Info: przejście do strony rejestracji nowych kont
     Argumenty:
     — Stage primaryStage
     ************************************************************/
    public static void goToSignUpPage(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(PageMenagerUtility.class.getResource("/com/crowdle/SignUpPage.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /***********************************************************
     Metoda: goToSettingPage
     Typ Zwracany: void
     Info: przejście do strony z ustawieniami
     Argumenty:
     — Stage primaryStage
     ************************************************************/
    public static void goToSettingsPage(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(PageMenagerUtility.class.getResource("/com/crowdle/SettingsPage.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /***********************************************************
     Metoda: goToRankingPage
     Typ Zwracany: void
     Info: przejście do strony z rankingiem wszystkich użytkowników
     Argumenty:
     — Stage primaryStage
     ************************************************************/
    public static void goToRankingPage(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(PageMenagerUtility.class.getResource("/com/crowdle/RankingPage.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /***********************************************************
     Metoda: goToAdminPage
     Typ Zwracany: void
     Info: przejście do strony administratora
     Argumenty:
     — Stage primaryStage
     ************************************************************/
    public static void goToAdminPage(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(PageMenagerUtility.class.getResource("/com/crowdle/AdminPage.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    /***********************************************************
     Metoda: goToAdminEditWindow
     Typ Zwracany: boolean
     Info: przejście do okna edycji użytkownika, po zamknięciu tego okna metoda zwróci true
     Argumenty:
     — Users selectedUser — obiekt z danymi użytkownika wybrany na stronie administratora
     ************************************************************/
    public static boolean goToAdminEditWindow(Users selectedUser) {
        try {
            FXMLLoader loader = new FXMLLoader(PageMenagerUtility.class.getResource("/com/crowdle/AdminEditPage.fxml"));
            Parent root = loader.load();

            //Przekazanie obiektu do Okna edycji
            AdminEditPageController controller = loader.getController();
            controller.setSelectedUser(selectedUser);

            Scene scene = new Scene(root, 900, 500);
            Image icon = new Image(new FileInputStream("images/logo_white.png"));
            Stage stage = new Stage();
            stage.getIcons().add(icon);
            stage.setTitle(ApplicationInfo.Title+ ": Edycja użytkownika");

            stage.setScene(scene);
            stage.setResizable(false);
            stage.showAndWait();
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /***********************************************************
     Metoda: goToAdminNotificationPage
     Typ Zwracany: void
     Info: przejście do strony wysyłania powiadomień
     Argumenty:
     — Stage primaryStage
     ************************************************************/
    public static void goToAdminNotificationPage(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(PageMenagerUtility.class.getResource("/com/crowdle/AdminNotificationPage.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



    /***********************************************************
     Metoda: goToAdminQuestionPage
     Typ Zwracany: void
     Info: przejście do strony dodawania nowych plików
     Argumenty:
     — Stage primaryStage
     ************************************************************/
    public static void goToAdminQuestionsPage(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(PageMenagerUtility.class.getResource("/com/crowdle/AdminQuestionsPage.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    /***********************************************************
     Metoda: goToNotificationWindow
     Typ Zwracany: void
     Info: otworzenie okna z wiadomościami od administratora
     Argumenty:
     ************************************************************/
    public static void goToNotificationWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(PageMenagerUtility.class.getResource("/com/crowdle/NotificationPage.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root, 320, 500);
            Image icon = new Image(new FileInputStream("images/logo_white.png"));
            Stage stage = new Stage();
            stage.getIcons().add(icon);
            stage.setTitle(ApplicationInfo.Title+ ": Nowości");

            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    /***********************************************************
     Metoda: goToGamemodePage
     Typ Zwracany: void
     Info: przejście do strony wybierania trybu gry
     Argumenty:
     — Stage primaryStage
     ************************************************************/
    public static void goToGamemodePage(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(PageMenagerUtility.class.getResource("/com/crowdle/GamemodePage.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    /***********************************************************
     Metoda: goToGamePage
     Typ Zwracany: void
     Info: przejście do strony gry
     Argumenty:
     — Stage primaryStage
     — int selectedDifficulty — id trybu gry, który wybrał użytkownik
     ************************************************************/
    public static void goToGamePage(Stage primaryStage, int selectedDifficulty) {
        try {
            FXMLLoader loader = new FXMLLoader(PageMenagerUtility.class.getResource("/com/crowdle/GamePage.fxml"));
            Parent root = loader.load();

            GamePageController controller = loader.getController();
            controller.setDifficulty(selectedDifficulty);

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    /***********************************************************
     Metoda: ScoreWindow
     Typ Zwracany: boolean
     Info: otworzenie okna z wynikiem po zakończonej grze, metoda zwraca true po zamknięciu okna
     Argumenty:
     — int goodAnswer — ilość poprawnie udzielonych przez użytkownika odpowiedzi
     — int howMuch — na ile pytań użytkownik musiał odpowiedzieć
     — int points — ilość punktów, które użytkownik zyska/straci w zależności od wyniku gry
     ************************************************************/
    public static boolean ScoreWindow(int goodAnswers, int howMuch, int points) {
        try {
            FXMLLoader loader = new FXMLLoader(PageMenagerUtility.class.getResource("/com/crowdle/ScorePage.fxml"));
            Parent root = loader.load();

            //Przekazanie zmiennych do okna wyniku
            ScorePageController controller = loader.getController();
            controller.setScore(goodAnswers,howMuch, points);

            Scene scene = new Scene(root, 320, 400);
            Image icon = new Image(new FileInputStream("images/logo_white.png"));
            Stage stage = new Stage();
            stage.getIcons().add(icon);
            stage.setTitle(ApplicationInfo.Title+ ": Wynik");

            stage.setScene(scene);
            stage.setResizable(false);
            stage.showAndWait();
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
