package com.example.ronik.myticketproject1;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PrefMan {
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    Context context;

    int PRIVATE_MODE = 0;

    private  static final String PREF_NAME = "alphatriv-welcome";

    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTineLaunch";

    public PrefMan(Context cont){
        this.context = cont;
        preferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = preferences.edit();
    }

    public void setIsFirstTimeLaunch(boolean isFirstTimeLaunch){
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTimeLaunch);
        editor.commit();
    }

    public boolean isFirstTimeLaunch(){
        return preferences.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }



}
