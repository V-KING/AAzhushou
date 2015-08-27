package com.vk.controls;

import java.util.ArrayList;
import java.util.List;

import com.vk.aazhushou.R;
import com.vk.adapter.AdapterSlideMenu;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;

public class SlideMenuView {

	private Activity mActivity;
	private boolean misClosed;
	private List mMenuList;
	private RelativeLayout layBottomBox;
	private OnSliderMenuLisener mOnSliderMenuLisener;

	public SlideMenuView(Activity pActivity) {
		mActivity = pActivity;

		initVariable();
		initView();
		initLiteners();
	}
	
	public interface OnSliderMenuLisener{
		public abstract void onSliderMenuItemClick(View pView, SlideMenuItem pSlideMenuItem);
	}

	private void initVariable() {
		mMenuList = new ArrayList();
		misClosed = true;
		mOnSliderMenuLisener = (OnSliderMenuLisener) mActivity;
	}

	private void initView() {
		layBottomBox = (RelativeLayout) mActivity
				.findViewById(R.id.includeBottom);
	}

	public void bindList() {
		AdapterSlideMenu _AdapterSlideMenu = new AdapterSlideMenu(mActivity, mMenuList);
		ListView _ListView = (ListView) mActivity.findViewById(R.id.lvSlideList);
		_ListView.setAdapter(_AdapterSlideMenu);
		_ListView.setOnItemClickListener(new OnSlideMenuItemClick());
	}

	private void initLiteners() {
		layBottomBox.setOnClickListener(new OnSlideMenuClick());
	}

	private void open() {
		RelativeLayout.LayoutParams _LayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT,RelativeLayout.LayoutParams.FILL_PARENT);
		_LayoutParams.addRule(RelativeLayout.BELOW, R.id.includeTittle);
		
		layBottomBox.setLayoutParams(_LayoutParams);
		misClosed = false;
	}

	private void close() {
		RelativeLayout.LayoutParams _LayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT,68);
		_LayoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		
		layBottomBox.setLayoutParams(_LayoutParams);
		misClosed = true;
	}

	private void toggle() {
		if (misClosed) {
			open();
		}
		else {
			close();
		}
	}

	public void add(SlideMenuItem pSlideMenuItem) {
		mMenuList.add(pSlideMenuItem);
	}

	private class OnSlideMenuClick implements OnClickListener {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			toggle();
			Toast.makeText(mActivity, "OnSlideMenuClick", 1).show();
		}
	}
	
	private class OnSlideMenuItemClick implements OnItemClickListener{
		@Override
		public void onItemClick(AdapterView<?> pAdapterView , View pView, int position,
				long id) {
//			Toast.makeText(mActivity, "ItemClick", 1).show();
			SlideMenuItem _SlideMenuItem = (SlideMenuItem) pAdapterView.getItemAtPosition(position);
			mOnSliderMenuLisener.onSliderMenuItemClick(pView, _SlideMenuItem);
			
		}
	}
	
	
	
}
