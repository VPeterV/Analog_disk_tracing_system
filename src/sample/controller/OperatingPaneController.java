package sample.controller;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import jdk.jfr.Event;
import sample.utils.TextSetter;
import sample.view.OperatingPane;
import sample.view.component.ImageButton;

import java.net.http.HttpResponse;

public class OperatingPaneController {
    private OperatingPane operatingPane;

    private TextField startIndex;
    private ImageButton startButton;
    ImageView startButtonIcon;
    private ImageButton confirmButton;

    private Image startGeneralImage;
    private Image startHoverImage;
    private Image pauseGenralImage;
    private Image pauseHoverImage;

    private SimpleBooleanProperty isPlaying=new SimpleBooleanProperty(false);

    public OperatingPaneController(){
        operatingPane=new OperatingPane();

        this.startGeneralImage=operatingPane.getStartGeneralImage();
        this.startHoverImage=operatingPane.getStartHoverImage();
        this.pauseGenralImage=operatingPane.getPauseGenralImage();
        this.pauseHoverImage=operatingPane.getPauseHoverImage();

        startIndex=operatingPane.getStartIndex();
        startButton=operatingPane.getStartButton();
        this.startButtonIcon=startButton.getIconImageView();
        this.confirmButton=operatingPane.getConfirmButton();

        clickStartButton();
    }

    public void clickStartButton(){
        startButton.setOnMouseClicked(e->{
            System.out.println("点击了一下");
            if(!isPlaying.get()){
                isPlaying.set(true);
                System.out.println(isPlaying.get());
                startButton.setGeneralImage(pauseGenralImage);
                startButton.setHoverImage(pauseHoverImage);
            }
            else{
                isPlaying.set(false);
                System.out.println(isPlaying.get());
                startButton.setGeneralImage(startGeneralImage);
                startButton.setHoverImage(startHoverImage);
            }
        });
    }

    public OperatingPane getOperatingPane() {
        return operatingPane;
    }

    public SimpleBooleanProperty isPlayingProperty() {
        return isPlaying;
    }

    public TextField getStartIndex() {
        return startIndex;
    }

}
