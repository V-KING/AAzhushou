package com.vk.Activity;

import com.vk.aazhushou.R;
import com.vk.controls.SlideMenuItem;
import com.vk.controls.SlideMenuView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class ActivityFrame extends ActivityBase {
	private SlideMenuView mSlideMenuView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.lay_main);
	}

	/**
	 * 动态将其他的layout(main_body.xml,GridView)加载id=layMainBody的视图中
	 * 
	 * @param pResId
	 *            要加载的相对布局的include的layout的id
	 */
	protected void appendMainBody(int pResId) {
		// 找到lay_main.xml中layMainBody；然后再在layMainBody中添加一个GridView
		LinearLayout _mainBody = (LinearLayout) findViewById(R.id.incLayMainBody);
		// 实例化成一个view
		View _view = LayoutInflater.from(this).inflate(pResId, null);
		// 得到RelativeLayout的参数(宽高)
//		RelativeLayout.LayoutParams _layoutParams = new RelativeLayout.LayoutParams(
//				RelativeLayout.LayoutParams.FILL_PARENT,
//				RelativeLayout.LayoutParams.FILL_PARENT);
//		// 将视图加载进来，带上实例(_view)和参数(_layoutParams)
//		_mainBody.addView(_view, _layoutParams);
		_mainBody.addView(_view);
	}

	protected void createSlideMenu(int pResId) {
		mSlideMenuView = new SlideMenuView(this);
		String[] _MenuItemArray = getResources().getStringArray(pResId);
		for (int i = 0; i < _MenuItemArray.length; i++) {
			SlideMenuItem _Item = new SlideMenuItem(i, _MenuItemArray[i]);
			mSlideMenuView.add(_Item);
		}
		mSlideMenuView.bindList();
	}

}
