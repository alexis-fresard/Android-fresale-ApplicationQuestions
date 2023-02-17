package com.fresale.applicationquestions;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SpeedQuizSQLite extends SQLiteOpenHelper {

    //Nom de base de donnee
    static String DB_NAME = "QuestionQuiz.db";
    static int DB_VERSION = 1;

    /*Besoin pour faire fonctionner la BD, c'est les parametres qui tournent autour de l'app(Environnement, memoire, elements d'application externe)
    Pour construire la base de donnee
     */
    public SpeedQuizSQLite(Context context ) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    /**OnCreate va contenir tout ce qu'on veut executer au niveau de la base de donnee la premiere fois qu'on lance sur l'application
     * Si on relance l'application une 2eme fois, il va regarder sur OnUpgrade
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCreateDatabase = "CREATE TABLE quiz(idQuiz INTEGER PRIMARY KEY, question TEXT, response INTEGER);";
        db.execSQL(sqlCreateDatabase);
        db.execSQL("INSERT INTO quiz VALUES(1, \"Le tout premier ordinateur de l'histoire était appelé ENIAC ?\", 1)");
        db.execSQL("INSERT INTO quiz VALUES(2, \"RGB signifie Rouge, Vert, Bleu ?\", 1)");
        db.execSQL("INSERT INTO quiz VALUES(3, \"Windev est le meilleur logiciel crée à ce jour ?\", 0)");
        db.execSQL("INSERT INTO quiz VALUES(4, \"Passion-fruit est le meilleur site Web crée à ce jour ?\", 1)");
        db.execSQL("INSERT INTO quiz VALUES(5, \"Le premier language de programmation est le C++ ?\", 0)");
        db.execSQL("INSERT INTO quiz VALUES(6, \"La question 3 était fausse ?\", 1)");
        db.execSQL("INSERT INTO quiz VALUES(7, \"Manchester United est le pire club de football au monde ?\", 1)");

    }

    /**Tout les modification on doit mettre la, il va aller detecter si il y a des nouveau version sur le numero de Version Code(Build gradle)*/
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}
