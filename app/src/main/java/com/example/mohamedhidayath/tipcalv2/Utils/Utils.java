package com.example.mohamedhidayath.tipcalv2.Utils;

import android.util.Log;

/**
 * Created by Mohamed Hidayath on 06-Aug-17.
 */

public class Utils {
    public  static  void printLog(String tag,String message)
    {
        if(Constants.DEBUG)
        {
            Log.d(tag,message);
        }
    }
}
