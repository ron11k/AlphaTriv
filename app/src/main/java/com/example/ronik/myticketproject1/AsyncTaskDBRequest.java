package com.example.ronik.myticketproject1;

import android.os.AsyncTask;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

public class AsyncTaskDBRequest extends AsyncTask<String, String, String> {

    final String TAG = "mark: ";
    MySQLiteOpenHelper openHelper;
    TextView questionTv;
    RadioButton radB0;
    RadioButton radB1;
    RadioButton radB2;
    RadioButton radB3;

    String stQuestion = "";
    String stCorrAnsw = "";
    String stWrongAns0 = "";
    String stWrongAns1 = "";
    String stWrongAns2 = "";

    public AsyncTaskDBRequest(MySQLiteOpenHelper openHelper,TextView question, RadioButton rb0, RadioButton rb1, RadioButton rb2, RadioButton rb3) {

        this.openHelper = openHelper;

        questionTv = question;
        radB0 = rb0;
        radB1 = rb1;
        radB2 = rb2;
        radB3 = rb3;
    }

    @Override
    protected void onPreExecute() {}

    @Override
    protected String doInBackground(String... arg0) {
        System.out.println(TAG + "getting json data in background");

        OneTableRawData otrd = openHelper.randomizeQuestion(openHelper.getWritableDatabase());



        stQuestion = otrd.getQuestion();

        stCorrAnsw = otrd.getCorrectAnswer();


        stWrongAns0 = otrd.getWrongAnswer0();


        stWrongAns1= otrd.getWrongAnswer1();


        stWrongAns2= otrd.getWrongAnswer2();





        return stQuestion;
    }

    @Override
    protected void onPostExecute(String strFromDoInBg) {

        questionTv.setText(stQuestion);
        radB0.setText(stCorrAnsw);
        radB1.setText(stWrongAns0);
        radB2.setText(stWrongAns1);
        radB3.setText(stWrongAns2);


    }
}
