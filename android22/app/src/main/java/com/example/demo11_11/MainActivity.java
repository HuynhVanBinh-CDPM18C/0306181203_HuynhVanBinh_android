package com.example.demo11_11;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;


import com.example.demo11_11.dangky.DangKi;
import com.example.demo11_11.dangnhap.dangnhap;
import com.example.demo11_11.danhsachphim.danhsachphim;
import com.example.demo11_11.danhsachphim.danhsachphimAdapter;
import com.example.demo11_11.danhsachphim.danhsachphimMain;
import com.example.demo11_11.danhsachphim.phimsapchieu;
import com.example.demo11_11.danhsachphim.phimsapchieuAdapter;
import com.example.demo11_11.lichsugiaodich.lichsugiaodich;
import com.example.demo11_11.lichsugiaodich.lichsugiaodichMain;
import com.example.demo11_11.thongtincaNhan.thongtincanhan;
import com.example.demo11_11.thongtingiaodich1.giaodich11;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.demo11_11.R.drawable.h1;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Intent intent;
    private List<slide> lstSlides ;
    private TabLayout indicator;
    private ViewPager sliderpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangchu);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.danhsachphim:{
                        startActivity(new Intent(MainActivity.this, danhsachphimMain.class));
                        break;
                    }
                    case R.id.trangchu:{
                        startActivity(new Intent(MainActivity.this, MainActivity.class));
                        break;
                    }
                    case R.id.dangky:{
                        startActivity(new Intent(MainActivity.this, taikhoanvb.class));
                        break;
                    }
                    case R.id.thongtin:{
                        startActivity(new Intent(MainActivity.this, thongtincanhan.class));
                        break;
                    }
                    case R.id.giaodich:{
                        startActivity(new Intent(MainActivity.this, giaodich11.class));
                        break;
                    }
                }
                drawerLayout.closeDrawers();
                return true;
            }
        });
        psc();
        pdc();
        iniView();
        iniSlider();

    }
    private void iniView() {
        sliderpager = findViewById(R.id.slider_pager);
        indicator = findViewById(R.id.indicator);
    }
    private void iniSlider() {
        lstSlides = new ArrayList<>() ;
        lstSlides.add(new slide(R.drawable.h1,"Chị mười ba \n Hành Động"));
        lstSlides.add(new slide(R.drawable.h2,"Cua lại vợ bầu \n Tình cảm"));
        lstSlides.add(new slide(R.drawable.h3,"Ròm \n Hành động"));
        lstSlides.add(new slide(R.drawable.h4,"Tuần trăng máu \n Kinh dị"));
        SlidePagerAdapter adapter = new SlidePagerAdapter(this,lstSlides);
        sliderpager.setAdapter(adapter);
        // setup timer
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(),1000,3000);
        indicator.setupWithViewPager(sliderpager,true);
    }
    class SliderTimer extends TimerTask {


        @Override
        public void run() {

            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (sliderpager.getCurrentItem()<lstSlides.size()-1) {
                        sliderpager.setCurrentItem(sliderpager.getCurrentItem()+1);
                    }
                    else
                        sliderpager.setCurrentItem(0);
                }
            });


        }
    }
    public void psc()
    {
        //tách hàm ra
        LinearLayoutManager layoutManagers
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        RecyclerView rv_phimsapchieu1  = (RecyclerView) findViewById(R.id.rv_phimsapchieu);
        rv_phimsapchieu1.setLayoutManager(layoutManagers);

        // Tạo request lên server.
        Request sapchieu = new Request.Builder()
                .url("http://10.5.50.144/api1/apiphimsapchieu.php")
                .build();

        // Khởi tạo OkHttpClient để lấy dữ liệu.
        OkHttpClient b = new OkHttpClient();

        // Khởi tạo Moshi adapter để biến đổi json sang model java (ở đây là User)
        Moshi c = new Moshi.Builder().build();
        Type d = Types.newParameterizedType(List.class, phimsapchieu.class);
        final JsonAdapter<List<phimsapchieu>> jsonAdapters = c.adapter(d);

        // Thực thi request.
        b.newCall(sapchieu).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("Error", "Network Error");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                // Lấy thông tin JSON trả về. Bạn có thể log lại biến json này để xem nó như thế nào.
                String jsons = response.body().string();
                final List<phimsapchieu> user = jsonAdapters.fromJson(jsons);

                // Cho hiển thị lên RecyclerView.
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        rv_phimsapchieu1.setAdapter(new phimsapchieuAdapter(user, MainActivity.this));
                    }
                });
            }
        });
    }
    public void pdc() {
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        RecyclerView rv_phimdangchieu1 = (RecyclerView) findViewById(R.id.rv_phimdangchieu);
        rv_phimdangchieu1.setLayoutManager(layoutManager);

        // Khởi tạo OkHttpClient để lấy dữ liệu.
        OkHttpClient client = new OkHttpClient();

        // Khởi tạo Moshi adapter để biến đổi json sang model java (ở đây là User)
        Moshi moshi = new Moshi.Builder().build();
        Type usersType = Types.newParameterizedType(List.class, danhsachphim.class);
        final JsonAdapter<List<danhsachphim>> jsonAdapter = moshi.adapter(usersType);

        // Tạo request lên server.
        Request request = new Request.Builder()
                .url("http://10.5.50.144/api1/api.php")
                .build();


        // Thực thi request.
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("Error", "Network Error");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                // Lấy thông tin JSON trả về. Bạn có thể log lại biến json này để xem nó như thế nào.
                String json = response.body().string();
                final List<danhsachphim> users = jsonAdapter.fromJson(json);

                // Cho hiển thị lên RecyclerView.
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        rv_phimdangchieu1.setAdapter(new danhsachphimAdapter(users, MainActivity.this));
                    }
                });
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