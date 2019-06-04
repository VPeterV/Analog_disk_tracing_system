package sample.view.component;

import javafx.scene.Cursor;
import javafx.scene.layout.StackPane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class ImageButton extends StackPane {

        private ImageView   iconImageView;
        private double iconWidth;
        private double buttonWidth;
        public ImageButton(Image generalImage,Image hoverImage,double iconWidth,double buttonWidth){
            this.iconWidth=iconWidth;
            this.buttonWidth=buttonWidth;

            setMinWidth(buttonWidth);
            setMaxHeight(buttonWidth);

            iconImageView=new ImageView(generalImage);
            iconImageView.setFitWidth(iconWidth);
            iconImageView.setPreserveRatio(true);

            setOnMouseEntered(e->{
                iconImageView.setImage(hoverImage);
                setCursor(Cursor.HAND);
            });

            setOnMouseExited(e->{
                iconImageView.setImage(generalImage);
                setCursor(Cursor.DEFAULT);
            });
            getChildren().add(iconImageView);
        }
}
