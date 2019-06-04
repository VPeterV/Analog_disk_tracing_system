package sample.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sample.controller.OperatingPaneController;
import sample.controller.ShowPaneController;
import sample.utils.*;

public class Main extends Application {

    private OperatingPaneController operatingPaneController=new OperatingPaneController();
    private ShowPaneController showPaneController = new ShowPaneController();

    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane allPane=new BorderPane();
//        allPane.setMinSize(1024,768);
//        allPane.setMaxSize(1024,768);

        //TODO 主界面还没有完成
        Pane showPane= showPaneController.getShowPane();
//        showPane.setMinHeight(700);
//        showPane.setMaxHeight(700);
//        showPane.setMinWidth(1210);
//        showPane.setMaxWidth(1210);

        OperatingPane operatingPane=new OperatingPane();
//        allPane.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,null,null)));
        BackgroundSetter.colorSetter(allPane,Color.TRANSPARENT);
        allPane.setLeft(operatingPane);
        allPane.setCenter(showPane);

        Scene scene=new Scene(allPane,1024,600);
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
