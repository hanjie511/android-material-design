# android-material-design 
Android的material-design（NavigationView、ToolBar、ButtonNavigationView、AppBarLayout、CoordinatorLayout、CollapsingToolbarLayout、SwipeRefreshLayout、FloatingActionButton）的使用方法。<br>
其中还包括了CardView和在toolbar中嵌入SearchView的使用方法。
## 项目展示
![navigationView](https://github.com/hanjie511/android-material-design1/blob/master/navigationView.gif)
![buttonNavigationView](https://github.com/hanjie511/android-material-design1/blob/master/buttonNavigationView.gif)
![loadmore](https://github.com/hanjie511/android-material-design1/blob/master/loadmore.gif)
![refresh](https://github.com/hanjie511/android-material-design1/blob/master/Refresh.gif)
![searchView](https://github.com/hanjie511/android-material-design1/blob/master/searchView.gif)
### NavigationView
如第一张图片所展示的功能一样，它主要实现了侧滑导航菜单栏。它位于android.support.design.widget包中。
* show my code:
```java
<android.support.design.widget.NavigationView
            android:id="@+id/nav_main"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            app:headerLayout="@layout/nav_header"
            app:itemTextAppearance="@style/nav_menu_text"
            app:menu="@menu/navigation_menu"
            />
```
app:headerLayout和app:menu属性分别对应其头部布局文件和菜单布局文件
### ToolBar
用来代替Android原来的ActionBar。Toolbar能够让我们对手机的页面头部的设计更加的快捷，灵活，多变。
* show my code:
```java
<android.support.v7.widget.Toolbar
        android:id="@+id/toolbar"
        android:layout_width="match_parent"
        android:layout_height="?attr/actionBarSize"
        android:paddingTop="10dp"
        android:theme="@style/AppTheme1"
        app:layout_collapseMode="pin"
        app:navigationIcon="@drawable/ic_menu_black_24dp"
        app:popupTheme="@style/ThemeOverlay.AppCompat.Light" />
```
app:navigationIcon用来定义手机页面左上角的导航图标，
### ButtonNavigationView
如第二张图片所示。它主要实现了手机页面底部的导航栏。它简化了我们原来设计底部导航栏的步骤，它使得我们的开发变得更加的快捷。
* show my code:
```java
<android.support.design.widget.BottomNavigationView
            android:id="@+id/buttonNavigation"
            android:layout_width="match_parent"
            android:layout_height="?attr/actionBarSize"
            android:layout_weight="2"
            app:itemIconTint="@color/navi_button_selector"
            app:itemTextColor="@color/navi_button_selector"
            app:labelVisibilityMode="labeled"
            app:menu="@menu/navigatiob_menu" />
```
app:menu属性用来定义它的菜单项，其中包括选项名称和图标。若我们不定义菜单选中时的selector，它会使用其默认的selector。
### SwipeRefreshLayout
google官方提供的一款下拉刷新的控件，它的使用方法很简单，我们只需要把ListView或RecyclerView作为它的唯一子控件即可，当我们这样设置完成后，如果列表中有数据且我们从列表顶部下拉时，它会自动检测到我们的下拉手势，并且弹出下拉刷新提示框。
* show my code:
```java
    <android.support.v4.widget.SwipeRefreshLayout
                android:id="@+id/swipeRefresh"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                app:layout_behavior="@string/appbar_scrolling_view_behavior">

                <android.support.v7.widget.RecyclerView
                    android:id="@+id/recyclerView"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"

                    />
            </android.support.v4.widget.SwipeRefreshLayout>
```
如上，我就将RecyclerView作为SwipeRefreshLayout的唯一子控件。just like this,it's done!!!
### FloatingActionButton
就是我们展示页面的那个红色的圆形的图标，故名思意，它是悬浮在手机页面之上的，它和其它的手机控件不在同一个维度。所以，不管它下面的内容如何变化，它都会漂浮在原来的位置上。注意：他必须位于位于FrameLayout性质的布局文件中，不然，它就漂浮不起来了！！！
* show my code:
```java
 <android.support.design.widget.FloatingActionButton
                android:id="@+id/fb"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:src="@drawable/ic_share_black_24dp"
                app:layout_anchor="@id/appBar"
                app:layout_anchorGravity="bottom|right" />
```
### AppBarLayout、CoordinatorLayout和CollapsingToolbarLayout
这三个我要一起说，因为他们就好像是爷爷（CoordinatorLayout）、父亲（AppBarLayout）和儿子（CollapsingToolbarLayout）的关系。他们都自能做各自的子控件。如AppBarLayout只能做CoordinatorLayout的子控件，而CollapsingToolbarLayout只能做AppBarLayout的子控件。
* CoordinatorLayout他是一个加强版的FrameLayout。他凭什么比FrameLayout优秀呢？因为，它能够监测到位于它布局容器内的所有控件的变化，进而做出相应的处理，而FrameLayout不行。
* AppBarLayout相当于一个垂直布局的LinearLayout，它的内部封装了一些滚动事件，位于它内部的控件都能使用它封装好的滚动事件。使用它的滚动事件的属性为：app:layout_scrollFlags。
* CollapsingToolbarLayout为可折叠的Toolbar布局，它可以更加丰富我们的Toolbar,它不会让我们的Toolbar只是像一个单调的页面标题栏了。它做到了让ToolBar可伸缩，还做到了让toolbar的布局和内容跟美观和丰富。该布局缩到最小后就是一个ToolBar。
* show my code:
```java
<android.support.design.widget.CoordinatorLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_weight="8"
            android:fitsSystemWindows="true">
            <android.support.design.widget.AppBarLayout
                android:id="@+id/appBar"
                android:layout_width="match_parent"
                android:layout_height="250dp"
                android:fitsSystemWindows="true">
                <android.support.design.widget.CollapsingToolbarLayout
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:fitsSystemWindows="true"
                    app:contentScrim="@color/colorPrimary"
                    app:layout_scrollFlags="scroll|exitUntilCollapsed">
                    <ImageView
                        android:layout_width="match_parent"
                        android:layout_height="match_parent"
                        android:fitsSystemWindows="true"
                        android:scaleType="centerCrop"
                        android:src="@mipmap/header_bg"
                        app:layout_collapseMode="parallax" />
                    <android.support.v7.widget.Toolbar
                        android:id="@+id/toolbar"
                        android:layout_width="match_parent"
                        android:layout_height="?attr/actionBarSize"
                        android:paddingTop="10dp"
                        android:theme="@style/AppTheme1"
                        app:layout_collapseMode="pin"
                        app:navigationIcon="@drawable/ic_menu_black_24dp"
                        app:popupTheme="@style/ThemeOverlay.AppCompat.Light" />
                </android.support.design.widget.CollapsingToolbarLayout>
            </android.support.design.widget.AppBarLayout>
            <android.support.design.widget.FloatingActionButton
                android:id="@+id/fb"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:src="@drawable/ic_share_black_24dp"
                app:layout_anchor="@id/appBar"
                app:layout_anchorGravity="bottom|right" />
            <android.support.v4.widget.SwipeRefreshLayout
                android:id="@+id/swipeRefresh"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                <!--app:layout_behavior属性让AppBarLayout明白谁在滚动，当滚动控件滚动时，AppbarLayout好做出相应的变化 -->
                app:layout_behavior="@string/appbar_scrolling_view_behavior">
                <android.support.v7.widget.RecyclerView
                    android:id="@+id/recyclerView"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
            </android.support.v4.widget.SwipeRefreshLayout>
        </android.support.design.widget.CoordinatorLayout>
```
### 重要的属性介绍：
* app:layout_collapseMode属性用来设置位于CollapsingToolbarLayout中的控件的折叠模式。它的值有3个，分别是parallax,pin和none.<br>
pin表示：在CollapsingToolbarLayout折叠的过程中拥有该属性值的控件的大小不变。<br>
parallax表示：在CollapsingToolbarLayout折叠的过程中拥有该属性值的控件会沿着与x轴平行的方向折叠（即沿着y轴的方向）。<br>
none表示不进行折叠。<br>
* app:layout_scrollFlags属性的属性值得介绍：它的属性值常用的有：scroll|exitUntilCollapsed|enterAlwaysCollapsed|enterAlways|snap这五个属性值。<br>
scroll表示：当滚动视图向上滚动时，带有该属性值的控件会跟着向上滚动并实现隐藏。<br>
snap表示:带有该属性值的控件在还没有完全显示或隐藏时，它会根据它的滚动距离自定选择时隐藏还是显示。<br>
enterAlways表示：带有该属性值的控件会跟随着滚动视图一起向下滚动（只要滚动视图向下一滚动，它就开始滚动）。<br>
exitUntilCollapsed表示：带有该属性值的控件在随着滚动视图向上滚动时，不会退出页面（隐藏）。<br>
enterAlwaysCollapsed表示：带有该属性值的控件会在滚动视图向下滚动结束以后才会才会开始向下滚动，而不是像设置了enterAlways属性的控件会随着滚动视图一开始就一起滚动。<br>
### show my all code:
```java
<?xml version="1.0" encoding="utf-8"?>
<android.support.v4.widget.DrawerLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/drawer"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">
    <!--主界面的布局控件header -->
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
        <android.support.design.widget.CoordinatorLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_weight="8"
            android:fitsSystemWindows="true">
            <android.support.design.widget.AppBarLayout
                android:id="@+id/appBar"
                android:layout_width="match_parent"
                android:layout_height="250dp"
                android:fitsSystemWindows="true">
                <android.support.design.widget.CollapsingToolbarLayout
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:fitsSystemWindows="true"
                    app:contentScrim="@color/colorPrimary"
                    app:layout_scrollFlags="scroll|exitUntilCollapsed">

                    <ImageView
                        android:layout_width="match_parent"
                        android:layout_height="match_parent"
                        android:fitsSystemWindows="true"
                        android:scaleType="centerCrop"
                        android:src="@mipmap/header_bg"
                        app:layout_collapseMode="parallax" />

                    <android.support.v7.widget.Toolbar
                        android:id="@+id/toolbar"
                        android:layout_width="match_parent"
                        android:layout_height="?attr/actionBarSize"
                        android:paddingTop="10dp"
                        android:theme="@style/AppTheme1"
                        app:layout_collapseMode="pin"
                        app:navigationIcon="@drawable/ic_menu_black_24dp"
                        app:popupTheme="@style/ThemeOverlay.AppCompat.Light" />
                </android.support.design.widget.CollapsingToolbarLayout>
            </android.support.design.widget.AppBarLayout>

            <android.support.design.widget.FloatingActionButton
                android:id="@+id/fb"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:src="@drawable/ic_share_black_24dp"
                app:layout_anchor="@id/appBar"
                app:layout_anchorGravity="bottom|right" />

            <android.support.v4.widget.SwipeRefreshLayout
                android:id="@+id/swipeRefresh"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                app:layout_behavior="@string/appbar_scrolling_view_behavior">

                <android.support.v7.widget.RecyclerView
                    android:id="@+id/recyclerView"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"

                    />
            </android.support.v4.widget.SwipeRefreshLayout>
        </android.support.design.widget.CoordinatorLayout>
        <android.support.design.widget.BottomNavigationView
            android:id="@+id/buttonNavigation"
            android:layout_width="match_parent"
            android:layout_height="?attr/actionBarSize"
            android:layout_weight="2"
            app:itemIconTint="@color/navi_button_selector"
            app:itemTextColor="@color/navi_button_selector"
            app:labelVisibilityMode="labeled"
            app:menu="@menu/navigatiob_menu" />
    </LinearLayout>
    <!--主界面的布局控件footer -->
    <!-- 侧滑界面的布局header-->
    <!-- 注意：侧滑界面的布局必须位于主界面布局的下方，否则会造成“点击侧滑菜单内容后，侧滑菜单消失的情况”-->
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_gravity="left"
        android:orientation="vertical">

        <android.support.design.widget.NavigationView
            android:id="@+id/nav_main"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            app:headerLayout="@layout/nav_header"
            app:itemTextAppearance="@style/nav_menu_text"
            app:menu="@menu/navigation_menu">
            <!-- drawerLayout页面的底部按钮header-->
            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_gravity="bottom"
                android:orientation="vertical">

                <LinearLayout
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:orientation="horizontal">

                    <Button
                        android:id="@+id/nav_reLogin"
                        android:layout_width="0dp"
                        android:layout_height="wrap_content"
                        android:layout_weight="1"
                        android:background="@android:color/transparent"
                        android:onClick="reLogin"
                        android:text="重新登录" />

                    <Button
                        android:id="@+id/nav_exit"
                        android:layout_width="0dp"
                        android:layout_height="wrap_content"
                        android:layout_weight="1"
                        android:background="@android:color/transparent"
                        android:onClick="exit"
                        android:text="退出" />
                </LinearLayout>

                <View
                    android:layout_width="match_parent"
                    android:layout_height="1dp"
                    android:background="@android:color/darker_gray" />
            </LinearLayout>
            <!-- drawerLayout页面的底部按钮footer-->
        </android.support.design.widget.NavigationView>
    </LinearLayout>
    <!-- 侧滑界面的布局footer-->
</android.support.v4.widget.DrawerLayout>
```
