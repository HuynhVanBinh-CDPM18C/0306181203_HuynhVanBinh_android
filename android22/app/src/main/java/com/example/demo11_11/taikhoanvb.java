package com.example.demo11_11;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.demo11_11.dangky.DangKi;
import com.example.demo11_11.dangnhap.dangnhap;

public class taikhoanvb extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taikhoanvb);
    }

    public void dangky(View view) {
        Intent intent=new Intent(taikhoanvb.this, DangKi.class);
        startActivity(intent);
    }

    public void dangnhap(View view) {
        Intent intent=new Intent(taikhoanvb.this, dangnhap.class);
        startActivity(intent);
    }
}