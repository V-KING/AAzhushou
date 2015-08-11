package com.vk.Activity;

import android.app.Activity;
import android.content.Intent;
import android.view.Window;
import android.widget.Toast;

public class ActivityBase extends Activity {

	protected void showMsg(String pMsg) {
		Toast.makeText(this, pMsg, Toast.LENGTH_LONG).show();
	}
	protected void openActivity(Class<?> pClass) {
		Intent _intent = new Intent(this, pClass);
		startActivity(_intent);
	}
}
