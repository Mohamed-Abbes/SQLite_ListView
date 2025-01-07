package com.example.listview;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AcceuiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_acceuil);
        TextView textView = findViewById(R.id.text_display);

        //Etudiant etudiant = (Etudiant) getIntent().getSerializableExtra("etudiant");

        String displayText = "Bonjour " ;
        textView.setText(displayText);

    }

}


