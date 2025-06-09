package com.crowdle;

/***********************************************************
 Klasa: ApplicationInfo
 Info: Klasa odpowiada za przechowywanie najważniejszych danych w aplikacji
 Pola:
 — public — static int — LoggedUserId — pole przechowywujące id zalogowanego Użytkownika
 — public — static int — WindowHeight — Wysokość głównego okna aplikacji
 — public — static int — WindowWidth — Szerokość głównego okna aplikacji
 — public — static String — Title — Tytuł aplikacji
 — public — static double — VictoryThreshold — Półap procentowy, od jakiego gra liczy się jako wygrana
************************************************************/

public class ApplicationInfo {
    public static int LoggedUserId = 0;
    public static int WindowHeight = 720;
    public static int WindowWidth = 1280;
    public static String Title = "Crowdle";
    public static double VictoryThreshold =0.65;

}
