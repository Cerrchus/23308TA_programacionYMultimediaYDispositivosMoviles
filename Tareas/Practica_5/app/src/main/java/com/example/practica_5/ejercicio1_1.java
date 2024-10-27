package com.example.practica_5;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class ejercicio1_1 extends AppCompatActivity {

    private EditText correoET;
    private EditText pwordET;
    private CheckBox rememberCheckBox;
    private Button loginButton;
    private TextView resTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ejercicio1_1);

        correoET = findViewById(R.id.editTextTextEmailAddress5);
        pwordET = findViewById(R.id.editTextTextPassword);
        rememberCheckBox = findViewById(R.id.checkBox);
        loginButton = findViewById(R.id.button);

        resTV = new TextView(this);
        resTV.setLayoutParams(new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT));
        resTV.setTextSize(18);
        resTV.setVisibility(View.INVISIBLE);

        ConstraintLayout layout = findViewById(R.id.constraintLayout);
        layout.addView(resTV);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleLogin();
            }
        });
    }

    private void handleLogin() {
        String email = correoET.getText().toString().trim();
        String password = pwordET.getText().toString().trim();
        boolean rememberMe = rememberCheckBox.isChecked();

        if (email.equals("correo@correo.com") && password.equals("123")) {
            String success = "Sesión iniciada correctamente";
            if (rememberMe) {
                success += " y recordada.";
            }
            resultMessage(success, Color.GREEN);
        } else {
            resultMessage("Correo o contraseña incorrectos", Color.RED);
        }
    }

    private void resultMessage(String message, int color) {
        resTV.setText(message);
        resTV.setTextColor(color);
        resTV.setVisibility(View.VISIBLE);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
