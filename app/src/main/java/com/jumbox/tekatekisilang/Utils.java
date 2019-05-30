package com.jumbox.tekatekisilang;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;

import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * Created by Jumadi Janjaya
 * 25, October, 2018
 * Jumbox Studios,
 * Bengkulu, Indonesia.
 */

public class Utils {

    public static final String TAG = "Utils";

    public static String LEVEL = "level";
    public static int BANTUAN_CEK = 1;
    public static int BANTUAN = 2;

    public static int BTN_CLICK = R.raw.click;
    public static int WINNER = R.raw.winner;

    public static String DIMBO = "dimbo";
    public static String COMIC_NEUE_BOLD = "ComicNeue-Bold";

    @SuppressLint("StaticFieldLeak")
    static Utilitas utils = null;
    public static void create(Context c) {
        if (utils == null) utils = new Utilitas(c);
    }

    public static class Utilitas {
        Context context;

        Utilitas(Context context) {
            this.context = context;
        }

        public Typeface font(String customFont) {
            // TODO Auto-generated method stub
            return Typeface.createFromAsset(context.getAssets(), "fonts/"+customFont+".ttf");
        }

        public <T> T JsonToObject(String string, Type type) {
            return new Gson().fromJson(string, type);
        }
    }

}
