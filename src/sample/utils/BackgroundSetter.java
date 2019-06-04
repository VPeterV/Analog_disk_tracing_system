package sample.utils;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class BackgroundSetter {
    public static void colorSetter(Pane pane, Color color){
        pane.setBackground(new Background(new BackgroundFill(color,null,null)));

    }
}
