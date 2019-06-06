package sample.utils;

import javafx.scene.paint.Color;

import java.util.regex.Pattern;

public class Const {

    public static Color operatingColor = Color.rgb(176,196,222,0.3);

    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }
}
