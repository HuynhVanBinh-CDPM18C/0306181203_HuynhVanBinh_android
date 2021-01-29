package com.example.demo11_11;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class binhluan extends AppCompatActivity {
    TextView xuat;
    EditText nhap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binhluan);
        xuat = findViewById(R.id.txtXuat);
        nhap = findViewById(R.id.edtNhap);
    }

    public void gui(View view) {
        String nhap1 = nhap.getText().toString();
        xuat.setText(nhap1);
    }
}