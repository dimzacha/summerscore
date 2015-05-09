package com.kostasioannou.summerscore;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by kostasioannou on 5/4/15.
 */


public class User {




    /*MEMBERS*/

    private String mName = "Name";

    private int mSwimmings ;

    private int mIcecreams ;




    /*GETTERS AND SETTERS*/

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getIcecreams() {
        if (mIcecreams >= 0) {
            return mIcecreams;
        }
        else{
            setIcecreams(0);
            return 0;
        }
    }

    public void setIcecreams(int icecreams) {
        mIcecreams = icecreams;
    }


    public int getSwimmings() {
        if (mSwimmings >= 0){
            return mSwimmings;
        }else{
            setSwimmings(0);
            return 0;
        }
    }

    public void setSwimmings(int swimmings) {
        mSwimmings = swimmings;
    }


    /*ADD AND EXTRACT MEMBERS*/

    public void addSwimming(){
        mSwimmings ++;
    }

    public void extractSwimming(){
        mSwimmings --;
    }

    public void addIcecream(){
        mIcecreams ++;
    }

    public void extractIcecream(){
        mIcecreams --;
    }

}
