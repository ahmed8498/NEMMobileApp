package com.example.nemmobileapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText nemAddressInput;
    private EditText nameInput;
    private Button loginButton;

    private static String address;
    private String name;

    private DBHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nemAddressInput = findViewById(R.id.addressEditText);
        nameInput = findViewById(R.id.nameEditText);
        loginButton = findViewById(R.id.loginButton);

        db = new DBHandler(this,1);


    }


    public void loginClicked(View view) {


        address = nemAddressInput.getText().toString();
        name = nameInput.getText().toString();

        if(address.equals(""))
            address = "";
        if(db.validUser(address))
            startActivity(new Intent(getApplicationContext(),ServicesList.class));
        else
            Toast.makeText(this,"Not a valid wallet address",Toast.LENGTH_LONG).show();
    }

    public void signUpClicked(View view) {
        startActivity(new Intent(getApplicationContext(),Register.class));
    }
}
