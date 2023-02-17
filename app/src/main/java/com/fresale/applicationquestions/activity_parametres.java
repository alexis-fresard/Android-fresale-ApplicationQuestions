package com.fresale.applicationquestions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class activity_parametres extends AppCompatActivity {

    private SeekBar sb_TailleNomsJoueurs;
    private Button bt_retour;
    private Button bt_valider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);

        sb_TailleNomsJoueurs = findViewById(R.id.ScrollTailleNomJoueurs);
        bt_retour = findViewById(R.id.param_bt_annuler);
        bt_valider = findViewById(R.id.param_bt_valider);
    }

    @Override
    protected void onStart() {
        super.onStart();



        // si on presse sur le bouton "retour" on revient à l'activité précédente sans sauvegarder les paramètres
        Button bt_retour = findViewById(R.id.param_bt_annuler);
        bt_retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        // si on presse sur le bouton "valider" on revient à l'activité précédente en sauvegardant les paramètres
        Button bt_valider = findViewById(R.id.param_bt_valider);
        bt_valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // sauvegarde des paramètres
                onBackPressed();
            }
        });
    }
}