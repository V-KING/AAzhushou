package com.vk.aazhushou;

import com.vk.Activity.ActivityFrame;
import com.vk.adapter.AdapterAppGrid;
import com.vk.controls.SlideMenuItem;
import com.vk.controls.SlideMenuView;
import com.vk.controls.SlideMenuView.OnSliderMenuLisener;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

public class ActivityMain extends ActivityFrame implements OnSliderMenuLisener{
	private GridView gvAppGrid;
	private AdapterAppGrid mAdapterAppGrid;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.lay_main);//在ActivityFrame中加载
		//加载layMainBody,此时还没有加载gridview中的东西
		appendMainBody(R.layout.main_body);
		initVariable();
		initView();
		initListeners();
		bindData();
		createSlideMenu(R.array.SlideMenuActivityMain);
	}
	public void initVariable(){
		mAdapterAppGrid = new AdapterAppGrid(this);
	}
	private void initView() {
		gvAppGrid = (GridView) findViewById(R.id.gvAppGrid);
	}
	private void initListeners() {
		// TODO Auto-generated method stub
		
	}
	private void bindData() {
		gvAppGrid.setAdapter(mAdapterAppGrid);
		
	}
	@Override
	public void onSliderMenuItemClick(View pView, SlideMenuItem pSlideMenuItem) {
		// TODO Auto-generated method stub
		Toast.makeText(this, pSlideMenuItem.getTitle(), Toast.LENGTH_SHORT).show();
	}
}
