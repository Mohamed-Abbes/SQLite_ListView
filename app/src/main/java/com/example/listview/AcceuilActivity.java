package com.example.listview;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AcceuilActivity extends AppCompatActivity {
    private Button suppButt;
    private EtudiantDao etudao;
    private TextView textToUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.acceuil_etud);
        suppButt = findViewById(R.id.id_maq_suppr);
        etudao = new EtudiantDao(this);
        textToUser = findViewById(R.id.user_text_id);


        Etudiant e = (Etudiant) getIntent().getSerializableExtra("etudiantSelctionne");

        textToUser.setText("Bonjour " + e.getNom());
        //Test purposes only -->verify id passed correctly
        Log.d("AcceuilActivity",String.valueOf(e.getId()));

        suppButt.setOnClickListener(v -> {
            int res = etudao.deleteEtudiant(e);

            //Test purposes only -->verify deletion operation
            Log.d("ResultDeleteEtud",String.valueOf(res));

            if (res > 0) {
                Toast.makeText(AcceuilActivity.this, "Utilisateur supprimé", Toast.LENGTH_LONG).show();
                finish();
            } else {
                Toast.makeText(AcceuilActivity.this, "Erreur de suppression", Toast.LENGTH_LONG).show();
            }

            Intent intent = new Intent(AcceuilActivity.this, DisplaysEtudiants.class);
            startActivity(intent);
        });


    }

}