#AAzhushou

aa助手

##20150805

### 1. 相对布局的时候注意bottom_box.xml的layout_alignParentBottom
### 2. 实现Acitity的Base类，以后可以往基类中添加内容
### 3. 实现AcitivityFrame类

- 要不要标题requestWindowFeature(Window.FEATURE_NO_TITLE);
- 动态将其他id(比如图片id)的item加载layMainBody中到

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