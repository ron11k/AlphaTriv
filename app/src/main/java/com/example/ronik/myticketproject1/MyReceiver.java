package com.example.ronik.myticketproject1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        // an Intent broadcast.



        String theMessageFromTheIntent = intent.getStringExtra("message");
        if (theMessageFromTheIntent != null)
        {

        }



        Bundle IntentExtras = intent.getExtras();
        String st2 = IntentExtras.getString("message");
        boolean bool2 = false;
        if (st2 != null)
            bool2 = st2.equals("waiting 15 seconds");
        if(bool2 == true)
        {
            Toast.makeText(context, " Your time to answer is up, 15 seconds passed"
                    , Toast.LENGTH_LONG).show();


            // todo: As I think  here we need to close the app immediately, after the user answered wrong.
            // todo: Also set time for 24 hours, until he can to play next game;
            //todo: The same goes for, when user do answers right. Close the app for 24 hours.
            //todo: The same should be done when user exits the app.

        }

    }

}

