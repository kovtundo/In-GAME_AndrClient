package com.ingame.controller;

import com.ingame.api.ApiConnector;
import com.ingame.dialog.DialogFactory;
import com.ingame.ui.R;
import com.ingame.util.TelephoneUtil;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;

/**
 * 
 * @author zemlyanoi
 *
 */
public class TaskRegister extends AsyncTask
{
	private Activity act;
    private String oper;
    private String[] param;
    private ProgressDialog dialog;
    private boolean isError;
    private boolean isRegister;
    private boolean rez = false;
    private int errMessID;
    private String errMessStr = "";
    
    public TaskRegister(Activity act, String oper, String[] param) 
    {
        this.act = act;
        this.oper = oper;
        this.param = param;
    }
    
    @Override
    protected void onPreExecute() 
    {
        super.onPreExecute();
        dialog = ProgressDialog.show(act, "", act.getString(R.string.wait_msg), true);
        if (!TelephoneUtil.isOnline(act)) 
        {
            DialogFactory.getInternetErrDialog(act);
        }
    }
    
	@Override
	protected Boolean doInBackground(Object... arg0) 
	{
		if (TelephoneUtil.isOnline(act)) 
		{
            try 
            {
            	new ApiConnector().Register(param);
            }
            catch (Exception ex) 
            {
                 System.err.println("System error: " + ex.getMessage());
                 isError = true;
                 errMessID = R.string.error_try_later;
            }
		}
        return true;
	}
	
	@Override
    protected void onPostExecute(Object result) {
        super.onPostExecute(result);
        dialog.dismiss();
    }  

}
