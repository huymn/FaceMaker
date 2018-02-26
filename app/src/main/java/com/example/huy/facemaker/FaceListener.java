package com.example.huy.facemaker;

import android.content.Context;
import android.support.annotation.IdRes;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.huy.facemaker.R.id.eyesRadioButton;
import static com.example.huy.facemaker.R.id.hairSpinner;

/**
 * Listener class that defines the actions of the views
 *
 * @author Huy Nguyen
 * Created on 2/12/2018
 * Last updated: 2/15/2018
 */

public class FaceListener implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, AdapterView.OnItemSelectedListener,
        RadioGroup.OnCheckedChangeListener {


    //Array list of the seekbar
    ArrayList<SeekBar> allSB = new ArrayList<SeekBar>();
    //Array list of the text views
    ArrayList<TextView> allTV = new ArrayList<TextView>();

    //Instance variables for the red, green, and blue seek bars
    private SeekBar redSB, greenSB, blueSB = null;

    //Instance variables for the red, green, and blue text views
    private TextView redTV, greenTV, blueTV = null;


    //Instance variable see which radio button is selected
    private int whichRB;

    //Create the face object
    Face face = null;

    public FaceListener(Face initFace) {
        face = initFace;


    }

    /**
     * Add all the seek bars the array list
     * @param sb
     */
    public void addSB(SeekBar sb){
        allSB.add(sb);
    }

    /**
     * Add all the text views to the array list
     * @param tv
     */
    public void addTV(TextView tv){
        allTV.add(tv);
    }

    /**
     * Assign the correct seek bars from the array list to the
     * instance seek bar variables
     */
    public void registerSeekBars(){
        for(SeekBar sb : allSB){
            if(sb.getId() == R.id.redSeekBar){
                redSB = sb;
            }
            else if(sb.getId() == R.id.greenSeekBar){
                greenSB = sb;
            }
            else if(sb.getId() == R.id.blueSeekBar){
                blueSB = sb;
            }
        }
    }

    /**
     * Assign the correct text views from the array list to the
     * instance text view variables
     */
    public void registerTextViews(){
        for(TextView tv : allTV){
            if(tv.getId() == R.id.redValue){
                redTV = tv;
            }
            else if(tv.getId() == R.id.greenValue){
                greenTV = tv;
            }
            else if(tv.getId() == R.id.blueValue) {
                blueTV = tv;
            }
        }
    }

    /**
     * Whenever the "Random Button" is clicked,
     * create a random new avatar
     * @param v
     */
    @Override
    public void onClick(View v) {
        face.randomize();
        face.invalidate();
    }

    /**
     * Check which spinner item is selected and update the avatar
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        /**
         External citation
            Date:     2/13/2018
            Problem:  Have no idea how to use spinners
            Resource:
                https://developer.android.com/guide/topics/ui/controls/spinner.html
            Solution: Used help from the android website

         */
        //Get the name of the item select
       String hairStyleName = (String)parent.getItemAtPosition(position);

        if(hairStyleName.equalsIgnoreCase("Rectangle")) {
            //Rectangle is being select
            face.setRectHair();
            face.invalidate();
        }
        else if(hairStyleName.equalsIgnoreCase("Oval")){
            //Oval is being select
            face.setOvalHair();
            face.invalidate();
        }
        else {
            //Bald is being select
            face.setBald();
            face.invalidate();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //Do nothing
    }

    /**
     * Check which radio button is selected
     * Set all the seek bars to the correct progress
     * Set the text views to the correct progress
     * Set which radio button is being select( 1 = eye, 2 = skin, 3 = hair)
     * @param group
     * @param checkedId
     */
    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        /**
            External Citation
                Date:       2/13/2018
                Problem:    Don't know how to use radio buttons/group
                Resource:
                    https://developer.android.com/guide/topics/ui/controls/radiobutton.html
                    https://developer.android.com/reference/android/widget/RadioGroup.html
                Solution: Look up how to use it from the developer and look at varies example codes

         */
        if(checkedId == R.id.eyesRadioButton){
            //This is when the eye radio button is check

            //Set the seek bars to the correct values
            redSB.setProgress(face.getEyeRedValue());
            greenSB.setProgress(face.getEyeGreenValue());
            blueSB.setProgress(face.getEyeBlueValue());

            //Set the text views to the correct values
            redTV.setText("" + face.getEyeRedValue());
            greenTV.setText("" + face.getEyeGreenValue());
            blueTV.setText("" + face.getEyeBlueValue());

            //Notified that the eyes radio button is selected
            whichRB = 1;

        }
        else if(checkedId == R.id.skinRadioButton) {
            //This is when the skin radio button is check

            //Set the seek bars to the correct values
            redSB.setProgress(face.getSkinRedValue());
            greenSB.setProgress(face.getSkinGreenValue());
            blueSB.setProgress(face.getSkinBlueValue());

            //Set text views to the correct values
            redTV.setText("" + face.getSkinRedValue());
            greenTV.setText("" + face.getSkinGreenValue());
            blueTV.setText("" + face.getSkinBlueValue());

            //Notified that the skin radio button is selected
            whichRB = 2;

        }
        else if(checkedId == R.id.hairRadioButton){
            //This is when the hair radio button is check

            //Set the seek bars to the correct values
            redSB.setProgress(face.getHairRedValue());
            greenSB.setProgress(face.getHairGreenValue());
            blueSB.setProgress(face.getHairBlueValue());

            //Set the text views to the correct values
            redTV.setText("" + face.getHairRedValue());
            greenTV.setText("" + face.getHairGreenValue());
            blueTV.setText("" + face.getHairBlueValue());

            //Notified that the hair radio button is selected
            whichRB = 3;



        }


    }

    /**
     * Change the color of the eyes, skin, or hair base on which radio button is selected
     * @param seekBar
     * @param progress
     * @param fromUser
     */
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        //Variables for the new eyes rgb values
        int newRedE, newGreenE, newBlueE;

        //Variables for the new skin rgb values
        int newRedS,newGreenS, newBlueS;

        //Variables for the new hair rgb values
        int newRedH, newGreenH, newBlueH;

        if(whichRB == 1){
            //When the eyes radio button is selected

            //Change eye color
            newRedE = redSB.getProgress();
            newGreenE = greenSB.getProgress();
            newBlueE = blueSB.getProgress();
            face.setEyeColor(newRedE, newGreenE, newBlueE);

            //Set the text views
            redTV.setText("" + newRedE);
            greenTV.setText("" + newGreenE);
            blueTV.setText("" + newBlueE);

            face.invalidate();
        }
        else if(whichRB == 2){
            //When the skin radio button is selected

            //Change skin color
            newRedS = redSB.getProgress();
            newGreenS = greenSB.getProgress();
            newBlueS = blueSB.getProgress();
            face.setSkinColor(newRedS, newGreenS, newBlueS);

            //Set the text views
            redTV.setText("" + newRedS);
            greenTV.setText("" + newGreenS);
            blueTV.setText("" + newBlueS);

            face.invalidate();
        }
        else if(whichRB == 3){
            //When the hair radio button is selected

            //Change hair color
            newRedH = redSB.getProgress();
            newGreenH = greenSB.getProgress();
            newBlueH = blueSB.getProgress();
            face.setHairColor(newRedH, newGreenH, newBlueH);

            //Set the text views
            redTV.setText("" + newRedH);
            greenTV.setText("" + newGreenH);
            blueTV.setText("" + newBlueH);

            face.invalidate();
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //Do nothing
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //Do nothing
    }


}
