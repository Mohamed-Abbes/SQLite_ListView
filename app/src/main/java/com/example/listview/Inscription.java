package com.example.listview;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Inscription extends AppCompatActivity {
    private EditText nomInput, prenomInput, emailInput, passwordInput;
    private Button registerButton;
    private EtudiantDao etudiantDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        nomInput = findViewById(R.id.id_inscri_nom);
        prenomInput = findViewById(R.id.id_inscri_prenom);
        emailInput = findViewById(R.id.id_inscri_login);
        passwordInput = findViewById(R.id.id_inscri_pass);
        registerButton = findViewById(R.id.id_inscri_enregistrer);

        etudiantDAO = new EtudiantDao(this);

        registerButton.setOnClickListener(v -> {
            String nom = nomInput.getText().toString();
            String prenom = prenomInput.getText().toString();
            String email = emailInput.getText().toString();
            String password = passwordInput.getText().toString();

            if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(Inscription.this, "Veuillez remplir tous les champs", Toast.LENGTH_LONG).show();
                return;
            }
            new AlertDialog.Builder(Inscription.this).setTitle("Confirmation !").setMessage("Voulez vous inscrire ?").setPositiveButton(
                    "Oui",((dialog, which) -> {
                Etudiant e = new Etudiant(nom,prenom,email,password);
                long id = etudiantDAO.insertEtudiant(e);
                if (id > 0) {
                    Toast.makeText(Inscription.this, "Inscription réussie", Toast.LENGTH_LONG).show();
                    finish();
                } else {
                    Toast.makeText(Inscription.this, "Erreur d'inscription", Toast.LENGTH_LONG).show();
                }
        })).setNegativeButton("Annuler", null).show();
        });

    }

        }

