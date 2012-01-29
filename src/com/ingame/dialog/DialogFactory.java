package com.ingame.dialog;

import com.ingame.ui.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.provider.Settings;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

/**
 * 
 * @author zemlyanoi
 *
 */
public class DialogFactory 
{
	 private static Activity activity;
	 private static ImageView image;
	 private static EditText edit;
	 private static AlertDialog alertDialog;
	 private static Context context;
	 
	 public static void getInternetErrDialog(Activity act) {
	        activity = act;
	        alertDialog = new AlertDialog.Builder(act).create();
	        alertDialog.setTitle(act.getResources().getString(R.string.error));
	        alertDialog.setMessage(act.getResources().getString(R.string.no_internet_msg));
	        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {

	            public void onClick(DialogInterface dialog, int which) {
	                Intent intent = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
	                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
	                activity.startActivity(intent);
	            }
	        });
	        alertDialog.setButton2(act.getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {

	            public void onClick(DialogInterface arg0, int arg1) {
	                activity.onBackPressed();
	            }
	        });
	        alertDialog.show();
	    } 
}



















