package com.kostasioannou.summerscore;

import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {


    //Creation of User Object

    User user = new User();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Retrieve the Views

        final TextView nameTextView = (TextView) findViewById(R.id.nameTextView);

        final TextView swimmingTextView = (TextView) findViewById(R.id.swimmingNumberTextview);

        final TextView icecreamTextView = (TextView) findViewById(R.id.iceNumberTextview);


        Button addSwimButton = (Button) findViewById(R.id.smimmingAddButton);

        Button addIceButton = (Button) findViewById(R.id.iceAddButton);

        Button exSwimButton = (Button) findViewById(R.id.swimmingExButton);

        Button exIceButton = (Button) findViewById(R.id.iceExButton);








        /*EVENTS REGISTRATION*/

        View.OnClickListener addSwimmListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.addSwimming();
                int currentSwimm = user.getSwimmings();
                swimmingTextView.setText((String.valueOf(currentSwimm)));
            }
        };

        View.OnClickListener addIceListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.addIcecream();
                int currentIce = user.getIcecreams();
                icecreamTextView.setText(String.valueOf(currentIce));
            }
        };

        View.OnClickListener exSwimmListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.extractSwimming();
                int currentSwimm = user.getSwimmings();
                swimmingTextView.setText(String.valueOf(currentSwimm));
            }
        };

        View.OnClickListener exIceListener = new View.OnClickListener() {
          @Override
            public void onClick(View v) {
              user.extractIcecream();
              int currentIce = user.getIcecreams();
              icecreamTextView.setText(String.valueOf(currentIce));
          }
        };


        addIceButton.setOnClickListener(addIceListener);
        addSwimButton.setOnClickListener(addSwimmListener);
        exIceButton.setOnClickListener(exIceListener);
        exSwimButton.setOnClickListener(exSwimmListener);



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
                    }
                });

        final AlertDialog dialogForChangingTheName = alertDialogBuilder.create();




        //CONNECTING ALERT DIALOG ----> PRESSING EVENT
        View.OnClickListener nameChange = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogForChangingTheName.show();
            }
        };

        nameTextView.setOnClickListener(nameChange);






    }//End of onCreate Method


}//End of MainActivity Class
