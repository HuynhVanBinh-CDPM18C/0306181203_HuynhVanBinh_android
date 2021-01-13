package com.example.demo11_11.dangky;


import android.annotation.SuppressLint;
import android.app.VoiceInteractor;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.demo11_11.MainActivity;
import com.example.demo11_11.R;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class DangKi extends AppCompatActivity {
    private EditText tuvung;
    private EditText dinhnghia;

    // String url="http://192.168.43.6:8081/api3/insert.php";
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ki);

        anhxa();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String tukhoa=tuvung.getText().toString().trim();
                String dinhnghia1=dinhnghia.getText().toString().trim();
                TuVung s = new TuVung(tukhoa,dinhnghia1);
                try {
                    String result=new APIInsert(getApplication()).execute(s).get();
                    if (result.equals("true")) {
                        Toast.makeText(getApplicationContext(), "Tạo tài khoản thành công ", Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Thêm Lỗi",Toast.LENGTH_LONG).show();
                    }
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // Toast.makeText(acti_2.this, tukhoas+"   "+dinhnghias, Toast.LENGTH_SHORT).show();
//                if (tukhoa.isEmpty()||dinhnghia1.isEmpty()){
//                    Toast.makeText(getApplicationContext(),"VUi LÒNG NHẬP ĐẦY ĐỦ THÔNG TIN",Toast.LENGTH_LONG).show();
//                }else {
//                    themtumoi(url);
//                }
            }
        });
    }

    public void trove(View view) {
        Intent intent=new Intent(DangKi.this, MainActivity.class);
        startActivity(intent);
    }

    private void anhxa()
    {
        tuvung=findViewById(R.id.tukhoas);
        dinhnghia=findViewById(R.id.dinhnghias);

        btn=findViewById(R.id.them);
    }
    public void themtumoi(String url)
    {
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        StringRequest stringRequest= new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("success"))
                {

                    Toast.makeText(getApplicationContext(),"Thêm Thành Công",Toast.LENGTH_LONG).show();
//                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
//                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Thêm Lỗi",Toast.LENGTH_LONG).show();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(getApplicationContext(),"Lỗi Không Truy Cập",Toast.LENGTH_LONG).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<>();
                params.put("tukhoa1",tuvung.getText().toString().trim());

                params.put("dinhnghia1",dinhnghia.getText().toString().trim());

                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}