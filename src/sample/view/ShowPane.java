package sample.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import sample.utils.BackgroundSetter;
import sample.utils.TextSetter;

public class ShowPane extends Pane {
        private int titleSize=15;
        private int resultSize=12;
        private Text fcfsTitle= TextSetter.setText("FCFS",titleSize,null, Color.BLACK);
        private Text sstfTitle= TextSetter.setText("SSTF",titleSize,null,Color.BLACK);
        private Text lookTitle=TextSetter.setText("电梯Look",titleSize,null,Color.BLACK);
        private Text cscanTitle=TextSetter.setText("C-SCAN",titleSize,null,Color.BLACK);
        private Text movementTimesTitleFcfs=TextSetter.setText("磁头移动次数 : 0",resultSize,null,Color.BLACK);
        private Text movementTimesTitleSstf=TextSetter.setText("磁头移动次数: 0",resultSize,null,Color.BLACK);
        private Text movementTimesTitleLook=TextSetter.setText("磁头移动次数: 0",resultSize,null,Color.BLACK);
        private Text movementTimesTitleCscan=TextSetter.setText("磁头移动次数: 0",resultSize,null,Color.BLACK);

        private Pane fcfsPane= new Pane();
        private Pane sstfPane=new Pane();
        private Pane lookPane=new Pane();
        private Pane cscanPane=new Pane();

        private VBox allNodes=new VBox();

        private Circle fcfsCircle=new Circle(5,Color.BLUE);

//        private Circle[] fcfsCircles=new Circle[1500];
//        private Circle[] sstfCircles=new Circle[1500];
//        private Circle[] lookCircle=new Circle[1500];
//        private Circle[] cscanCircle=new Circle[1500];

    public ShowPane(){
        setPosition();
        placeCircles();
//        placeCircles();
//        setAlignment(Pos.CENTER);
//        setPadding(new Insets(1000,1000,1000,1000 ));

        getChildren().addAll(fcfsTitle,fcfsPane,movementTimesTitleFcfs,sstfTitle,sstfPane,movementTimesTitleSstf,lookTitle,lookPane,movementTimesTitleLook,
                cscanTitle,cscanPane,movementTimesTitleCscan);
//        fcfsTitle.setTranslateX(10);
//        setCenter(allNodes);
    }

    private void setPosition(){
        BackgroundSetter.colorSetter(fcfsPane,Color.GREY);
        fcfsPane.setPrefSize(550,90);
        fcfsPane.setTranslateX(149);
        fcfsPane.setTranslateY(38);
        BackgroundSetter.colorSetter(sstfPane,Color.GREY);
        sstfPane.setPrefSize(550,90);
        sstfPane.setTranslateX(149);
        sstfPane.setTranslateY(169);
        BackgroundSetter.colorSetter(lookPane,Color.GREY);
        lookPane.setPrefSize(550,90);
        lookPane.setTranslateX(149);
        lookPane.setTranslateY(300);
        BackgroundSetter.colorSetter(cscanPane,Color.GREY);
        cscanPane.setPrefSize(550,90);
        cscanPane.setTranslateX(149);
        cscanPane.setTranslateY(431);

        fcfsTitle.setTranslateX(149);
        fcfsTitle.setTranslateY(30);
        sstfTitle.setTranslateX(149);
        sstfTitle.setTranslateY(156);
        lookTitle.setTranslateX(149);
        lookTitle.setTranslateY(290);
        cscanTitle.setTranslateX(149);
        cscanTitle.setTranslateY(418);

        movementTimesTitleFcfs.setTranslateX(600);
        movementTimesTitleFcfs.setTranslateY(146);
        movementTimesTitleSstf.setTranslateX(600);
        movementTimesTitleSstf.setTranslateY(273);
        movementTimesTitleLook.setTranslateX(600);
        movementTimesTitleLook.setTranslateY(408);
        movementTimesTitleCscan.setTranslateX(600);
        movementTimesTitleCscan.setTranslateY(535);
    }

    private void placeCircles(){
        fcfsCircle.setTranslateX(14);
        fcfsCircle.setTranslateY(45);
        fcfsPane.getChildren().add(fcfsCircle);


    }

//    private void placeCircles(){
//        int translateX=14;
//        int translateY=75;
//
//        for(int i=0;i<1000;i++){
//            fcfsCircles[i]=new Circle(0.5,Color.BLUE);
//            fcfsCircles[i].setId(Integer.toString(i));
//            fcfsCircles[i].setTranslateX(translateX);
//            fcfsCircles[i].setTranslateY(translateY);
//            fcfsPane.getChildren().add(fcfsCircles[i]);
//            translateY-=5;
//            if(i%10==0){
//                translateX+=5;
//                translateY=75;
//            }
//        }
//    }

    public int getTitleSize() {
        return titleSize;
    }

    public void setTitleSize(int titleSize) {
        this.titleSize = titleSize;
    }

    public int getResultSize() {
        return resultSize;
    }

    public void setResultSize(int resultSize) {
        this.resultSize = resultSize;
    }

    public Text getFcfsTitle() {
        return fcfsTitle;
    }

    public void setFcfsTitle(Text fcfsTitle) {
        this.fcfsTitle = fcfsTitle;
    }

    public Text getSstfTitle() {
        return sstfTitle;
    }

    public void setSstfTitle(Text sstfTitle) {
        this.sstfTitle = sstfTitle;
    }

    public Text getLookTitle() {
        return lookTitle;
    }

    public void setLookTitle(Text lookTitle) {
        this.lookTitle = lookTitle;
    }

    public Text getCscanTitle() {
        return cscanTitle;
    }

    public void setCscanTitle(Text cscanTitle) {
        this.cscanTitle = cscanTitle;
    }

    public Text getMovementTimesTitleFcfs() {
        return movementTimesTitleFcfs;
    }

    public void setMovementTimesTitleFcfs(Text movementTimesTitleFcfs) {
        this.movementTimesTitleFcfs = movementTimesTitleFcfs;
    }

    public Text getMovementTimesTitleSstf() {
        return movementTimesTitleSstf;
    }

    public void setMovementTimesTitleSstf(Text movementTimesTitleSstf) {
        this.movementTimesTitleSstf = movementTimesTitleSstf;
    }

    public Text getMovementTimesTitleLook() {
        return movementTimesTitleLook;
    }

    public void setMovementTimesTitleLook(Text movementTimesTitleLook) {
        this.movementTimesTitleLook = movementTimesTitleLook;
    }

    public Text getMovementTimesTitleCscan() {
        return movementTimesTitleCscan;
    }

    public void setMovementTimesTitleCscan(Text movementTimesTitleCscan) {
        this.movementTimesTitleCscan = movementTimesTitleCscan;
    }

    public Pane getFcfsPane() {
        return fcfsPane;
    }

    public void setFcfsPane(Pane fcfsPane) {
        this.fcfsPane = fcfsPane;
    }

    public Pane getSstfPane() {
        return sstfPane;
    }

    public void setSstfPane(Pane sstfPane) {
        this.sstfPane = sstfPane;
    }

    public Pane getLookPane() {
        return lookPane;
    }

    public void setLookPane(Pane lookPane) {
        this.lookPane = lookPane;
    }

    public Pane getCscanPane() {
        return cscanPane;
    }

    public void setCscanPane(Pane cscanPane) {
        this.cscanPane = cscanPane;
    }

    public VBox getAllNodes() {
        return allNodes;
    }

    public void setAllNodes(VBox allNodes) {
        this.allNodes = allNodes;
    }

    public Circle getFcfsCircle() {
        return fcfsCircle;
    }

    public void setFcfsCircle(Circle fcfsCircle) {
        this.fcfsCircle = fcfsCircle;
    }

    //
//    public Circle[] getFcfsCircles() {
//        return fcfsCircles;
//    }
//
//    public void setFcfsCircles(Circle[] fcfsCircles) {
//        this.fcfsCircles = fcfsCircles;
//    }
//
//    public Circle[] getSstfCircles() {
//        return sstfCircles;
//    }
//
//    public void setSstfCircles(Circle[] sstfCircles) {
//        this.sstfCircles = sstfCircles;
//    }
//
//    public Circle[] getLookCircle() {
//        return lookCircle;
//    }
//
//    public void setLookCircle(Circle[] lookCircle) {
//        this.lookCircle = lookCircle;
//    }
//
//    public Circle[] getCscanCircle() {
//        return cscanCircle;
//    }
//
//    public void setCscanCircle(Circle[] cscanCircle) {
//        this.cscanCircle = cscanCircle;
//    }
}
