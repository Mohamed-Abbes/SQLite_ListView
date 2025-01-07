package com.example.listview;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText emailInput, passwordInput;
    private Button loginButton, signupButton;
    private EtudiantDao etudiantDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailInput = findViewById(R.id.id_login);
        passwordInput = findViewById(R.id.id_pass);
        loginButton = findViewById(R.id.id_connex);
        signupButton = findViewById(R.id.id_inscri);

        etudiantDAO = new EtudiantDao(this);


        loginButton.setOnClickListener(v -> {
            String email = emailInput.getText().toString().trim();
            String password = passwordInput.getText().toString().trim();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(MainActivity.this, "Veuillez remplir tous les champs", Toast.LENGTH_LONG).show();
                return;
            }

            Etudiant e = etudiantDAO.getEtudiantWithLogin(email, password);
            if (e != null) {
                Intent intent = new Intent(MainActivity.this, AcceuiActivity.class);
                //intent.putExtra("etudiant",e);
                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this, "Authentification échouée", Toast.LENGTH_LONG).show();
            }
        });

        signupButton.setOnClickListener(v -> {
           startActivity(new Intent(MainActivity.this, Inscription.class));
        });
    }
}