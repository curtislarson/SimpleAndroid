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
package com.quackware.simpleandroid.simple.ui.view;

import android.content.Context;
import android.widget.Button;

public class ViewFactory 
{
	
	private static Context mContext;

	public static Button getButton(String buttonText)
	{
		Button b = new Button(mContext);
		b.setText(buttonText);
		return b;
	}
	
	public static void setContext(Context pContext)
	{
		mContext = pContext;
	}
}
