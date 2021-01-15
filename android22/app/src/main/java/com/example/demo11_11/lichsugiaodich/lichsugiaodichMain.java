package com.example.demo11_11.lichsugiaodich;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.demo11_11.R;
import com.example.demo11_11.chitietphim.chitietphim;
import com.example.demo11_11.chitietphim.chitietphimAdapter;
import com.example.demo11_11.chitietphim.chitietphimMain;
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

public class lichsugiaodichMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lichsugiaodich_item);

        final RecyclerView rvLichsu = findViewById(R.id.rv_lichsugiaodich);
        rvLichsu.setLayoutManager(new LinearLayoutManager(this));

        // Khởi tạo OkHttpClient để lấy dữ liệu.
        OkHttpClient client = new OkHttpClient();

        // Khởi tạo Moshi adapter để biến đổi json sang model java (ở đây là User)
        Moshi moshi = new Moshi.Builder().build();
        Type usersType = Types.newParameterizedType(List.class, lichsugiaodich.class);
        final JsonAdapter<List<lichsugiaodich>> jsonAdapter = moshi.adapter(usersType);

        // Tạo request lên server.
        Request request = new Request.Builder()
                .url("http://192.168.88.105/api1/thanhtoan.php")
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
                final List<lichsugiaodich> users = jsonAdapter.fromJson(json);

                // Cho hiển thị lên RecyclerView.
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        rvLichsu.setAdapter(new lichsugiaodichAdapter(users, lichsugiaodichMain.this));
                    }
                });
            }
        });
    }
}