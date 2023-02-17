package com.fresale.applicationquestions;

import android.database.Cursor;

public class Question {
    private String Intitule;
    private int Reponse;

    //constructeur
    public Question(String intitule, int reponse) {
        Intitule = intitule;
        Reponse = reponse;
    }

    /**
     * @param cursor le curseur de la base de données
     */
    public Question(Cursor cursor) {
        Intitule = cursor.getString(cursor.getColumnIndexOrThrow("question"));
        Reponse = cursor.getInt(cursor.getColumnIndexOrThrow("reponse"));
    }

    //getter pour l'intitulé
    public String getIntitule() {
        return Intitule;
    }

    //getter pour la réponse
    public int getReponse() {
        return Reponse;
    }
}
