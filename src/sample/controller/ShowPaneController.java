package sample.controller;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.util.Duration;
import sample.utils.TextSetter;
import sample.view.ShowPane;

import java.util.ArrayList;
import java.util.Collections;

public class ShowPaneController {
    private ShowPane showPane;
    private ArrayList<Integer> randomNumbers=new ArrayList<Integer>(400);
    private int firstNumbers=200;       //0-499
    private int secondNumbers=100;      //500-999
    private int thirdNumbers=100;       //1000-1499

    private Text movementTimesTitleFcfs;
    private Text movementTimesTitleSstf;
    private Text movementTimesTitleLook;
    private Text movementTimesTitleCscan;

    private ArrayList<Integer> fcfsNumbers=new ArrayList<Integer>(400);
    private ArrayList<Integer> sstfNumbers=new ArrayList<>(400);
    private ArrayList<Integer> lookNumbers=new ArrayList<>(400);
    private ArrayList<Integer> cscanNumbers=new ArrayList<>(400);

    private Circle fcfsCircle;

    private SimpleBooleanProperty isPlaying= new SimpleBooleanProperty(true);

    public ShowPaneController(){
        showPane=new ShowPane();
        fcfsCircle=showPane.getFcfsCircle();
        getRandomNumbers();
        System.out.println(randomNumbers);
        this.fcfsNumbers=fcfsAlgorithm();
        System.out.println(this.fcfsNumbers);
        updatePane();

    }

    public void getRandomNumbers(){
//        int firstSize=0;
//        int secondSize=0;
//        int thirdSize=0;
//        while (firstSize<firstNumbers || secondSize<secondNumbers || thirdSize<thirdNumbers){
//            int randomNumber=(int)(Math.random()*(1499-0))+0;
//            if(firstSize>=firstNumbers){
//                while (randomNumber<499) {
//                    randomNumber = (int) (Math.random() * (1499 - 0)) + 0;
//                }
//            }
//            if(secondSize>=secondNumbers){
//                while (randomNumber)
//            }
//        }
//        int[] a=new int[10];
//        a.shuff
        for(int i=0;i<200;i++){
            int randomNumber=(int)(Math.random()*(499-0))+0;
            randomNumbers.add(Integer.valueOf(randomNumber));
        }
        for(int i=0;i<100;i++){
            int randomNumber=(int)(Math.random()*(999-500))+500;
            randomNumbers.add(Integer.valueOf(randomNumber));
        }
        for(int i=0;i<100;i++){
            int randomNumber=(int)(Math.random()*(1499-1000))+1000;
            randomNumbers.add(Integer.valueOf(randomNumber));
        }
        Collections.shuffle(randomNumbers);
    }

    public ArrayList<Integer> fcfsAlgorithm(){
        ArrayList<Integer> fcfsList=new ArrayList<Integer>(400);
        for(int i=0;i<400;i++){
            System.out.println(randomNumbers.get(i));
            fcfsList.add(randomNumbers.get(i));
        }
        System.out.println(fcfsList);
        return fcfsList;
    }

    public void updatePane(){
        Timeline timeline =  new Timeline();
//        timeline.setCycleCount(Timeline.INDEFINITE);
//        timeline.setAutoReverse(true);
        for(int i=0;i<400;i++){
            System.out.println(i);
            KeyValue kv=new KeyValue(fcfsCircle.translateXProperty(),14+fcfsNumbers.get(i)*0.29);
            KeyFrame kf=new KeyFrame(Duration.millis(4000),kv);
            fcfsCircle.setTranslateX(14+fcfsNumbers.get(i)*0.29);


            timeline.getKeyFrames().add(kf);


//            path.getElements().add(new MoveTo(14+0.29*fcfsNumbers.get(i),45));
//            path.getElements().add(new LineTo(14,75));
        }
//        PathTransition pt=new PathTransition();
//        pt.setDuration(Duration.millis(30000));
//        pt.setPath(path);
//        pt.setNode(this.fcfsCircle);
//        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
//        pt.setAutoReverse(true);
//        pt.play();
        timeline.play();

    }

    public ShowPane getShowPane() {
        return showPane;
    }

    public void setShowPane(ShowPane showPane) {
        this.showPane = showPane;
    }
}
