package com.example.enesha.cuisine;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private EditText UserID;
    private EditText UserPassword;
    private FirebaseAuth mAuth;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginn);
        mAuth = FirebaseAuth.getInstance();
        UserID = findViewById(R.id.UserID);
        UserPassword = findViewById(R.id.UserPassword);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });


    }

    public void signIn (){
        String email=UserID.getText().toString();
        String password=UserPassword.getText().toString();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("abcd", "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            onClickGotoList();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w( "abcd", "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });

    }
    public void onClickGotoList(){

        Intent i = new Intent(LoginActivity.this, ActivityCook.class);
        startActivity(i);

    }
    }

