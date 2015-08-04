package com.vk.Base;

import com.vk.aazhushou.R;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class ActivityFrame extends ActivityBase {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.lay_main);
	}
	/**
	 * 动态将其他id(比如图片id)的item加载layMainBody中到
	 * @param pResId	要加载的相对布局的include的layout的id
	 */
	protected void appendMainBody(int pResId) {
		//找到id
		LinearLayout _mainBody = (LinearLayout)findViewById(R.id.layMainBody);
		//实例化成一个view
		View _view = LayoutInflater.from(this).inflate(pResId, null);
		//得到RelativeLayout的参数(宽高)
		RelativeLayout.LayoutParams _layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.FILL_PARENT);
		//将视图加载进来，带上实例(_view)和参数(_layoutParams)
		_mainBody.addView(_view, _layoutParams);
	}
}
