package com.example.demo11_11;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class bl extends AppCompatActivity {
    TextView nd, dg;
    ArrayList<ListBinhLuan> dsBinhLuan;
    RecyclerView recyclerView;
    BinhLuanAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bl);
        recyclerView = findViewById(R.id.showbinhluan);
        nd = findViewById(R.id.edit_formBinhLuan_ND);
        dg = findViewById(R.id.edit_formBinhLuan_DG);
        showBinhLuan();
    }
    public void addBinhLuan() {
        String url = "http://10.5.50.144/api1/bl.php";
        RequestQueue request = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("them thanh cong")) {
                    Intent intent = new Intent(getApplication(), bl.class);
                    startActivity(intent);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("noi_dung_binhluan", nd.getText().toString());
                params.put("danh_gia_phim", dg.getText().toString());
                return params;
            }
        };
        request.add(stringRequest);
    }

    public void showBinhLuan(){
        String url ="http://10.5.50.144/api1/show_bl.php";
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, response -> {
            JSONObject jsonObject = null;
            try{
                for(int i =0;i<response.length();i++){
                    jsonObject = response.getJSONObject(i);

                    String nd = jsonObject.getString("noi_dung_binhluan");
                    String dg = jsonObject.getString("danh_gia_phim");

                    ListBinhLuan listBinhLuan = new ListBinhLuan(nd,dg);
                    dsBinhLuan.add(listBinhLuan);
                }
                adapter = new BinhLuanAdapter(getApplicationContext(),dsBinhLuan);
                recyclerView.setAdapter(adapter);
            }catch (Exception e){
                Toast.makeText(getApplicationContext(), "Lỗi kết nối", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonArrayRequest);
    }

}