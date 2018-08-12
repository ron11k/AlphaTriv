package com.example.ronik.myticketproject1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MyReceiver extends BroadcastReceiver {



    Context context;

    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {




        this.context = context;

        String theMessageFromTheIntent = intent.getStringExtra("message");
        if (theMessageFromTheIntent != null) {

        }


        Bundle IntentExtras = intent.getExtras();
        String st2 = IntentExtras.getString("message");
        boolean bool2 = true;
        if (st2 != null)
            bool2 = st2.equals("waiting 15 seconds");
        if (bool2 == true) {
            Toast.makeText(context, " Your time to answer is up, 15 seconds passed"
                    , Toast.LENGTH_LONG).show();



            //=========================THE ONLY THING UNDONE FOR ME, COULDN'T UNDERSTAND SHARED PREFERENCES STUFF, THOUGH READ A LOT IN STACKOVERFLOW===============


/*

            // Save the current time:
            saveTheCurrentTime();

            // Create timers that read the saved time and
            //   show how much time left
            //  This will create many Toasts for 24 hours
            //   it is just for the example...
            //    you should display the countdown
            //       on a TextView instead of showing the toast,
            //     and stop it as soon as the app isn't visible
            //     and start it again as soon as it is visible
            //


            new CountDownTimer(24*3600*1000, 1000) {

                public void onTick(long millisUntilFinished) {
                    long l = readHowMuchTimeLeft();
                    String stSeconds = (millisUntilFinished / 1000) + "";
                    String stMinutes = (millisUntilFinished / 1000 /60 ) + "";
                    String stHours = (millisUntilFinished / 1000 /60/ 60 ) + "";
                   /* Toast.makeText(MyReceiver.this.context,
                            stSeconds + "\n" + stMinutes + "\n" + stHours
                            , Toast.LENGTH_SHORT).show(); //timer.setText(stHours + " : " + stMinutes + " : " + stSeconds);

                }

                public void onFinish() {
                    //timer.setText("00 : 00 : 00");
                    //Toast.makeText(MyReceiver.this.context,
                           // "24 hours passed"
                           // , Toast.LENGTH_LONG).show();
                }
            }.start();






        }

    }





    private long readHowMuchTimeLeft() {
        SharedPreferences shrdPref = context.getSharedPreferences(
                "ofraShrdPref", Context.MODE_PRIVATE);
        String dateTimeKey = "ofraDatetime";
        long lFinishTime = shrdPref.getLong(dateTimeKey, 12345);
        long lNow  = (new Date()).getTime();
        return (lFinishTime-lNow);
    }

    private void saveTheCurrentTime() {
        SharedPreferences shrdPref = context.getSharedPreferences(
                "ofraShrdPref", Context.MODE_PRIVATE);
        String dateTimeKey = "ofraDatetime";
        long finishTime = ((new Date()).getTime()) + (24*60*60*1000);
        shrdPref.edit().putLong(dateTimeKey, finishTime).commit();
    }*/


        }
    }
}
