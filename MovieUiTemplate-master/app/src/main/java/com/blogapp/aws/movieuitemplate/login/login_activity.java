package com.blogapp.aws.movieuitemplate.login;

import android.content.Intent;
import android.icu.text.IDNA;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.blogapp.aws.movieuitemplate.R;
import com.blogapp.aws.movieuitemplate.ui.HomeActivity;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.InflaterOutputStream;

public class login_activity extends AppCompatActivity {
    EditText edtName,edtEmail,edtPassWord;
    Button btnDangKi,btnDangNhap;
    String URL="http://192.168.88.100/loginandroid/dangki.php";
    String URL_LOGIN="http://192.168.88.100/loginandroid/dangnhap.php";
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);
        edtName=(EditText)findViewById(R.id.edtName);
        edtEmail=(EditText)findViewById(R.id.edtEmail);
        edtPassWord=(EditText)findViewById(R.id.edtPassWord);
        requestQueue= Volley.newRequestQueue(this);
        btnDangKi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(login_activity.this,response,Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(login_activity.this,error+"",Toast.LENGTH_SHORT).show();
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> params=new HashMap<String, String>();
                        String name=edtName.getText().toString();
                        String email=edtEmail.getText().toString();
                        String password=edtPassWord.getText().toString();
                        params.put("Name",name);
                        params.put("Email",email);
                        params.put("PassWord",password);
                        return params;
                    }
                };
                requestQueue.add(stringRequest);
            }

        });
        btnDangNhap=(Button)findViewById(R.id.btnDangNhap);

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            String email=edtEmail.getText().toString();
            String password=edtPassWord.getText().toString();
            @Override
            public void onClick(View view) {
                StringRequest stringRequest=new StringRequest(Request.Method.POST, URL_LOGIN, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                       String s=response.trim();

                       if(s.equalsIgnoreCase("Thanh Cong")){
                           Intent intent=new Intent(getApplication(), HomeActivity.class);
                           startActivity(intent);

                       }else{
                           Toast.makeText(login_activity.this,response,Toast.LENGTH_SHORT).show();
                       }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> params=new HashMap<String, String>();

                        params.put("Email",email);
                        params.put("PassWord",password);
                        return params;
                    }
                };
                requestQueue.add(stringRequest);
            }
        });
    }
}