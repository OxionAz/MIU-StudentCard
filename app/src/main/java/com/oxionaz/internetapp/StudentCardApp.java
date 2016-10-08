package com.oxionaz.internetapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class StudentCardApp extends android.app.Application
{
    private static final String STUDENT_NUMBER = "number";
    private static final String DEFAULT_STUDENT_NUMBER = "1";

    public static void setStudentNumber(Context context, String number){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(STUDENT_NUMBER, number);
        editor.commit();
    }

    public static String getStudentNumber(Context context){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        return pref.getString(STUDENT_NUMBER, DEFAULT_STUDENT_NUMBER);
    }
}
