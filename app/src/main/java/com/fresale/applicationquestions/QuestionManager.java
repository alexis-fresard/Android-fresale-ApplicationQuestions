package com.fresale.applicationquestions;

// Imopte les bibliothèques nécessaires

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.fresale.applicationquestions.SpeedQuizSQLite;

import java.util.ArrayList;

public class QuestionManager {
    private ArrayList<Question> QuestionList = new ArrayList<>();

    //getter et setter
    public ArrayList<Question> getQuestionList() {
        return QuestionList;
    }

    /**
     * Constructeur de la classe QuestionManager
     * @param context le contexte de l'application
     */
    public QuestionManager(Context context) {
        QuestionList = initQuestionList(context);
    }

    /**
     * Récupère la question à l'index donné
     * @param index l'index de la question
     * @return la question à l'index donné
     */
    public Question getQuestion(int index) {
        return QuestionList.get(index);
    }

    /**
     * Détermine si la question est la dernière de la liste
     * @param index l'index de la question
     * @return vrai si la question est la dernière de la liste
     */
    public boolean LastQuestion(int index) {
        try {
            QuestionList.get(index + 1);
            return false;
        } catch (IndexOutOfBoundsException e) {
            return true;
        }
    }

    /**
     * Initialise la liste de questions
     * @param context le contexte de l'application
     * @return une liste de questions
     */
    public ArrayList<Question> initQuestionList(Context context) {
        ArrayList<Question> questionList = new ArrayList<>();
        SpeedQuizSQLite helper = new SpeedQuizSQLite(context);
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor cursor = db.query(true, "quiz", new String[]{"idQuiz", "question", "reponse"}, null, null, null, null, "idQuiz", null);

        while (cursor.moveToNext()) {
            questionList.add(new Question(cursor));
        }

        cursor.close();
        db.close();
        return questionList;
    }
}
