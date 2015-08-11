package com.vk.aazhushou;

import com.vk.Activity.ActivityFrame;
import com.vk.adapter.AdapterAppGrid;
import com.vk.adapter.AdapterSlideMenu;
import com.vk.controls.SlideMenuItem;
import com.vk.controls.SlideMenuView;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

public class ActivityMain extends ActivityFrame{
	private GridView gvAppGrid;
	private AdapterAppGrid mAdapterAppGrid;
	
	private SlideMenuView mSlideMenuView;
	
	private AdapterSlideMenu mAdapterSlideMenu;
	
	private ListView lvSlideList;
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
	}
	public void initVariable(){
		mAdapterAppGrid = new AdapterAppGrid(this);
		mSlideMenuView = new SlideMenuView(this);
	}
	private void initView() {
		gvAppGrid = (GridView) findViewById(R.id.gvAppGrid);
		lvSlideList = (ListView) findViewById(R.id.lvSlideList);
	}
	private void initListeners() {
		// TODO Auto-generated method stub
		
	}
	private void bindData() {
		// TODO Auto-generated method stub
		gvAppGrid.setAdapter(mAdapterAppGrid);
		lvSlideList.setAdapter(mAdapterSlideMenu);
	}
}
