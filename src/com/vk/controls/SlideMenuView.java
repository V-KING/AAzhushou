package com.vk.controls;

import java.util.ArrayList;
import java.util.List;

import com.vk.aazhushou.R;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;

public class SlideMenuView {

	private Activity mActivity;
	private boolean misClosed;
	private List mMenuList;
	private RelativeLayout layBottomBox;

	public SlideMenuView(Activity pActivity) {
		mActivity = pActivity;

		initVariable();
		initView();
		initLiteners();
	}

	private void initVariable() {
		mMenuList = new ArrayList();
		misClosed = true;
	}

	private void initView() {
		layBottomBox = (RelativeLayout) mActivity
				.findViewById(R.id.includeBottom);
	}

	private void bindList() {

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

	private void add(SlideMenuItem pSlideMenuItem) {
		mMenuList.add(pSlideMenuItem);
	}

	private void onSlideMenuClick() {

	}

	private class OnSlideMenuClick implements OnClickListener {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			toggle();
			Toast.makeText(mActivity, "OnSlideMenuClick", 1).show();
		}
	}
}
