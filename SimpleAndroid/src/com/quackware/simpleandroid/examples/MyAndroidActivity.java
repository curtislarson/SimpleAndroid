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
package com.quackware.simpleandroid.examples;

import android.widget.Button;
import android.widget.Toast;

import com.quackware.simpleandroid.simple.ui.SimpleAndroidActivity;
import com.quackware.simpleandroid.simple.ui.view.LayoutFactory.LayoutType;

public class MyAndroidActivity extends SimpleAndroidActivity {

	@Override
	public void main() {
		
		this.addMainLayout(LayoutType.LINEAR_VERTICAL);
		this.addButton("Hello World!",true);
		this.addButton("Click me!",true);
		
	}
	
	@Override
	public void dialogClicked(int which)
	{
		switch(which)
		{
		case 1:
			this.showMessage("OK was clicked!", 0);
			break;
			
		}
	}
	
	@Override
	public void buttonClicked(Button pClickedButton)
	{
		if(pClickedButton.getText().equals("Click me!"))
		{
			this.showMessage("I Was Clicked!",0);
		}
		else if(pClickedButton.getText().equals("Hello World!"))
		{
			this.showDialog("Title", "Message", "OK", "Cancel");
		}
	}

}
