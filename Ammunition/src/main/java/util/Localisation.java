package main.java.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class Localisation {

    static private Locale currentLocale = new Locale("en", "US");
    static private ResourceBundle messages = ResourceBundle.getBundle("localization", currentLocale);

    public static String getMessage(String message) {
        return messages.getString(message);
    }

    public static void setLocale(String language, String country) {
        currentLocale = new Locale(language, country);
        messages = ResourceBundle.getBundle("localization", currentLocale);
    }
}