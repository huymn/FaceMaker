package com.example.huy.facemaker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Main Activity class
 * This class is use to make reference to all the views
 *
 * @author Huy Nguyen
 * Created on: 2/12/2018
 * Last updated: 2/15/2018
 */
public class MainActivity extends AppCompatActivity  {
    //These are the inputs of the spinner
    private String[] hairStyles = {"Rectangle","Oval", "Bald"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
          External Citation
            Date:       2/12/2018
            Problem:    Don't remember a lot of stuff.
            Resources:
                https://learning.up.edu/moodle/pluginfile.php/638764/mod_resource/content/1/MainActivity.java
            Solution:   Use class example as reference.
         */
        //Create reference of the seek bars
        SeekBar redSeekBar = (SeekBar)findViewById(R.id.redSeekBar);
        SeekBar greenSeekBar = (SeekBar)findViewById(R.id.greenSeekBar);
        SeekBar blueSeekBar = (SeekBar)findViewById(R.id.blueSeekBar);

        //Create reference of the text views
        TextView redTextView = (TextView)findViewById(R.id.redValue);
        TextView greenTextView = (TextView)findViewById(R.id.greenValue);
        TextView blueTextView = (TextView)findViewById(R.id.blueValue);

        //Reference the face listener class
        Face face = (Face)findViewById(R.id.mainSurfaceView);
        FaceListener faceListener = new FaceListener(face);

        //Add all the seek bars and text views
        faceListener.addSB(redSeekBar);
        faceListener.addSB(greenSeekBar);
        faceListener.addSB(blueSeekBar);
        faceListener.addTV(redTextView);
        faceListener.addTV(greenTextView);
        faceListener.addTV(blueTextView);
        faceListener.registerTextViews();
        faceListener.registerSeekBars();

        //Register the random face button and detect when it's click
        Button randomButton = (Button)findViewById(R.id.ranFaceButton);
        randomButton.setOnClickListener(faceListener);

        //Register the spinner
        ArrayAdapter<String> hairAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, hairStyles);
        Spinner hairSpinner = (Spinner)findViewById(R.id.hairSpinner);
        hairSpinner.setAdapter(hairAdapter);
        hairSpinner.setOnItemSelectedListener(faceListener);

        //Register the radio group
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(faceListener);

        //Register when the seek bar are being change
        redSeekBar.setOnSeekBarChangeListener(faceListener);
        greenSeekBar.setOnSeekBarChangeListener(faceListener);
        blueSeekBar.setOnSeekBarChangeListener(faceListener);


    }




}
