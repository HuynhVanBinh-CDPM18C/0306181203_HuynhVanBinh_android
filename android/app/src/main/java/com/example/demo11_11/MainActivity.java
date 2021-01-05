package com.example.demo11_11;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;


import com.example.demo11_11.danhsachphim.danhsachphimMain;
import com.example.demo11_11.lichsugiaodich.lichsugiaodich;
import com.example.demo11_11.thongtincaNhan.thongtincanhan;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabAdapter adapter;
    RecyclerView recycler;

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new tab1(),"Đang chiếu");
        adapter.addFragment(new tab2(),"Sắp chiếu");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.trangchu: {
                        intent = new Intent(MainActivity.this, MainActivity.class);
                        break;
                    }
                    case R.id.thongtin: {
                        intent = new Intent(MainActivity.this, thongtincanhan.class);
                        break;
                    }
                    case R.id.giaodich: {
                        intent = new Intent(MainActivity.this, lichsugiaodich.class);
                        break;
                    }
                    case R.id.danhsachphim:{
                        intent=new Intent(MainActivity.this, danhsachphimMain.class);
                        break;
                    }
                }
                startActivity(intent);
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu: {
                drawerLayout.openDrawer(GravityCompat.END);
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}