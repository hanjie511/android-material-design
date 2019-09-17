# android-material-design
此次的demo主要演示了如何使用Google官方提供的material-design设计库来帮助我们更加快速的、高效的、美观的开发我们的Android应用。该demo中使用了material-design中的Toolbar来代替传统的手机页面顶部的ActionBar，使用了NavigationView来来简化了页面侧滑菜单繁重的编写过程。
# 项目实现效果图
## 侧滑页面布局代码（其中包括主界面的布页面）：
```java
<android.support.v4.widget.DrawerLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:id="@+id/drawer"
    >
        <!-- Android的toolbar的布局，由于是在DrawerLayout中，为了防止没有layout_gravity属性的控件占满整个屏幕-->
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="vertical"
            >
            <android.support.v7.widget.Toolbar
                android:id="@+id/toolbar"
                android:layout_width="match_parent"
                android:layout_height="?attr/actionBarSize"
                android:background="?attr/colorPrimary"
                android:theme="@style/AppTheme1"
                app:popupTheme="@style/ThemeOverlay.AppCompat.Light"
                app:navigationIcon="@drawable/ic_menu_black_24dp"
                />
        </LinearLayout>
    <!--我们可以在这里写主界面的布局控件header -->

    <!--我们可以在这里写主界面的布局控件footer -->
    <!-- 侧滑界面的布局header-->
    <LinearLayout
        android:layout_width="match_parent"
        android:orientation="vertical"
        android:layout_gravity="left"
        android:layout_height="match_parent">
    <android.support.design.widget.NavigationView
        android:id="@+id/nav_main"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:headerLayout="@layout/nav_header"
        app:menu="@menu/navigation_menu"
        app:itemTextAppearance="@style/nav_menu_text"
        >
        <!-- drawerLayout页面的底部按钮header-->
       <LinearLayout
           android:layout_width="match_parent"
           android:layout_height="wrap_content"
           android:orientation="vertical"
           android:layout_gravity="bottom"
           >
           <View
               android:layout_width="match_parent"
               android:layout_height="1dp"
               android:background="@android:color/darker_gray"
               />
        <LinearLayout
            android:layout_width="match_parent"
            android:orientation="horizontal"
            android:layout_height="wrap_content">
            <Button
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:text="重新登录"
                android:onClick="reLogin"
                android:background="@android:color/transparent"
                android:id="@+id/nav_reLogin"
                />
            <Button
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:text="退出"
                android:onClick="exit"
                android:background="@android:color/transparent"
                android:id="@+id/nav_exit"
                />
        </LinearLayout>
       </LinearLayout>
        <!-- drawerLayout页面的底部按钮footer-->
    </android.support.design.widget.NavigationView>
</LinearLayout>
<!-- 侧滑界面的布局footer-->
</android.support.v4.widget.DrawerLayout>
```
## ToolBar的引用
```java
 <android.support.v7.widget.Toolbar
        android:id="@+id/toolbar"
        android:layout_width="match_parent"
        android:layout_height="?attr/actionBarSize"
        android:background="?attr/colorPrimary"
        android:theme="@style/AppTheme1"
        app:popupTheme="@style/ThemeOverlay.AppCompat.Light"
        app:navigationIcon="@drawable/ic_menu_black_24dp"
         />
```

### 属性说明
* app:popupTheme设置ToolBar上的按钮点击后弹出菜单的样式
* app:navigationIcon设置ToolBar上左侧的图标（没错，就是页面顶部左侧有三条横线的那个图标）
## NavigationView的引用
```java
<android.support.design.widget.NavigationView
        android:id="@+id/nav_main"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:headerLayout="@layout/nav_header"
        app:menu="@menu/navigation_menu"
        app:itemTextAppearance="@style/nav_menu_text"
        >
```

<br>

### 属性说明
* app:headerLayout设置侧滑界面的头部布局文件
* app:menu设置侧滑界面选项功能的布局界面
* app:itemTextAppearance设置选项的字体样式
## 如何使用Toolbar：
* 将app的主题设置为*.NoActionBar的样式(在AndroidManifast.xml文件中的application标签中的android:theme=""属性中设置)。
* 在ToolBar所在的activity的onCreate方法中添加如下代码：
```java
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        .
        .
        }
```
* 为ToolBar添加图标和点击事件（重写Activity的onCreateOptionsMenu(Menu menu)和onOptionsItemSelected(MenuItem item)这两个方法）：<br>
代码如下：<br>
```java
@Override
    //添加ToolBar按钮图标的方法
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbarmenu,menu);
        return true;
    }

    @Override
    //ToolBar的按钮点击事件
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.edit_toolbar_menu:
                Toast.makeText(this, "你点击了编辑按钮", Toast.LENGTH_SHORT).show();
                break;
            case R.id.search_toolbar_menu:
                Toast.makeText(this, "你点击了搜索按钮", Toast.LENGTH_SHORT).show();
                break;    
        }
        return true;
    }
```


