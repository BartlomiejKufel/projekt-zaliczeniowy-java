package com.crowdle.utility;

import java.util.regex.Pattern;

public class ValidationUtility {

    //Co sprawdza isValidPassword:
    //  (?=.*[a-z]) – przynajmniej jedna mała litera,
    //  (?=.*[A-Z]) – przynajmniej jedna wielka litera,
    //  (?=.*\\d) – przynajmniej jedna cyfra,
    //  (?=.*[@$!%*?&]) – przynajmniej jeden znak specjalny,
    //  [A-Za-z\\d@$!%*?&]{8,} – co najmniej 8 znaków z dozwolonego zestawu.
    public static boolean isValidPassword(String password) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        return Pattern.matches(regex, password);
    }

    //Co sprawdza isValidEmail:
    //  ^[A-Za-z0-9+_.-]+ – początek e-maila: litery, cyfry, plus, podkreślnik, kropka, minus,
    //  @ – małpa,
    //  [A-Za-z0-9.-]+ – domena,
    //  \\.[A-Za-z]{2,}$ – końcówka domeny (np: .com, .pl, .org).
    public static boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return Pattern.matches(regex, email);
    }
}
