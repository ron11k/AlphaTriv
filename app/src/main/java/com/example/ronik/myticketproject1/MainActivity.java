package com.example.ronik.myticketproject1;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerToGetBroadcastWithPendingIntent();
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
}
