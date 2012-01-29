package com.ingame.api;

import org.local.json.JSONObject;

import com.ingame.util.Http;

import android.app.Activity;

/**
 * 
 * @author zemlyanoi
 *
 */
public class ApiConnector 
{
	private static String email = "ggggggg@mail.ru";
	private static String ip    = "127.0.0.1";
	
	private static String URL = "http://46.98.245.145:8080/GS/auth";
	private static String appkey = "!ja34nasjal2@#$nhfsjdk@ ";
	private static String version = "1.0.3";
	private static boolean DEBUG = true;
	private static String session;
	
<<<<<<< HEAD
	 public static void Register(String[] params) throws Exception 
=======
	 public static Boolean Register(String[] params) throws Exception 
>>>>>>> allredy ok register test3
	 {
	        String login = params[0];
	        String password = params[1];
	        String imei = params[2];
	        JSONObject jSONObject = new JSONObject();
	        jSONObject.put("oper", "login");
	        jSONObject.put("imei", imei);
	        jSONObject.put("appkey", appkey);
	        jSONObject.put("email", email);
	        jSONObject.put("login", login);
	        jSONObject.put("password", password);
	        jSONObject.put("ip", ip);
	        
	        String resp = Http.Request(URL, "POST", jSONObject.toString(), "text/xml");
<<<<<<< HEAD

=======
	        
	        JSONObject object = new JSONObject(resp);
	        if("ok".equals(object.getString("status")))
	        { // Регистрация прошла успешно
	        	return true;
	        }
	        return false;
	 }
 
	 public static Boolean Login(String[] params) throws Exception 
	 {
	        String login = params[0];
	        String password = params[1];
	        String imei = params[2];
	        JSONObject jSONObject = new JSONObject();
	        jSONObject.put("oper", "login");
	        jSONObject.put("imei", imei);
	        jSONObject.put("appkey", appkey);
	        jSONObject.put("email", email);
	        jSONObject.put("login", login);
	        jSONObject.put("password", password);
	        jSONObject.put("ip", ip);
	        
	        String resp = Http.Request(URL, "POST", jSONObject.toString(), "text/xml");
	        JSONObject object = new JSONObject(resp);
	        if("ok".equals(object.getString("status")))
	        { // вход успешно
	        	return true;
	        }
	        return false;
>>>>>>> allredy ok register test3
	 }
	

}
