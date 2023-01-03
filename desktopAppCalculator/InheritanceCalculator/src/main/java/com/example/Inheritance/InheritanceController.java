package com.example.Inheritance;

import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;

public class InheritanceController {


    @FXML
    public TextArea resultTextArea;
    @FXML
    private Slider nbWivesSlider, nbSonsSlider, nbDaughtersSlider;

    @FXML
    private TextField inheritance;



    private Integer nbWives;
    private Integer nbSons;
    private Integer nbDaughters;


    @FXML
    protected void onWifeSliderChanged(){
        this.nbWives = (int) nbWivesSlider.getValue();
    }

    @FXML
    protected void onSonSliderChanged(){
        this.nbSons = (int) nbSonsSlider.getValue();
    }

    @FXML
    protected void onDaughterSliderChanged(){
        this.nbDaughters = (int) nbDaughtersSlider.getValue();
    }

    @FXML
    protected void onCalculateButtonClick() {
        int inheritanceValue;
        try {
            inheritanceValue = Integer.parseInt(inheritance.getText());
        } catch (Exception e) {
            inheritanceValue = 0;
        }

        if(!(nbDaughters instanceof Integer))  nbDaughters = 0;
        if(!(nbSons instanceof Integer))  nbSons = 0;
        if(!(nbWives instanceof Integer))  nbWives = 0;

        float inheritance = (float) inheritanceValue;


        float wifeShare = nbWives == 0 ? 0: inheritance / 8f;
        wifeShare = (nbDaughters == 0 && nbSons == 0 && nbWives != 0) ? inheritance : wifeShare;


        inheritance -= wifeShare;

        float sonShare = nbSons == 0 ? 0 : ((nbSons * 2) / ((nbSons * 2f) + nbDaughters));

        float sonsShare = inheritance * sonShare;

        inheritance -= inheritance * sonShare;

        float daughterShare = inheritance;

        DecimalFormat df = new DecimalFormat("#.##");

        float eachWife = nbWives == 0 ? 0 : wifeShare / nbWives;
        float eachSon = nbSons == 0 ? 0 : sonsShare / nbSons;
        float eachDaughter = nbDaughters == 0 ? 0 : daughterShare / nbDaughters;

        resultTextArea.setText(
                "all wives" + "(" + nbWives + ") take $"  +  df.format(wifeShare) + " each wife takes $" + df.format(eachWife) + "\n\n"
                + "all sons(" + nbSons + ") take $" + df.format(sonsShare) + " each son takes $" + df.format(eachSon)  + "\n\n"
                + "all daughters(" + nbDaughters + ") take $" + df.format(daughterShare) + " each daughter takes $" + df.format( eachDaughter)

        );



    }

}