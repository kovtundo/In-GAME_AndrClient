package com.ingame.validator;

import android.view.View;

/**
 * 
 * @author zemlyanoi
 *
 *
 * ПОКА КАК-ТО ТАК
 */
public class ValidatorFields 
{
	public static Boolean ValidateEmptyFields(String str)
	{
		if(str.length() > 0){return true;}
		return false;
	}
}
