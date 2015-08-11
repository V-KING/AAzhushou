[toc]

#AAzhushou

aa助手



##20150805

### 1. 相对布局的时候注意bottom_box.xml的layout_alignParentBottom
### 2. 实现Acitity的Base类，以后可以往基类中添加内容
### 3. 实现AcitivityFrame类

- 要不要标题requestWindowFeature(Window.FEATURE_NO_TITLE);
- 动态将其他id(比如图片id)的item加载到layMainBody的GridView中

##20150806
### 1. 将main_body.xml建立,里面有GridView
### 2. 既然有了GridView我们就要动态的加载里面的item，所以下需要bind一个AdapterAppGrid,新建AdapterAppGrid类
### 3. 需要一个装item的layout
### 4. 在BaseAdapter中封装一个Holder类装iv和tv的实体类,看起来清爽
- 所用到的资源封装到一个Integer数组m_ImageInteger中(资源id)
- 将所有的ivIcon的name所用到的字符串也封装到一个数组m_ImageString中
- 注意：封装m_ImageString的时候，封装在构造函数里，因为获得string的时候是要用到方法的

### 5. 复写AdapterAppGrid里面的方法
思路：如果没有convertView就创建一组view（iv和tv），有就直接获得<组items>并设置资源.
可以参考：http://www.cnblogs.com/andriod-html5/archive/2012/06/06/2539221.html
- 重点复写getView(int position, View convertView, ViewGroup parent)方法
- 怎么获取(过滤)一个layout或者View? 
	- LayoutInflater _layoutInflater = LayoutInflater.from(mContext);
	- convertView = _layoutInflater .inflate(R.layout.main_body_item, null);
- convertView.setTag(Object)//可以设置一个Tag里面可以放Object实体，可以在外面获取这个Object

### 6. 初始化的一些封装
- initVariable()
- initView()
- initListeners()
- bindData()//例如：Adapter

### 7. 实现GridView里面的Selector的样式
作用：点中后是什么样的样式，如背景颜色，圆角，形状等
- 属性：
	- android:state_selected
	- android:state_focused 获得焦点
	- android:state_pressed
```
	<！--非触摸膜式下获得焦点并单击时的背景图片 -->
	<item android:state_focused = "true"
		android:state_pressed = "true"
		android:drawable = "@drawable/pic1.pgn" />
	<！--触摸膜式下单击时的背景图片 -->
	<item android:state_focused = "false"
		android:state_pressed = "true"
		android:drawable = "@drawable/pic2.pgn" />	
```
1. 选择器设置如下：
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
2. 在GridView中引用这个选择器
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
### 1. SlideMenuItem，SlideMenuView(里面有ListView装东西的)
SliderMenuView 有很多个，并且和业务有关，所以要封装； listView很多地方要用到，所以也可以封装
- 底部需要一个布局，当你点击的时候能够将整个页面撑满，再点击的时候就回复原样.线性布局里面加ListView，listview中可以有很多东西，string，image，description，等等,所以可以封装SlideMenuItem实体类
	- ListView中的style被应用到很多地方，所以封装style
- 创建SlideMenuView
```
open();
close();
toggle();
add();
bindList();
onSlideMenuClick();
构造函数
isClosed;
mMenuList
```
- 怎么动态的设置控件的参数LayoutParams(可以具体到RelativeLayout.LayoutParams),设置控件的位置_LayoutParams.addRule
```
private void open() {
		RelativeLayout.LayoutParams _LayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT,RelativeLayout.LayoutParams.FILL_PARENT);
		_LayoutParams.addRule(RelativeLayout.BELOW, R.id.includeTittle);
		
		layBottomBox.setLayoutParams(_LayoutParams);
		misClosed = false;
	}
```

然后测试一下SlideMenuView是否正常显示,click监听是否工作

###2. 添加SlideMenuItem的Adapter
发现好adapter的东西重复了,所以新建一个AdapterBase类继承BaseAdapter，发现我们的getView不能实现，所以将AdapterBase变成抽象类.让AdapterSlideMenu继承AdapterBase。


- 抽象类：谁继承我谁去实现方法
- 再写AdapterSlideMenu时,新建slidemenu_list_item.xml让AdapterSlideMenu去加载slidemenu_list_item.xml里面的textview里的string
- 菜单被用到很多次，跟业务联系紧密，所以在ActivityFram中封装CreateSlideMenu()
	- 新建SlideMenuView控件。(里面有视图，有监听器等和SlideMenuView有关的东西)
	- 新建数组arrays.xml
		- 
		```	
		<string-array name = "SlideMenuActivityMain">
			<item>软件帮助</item>
			<item>关于软件</item>
		</string-array>
		```	
		
	- 得到arrays.xml中的数组
		- getResource().getStringArray(R.array.SlideMenuActivityMain);
		- getResource().getStringArray(传进来的参数int);
		
	







