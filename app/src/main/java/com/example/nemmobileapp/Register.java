package com.example.nemmobileapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Register extends AppCompatActivity {


    private EditText unInput;
    private EditText fnInput;
    private EditText lnInput;
    private EditText waInput;
    private EditText emInput;

    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        unInput = findViewById(R.id.usernameInput);
       fnInput = findViewById(R.id.fnInput);
       lnInput = findViewById(R.id.lnInput);
        waInput = findViewById(R.id.walletInput);
         emInput = findViewById(R.id.emailInput);

         dbHandler = new DBHandler(this,1);


    }

    public void submitButtonClicked(View view) {

        String username = unInput.getText().toString();
        String firstName = fnInput.getText().toString();
        String lastName = lnInput.getText().toString();
        String email = emInput.getText().toString();
        String wallet = waInput.getText().toString();
        dbHandler.addUser(username,firstName,lastName,wallet,email);

        
    }
}
