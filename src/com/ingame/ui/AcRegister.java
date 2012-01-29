package com.ingame.ui;

import com.ingame.controller.TaskRegister;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

/**
 * 
 * @author zemlyanoi
 *
 */
public class AcRegister extends Activity
{
	 //private LinearLayout llMain;
	 private TableLayout  tlLoginForm;
	 private Activity 	  act;
	 private TextView     tLogin;
	 private EditText     eLogin;
	 private TextView     tPass;
	 private EditText     ePass;
	 private Button		  btnLogin;
	 
	 @Override
	 public void onCreate(Bundle icicle) 
	 {
		 super.onCreate(icicle);
		 act = this;
		 setContentView(R.layout.ac_login);
		 
		 InitializationField();   	// иниуиализация всех компонентов
		 CreateLoginFormAndAddInTheMainView();
		 AddBtnLoginListeners();

	 }
	 
	 //инициализация
	 private void InitializationField()
	 {
		 //llMain = (LinearLayout) findViewById(R.layout.ac_login);
		 
		 tlLoginForm = (TableLayout) findViewById(R.id.mainTable);
		 tLogin      = new TextView(act); 
		 eLogin      = new EditText(act); 
		 tPass       = new TextView(act); 
		 ePass       = new EditText(act); 
		 btnLogin    = new Button(act);
	 }
	 
	 private void CreateLoginFormAndAddInTheMainView()
	 {
		 TableRow trLogin = new TableRow(act);
		 trLogin.setOrientation(TableRow.VERTICAL);
		 trLogin.addView(tLogin);
		 trLogin.addView(eLogin);
		 
		 tlLoginForm.addView(trLogin);
		 
		 TableRow trPass = new TableRow(act);
		 trPass.setOrientation(TableRow.VERTICAL);
		 trPass.addView(tPass);
		 trPass.addView(ePass);
		 
		 tlLoginForm.addView(trPass);
		 tlLoginForm.addView(btnLogin , new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
		 
		 //llMain.addView(tlLoginForm);
	 }
	 
	 private void AddBtnLoginListeners()
	 {
		 btnLogin.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				String []param = new String[10];
				param[0] = eLogin.getText().toString();
				param[1] = ePass.getText().toString();
				new TaskRegister(act, "register", param).execute();
			}
		});
	 }
}
