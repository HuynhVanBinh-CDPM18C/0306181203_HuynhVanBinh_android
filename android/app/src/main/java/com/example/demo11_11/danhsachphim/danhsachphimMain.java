package com.example.demo11_11.danhsachphim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.demo11_11.R;
import com.example.demo11_11.chitietphim;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class danhsachphimMain extends AppCompatActivity {
    private ImageButton imageButton;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachphim);


        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView myList = (RecyclerView) findViewById(R.id.rv_phimdangchieu);
        myList.setLayoutManager(layoutManager);

        // Khởi tạo OkHttpClient để lấy dữ liệu.
        OkHttpClient client = new OkHttpClient();

        // Khởi tạo Moshi adapter để biến đổi json sang model java (ở đây là User)
        Moshi moshi = new Moshi.Builder().build();
        Type usersType = Types.newParameterizedType(List.class, danhsachphim.class);
        final JsonAdapter<List<danhsachphim>> jsonAdapter = moshi.adapter(usersType);

        // Tạo request lên server.
        Request request = new Request.Builder()
                .url("http://192.168.43.49/api1/api.php")
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
                        myList.setAdapter(new danhsachphimAdapter(users, danhsachphimMain.this));
                    }
                });
            }
        });






        LinearLayoutManager layoutManagers
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView a = (RecyclerView) findViewById(R.id.rv_phimsapchieu);
        a.setLayoutManager(layoutManagers);

        // Tạo request lên server.
        Request sapchieu = new Request.Builder()
                .url("http://192.168.43.49/api1/apiphimsapchieu.php")
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
                        a.setAdapter(new phimsapchieuAdapter(user, danhsachphimMain.this));
                    }
                });
            }
        });
    }

    public void chitiet(View view) {
        Intent intent = new Intent(danhsachphimMain.this, chitietphim.class);
        startActivity(intent);

    }
}