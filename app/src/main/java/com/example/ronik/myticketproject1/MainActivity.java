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
        MyRadioButton cans = (MyRadioButton) findViewById(R.id.rb0);
        MyRadioButton wansw0 = (MyRadioButton) findViewById(R.id.rb1);
        MyRadioButton wansw1 = (MyRadioButton) findViewById(R.id.rb2);
        MyRadioButton wansw2 = (MyRadioButton) findViewById(R.id.rb3);


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

    public void checkAnswer (View view)
    {
        // Check which radio button was selected
        MyRadioButton rb0 = (MyRadioButton)findViewById(R.id.rb0);
        MyRadioButton rb1 = (MyRadioButton)findViewById(R.id.rb1);
        MyRadioButton rb2 = (MyRadioButton)findViewById(R.id.rb2);
        MyRadioButton rb3 = (MyRadioButton)findViewById(R.id.rb3);

        if (rb0.isSelected() == true && rb0.isTheCorrectAnswer == true)
        {
                theUserIsRight(rb0);
        }

        else if (rb1.isSelected() == true && rb1.isTheCorrectAnswer == true)
        {
            theUserIsRight(rb1);
        }

        else if (rb2.isSelected() == true && rb2.isTheCorrectAnswer == true)
        {
            theUserIsRight(rb2);
        }

        else if (rb3.isSelected() == true && rb3.isTheCorrectAnswer == true)
        {
            theUserIsRight(rb3);
        }


        theUserIsWrong();

    }

    private void theUserIsWrong() {
        // the user was wrong,
        // change his selected answer to red
        // Check which radio button was selected
        MyRadioButton rb0 = (MyRadioButton)findViewById(R.id.rb0);
        MyRadioButton rb1 = (MyRadioButton)findViewById(R.id.rb1);
        MyRadioButton rb2 = (MyRadioButton)findViewById(R.id.rb2);
        MyRadioButton rb3 = (MyRadioButton)findViewById(R.id.rb3);

        if (rb0.isSelected() == true)
        {
            //  change rb0 background to red
        }

        else if (rb1.isSelected() == true)
        {
            //  change rb1 background to red
        }


        else if (rb2.isSelected() == true)
        {
            //  change rb2 background to red
        }

        else if (rb3.isSelected() == true)
        {
            //  change rb3 background to red
        }
    }

    private void theUserIsRight(MyRadioButton mrb) {

        // the user answered correctly,
        //   Change the color of the correct answer on the screen to green

    }
}
