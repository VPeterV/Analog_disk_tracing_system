package sample.controller;

import com.sun.javafx.fxml.FXMLLoaderHelper;
import javafx.animation.*;
import javafx.application.Platform;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.util.Duration;
import sample.utils.BinarySearch;
import sample.utils.TextSetter;
import sample.view.ShowPane;

import java.sql.Time;
import java.text.CollationElementIterator;
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
    private Circle sstfCircle;
    private Circle lookCircle;
    private Circle cscanCircle;

    private boolean turnRight=false;         //The initial direction of movement of disk magnetic head

    private SimpleBooleanProperty isPlaying= new SimpleBooleanProperty(true);

    private int[] initNumber=new int[1];

    public ShowPaneController(){
        initNumber[0]=500;
        showPane=new ShowPane();
        fcfsCircle=showPane.getFcfsCircle();
        sstfCircle=showPane.getSstfCircle();
        lookCircle=showPane.getLookCircle();
        cscanCircle=showPane.getCscanCircle();
        placeCircles();
        getRandomNumbers();
        System.out.println(randomNumbers);
        this.fcfsNumbers=fcfsAlgorithm();
        this.sstfNumbers=sstfAlgorithm();
        this.lookNumbers=lookAlgorithm();
        System.out.println(this.lookNumbers);
        movementTimesTitleFcfs=showPane.getMovementTimesTitleFcfs();
        movementTimesTitleSstf=showPane.getMovementTimesTitleSstf();
        paneAnimation();

    }

    private void placeCircles(){
        fcfsCircle.setTranslateX(14+0.29*initNumber[0]);
        fcfsCircle.setTranslateY(45);

        sstfCircle.setTranslateX(14+0.29*initNumber[0]);
        sstfCircle.setTranslateY(45);

        lookCircle.setTranslateX(14+0.29*initNumber[0]);
        lookCircle.setTranslateY(45);

        cscanCircle.setTranslateX(14+0.29*initNumber[0]);
        cscanCircle.setTranslateY(45);
    }

    private void getRandomNumbers(){
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

    private ArrayList<Integer> fcfsAlgorithm(){
        ArrayList<Integer> fcfsList=new ArrayList<Integer>(400);
        for(int i=0;i<400;i++){
            System.out.println(randomNumbers.get(i));
            fcfsList.add(randomNumbers.get(i));
        }
        System.out.println(fcfsList);
        return fcfsList;
    }

    private ArrayList<Integer> sstfAlgorithm(){
        ArrayList<Integer> sstfList=new ArrayList<>(400);
        int current=initNumber[0];
        sstfNumbers.clear();
        for(int i=0;i<400;i++){
            this.sstfNumbers.add(randomNumbers.get(i));
        }

        for(int i=0;i<400;i++){
            int minIndex=0;
            int minDistance=Math.abs(current-sstfNumbers.get(0));
            for(int j=0;j<sstfNumbers.size();j++){
                if(Math.abs(current-sstfNumbers.get(j))<minDistance){
                    minIndex=j;
                    minDistance=Math.abs(current-sstfNumbers.get(j));
                }
            }
            sstfList.add(sstfNumbers.get(minIndex));
            sstfNumbers.remove(minIndex);
        }

        return sstfList;
    }

    private ArrayList<Integer> lookAlgorithm(){
        ArrayList<Integer> lookList=new ArrayList<>(400);
        int current=initNumber[0];
        lookNumbers.clear();
        for(int i=0;i<400;i++){
            this.lookNumbers.add(randomNumbers.get(i));
        }

        boolean turnRight=true;
        Collections.sort(lookNumbers);

        int miniDistanceIndex= BinarySearch.binarySearch(lookNumbers,current);
        //The number of the node which is the closest to the Initial Point

        if(this.turnRight){
            for(int i=miniDistanceIndex;i<lookNumbers.size();i++){
                lookList.add(lookNumbers.get(i));
            }
            for(int i=miniDistanceIndex-1;i>=0;i--){
                lookList.add(lookNumbers.get(i));
            }
        }
        else{
            for(int i=miniDistanceIndex-1;i>=0;i--){
                lookList.add(lookNumbers.get(i));
            }
            for(int i=miniDistanceIndex;i<lookNumbers.size();i++){
                lookList.add(lookNumbers.get(i));
            }
        }
        return lookList;

//        if(current<lookNumbers.get(miniDistanceIndex)){
//            turnRight=true;
//        }
//        else if (current>lookNumbers.get(miniDistanceIndex)){
//            turnRight= false;
//        }
//        else{
//            if(miniDistanceIndex==399){
//                turnRight=false;
//            }
//            else if(miniDistanceIndex==0){
//                turnRight=true;
//            }
//            else{
//                int compare=(lookNumbers.get(miniDistanceIndex+1)-current)-(current-lookNumbers.get(miniDistanceIndex-1));
//                if(compare)
//            }
//        }

    }

    public void paneAnimation(){
        int[] fcfsIndexNumber=new int[1];
        fcfsIndexNumber[0]=0;
        int [] fcfsInitNumber=new int[1];
        fcfsInitNumber[0]=initNumber[0];
        int[] fcfsMoveTimes=new int[1];
        fcfsMoveTimes[0]=0;
        EventHandler<ActionEvent> fcfsEventEventHandler=e->{
            int fcfsNumber=fcfsGetNumber(fcfsIndexNumber[0]);
            fcfsMoveTimes[0]+=Math.abs((fcfsNumber-fcfsInitNumber[0]));
            fcfsInitNumber[0]=fcfsNumber;
            fcfsIndexNumber[0]++;
            fcfsCircle.setTranslateX(14+0.29*fcfsNumber);
            movementTimesTitleFcfs.setText("磁头移动次数 : "+String.valueOf(fcfsMoveTimes[0]));
        };

        int[] sstfIndexNumber=new int[1];
        sstfIndexNumber[0]=0;
        int[] sstfInitNumber=new int[1];
        sstfInitNumber[0]=initNumber[0];
        int[] sstfMoveTimes=new int[1];
        sstfMoveTimes[0]=0;
        EventHandler<ActionEvent> sstfEventEventHandler=e->{
            int sstfNumber=sstfGetNumber(sstfIndexNumber[0]);
            sstfMoveTimes[0]+=Math.abs((sstfNumber-sstfInitNumber[0]));
            sstfInitNumber[0]=sstfNumber;
            sstfIndexNumber[0]++;
            sstfCircle.setTranslateX(14+0.29*sstfNumber);
            movementTimesTitleSstf.setText("磁头移动次数 : "+String.valueOf(sstfMoveTimes[0]));
        };

        Timeline timeline=new Timeline();
        timeline.getKeyFrames().addAll(new KeyFrame(Duration.millis(100),fcfsEventEventHandler),
                new KeyFrame(Duration.millis(100),sstfEventEventHandler));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

    }
//        timer.start();
    private int fcfsGetNumber(int index){
        return fcfsNumbers.get(index);
    }

    private int sstfGetNumber(int index){
        return sstfNumbers.get(index);
    }

    private int lookGetNumber(int index){
        return lookNumbers.get(index);
    }

    public ShowPane getShowPane() {
        return showPane;
    }

    public void setShowPane(ShowPane showPane) {
        this.showPane = showPane;
    }
}
