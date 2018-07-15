package com.example.ronik.myticketproject1;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase sqLiteDatabase = null;
    MySQLiteOpenHelper openHelper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("hello");

        this.deleteDatabase("AlphaTriv.db");

        openHelper = new MySQLiteOpenHelper(this);

        sqLiteDatabase = openHelper.getWritableDatabase();


        openHelper.dropTable(sqLiteDatabase, "questions_answers");

        openHelper.addTables(sqLiteDatabase);

        openHelper.insertQuestionsAndAnswersManually(sqLiteDatabase);

        randomizeQuestionForTheScreen();

        /*OneTableRawData otrd = openHelper.randomizeQuestion(sqLiteDatabase);


        TextView tv = findViewById(R.id.textView);
        tv.setText(otrd.getQuestion());

        tv = findViewById(R.id.rb0);
        tv.setText(otrd.getCorrectAnswer());

        tv = findViewById(R.id.rb1);
        tv.setText(otrd.getWrongAnswer0());

        tv = findViewById(R.id.rb2);
        tv.setText(otrd.getWrongAnswer1());

        tv = findViewById(R.id.rb3);
        tv.setText(otrd.getWrongAnswer2());
        */


        //openHelper.listAllQuestionsAndAnswers(sqLiteDatabase);


        //===========================================================

        registerToGetBroadcastWithPendingIntent();
    }

    void randomizeQuestionForTheScreen(){
        TextView tvQ = (TextView) findViewById(R.id.textView);
        RadioButton cans = (RadioButton) findViewById(R.id.rb0);
        RadioButton wansw0 = (RadioButton) findViewById(R.id.rb1);
        RadioButton wansw1 = (RadioButton) findViewById(R.id.rb2);
        RadioButton wansw2 = (RadioButton) findViewById(R.id.rb3);


        new AsyncTaskDBRequest(openHelper ,tvQ, cans, wansw0, wansw1, wansw2).execute();

    }


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rb0: {
                if (checked) {
                    //
                }
                break;
            }
            case R.id.rb1: {
                if (checked) {
                    //
                }
                break;
            }
            case R.id.rb2: {
                if (checked) {
                    //
                }
                break;
            }
            case R.id.rb3: {
                if (checked) {
                    //
                }
                    break;
            }
        }
    }


    public void registerToGetBroadcastWithPendingIntent()
    {
        Intent intent = new Intent(this, MyReceiver.class);
        intent.putExtra("message", "waiting 15 seconds");
        PendingIntent pendingIntent =
                PendingIntent.getBroadcast(this.getApplicationContext(),
                        5, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis()
                        + (15 * 1000), pendingIntent);
    }

    public void close(){
        openHelper.close();
    }

}
