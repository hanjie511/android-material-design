package com.example.navigationview;

import android.content.Context;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.MenuCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    CircleImageView circleImageView;
    TextView username;
    Toolbar toolbar;
    BottomNavigationView bottomNavigationView;
    RecyclerView recyclerView;
    ArrayList picList=new ArrayList();
    Context context;
    MyAdapter adapter;
    FloatingActionButton floatingActionButton;
    SwipeRefreshLayout swipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initView();
        picList=initList();
        context=MainActivity.this;
        adapter=new MyAdapter(picList,R.layout.recycler_item,context);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {//recyclerView的滚动监听，主要用来监听上拉加载更多
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                if (newState==RecyclerView.SCROLL_STATE_IDLE){
                    RecyclerView.LayoutManager layoutManager=recyclerView.getLayoutManager();
                    int lastVisiblePosition;
                    if (layoutManager instanceof GridLayoutManager){
                        lastVisiblePosition=((GridLayoutManager) layoutManager).findLastVisibleItemPosition();
                    }else {
                        lastVisiblePosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
                    }
                    if (layoutManager.getChildCount()>0             //当当前显示的item数量>0
                            &&lastVisiblePosition>=layoutManager.getItemCount()-1           //当当前屏幕最后一个加载项位置>=所有item的数量
                            &&layoutManager.getItemCount()>layoutManager.getChildCount()) { // 当当前总Item数大于可见Item数
                                try{
                                    Thread.sleep(1500);
                                    picList.add("https://b-ssl.duitang.com/uploads/item/201601/07/20160107170247_5GX3k.jpeg");
                                    picList.add("https://i0.hdslb.com/bfs/article/708aaa2a706bbc722e92fb28becebe680064b2bd.jpg");
                                    picList.add("https://i0.hdslb.com/bfs/article/70a845c18dddf4f789c4a59446c917d0df1e197a.jpg");
                                    picList.add("https://b-ssl.duitang.com/uploads/item/201610/11/20161011163941_JmvwG.thumb.700_0.jpeg");
                                    adapter.notifyDataSetChanged();
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                            }
                }
            }
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }
    private void initView(){
        bottomNavigationView=findViewById(R.id.buttonNavigation);
        drawerLayout=findViewById(R.id.drawer);
        navigationView=findViewById(R.id.nav_main);
        View view= navigationView.getHeaderView(0);//找到navigationView的头部View，然后才能为其控件设置监听(只有这样才能为navigationView的headerView的控件设置点击事件)，
        circleImageView=view.findViewById(R.id.circleImage_nav_header);
        username=view.findViewById(R.id.username_nav_header);
        recyclerView=findViewById(R.id.recyclerView);
        floatingActionButton=findViewById(R.id.fb);
        swipeRefreshLayout=findViewById(R.id.swipeRefresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {//设置下拉刷新的监听
            @Override
            public void onRefresh() {
                picList.clear();
                picList=initList();
                adapter=new MyAdapter(picList,R.layout.recycler_item,context);
                LinearLayoutManager linearLayoutManager=new LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false);
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(adapter);
                swipeRefreshLayout.setRefreshing(false);
                Toast.makeText(context, "数据已刷新", Toast.LENGTH_SHORT).show();
            }
        });
        floatingActionButton.setOnClickListener(new View.OnClickListener() {//设置floatingActionButton的点击v事件
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "分享被点击了", Toast.LENGTH_SHORT).show();
            }
        });
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {//设置toolbar的navigationButton的点击事件
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });
        circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "你点击了头像", Toast.LENGTH_SHORT).show();
            }
        });
        username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "你点击用户名", Toast.LENGTH_SHORT).show();
            }
        });
        //底部导航栏的点击监听事件
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.c1:
                        Toast.makeText(MainActivity.this,"选项1",Toast.LENGTH_SHORT).show();

                        break;
                    case R.id.c2:
                        Toast.makeText(MainActivity.this,"选项2",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.c3:
                        Toast.makeText(MainActivity.this,"选项3",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.c4:
                        Toast.makeText(MainActivity.this,"选项4",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.c5:
                        Toast.makeText(MainActivity.this,"选项5",Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
        //策划导航栏的点击监听事件
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                 int id=menuItem.getItemId();
                 switch (id){
                     case R.id.setting1:
                         Toast.makeText(MainActivity.this, "你点击选项一", Toast.LENGTH_SHORT).show();
                         break;
                     case R.id.setting2:
                         Toast.makeText(MainActivity.this, "你点击选项二", Toast.LENGTH_SHORT).show();
                         break;
                     case R.id.setting3:
                         Toast.makeText(MainActivity.this, "你点击选项三", Toast.LENGTH_SHORT).show();
                         break;
                     case R.id.setting4:
                         Toast.makeText(MainActivity.this, "你点击选项四", Toast.LENGTH_SHORT).show();
                         break;
                     case R.id.setting5:
                         Toast.makeText(MainActivity.this, "你点击选项五", Toast.LENGTH_SHORT).show();
                         break;
                     case R.id.setting6:
                         Toast.makeText(MainActivity.this, "你点击选项六", Toast.LENGTH_SHORT).show();
                         break;
                 }
                return true;
            }
        });

    }
    public void reLogin(View view){
        Toast.makeText(this, "你点击了重新登录按钮", Toast.LENGTH_SHORT).show();
    }
    public void exit(View view){
        Toast.makeText(this, "你点击了退出按钮", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {//toolBar的菜单的创建方法
        getMenuInflater().inflate(R.menu.toolbarmenu,menu);
        MenuItem item=menu.findItem(R.id.search_toolbar_menu);
        SearchView searchView=(SearchView)item.getActionView();
        searchView.setQueryHint("请输入搜索内容");
        searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Toast.makeText(context, "你输入的文本为："+s, Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {//toolbar的菜单按钮点击监听
        switch(item.getItemId()){
            case R.id.search_toolbar_menu:
                Toast.makeText(this, "你点击了搜索按钮", Toast.LENGTH_SHORT).show();
                break;    
        }
        return true;
    }
    private ArrayList<String> initList(){
        ArrayList<String> list=new ArrayList<>();
        list.add("https://b-ssl.duitang.com/uploads/item/201601/07/20160107170247_5GX3k.jpeg");
        list.add("https://i0.hdslb.com/bfs/article/708aaa2a706bbc722e92fb28becebe680064b2bd.jpg");
        list.add("https://i0.hdslb.com/bfs/article/70a845c18dddf4f789c4a59446c917d0df1e197a.jpg");
        list.add("https://b-ssl.duitang.com/uploads/item/201610/11/20161011163941_JmvwG.thumb.700_0.jpeg");
        list.add("https://b-ssl.duitang.com/uploads/item/201303/07/20130307211303_kr45e.jpeg");
        list.add("https://5b0988e595225.cdn.sohucs.com/images/20181228/c383bca8f38246ab8233c5ebe95337ab.jpeg");
        list.add("https://b-ssl.duitang.com/uploads/item/201706/10/20170610095055_G5LM8.jpeg");
        list.add("https://img.mp.itc.cn/upload/20161012/237143e03d9746d1946551fe2f0f1f5e_th.jpg");
        return list;
    }
 }
