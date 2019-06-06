package sample.controller;

import com.sun.javafx.fxml.FXMLLoaderHelper;
import javafx.animation.*;
import javafx.application.Platform;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.paint.Stop;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.util.Duration;
import sample.utils.BinarySearch;
import sample.utils.Const;
import sample.utils.TextSetter;
import sample.view.OperatingPane;
import sample.view.ShowPane;

import javax.naming.TimeLimitExceededException;
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

    private SimpleBooleanProperty isPlaying;

    private int[] initNumber=new int[1];

    private OperatingPaneController operatingPaneController;

    public ShowPaneController(OperatingPaneController operatingPaneController){

        this.operatingPaneController=operatingPaneController;
        this.isPlaying=this.operatingPaneController.isPlayingProperty();

        initNumber[0]=750;
//        if(operatingPaneController.getStartIndex().getText())

        if(Const.isInteger(operatingPaneController.getStartIndex().getText())){
            int inputNumber=Integer.valueOf(operatingPaneController.getStartIndex().getText());
            if(inputNumber>=0 && inputNumber<=1499){
                initNumber[0]=inputNumber;
            }
        }

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
        this.cscanNumbers=cscanAlgorithm();
        System.out.println(this.sstfNumbers);
        System.out.println(this.lookNumbers);
        System.out.println(this.cscanNumbers);

        movementTimesTitleFcfs=showPane.getMovementTimesTitleFcfs();
        movementTimesTitleSstf=showPane.getMovementTimesTitleSstf();
        movementTimesTitleLook=showPane.getMovementTimesTitleLook();
        movementTimesTitleCscan=showPane.getMovementTimesTitleCscan();
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
    }

    private ArrayList<Integer> cscanAlgorithm(){
        ArrayList<Integer> cscanList=new ArrayList<>(400);
        int current=initNumber[0];
        cscanNumbers.clear();
        for(int i=0;i<400;i++){
            cscanNumbers.add(randomNumbers.get(i));
        }

        Collections.sort(cscanNumbers);
        int miniDistanceIndex= BinarySearch.binarySearch(cscanNumbers,current);


        if(this.turnRight){
            for(int i=miniDistanceIndex;i<cscanNumbers.size();i++){
                cscanList.add(cscanNumbers.get(i));
            }
            for(int i=0;i<miniDistanceIndex;i++){
                cscanList.add(cscanNumbers.get(i));
            }
        }
        else{
            for(int i=miniDistanceIndex-1;i>=0;i--){
                cscanList.add(cscanNumbers.get(i));
            }
            for(int i=cscanNumbers.size()-1;i>=miniDistanceIndex;i--){
                cscanList.add(cscanNumbers.get(i));
            }
        }
        return cscanList;
    }

    public void paneAnimation(){
        int[] fcfsIndexNumber=new int[1];
        fcfsIndexNumber[0]=0;
        int [] fcfsInitNumber=new int[1];
        fcfsInitNumber[0]=initNumber[0];
        int[] fcfsMoveTimes=new int[1];
        fcfsMoveTimes[0]=0;
        EventHandler<ActionEvent> fcfsEventEventHandler=e->{
            if (fcfsIndexNumber[0]<=399){
                int fcfsNumber=fcfsGetNumber(fcfsIndexNumber[0]);
                fcfsMoveTimes[0]+=Math.abs((fcfsNumber-fcfsInitNumber[0]));
                fcfsInitNumber[0]=fcfsNumber;
                fcfsIndexNumber[0]++;
                fcfsCircle.setTranslateX(14+0.29*fcfsNumber);
                movementTimesTitleFcfs.setText("磁头移动次数 : "+String.valueOf(fcfsMoveTimes[0]));
            }

        };

        int[] sstfIndexNumber=new int[1];
        sstfIndexNumber[0]=0;
        int[] sstfInitNumber=new int[1];
        sstfInitNumber[0]=initNumber[0];
        int[] sstfMoveTimes=new int[1];
        sstfMoveTimes[0]=0;
        System.out.println("SSTF");
        System.out.println(sstfNumbers);
        EventHandler<ActionEvent> sstfEventEventHandler=e->{
            if(sstfIndexNumber[0]<=399){
                int sstfNumber=sstfGetNumber(sstfIndexNumber[0]);
                sstfMoveTimes[0]+=Math.abs((sstfNumber-sstfInitNumber[0]));
                sstfInitNumber[0]=sstfNumber;
                sstfIndexNumber[0]++;
                sstfCircle.setTranslateX(14+0.29*sstfNumber);
                movementTimesTitleSstf.setText("磁头移动次数 : "+String.valueOf(sstfMoveTimes[0]));
            }

        };

        int[] lookIndexNumber=new int[1];
        lookIndexNumber[0]=0;
        int[] lookInitNumber=new int[1];
        lookInitNumber[0]=initNumber[0];
        int[] lookMoveTimes=new int[1];
        lookMoveTimes[0]=0;
        EventHandler<ActionEvent> lookEventEventHandler=e->{
            if(lookIndexNumber[0]<=399){
                int lookNumber=lookGetNumber(lookIndexNumber[0]);
                lookMoveTimes[0]+=Math.abs((lookNumber-lookInitNumber[0]));
                lookInitNumber[0]=lookNumber;
                lookIndexNumber[0]++;
                lookCircle.setTranslateX(14+0.29*lookNumber);
                movementTimesTitleLook.setText("磁头移动次数 : "+String.valueOf(lookMoveTimes[0]));
            }

        };

        int[] cscanIndexNumber=new int[1];
        cscanIndexNumber[0]=0;
        int[] cscanInitNumber=new int[1];
        cscanInitNumber[0]=initNumber[0];
        int[] cscanMoveTimes=new int[1];
        cscanMoveTimes[0]=0;
        EventHandler<ActionEvent> cscanEventEventHandler=e->{
            if(cscanIndexNumber[0]<=399){
                int cscanNumber=cscanGetNumber(cscanIndexNumber[0]);
                cscanMoveTimes[0]+=Math.abs((cscanNumber-cscanInitNumber[0]));
                cscanInitNumber[0]=cscanNumber;
                cscanIndexNumber[0]++;
                cscanCircle.setTranslateX(14+0.29*cscanNumber);
                movementTimesTitleCscan.setText("磁头移动次数 : "+String.valueOf(cscanMoveTimes[0]));
            }

        };

        Timeline timeline=new Timeline();
        timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.millis(100),fcfsEventEventHandler),
                new KeyFrame(Duration.millis(100),sstfEventEventHandler),
                new KeyFrame(Duration.millis(100),lookEventEventHandler),
                new KeyFrame(Duration.millis(100),cscanEventEventHandler));

        timeline.setCycleCount(Timeline.INDEFINITE);
        this.isPlaying.addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if(t1.booleanValue()){
                    timeline.play();
                }
                else{
                    timeline.pause();
                }
            }
        });
        if(fcfsMoveTimes[0]==399){
            timeline.stop();
        }

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

    private int cscanGetNumber(int index){return cscanNumbers.get(index);}

    public ShowPane getShowPane() {
        return showPane;
    }

    public void setShowPane(ShowPane showPane) {
        this.showPane = showPane;
    }
}
