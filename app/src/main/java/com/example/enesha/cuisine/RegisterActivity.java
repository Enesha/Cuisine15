package com.example.enesha.cuisine;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    //defining view objects
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonSignUp;

    private TextView textViewSignIn;
    private ProgressDialog progressDialog;

    //defining firebaseauth object
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //initializing firebase auth object
        firebaseAuth = FirebaseAuth.getInstance();
        //initializing views
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        textViewSignIn = (TextView) findViewById(R.id.textViewSignIn);

        buttonSignUp = (Button) findViewById(R.id.buttonSignup);

        progressDialog = new ProgressDialog(this);

        //attaching listener to button
        buttonSignUp.setOnClickListener(this);
        textViewSignIn.setOnClickListener(this);
    }

    private void registerUser() {

        //getting email and password from edit texts
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        //checking if email and passwords are empty
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Please enter email", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please enter password", Toast.LENGTH_LONG).show();
            return;
        }
        //if the email and password are not empty
        //displaying a progress dialog

        progressDialog.setMessage("Registering Please Wait...");
        progressDialog.show();

        //creating a new user
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                //checking if success
                if (task.isSuccessful()) {
                    Toast.makeText(RegisterActivity.this, "Registration successful", Toast.LENGTH_LONG).show();
                    Intent j = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(j);

                } else {
                    //display some message here
                    Toast.makeText(RegisterActivity.this, "Registration Error", Toast.LENGTH_LONG).show();
                }
                progressDialog.dismiss();
            }
        });


    }


    @Override
    public void onClick(View view) {
        if (view == buttonSignUp) {
            registerUser();

        }
        if (view == textViewSignIn) {
            //open login activity when user taps on the already registered textview
            startActivity(new Intent(this, LoginActivity.class));
        }

    }
}