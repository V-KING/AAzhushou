package com.vk.controls;

import java.util.List;

public class SlideMenuItem {
	private int mItemId;
	private String mTitle;
	
	public SlideMenuItem(int pItemId, String pTitle) {
		mItemId = pItemId;
		mTitle = pTitle;
	}
	
	public int getItemId() {
		return mItemId;
	}
	public void setItemId(int gItemId) {
		this.mItemId = gItemId;
	}
	public String getTitle() {
		return mTitle;
	}
	public void setTitle(String gTitle) {
		this.mTitle = gTitle;
	}
}
