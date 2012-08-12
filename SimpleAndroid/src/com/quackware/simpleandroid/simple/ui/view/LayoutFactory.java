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
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class LayoutFactory {
	
	private static Context mContext;

	
	public static ViewGroup getLayout(LayoutType pType)
	{
		switch(pType)
		{
		case LINEAR_HORIZONTAL:
			return getLinearLayout(LinearLayout.HORIZONTAL);
		case LINEAR_VERTICAL:
			return getLinearLayout(LinearLayout.VERTICAL);
		default:
			return null;
		}
	}
	
	private static LinearLayout getLinearLayout(int pOrientation)
	{
		LinearLayout ll = new LinearLayout(mContext);
		ll.setOrientation(pOrientation);
		return ll;
	}
	
	
	public enum LayoutType
	{
		LINEAR_HORIZONTAL,
		LINEAR_VERTICAL;
	};
	
	public static void setContext(Context pContext)
	{
		mContext = pContext;
	}

}
