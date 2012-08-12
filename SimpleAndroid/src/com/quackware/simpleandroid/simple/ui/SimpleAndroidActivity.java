/*******************************************************************************
 * Copyright (c) 2012 Curtis Larson (QuackWare).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     Curtis Larson - initial API and implementation
 ******************************************************************************/
package com.quackware.simpleandroid.simple.ui;

import java.util.ArrayList;
import java.util.HashMap;

import com.quackware.simpleandroid.simple.ui.view.BaseSimpleView;
import com.quackware.simpleandroid.simple.ui.view.LayoutFactory;
import com.quackware.simpleandroid.simple.ui.view.ViewFactory;
import com.quackware.simpleandroid.simple.ui.view.LayoutFactory.LayoutType;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public abstract class SimpleAndroidActivity extends Activity implements ISimple, OnClickListener, android.content.DialogInterface.OnClickListener {
	
	private ViewGroup mView;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		this.onSetContentView();
		LayoutFactory.setContext(this);
		ViewFactory.setContext(this);
		this.main();
		
	}
	
	protected void onSetContentView()
	{
		mView = new BaseSimpleView(this);
		setContentView(mView);
	}
	
	public void addMainLayout(LayoutType pLayoutType)
	{
		mView = LayoutFactory.getLayout(pLayoutType);
		setContentView(mView);
	}
	
	public Button addButton(String buttonText)
	{
		return addButton(buttonText,true);
	}
	
	public void addView(View v, boolean pAddClickListener)
	{
		mView.addView(v);
		if(pAddClickListener)
		{
			v.setOnClickListener(this);
		}
		
	}
	
	public void addView(View v)
	{
		addView(v,true);
	}
	
	public Button addButton(String buttonText, boolean pAddClickListener)
	{
		Button b = ViewFactory.getButton(buttonText);
		mView.addView(b);
		if(pAddClickListener)
		{
			b.setOnClickListener(this);
		}
		return b;
		
	}
	
	public void showDialog(String title, String message, String positiveButtonText,
			String negativeButtonText)
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(title);
		builder.setMessage(message);
		builder.setPositiveButton(positiveButtonText, this);
		builder.setNegativeButton(negativeButtonText, this);
		builder.create().show();
	}
	
	public void buttonClicked(Button pClickedButton){}
	public void dialogClicked(int which) {}
	
	public void showMessage(String message,int duration)
	{
		Toast.makeText(this, message, duration).show();
	}
	
	@Override
	public void onClick(DialogInterface dialog, int which)
	{
		
		this.dialogClicked(Math.abs(which));
	}
	
	@Override
	public void onClick(View v)
	{
		if(v instanceof Button)
		{
			this.buttonClicked((Button)v);
		}
	}
	

}
