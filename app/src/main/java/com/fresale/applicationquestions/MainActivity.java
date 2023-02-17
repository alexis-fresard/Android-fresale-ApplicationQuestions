package com.fresale.applicationquestions;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button bt_start;
    private EditText et_joueur1;
    private EditText et_joueur2;
    private Button bt_quitter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_start = findViewById(R.id.main_calculer_filledButton);
        et_joueur1 = findViewById(R.id.main_joueur1_edittext);
        et_joueur2 = findViewById(R.id.main_joueur2_edittext);
        bt_quitter = findViewById(R.id.main_quitter_filledButton);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.itemQuitter) {
            finish();
        }

        if (id == R.id.itemAbout) {
            Intent intent = new Intent(MainActivity.this, about_activity.class);
            startActivity(intent);
        }

        if (id == R.id.itemParam) {
            Intent intent = new Intent(MainActivity.this, activity_parametres.class);
            startActivity(intent);
        }
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();


        bt_quitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        bt_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Activity_Game.class);
                startActivity(intent);

            // envoie les valeurs des edittext saisie par l'utilisateur à l'activité suivante
                intent.putExtra("joueur1", et_joueur1.getText().toString());
                intent.putExtra("joueur2", et_joueur2.getText().toString());
                startActivity(intent);

            }
        });
    }


}