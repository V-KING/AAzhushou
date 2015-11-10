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
	 * ��̬��������layout(main_body.xml,GridView)����id=layMainBody����ͼ��
	 * 
	 * @param pResId
	 *            Ҫ���ص���Բ��ֵ�include��layout��id
	 */
	protected void appendMainBody(int pResId) {
		// �ҵ�lay_main.xml��layMainBody��Ȼ������layMainBody�����һ��GridView
		LinearLayout _mainBody = (LinearLayout) findViewById(R.id.incLayMainBody);
		// ʵ������һ��view
		View _view = LayoutInflater.from(this).inflate(pResId, null);
		// �õ�RelativeLayout�Ĳ���(���)
//		RelativeLayout.LayoutParams _layoutParams = new RelativeLayout.LayoutParams(
//				RelativeLayout.LayoutParams.FILL_PARENT,
//				RelativeLayout.LayoutParams.FILL_PARENT);
//		// ����ͼ���ؽ���������ʵ��(_view)�Ͳ���(_layoutParams)
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
