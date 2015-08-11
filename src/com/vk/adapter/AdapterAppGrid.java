package com.vk.adapter;

import java.util.List;

import com.vk.aazhushou.R;
import com.vk.adapter.base.AdapterBase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterAppGrid extends BaseAdapter{


	// ����װitem�е�iv��tv
	private class Holder {
		ImageView ivIcon;
		TextView tvName;
	}

	// ͼƬ��Դid��װ
	private Integer[] m_ImageInteger = { R.drawable.grid1, R.drawable.grid2,
			R.drawable.grid3, R.drawable.grid4, R.drawable.grid5,
			R.drawable.grid6, };
	private String[] m_ImageString = new String[6];
	private Context mContext;

//	public AdapterAppGrid(Context pContext, List pList) {
//		super(pContext, pList);
//		mContext = pContext;
//		m_ImageString[0] = pContext.getString(R.string.appGridTextRecordConsume);
//		m_ImageString[1] = pContext.getString(R.string.appGridTextQueryConsume);
//		m_ImageString[2] = pContext.getString(R.string.appGridTextAccountManage);
//		m_ImageString[3] = pContext.getString(R.string.appGridTextStatisticsManage);
//		m_ImageString[4] = pContext.getString(R.string.appGridTextGategoryManage);
//		m_ImageString[5] = pContext.getString(R.string.appGridTextUserManage);
//	}
	public AdapterAppGrid(Context pContext) {
		mContext = pContext;
		m_ImageString[0] = pContext.getString(R.string.appGridTextRecordConsume);
		m_ImageString[1] = pContext.getString(R.string.appGridTextQueryConsume);
		m_ImageString[2] = pContext.getString(R.string.appGridTextAccountManage);
		m_ImageString[3] = pContext.getString(R.string.appGridTextStatisticsManage);
		m_ImageString[4] = pContext.getString(R.string.appGridTextGategoryManage);
		m_ImageString[5] = pContext.getString(R.string.appGridTextUserManage);
	}

	@Override
	public int getCount() {
		return m_ImageInteger.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO ���һ��������item,�����itemֻ��һ��string��Ӧ�ð���iv��tv��item
		return m_ImageString[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		//TODO ��������convertViewӦ���ǰ���iv��tv��,�����ں����ٷ�װ���������õ�����Ҫ��getTag
		Holder _Holder;
		//create ivIcon and tvName's Object,then add resource to Object
		if (convertView == null) {//if the view you want to get is null,then create
			// �õ�item��view:convertView
			LayoutInflater _layoutInflater = LayoutInflater.from(mContext);
			convertView = _layoutInflater .inflate(R.layout.main_body_item, null);
			// add item's view to convertView
			_Holder = new Holder();
			_Holder.ivIcon = (ImageView) convertView.findViewById(R.id.ivIcon);
			_Holder.tvName = (TextView) convertView.findViewById(R.id.tvName);
			// setTag for others to use the ItemObject.Here is the Holder class's function:to setTag
			convertView.setTag(_Holder);

		}
		else {
			//if convertView not null,then getTag
			_Holder = (Holder) convertView.getTag();
		}
		_Holder.ivIcon.setImageResource(m_ImageInteger[position]); 
		_Holder.tvName.setText(m_ImageString[position]);
		return convertView;//�����iv��tv������(Holder)getTag����ȡ
	}
}
