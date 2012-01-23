package com.ingame.andrclient;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.ui.activity.BaseGameActivity;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;

public class MainAndClientActivity extends BaseGameActivity
{

	private Camera	camera;
	private Display	display;

	public Engine onLoadEngine()
	{
		this.display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
		this.camera = new Camera(0f, 0f, this.display.getWidth(), this.display.getHeight());
		EngineOptions options = new EngineOptions(true, ScreenOrientation.LANDSCAPE, new RatioResolutionPolicy(this.camera.getWidth(),
				this.camera.getHeight()), this.camera);

		return new Engine(options);
	}

	public void onLoadResources()
	{
		// TexturesLoader
	}

	public Scene onLoadScene()
	{
		// TODO Auto-generated method stub
		return null;
	}

	public void onLoadComplete()
	{
		// TODO Auto-generated method stub

	}
}