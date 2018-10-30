package ru.mylx.internetstarosta;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class TestActivity extends AppCompatActivity {
    private FirebaseAuth.AuthStateListener mStateListener;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser() == null){
            Intent intent = new Intent(TestActivity.this,LoginActivity.class);
            startActivity(intent);
        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
            }
        });
        mStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if ( firebaseAuth.getCurrentUser() == null){
                    startActivity(new Intent(TestActivity.this,LoginActivity.class));
                }
            }
        };
    }
}}
