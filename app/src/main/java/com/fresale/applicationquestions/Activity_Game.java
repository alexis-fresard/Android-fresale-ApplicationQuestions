package com.fresale.applicationquestions;

// Imopte les bibliothèques nécessaires

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import com.fresale.applicationquestions.QuestionManager;

import java.util.ArrayList;

public class Activity_Game extends AppCompatActivity {

    // Déclaration des variables

    private Button bt_joueur1;
    private Button bt_joueur2;
    private TextView score_joueur1;
    private TextView score_joueur2;
    private TextView tv_joueur1;
    private TextView tv_joueur2;
    private TextView tv_question;
    private TextView tv_play1;
    private TextView tv_play2;

    Runnable questionRunnable = null;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        // force l'orientation de l'écran en mode paysage
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        // initialisation des variables
        bt_joueur1 = findViewById(R.id.Game_bouton_joueur1);
        bt_joueur2 = findViewById(R.id.Game_bouton_joueur2);

        score_joueur1 = findViewById(R.id.Game_score_joueur1);
        score_joueur2 = findViewById(R.id.Game_score_joueur2);

        tv_joueur1 = findViewById(R.id.Game_joueur1);
        tv_joueur2 = findViewById(R.id.Game_joueur2);

        tv_question = findViewById(R.id.TextView_Questions);

        tv_play1 = findViewById(R.id.TextView_libellé_Joueur1);
        tv_play2 = findViewById(R.id.TextView_libellé_Joueur2);



    }

    @Override
    protected void onStart() {
        super.onStart();
        startCountDownTimer();
        //récupère les valeurs des edittext saisie par l'utilisateur à l'activité précédente
        tv_joueur1.setText(getIntent().getStringExtra("joueur1"));
        tv_joueur2.setText(getIntent().getStringExtra("joueur2"));

        // si on presse sur le bouton "joueur 1" on ajoute 1 au score du joueur 1
        bt_joueur1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int score = Integer.parseInt(score_joueur1.getText().toString());
                score_joueur1.setText(String.valueOf(score + 1));
            }
        });

        // si on presse sur le bouton "joueur 2" on ajoute 1 au score du joueur 2
        bt_joueur2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int score = Integer.parseInt(score_joueur2.getText().toString());
                score_joueur2.setText(String.valueOf(score + 1));
            }
        });
    }

    private void startQuestionIterative() {
        handler = new Handler();

        questionRunnable = new Runnable() {
            @Override
            public void run() {
                if ( > 0) {

                    int score1 = Integer.parseInt(score_joueur1.getText().toString());
                    int score2 = Integer.parseInt(score_joueur2.getText().toString());

                    // affiche le gagnant en fonction du nombre de points
                    if (score1 > score2) {
                        tv_play1.setText("Le joueur 1 gagne la partie !");
                        tv_play2.setText("Le joueur 1 gagne la partie !");
                    } else if (score1 < score2) {
                        tv_play1.setText("Le joueur 2 gagne la partie !");
                        tv_play2.setText("Le joueur 2 gagne la partie !");
                    } else {
                        tv_play1.setText("Les deux joueurs sont à égalité !");
                        tv_play2.setText("Les deux joueurs sont à égalité !");
                    }
                    handler.removeCallbacks(this);
                } else {
                    handler.postDelayed(this, 2000);
                }
            }
        };
        handler.postDelayed(questionRunnable, 1000);
    }

    /**
     * Méthode qui permet d'afficher les questions
     */
    private void afficheQuestions() {
        tv_question.setText(QuestionManager.getQuestion().getIntitule());
    }

    /**
     * Méthode qui permet de lancer le compte à rebours
     */
    private void startCountDownTimer() {
        new CountDownTimer(6000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                // afficher le compteur à l'utilisateur
                tv_question.setText(String.valueOf(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                startQuestionIterative();
            }
        }.start();
    }
}
