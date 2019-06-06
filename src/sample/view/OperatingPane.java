package sample.view;

import javafx.geometry.Pos;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import sample.utils.Const;
import sample.utils.TextSetter;
import sample.view.component.ImageButton;
import javafx.scene.shape.*;

public class OperatingPane extends Pane {
        private Image startGeneralImage = new Image("./sample/res/icon/startGeneral.png");
        private Image startHoverImage = new Image("./sample/res/icon/startHover.png");
        private Image pauseGenralImage = new Image("./sample/res/icon/pauseGeneral.png");
        private Image pauseHoverImage = new Image("./sample/res/icon/pauseHover.png");
        private Image confirmGenralImage = new Image("./sample/res/icon/confirmGeneral.png");
        private Image confirmHover = new Image("./sample/res/icon/confirmHover.png");


        private Text startPositionTitile=TextSetter.setText("初始位置",15,null, Color.BLACK);
        private TextField startIndex = new TextField("请输入磁头初始位置(默认750)");
        private ImageButton startButton = new ImageButton(startGeneralImage,startHoverImage,50,50);
        private ImageButton confirmButton = new ImageButton(confirmGenralImage,confirmHover,32,32);
        private HBox titleBox = new HBox();

        public OperatingPane(){
                setPrefSize(200,200);
                startIndex.setPrefSize(132,30);
                startIndex.setTranslateX(34);
                startIndex.setTranslateY(220);
//                startIndex.setPrefColumnCount(5);
                setBackground(new Background(new BackgroundFill(Const.operatingColor,null,null)));
//                Rectangle topRectangle=new Rectangle(5,200,Color.TRANSPARENT);
//                Rectangle middleRectangle=new Rectangle(5,100,Color.TRANSPARENT);
//                Rectangle textRectangle=new Rectangle(15,1,Color.TRANSPARENT);
//                Rectangle textStartRectangle=new Rectangle(1,5,Color.TRANSPARENT);

                startPositionTitile.setTranslateX(70);
                startPositionTitile.setTranslateY(208);
                confirmButton.setTranslateX(82.5);
                confirmButton.setTranslateY(263);
                startButton.setTranslateX(75);
                startButton.setTranslateY(362);

                getChildren().addAll(startPositionTitile,startIndex,startButton,confirmButton);

        }

        public TextField getStartIndex() {
                return startIndex;
        }

        public void setStartIndex(TextField startIndex) {
                this.startIndex = startIndex;
        }

        public ImageButton getStartButton() {
                return startButton;
        }

        public void setStartButton(ImageButton startButton) {
                this.startButton = startButton;
        }

        public Image getStartGeneralImage() {
                return startGeneralImage;
        }

        public void setStartGeneralImage(Image startGeneralImage) {
                this.startGeneralImage = startGeneralImage;
        }

        public Image getStartHoverImage() {
                return startHoverImage;
        }

        public void setStartHoverImage(Image startHoverImage) {
                this.startHoverImage = startHoverImage;
        }

        public Image getPauseGenralImage() {
                return pauseGenralImage;
        }

        public void setPauseGenralImage(Image pauseGenralImage) {
                this.pauseGenralImage = pauseGenralImage;
        }

        public Image getPauseHoverImage() {
                return pauseHoverImage;
        }

        public void setPauseHoverImage(Image pauseHoverImage) {
                this.pauseHoverImage = pauseHoverImage;
        }

        public ImageButton getConfirmButton() {
                return confirmButton;
        }

        public void setConfirmButton(ImageButton confirmButton) {
                this.confirmButton = confirmButton;
        }
}
