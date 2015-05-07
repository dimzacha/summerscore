package com.kostasioannou.summerscore;

/**
 * Created by kostasioannou on 5/4/15.
 */


public class User {


    /*MEMBERS*/

    private String mName = "Name";

    private int mSwimmings = 0;

    private int mIcecreams = 0;




    /*GETTERS AND SETTERS*/

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getIcecreams() {
        return mIcecreams;
    }

    public void setIcecreams(int icecreams) {
        mIcecreams = icecreams;
    }


    public int getSwimmings() {
        return mSwimmings;
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
