[toc]

#AAzhushou

aa����

##20150805

### 1. ��Բ��ֵ�ʱ��ע��bottom_box.xml��layout_alignParentBottom
### 2. ʵ��Acitity��Base�࣬�Ժ�������������������
### 3. ʵ��AcitivityFrame��

- Ҫ��Ҫ����requestWindowFeature(Window.FEATURE_NO_TITLE);
- ��̬��һ��lay_main_body.xml(�����ǰ���GridView��)�ӵ�����õ�lay_main.xml����main_activity.xml���� 
	- //�ҵ�lay_main.xml��incLayMainBody��Ȼ������layMainBody�����һ��GridView
	```java
	LinearLayout _mainBody = (LinearLayout) findViewById(R.id.incLayMainBody);
	```
	-  //ʵ������һ��view��������Ҫ��̬�����GridView��main_body.xml�� 
	```java
	View _view = LayoutInflater.from(this).inflate(pResId, null);
	RelativeLayout.LayoutParams _layoutParams = new RelativeLayout.LayoutParams(
			RelativeLayout.LayoutParams.FILL_PARENT,
			RelativeLayout.LayoutParams.FILL_PARENT);
	```

	- //����ͼgridview���ص������н���������ʵ��(_view)�Ͳ���(_layoutParams)��_layoutParams�ǿ��Բ�Ҫ��
	```java
		_mainBody.addView(_view, _layoutParams);
	```

##20150806
### 1. ��main_body.xml����,������GridView
### 2. ��Ȼ����GridView���Ǿ�Ҫ��̬�ļ��������item����������Ҫbindһ��AdapterAppGrid,�½�AdapterAppGrid��
### 3. ��Ҫһ��װitem��layout
### 4. ��BaseAdapter�з�װһ��Holder��װiv��tv��ʵ����,��������ˬ
- ���õ�����Դ��װ��һ��Integer����m_ImageInteger��(��Դid)
- �����е�ivIcon��name���õ����ַ���Ҳ��װ��һ������m_ImageString��
- ע�⣺��װm_ImageString��ʱ�򣬷�װ�ڹ��캯�����Ϊ���string��ʱ����Ҫ�õ�������

### 5. ��дAdapterAppGrid����ķ���
˼·�����û��convertView�ʹ���һ��view��iv��tv�����о�ֱ�ӻ��<��items>��������Դ.
���Բο���http://www.cnblogs.com/andriod-html5/archive/2012/06/06/2539221.html
- �ص㸴дgetView(int position, View convertView, ViewGroup parent)����
	- 
- ��ô��ȡ(����)һ��layout����View? 
	- LayoutInflater _layoutInflater = LayoutInflater.from(mContext);
	- convertView = _layoutInflater .inflate(R.layout.main_body_item, null);
- convertView.setTag(Object)//��������һ��Tag������Է�Objectʵ�壬�����������ȡ���Object

### 6. ��ʼ����һЩ��װ
- initVariable()
- initView()
- initListeners()
- bindData()//���磺Adapter

### 7. ʵ��GridView�����Selector����ʽ
���ã����к���ʲô������ʽ���米����ɫ��Բ�ǣ���״��
- ���ԣ�
	- android:state_selected
	- android:state_focused ��ý���
	- android:state_pressed
```
	<��--�Ǵ���Ĥʽ�»�ý��㲢����ʱ�ı���ͼƬ -->
	<item android:state_focused = "true"
		android:state_pressed = "true"
		android:drawable = "@drawable/pic1.pgn" />
	<��--����Ĥʽ�µ���ʱ�ı���ͼƬ -->
	<item android:state_focused = "false"
		android:state_pressed = "true"
		android:drawable = "@drawable/pic2.pgn" />	
```
1. ѡ�����������£�һ�����drawableĿ¼�У���
```
<selector xmlns:android="http://schemas.android.com/apk/res/android">
<item android:state_pressed="true">
        <shape>
            <corners android:radius="6dp" />
            <gradient android:angle="270" android:endColor="#ff4d56" android:startColor="#ffa3a5" />
        </shape>
</item>
</selector>		
```
2. ��GridView���������ѡ����
```
<GridView
        android:id="@+id/gvAppGrid"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:numColumns="3" 
        android:listSelector="@drawable/app_grid_selector">
</GridView>
```


##20150807
### 1. SlideMenuItem��SlideMenuView(������ListViewװ������)
SliderMenuView �кܶ�������Һ�ҵ���йأ�����Ҫ��װ�� listView�ܶ�ط�Ҫ�õ�������Ҳ���Է�װ
- �ײ���Ҫһ�����֣���������ʱ���ܹ�������ҳ��������ٵ����ʱ��ͻظ�ԭ��.���Բ��������ListView��listview�п����кܶණ����string��image��description���ȵ�,���Կ��Է�װSlideMenuItemʵ����
	- ListView�е�style��Ӧ�õ��ܶ�ط������Է�װstyle
- ����SlideMenuView
```
open();
close();
toggle();
add();
bindList();//����adapter��Listener
onSlideMenuClick();
���캯��
isClosed;
mMenuList
```
- ��ô��̬�����ÿؼ��Ĳ���LayoutParams(���Ծ��嵽RelativeLayout.LayoutParams),���ÿؼ���λ��_LayoutParams.addRule
```
private void open() {
		RelativeLayout.LayoutParams _LayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT,RelativeLayout.LayoutParams.FILL_PARENT);
		_LayoutParams.addRule(RelativeLayout.BELOW, R.id.includeTittle);
		
		layBottomBox.setLayoutParams(_LayoutParams);
		misClosed = false;
	}
```

Ȼ�����һ��SlideMenuView�Ƿ�������ʾ,click�����Ƿ���

###2. ���SlideMenuItem��Adapter
���ֺ�adapter�Ķ����ظ���,�����½�һ��AdapterBase��̳�BaseAdapter���������ǵ�getView����ʵ�֣����Խ�AdapterBase��ɳ�����.��AdapterSlideMenu�̳�AdapterBase��


- �����ࣺ˭�̳���˭ȥʵ�ַ���getView()
- ��дAdapterSlideMenuʱ,�½�slidemenu_list_item.xml��AdapterSlideMenuȥ����slidemenu_list_item.xml�����textview���string
- �˵����õ��ܶ�Σ���ҵ����ϵ���ܣ�������ActivityFram�з�װCreateSlideMenu()
	- �½�SlideMenuView�ؼ���(��������ͼ���м������Ⱥ�SlideMenuView�йصĶ���)
	- �½�����arrays.xml
		- 
		```	
		<string-array name = "SlideMenuActivityMain">
			<item>�������</item>
			<item>�������</item>
		</string-array>
		```	
		
	- �õ�arrays.xml�е�����
		- getResource().getStringArray(R.array.SlideMenuActivityMain);
		- getResource().getStringArray(�������Ĳ���int);
	
> **��������**��
**type #0x12 is not valid**��������Դid��ʱ�����ô���,��layout��ID����view��ID
	
##20150827
####1. ��������SliderMenuView�����item���click���Ա��õ��ܶ�Σ�click������ͬ�Ĵ���
�ýӿ���ʵ�֣�������Activity ʵ��OnClickListener����button��click��OnClickListenerҲ����ô���ġ�

```
//��SliderMenuView����
private OnSliderMenuLisener mOnSliderMenuLisener;
//at initValible()
mOnSliderMenuLisener = (OnSliderMenuLisener) mActivity;
public interface OnSliderMenuLisener{
	public abstract void onSliderMenuItemClick(View pView, SlideMenuItem pSlideMenuItem);
}
//in click method
mOnSliderMenuLisener.onSliderMenuItemClick(pView, _SlideMenuItem);
```

```
public class ActivityMain extends ActivityFrame implements OnSliderMenuLisener{
	//...
	@Override
	public void onSliderMenuItemClick(View pView, SlideMenuItem pSlideMenuItem) {
		// TODO Auto-generated method stub
		Toast.makeText(this, pSlideMenuItem.getTitle(), Toast.LENGTH_SHORT).show();
	}
}
```
�������Ǿ�����һ���ӿڣ���Activityʵ�֣�˭��˭ʵ�֣��Ϳ�����OnClickListener��������buttonһ����










