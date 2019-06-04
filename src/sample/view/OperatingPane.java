package sample.view;

import javafx.geometry.Pos;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import sample.utils.Const;
import sample.utils.TextSetter;
import sample.view.component.ImageButton;
import javafx.scene.shape.*;

public class OperatingPane extends VBox {
        Image startGeneralImage = new Image("./sample/res/icon/startGeneral.png");
        Image startHoverImage = new Image("./sample/res/icon/startHover.png");


        private Text startPositionTitile=TextSetter.setText("初 始 位 置",15,null, Color.BLACK);
        private TextField startIndex = new TextField("请输入磁头初始位置");
        private ImageButton startButton = new ImageButton(startGeneralImage,startHoverImage,32,32);
        private HBox titleBox = new HBox();

        public OperatingPane(){
//                setMinWidth(200);
//                setMaxWidth(200);
                startIndex.setAlignment(Pos.CENTER);
//                startIndex.setPrefColumnCount(5);
                setBackground(new Background(new BackgroundFill(Const.operatingColor,null,null)));
                Rectangle topRectangle=new Rectangle(5,200,Color.TRANSPARENT);
                Rectangle middleRectangle=new Rectangle(5,100,Color.TRANSPARENT);
                Rectangle textRectangle=new Rectangle(40,1,Color.TRANSPARENT);
                Rectangle textStartRectangle=new Rectangle(1,5,Color.TRANSPARENT);
                titleBox.getChildren().addAll(textRectangle,startPositionTitile);
                getChildren().addAll(topRectangle,titleBox,textStartRectangle,startIndex,middleRectangle,startButton);

        }
}
