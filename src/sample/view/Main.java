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
import sample.view.component.ImageButton;

public class Main extends Application {

    private OperatingPaneController operatingPaneController=new OperatingPaneController();
    private ShowPaneController showPaneController = new ShowPaneController(operatingPaneController);

    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane allPane=new BorderPane();


        Pane showPane= showPaneController.getShowPane();
        OperatingPane operatingPane=operatingPaneController.getOperatingPane();
        ImageButton confirmButton=operatingPane.getConfirmButton();


        BackgroundSetter.colorSetter(allPane,Color.TRANSPARENT);
        allPane.setLeft(operatingPane);
        allPane.setCenter(showPane);

        Scene scene=new Scene(allPane,1024,600);
        primaryStage.setScene(scene);
        primaryStage.show();

        confirmButton.setOnMouseClicked(e->{
            showPane.getChildren().clear();
            allPane.setCenter(null);
            showPaneController=new ShowPaneController(operatingPaneController);
            Pane showPane_new=showPaneController.getShowPane();
            allPane.setCenter(showPane_new);
        });

    }


    public static void main(String[] args) {
        launch(args);
    }


}
