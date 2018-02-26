package com.example.huy.facemaker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.SurfaceView;

/**
 * This is the Face class
 * This class create the face that appears on the surface view
 * with varies draw methods
 *
 * @author Huy Nguyen
 * Created on 2/12/2018
 * Last updated: 2/15/2018
 */

public class Face extends SurfaceView {
    private Paint skinColor =  new Paint(); //Define the skin paint
    private Paint eyeColor = new Paint(); //Define the eye paint
    private Paint hairColor = new Paint(); //Define the


    //These are int values for the colors
    private int eyeRedValue, eyeGreenValue, eyeBlueValue, hairRedValue, hairGreenValue
    ,hairBlueValue, skinRedValue, skinGreenValue, skinBlueValue;

    private int hairStyle;


    public Face(Context context) {
        super(context);
        generalInit();
        randomize();

    }

    public Face(Context context, AttributeSet attrs) {
        super(context, attrs);
        generalInit();
        randomize();

    }

    public Face(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        generalInit();
        randomize();

    }

    public void generalInit() {
        setWillNotDraw(false);
    }

    /**
     * Set up the colors for eyes, skin, and hair
     */
    public void setColors() {
        skinColor.setColor(Color.rgb(skinRedValue, skinGreenValue, skinBlueValue));
        hairColor.setColor(Color.rgb(hairRedValue, hairGreenValue, hairBlueValue));
        eyeColor.setColor(Color.rgb(eyeRedValue, eyeGreenValue, eyeBlueValue));

    }

    /**
     * Set up new color for eyes
     *
     * @param rVal - new red values
     * @param gVal - new green blues
     * @param bVal - new blue values
     */
    public void setEyeColor(int rVal, int gVal, int bVal){
        //Change the old values to the new values
        eyeRedValue = rVal;
        eyeGreenValue = gVal;
        eyeBlueValue = bVal;

        //New eyes color
        eyeColor.setColor(Color.rgb(eyeRedValue, eyeGreenValue, eyeBlueValue));
    }

    /**
     * Set up new colors for the skin
     *
     * @param rVal - new red values
     * @param gVal - new green values
     * @param bVal - new blue values
     */
    public void setSkinColor(int rVal, int gVal, int bVal){
        //Change the old values to the new values
        skinRedValue = rVal;
        skinGreenValue = gVal;
        skinBlueValue = bVal;

        //New skin color
        skinColor.setColor(Color.rgb(skinRedValue, skinGreenValue, skinBlueValue));
    }

    /**
     * Set up new colors for the hair
     *
     * @param rVal - new red values
     * @param gVal - new green values
     * @param bVal - new blue values
     */
    public void setHairColor(int rVal, int gVal, int bVal){
        //Change the old values to the new values
        hairRedValue = rVal;
        hairGreenValue = gVal;
        hairBlueValue = bVal;

        //New hair color
        hairColor.setColor(Color.rgb(hairRedValue, hairGreenValue, hairBlueValue));
    }


    /**
     * @return the red value of eye
     */
    public int getEyeRedValue(){
        return eyeRedValue;
    }

    /**
     * @return the green value of eye
     */
    public int getEyeGreenValue(){
        return eyeGreenValue;
    }

    /**
     * @return the blue value of eye
     */
    public int getEyeBlueValue(){
        return eyeBlueValue;
    }

    /**
     * @return the red value of skin
     */
    public int getSkinRedValue(){
        return skinRedValue;
    }

    /**
     * @return the green value of skin
     */
    public int getSkinGreenValue(){
        return skinGreenValue;
    }

    /**
     * @return the blue value of skin
     */
    public int getSkinBlueValue(){
        return skinBlueValue;
    }

    /**
     * @return the red value of hair
     */
    public int getHairRedValue(){
        return hairRedValue;
    }

    /**
     * @return the green value of hair
     */
    public int getHairGreenValue(){
        return hairGreenValue;
    }

    /**
     * @return the blue value of hair
     */
    public int getHairBlueValue(){
        return hairBlueValue;
    }

    /**
     * Randomize the rgb values for eyes, skin, and hair
     * Set the color base on the new randomize colors
     * Pick a random hairstyle
     */
    public void randomize() {
        //Random rgb values for eyes
        eyeRedValue =(int)(Math.random() * 256);
        eyeGreenValue =(int)(Math.random() * 256);
        eyeBlueValue =(int)(Math.random() * 256);
        //Random rgb values for hair
        hairRedValue =(int)(Math.random() * 256);
        hairGreenValue =(int)(Math.random() * 256);
        hairBlueValue =(int)(Math.random() * 256);
        //Random rgb values for skin
        skinRedValue =(int)(Math.random() * 256);
        skinGreenValue =(int)(Math.random() * 256);
        skinBlueValue =(int)(Math.random() * 256);

        //Set the new random color
        setColors();

        //Random hair style
        hairStyle = (int)(Math.random() * 3);

    }

    /**
     * Draw the face of the avatar
     * @param canvas
     */
    public void drawHead(Canvas canvas) {


        //Draw the head
        canvas.drawCircle((float)(getWidth()/2), (float)(getHeight()/2), 500.0f, skinColor );


        //Draw the nose
        Paint blackPaint = new Paint();
        canvas.drawCircle((float)(getWidth()/2),(float)(getHeight()/2), 50.0f,blackPaint);

        /**
          External Citation
            Date:     2/13/2018
            Problem:  Don't know how to draw a curve line
            Resource:
                http://hmkcode.com/android-draw-happy-face/
            Solution: Use the example code given as a reference
         */
        //Draw the smile
        RectF rectF = new RectF((float)(getWidth()/2 - 250), (float)(getHeight()/2),(float)(getWidth()/2 + 250),(float)(getHeight()/2 + 250));
        Path path = new Path();
        path.arcTo(rectF, 30, 120, true);
        blackPaint.setColor(Color.BLACK);
        blackPaint.setStyle(Paint.Style.STROKE);
        blackPaint.setStrokeWidth(5.0f);
        canvas.drawPath(path, blackPaint);




    }

    /**
     * Set the rectangle hair style
     */
    public void setRectHair(){
        hairStyle = 1;
    }

    /**
     * Set the oval hair style
     */
    public void setOvalHair(){
        hairStyle = 2;
    }

    /**
     * Set the bald head
     */
    public void setBald(){
        hairStyle = 0;
    }


    /**
     * Draw the rectangle hair
     * @param canvas
     */
    public void drawRectHair(Canvas canvas) {
        //Draw rectangle haircut
        canvas.drawRect((float) (getWidth() / 2 - 400), (float) (getHeight() / 2 - 500), (float) (getWidth() / 2 + 400),
                    (float) (getHeight() / 2 - 300), hairColor);


    }

    /**
     * Draw the oval hair
     * @param canvas
     */
    public void drawOvalHair(Canvas canvas) {
            //Draw oval haircut
            RectF rect = new RectF((float) (getWidth() / 2 - 400), (float) (getHeight() / 2 - 500), (float) (getWidth() / 2 + 400),
                    (float) (getHeight() / 2 - 200));
            Path bowlPath = new Path();
            bowlPath.arcTo(rect, 0, 359, true);
            canvas.drawPath(bowlPath, hairColor);

    }

    /**
     * Draw the eyes of the avatar
     * @param canvas
     */
    public void drawEyes(Canvas canvas) {
        //Draw the white part of the eyes
        Paint eyePaint = new Paint();
        eyePaint.setColor(Color.WHITE);
        canvas.drawCircle((float)(getWidth()/2 - 250), (float)(getHeight()/2 - 100),100.0f, eyePaint);
        canvas.drawCircle((float)(getWidth()/2 + 250), (float)(getHeight()/2 - 100),100.0f, eyePaint);

        //Draw the iris of the eyes
        canvas.drawCircle((float)(getWidth()/2 - 250), (float)(getHeight()/2 - 100),60.0f, eyeColor);
        canvas.drawCircle((float)(getWidth()/2 + 250), (float)(getHeight()/2 - 100),60.0f, eyeColor);

        //Draw the pupil of the eyes
        eyePaint.setColor(Color.BLACK);
        canvas.drawCircle((float)(getWidth()/2 - 250), (float)(getHeight()/2 - 100),25.0f, eyePaint);
        canvas.drawCircle((float)(getWidth()/2 + 250), (float)(getHeight()/2 - 100),25.0f, eyePaint);
    }


    /**
     * Draw the avatar on givan canvas(surface view)
     * @param canvas
     */
    @Override
    public void onDraw(Canvas canvas) {
        drawHead(canvas);
        if(hairStyle == 1){
            drawRectHair(canvas);
        }
        else if(hairStyle == 2){
            drawOvalHair(canvas);
        }
        drawEyes(canvas);


    }

}
