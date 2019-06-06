package sample.view.component;

import javafx.scene.Cursor;
import javafx.scene.layout.StackPane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class ImageButton extends StackPane {

        private ImageView   iconImageView;
        private double iconWidth;
        private double buttonWidth;

        private Image generalImage;
        private Image hoverImage;
        public ImageButton(Image generalImage,Image hoverImage,double iconWidth,double buttonWidth){
            this.iconWidth=iconWidth;
            this.buttonWidth=buttonWidth;
            this.generalImage=generalImage;
            this.hoverImage=hoverImage;

            setMinWidth(this.buttonWidth);
            setMaxHeight(this.buttonWidth);

            iconImageView=new ImageView(this.generalImage);
            iconImageView.setFitWidth(this.iconWidth);
            iconImageView.setPreserveRatio(true);

            setOnMouseEntered(e->{
                iconImageView.setImage(this.hoverImage);
                setCursor(Cursor.HAND);
            });

            setOnMouseExited(e->{
                iconImageView.setImage(this.generalImage);
                setCursor(Cursor.DEFAULT);
            });
            getChildren().add(iconImageView);
        }

    public Image getGeneralImage() {
        return generalImage;
    }

    public void setGeneralImage(Image generalImage) {
        this.generalImage = generalImage;
    }

    public Image getHoverImage() {
        return hoverImage;
    }

    public void setHoverImage(Image hoverImage) {
        this.hoverImage = hoverImage;
    }

    public ImageView getIconImageView() {
        return iconImageView;
    }

    public void setIconImageView(ImageView iconImageView) {
        this.iconImageView = iconImageView;
    }
}
