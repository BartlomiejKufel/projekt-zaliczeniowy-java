package com.crowdle.utility;

import java.util.regex.Pattern;

/***********************************************************
 Klasa: ValidationUtility
 Info: Klasa odpowiada za przechowywanie funkcji walidacyjnych dla tworzenia, edycji danych i logowania się użytkownika
 Metody:
 — public — static boolean — isValidPassword (String password)
 — public — static boolean — isValidEmail (String email)
 ************************************************************/

public class ValidationUtility {


    /***********************************************************
     Metoda: isValidPassword
     Typ Zwracany: boolean
     Info: Metoda zwracająca true/false w zależności od tego, czy `password` jest zgodny z regexem
     Argumenty:
     — String — password
     Co sprawdza regex:
     — (?=.*[a-z]) — przynajmniej jedna mała litera
     — (?=.*[A-Z]) — przynajmniej jedna wielka litera
     — (?=.*\\d) — przynajmniej jedna cyfra
     — (?=.*[@$!%*?&]) — przynajmniej jeden znak specjalny
     — [A-Za-z\\d@$!%*?&]{8,} — co najmniej 8 znaków z dozwolonego zestawu.
     ************************************************************/
    public static boolean isValidPassword(String password) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        return Pattern.matches(regex, password);
    }


    /***********************************************************
     Metoda: isValidEmail
     Typ Zwracany: boolean
     Info: Metoda zwracająca true/false w zależności od tego, czy `email` jest zgodny z regexem
     Argumenty:
     — String — password
     Co sprawdza regex:
     — ^[A-Za-z0-9+_.-]+ — początek e-maila: litery, cyfry, plus, podkreślnik, kropka, minus
     — @ — małpa
     — [A-Za-z0-9.-]+ — domena
     — [A-Za-z]{2,}$ — końcówka domeny (np: .com, .pl, .org).
     ************************************************************/
    public static boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return Pattern.matches(regex, email);
    }
}
