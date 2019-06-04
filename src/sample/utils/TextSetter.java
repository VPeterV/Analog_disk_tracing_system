package sample.utils;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class TextSetter {
    public static Text setText(String title,double titleSize,String titleId, Color color){
        Text text=new Text(title);
        text.setFont(Font.font(titleSize));
        text.setId(titleId);
        text.setFill(color);
        return text;
    }
}
