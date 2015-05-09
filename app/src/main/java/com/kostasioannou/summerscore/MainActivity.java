package com.kostasioannou.summerscore;

import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {


    //Creation of User Object

    User user = new User();

    public static final String USER_INFORMATION = "UserInformatioFile";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //************* RETRIEVE THE VIEWS ******************************************

        final TextView nameTextView = (TextView) findViewById(R.id.nameTextView);

        final TextView swimmingTextView = (TextView) findViewById(R.id.swimmingNumberTextview);

        final TextView icecreamTextView = (TextView) findViewById(R.id.iceNumberTextview);


        Button addSwimButton = (Button) findViewById(R.id.smimmingAddButton);

        Button addIceButton = (Button) findViewById(R.id.iceAddButton);

        Button exSwimButton = (Button) findViewById(R.id.swimmingExButton);

        Button exIceButton = (Button) findViewById(R.id.iceExButton);

        Button shareButton = (Button) findViewById(R.id.shareButton);




        /*DATA PERSISTENCE*/

        SharedPreferences pref = getApplicationContext().getSharedPreferences(USER_INFORMATION,0);

        final SharedPreferences.Editor editor = pref.edit();

        //PASSING THE SAVED VALUES IF THEY DONT EXISTS PASSING DEFAULTS

        nameTextView.setText(pref.getString("name_key","Name"));
        user.setName(pref.getString("name_key","Name"));
        swimmingTextView.setText(String.valueOf(pref.getInt("swimm_key", 0)));
        user.setSwimmings(pref.getInt("swimm_key",0));
        icecreamTextView.setText(String.valueOf(pref.getInt("ice_key", 0)));
        user.setIcecreams(pref.getInt("ice_key",0));






        /*EVENTS REGISTRATION*/

        View.OnClickListener addSwimmListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.addSwimming();
                swimmingTextView.setText((String.valueOf(user.getSwimmings())));


                //SAVING
                editor.putInt("swimm_key", user.getSwimmings());
                editor.commit();
            }
        };

        View.OnClickListener addIceListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.addIcecream();
                icecreamTextView.setText(String.valueOf(user.getIcecreams()));


                //SAVING
                editor.putInt("ice_key", user.getIcecreams());
                editor.commit();
            }
        };

        View.OnClickListener exSwimmListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.extractSwimming();
                swimmingTextView.setText(String.valueOf(user.getSwimmings()));


                //SAVING
                editor.putInt("swimm_key", user.getSwimmings());
                editor.commit();
            }
        };

        View.OnClickListener exIceListener = new View.OnClickListener() {
          @Override
            public void onClick(View v) {
              user.extractIcecream();
              icecreamTextView.setText(String.valueOf(user.getIcecreams()));


              //SAVING
              editor.putInt("ice_key", user.getIcecreams());
              editor.commit();
          }
        };





        //************ SHARE BUTTON EVENT ************************************************

        View.OnClickListener shareListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        };




        addIceButton.setOnClickListener(addIceListener);
        addSwimButton.setOnClickListener(addSwimmListener);
        exIceButton.setOnClickListener(exIceListener);
        exSwimButton.setOnClickListener(exSwimmListener);

        shareButton.setOnClickListener(shareListener);



        //ALERT DIALOG CREATION
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        final EditText dialogNameTextField = new EditText(this);
        dialogNameTextField.setInputType(InputType.TYPE_CLASS_TEXT);


        alertDialogBuilder.setTitle("Set name")
                .setMessage("Give a name please.")
                .setView(dialogNameTextField)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        user.setName(dialogNameTextField.getText().toString());
                        nameTextView.setText(user.getName());


                        //SAVING
                        editor.putString("name_key",user.getName());
                        editor.commit();
                    }
                });

        final AlertDialog dialogForChangingTheName = alertDialogBuilder.create();




        //REGISTERING ALERT DIALOG ----> PRESSING EVENT
        View.OnClickListener nameChange = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogForChangingTheName.show();
            }
        };

        nameTextView.setOnClickListener(nameChange);






    }//End of onCreate Method

}//End of MainActivity Class
