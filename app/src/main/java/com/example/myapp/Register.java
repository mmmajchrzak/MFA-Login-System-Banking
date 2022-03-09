package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.MissingFormatArgumentException;

public class Register extends AppCompatActivity implements View.OnClickListener {

    private TextView SafeLogin, RegisterNewUser;
    private EditText editTextFullName, editTextPesel, editTextemailRegi, editTextPasswordRegi;
    private ProgressBar bar;


    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        SafeLogin = (TextView) findViewById(R.id.SafeLogin);
        SafeLogin.setOnClickListener(this);

        RegisterNewUser = (Button) findViewById(R.id.RegisterNewUser);
        RegisterNewUser.setOnClickListener(this);

        editTextFullName = (EditText) findViewById(R.id.FullName);
        editTextPesel = (EditText) findViewById(R.id.Pesel);
        editTextemailRegi = (EditText) findViewById(R.id.emailRegi);
        editTextPasswordRegi = (EditText) findViewById(R.id.PasswordRegi);

        bar = (ProgressBar) findViewById(R.id.bar);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.SafeLogin:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.RegisterNewUser:
                RegisterNewUser();
                break;
        }

    }

    private void RegisterNewUser() { //walidacje
        String FullName = editTextFullName.getText().toString().trim();
        String Pesel = editTextPesel.getText().toString().trim();
        String emailRegi = editTextemailRegi.getText().toString().trim();
        String PasswordRegi = editTextPasswordRegi.getText().toString().trim();

        if (FullName.isEmpty()) {
            editTextFullName.setError("Please provide full name");
            editTextFullName.requestFocus();
            return;

        }
        if (Pesel.isEmpty()) {
            editTextPesel.setError("Please provide valid Pesel");
            editTextPesel.requestFocus();
            return;

        }
        if (!(Pesel.length() > 11)) {
            editTextPesel.setError("Pesel or ID is to short");
            editTextPesel.requestFocus();
            return;
        }
        if (emailRegi.isEmpty()) {
            editTextemailRegi.setError("Please provide valid email");
            editTextemailRegi.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(emailRegi).matches()) {
            editTextemailRegi.setError("Please provide valid email");
            editTextemailRegi.requestFocus();
            return;

        }
        if (PasswordRegi.isEmpty()) {
            editTextPasswordRegi.setError("Please provide your password");
            editTextPasswordRegi.requestFocus();
            return;


        }
        if (!(PasswordRegi.length() > 14)) {
            editTextPasswordRegi.setError("Password should has min. 14 signs");
            editTextPasswordRegi.requestFocus();
            return;
        }
        if (!(PasswordRegi.contains("@") || PasswordRegi.contains("#")
                || PasswordRegi.contains("!") || PasswordRegi.contains("~")
                || PasswordRegi.contains("$") || PasswordRegi.contains("%")
                || PasswordRegi.contains("^") || PasswordRegi.contains("&")
                || PasswordRegi.contains("*") || PasswordRegi.contains("(")
                || PasswordRegi.contains(")") || PasswordRegi.contains("-")
                || PasswordRegi.contains("+") || PasswordRegi.contains("/")
                || PasswordRegi.contains(":") || PasswordRegi.contains(".")
                || PasswordRegi.contains(",") || PasswordRegi.contains("<")
                || PasswordRegi.contains(">") || PasswordRegi.contains("?")
                || PasswordRegi.contains("|"))) {
            editTextPasswordRegi.setError("Password must require at least one special sign");
            editTextPasswordRegi.requestFocus();
            return;

        }
        if (PasswordRegi.contains(" ")){
            editTextPasswordRegi.setError("Delete blank spaces");
            editTextPasswordRegi.requestFocus();
            return;
        }
        if (!(PasswordRegi.contains("Q") || PasswordRegi.contains("W")
                || PasswordRegi.contains("E") || PasswordRegi.contains("R")
                || PasswordRegi.contains("T") || PasswordRegi.contains("Y")
                || PasswordRegi.contains("U") || PasswordRegi.contains("I")
                || PasswordRegi.contains("O") || PasswordRegi.contains("P")
                || PasswordRegi.contains("A") || PasswordRegi.contains("S")
                || PasswordRegi.contains("D") || PasswordRegi.contains("F")
                || PasswordRegi.contains("G") || PasswordRegi.contains("H")
                || PasswordRegi.contains("J") || PasswordRegi.contains("K")
                || PasswordRegi.contains("L") || PasswordRegi.contains("Z")
                || PasswordRegi.contains("X") || PasswordRegi.contains("C")
                || PasswordRegi.contains("V") || PasswordRegi.contains("B")
                || PasswordRegi.contains("N") || PasswordRegi.contains("M")
        )) {
            editTextPasswordRegi.setError("Password must require at least one capital letter");
            editTextPasswordRegi.requestFocus();
            return;

        }
        bar.setVisibility(View.GONE);
        mAuth.createUserWithEmailAndPassword(emailRegi, PasswordRegi)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            User user = new User(FullName, Pesel, emailRegi);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(Register.this, "User has been created", Toast.LENGTH_LONG).show();
                                        bar.setVisibility(View.GONE);
                                    } else {
                                        Toast.makeText(Register.this, "Failed to register", Toast.LENGTH_LONG).show();
                                        bar.setVisibility(View.GONE);
                                    }
                                }
                            });
                        }else{
                                Toast.makeText(Register.this, "Failed to register", Toast.LENGTH_LONG).show();
                                bar.setVisibility(View.GONE);


                        }
                    }
                });





    }
}