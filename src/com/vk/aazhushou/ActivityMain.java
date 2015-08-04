package com.vk.aazhushou;

import com.vk.Base.ActivityFrame;

import android.os.Bundle;

public class ActivityMain extends ActivityFrame{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.lay_main);//在ActivityFrame中加载
		//在layMainBody中加载其他的id视图
		//appendMainBody(R.id.layMainBody);
	}

}
