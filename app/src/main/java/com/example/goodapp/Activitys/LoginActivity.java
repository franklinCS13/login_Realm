package com.example.goodapp.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.goodapp.R;

import java.util.regex.Pattern;

import static java.sql.DriverManager.println;

public class LoginActivity extends AppCompatActivity {

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!¡?¿])(?=\\S+$).{6,12}$");


    public static final Pattern EMAIL_ADDRESS = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[A-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
    );

    private EditText email;
    private EditText password;
    Button btnlogin, btngoo, btnface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.edEmail);
        password = findViewById(R.id.edPass);
        btnlogin = findViewById(R.id.btnLogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateEmail() && validatePassword() == true){
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                } else{
                    println("Ha ingresado un dato incorrecto");
                }


               /* if (email.getText().toString().trim().length()==0){
                    email.setError("Email no válido");
                    email.requestFocus();
                }
                if (password.getText().toString().trim().length()==0){
                    password.setError("Password incorrecto");
                    password.requestFocus();
                }
                else {
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                }
            }
        });*/
            }


            public boolean validateEmail() {
                String emailInput = email.getText().toString().trim();

                if (emailInput.isEmpty()) {
                    email.setError("Ingresar correo válido");
                    return false;
                } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
                    email.setError("Por favor, ingrese una dirección de correo válido");
                    return false;
                } else {
                    email.setError(null);
                    return true;
                }


            }

            public boolean validatePassword() {
                String passwordInput = password.getText().toString().trim();

                if (passwordInput.isEmpty()) {
                    password.setError("El campo no puede estar vácio");
                    return false;
                } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
                    password.setError("Contraseña demasiado débil");
                    return false;
                } else {
                    password.setError(null);
                    return true;
                }
            }

        });

    }
}