package com.ingame.util;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;

/**
 * 
 * @author zemlyanoi
 *
 */
public class TelephoneUtil 
{
	/**
	 * Получаем imei телефона
	 * @param act
	 * @return
	 */
	public static String getImei(Activity act) {
        String imei = ((TelephonyManager) act.getApplicationContext().getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
        if (imei == null || imei.startsWith("0000000000")) {
            imei = Secure.getString(act.getContentResolver(), Secure.ANDROID_ID);
        }
        return imei;
    }
	
	public static boolean isOnline(Activity act) {
        ConnectivityManager conMgr = (ConnectivityManager) act.getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo i = conMgr.getActiveNetworkInfo();
//        if (i == null) {
//            return false;
//        }
//        if (!i.isConnected()) {
//            return false;
//        }
        return true;
    }
}
