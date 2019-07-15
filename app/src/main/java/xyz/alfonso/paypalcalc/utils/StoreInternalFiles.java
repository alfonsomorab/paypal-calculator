package xyz.alfonso.paypalcalc.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by icrea on 22/05/17.
 */

public class StoreInternalFiles {
    private static final String ARCHIVO = "datos_1";


    public static void clearData(Context context){
        SharedPreferences sharedPref = context.getSharedPreferences(ARCHIVO, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.clear();
        editor.apply();
    }


    public static void saveData(Context context, String key, String value){
        SharedPreferences sharedPref = context.getSharedPreferences(ARCHIVO, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(key, value);
        editor.apply();

        Log.w("-->> Save", key);
    }

    public static void saveSession(Context context, int value){
        SharedPreferences sharedPref = context.getSharedPreferences(ARCHIVO, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("sesion", value);
        editor.apply();
    }

    public static void saveFirebaseToken(Context context, String value){
        SharedPreferences sharedPref = context.getSharedPreferences(ARCHIVO, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("my_firebase_token", value);
        editor.apply();
    }

    public static String getFirebaseToken(Context context){
        return context.getSharedPreferences(ARCHIVO, 0).getString("my_firebase_token", "");
    }

    public static String getData(Context context, String key){
        return context.getSharedPreferences(ARCHIVO, 0).getString(key, "");
    }

    public static String getDataZ(Context context, String key){
        return context.getSharedPreferences(ARCHIVO, 0).getString(key, "0");
    }

    public static int getSession(Context context){
        return context.getSharedPreferences(ARCHIVO, 0).getInt("sesion", 0);
    }

    public static Double getLatitude(Context context){
        return Double.valueOf(context.getSharedPreferences(ARCHIVO, 0).getString("mi_latitud", "-31.554239"));
    }

    public static Double getLongitude(Context context){
        return Double.valueOf(context.getSharedPreferences(ARCHIVO, 0).getString("mi_longitud", "-63.535634"));
    }


    public static void saveArrayList(Context context, ArrayList arrayList, String name){

    }

    public static ArrayList getArrayList(Context context, String name){

        return null;
    }

    public static void saveDouble(Context context, Double value, String name){
        SharedPreferences sharedPref = context.getSharedPreferences(ARCHIVO, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putFloat(name, value.floatValue());
        editor.apply();
    }

    public static Double getDouble(Context context, String name){
        return Double.valueOf(context.getSharedPreferences(ARCHIVO, 0).getFloat(name, 0));
    }

}
