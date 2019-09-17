package com.example.navigationview;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    CircleImageView circleImageView;
    TextView username;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initView();
    }
    private void initView(){
        navigationView=findViewById(R.id.nav_main);
        drawerLayout=findViewById(R.id.drawer);
        View view= navigationView.getHeaderView(0);
        circleImageView=view.findViewById(R.id.circleImage_nav_header);
        username=view.findViewById(R.id.username_nav_header);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbarmenu,menu);
        return true;
    }

    @Override
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
}
