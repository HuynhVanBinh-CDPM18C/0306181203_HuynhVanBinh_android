package com.example.demo11_11;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class lichchieu extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener{
    Button lichchieu;
    Button binhluan;
    ImageView chonngay;
    int year, month, day;
    TextView txtNgayduocchon;
    Calendar cal;

    Button ngay1,ngay2,ngay3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lichchieu);
        Spinner spnkhuvuc = (Spinner) findViewById(R.id.spnKhuVuc);
        Spinner spnRap = (Spinner) findViewById(R.id.spnRap);
        Spinner spnGio = (Spinner) findViewById(R.id.spnGio);
        lichchieu = findViewById(R.id.btnLichChieu);
        binhluan = findViewById(R.id.btnXemBinhLuan);
        ngay1 = findViewById(R.id.btnD1);
        ngay2 = findViewById(R.id.btnDay2);
        ngay3 = findViewById(R.id.btnDay3);
        //List Khu Vuc
        List<String> khuvuc = new ArrayList<String>();
        khuvuc.add("Hồ Chí Minh");
        khuvuc.add("Hà Nội");
        khuvuc.add("Vũng Tàu");
        khuvuc.add("Đà Nẵng");
        //List Rap
        List<String> rap = new ArrayList<String>();
        rap.add("Rạp con mèo");
        rap.add("Rạp con chó kêu");
        rap.add("Rạp con gà kêu");
        rap.add("Rạp con ếch kêu");
        //list Suat Chieu
        List<String> suatchieu = new ArrayList<String>();
        suatchieu.add("9:00");
        suatchieu.add("11:00");
        suatchieu.add("13:00");
        suatchieu.add("15:00");
        suatchieu.add("17:00");
        suatchieu.add("19:00");
        suatchieu.add("21:00");
        suatchieu.add("23:00");

        // Creating adapter for spinner
        ArrayAdapter<String> khuvucAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, khuvuc);
        ArrayAdapter<String> rapAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, rap);
        ArrayAdapter<String> suatAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, suatchieu);
        // Drop down layout style - list view with radio button
        khuvucAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        rapAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        suatAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spnkhuvuc.setAdapter(khuvucAdapter);
        spnRap.setAdapter(rapAdapter);
        spnGio.setAdapter(suatAdapter);

        ngay1.setOnClickListener(this);
        ngay2.setOnClickListener(this);
        ngay3.setOnClickListener(this);

        ngay1.setOnTouchListener(this);
        ngay2.setOnTouchListener(this);
        ngay3.setOnTouchListener(this);
    }



        /*chonngay = findViewById(R.id.img_lich);
        txtNgayduocchon = findViewById(R.id.txtNgayduochon);
        cal = Calendar.getInstance();
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH);
        showDate(year, month + 1, day);

        //OnClick nut chon ngay
        chonngay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(1);
                Toast.makeText(getApplicationContext(), "Choose a day!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == 1) {
            return new DatePickerDialog(this, dateSetListener, year, month, day);
        }
        return null;
    }

    DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            txtNgayduocchon.setText("");
            showDate(year, month + 1, dayOfMonth);
        }
    };

    //hien ngay
    private void showDate(int year, int month, int day) {
        txtNgayduocchon.setText(new StringBuilder().append(day > 9 ? day : "0" + day).append("/").append(month > 9 ? month : "0" + month).append("/").append(year));
    }*/

    public void datve(View view) {
        Intent intent = new Intent(lichchieu.this , datve.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnD1:
                Toast.makeText(getApplicationContext(),"30/1",Toast.LENGTH_LONG).show();
                break;
            case R.id.btnDay2:
                Toast.makeText(getApplicationContext(),"1/1",Toast.LENGTH_LONG).show();
                break;
            case R.id.btnDay3:
                Toast.makeText(getApplicationContext(),"2/1",Toast.LENGTH_LONG).show();
                break;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()) {
            case R.id.btnD1: {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    ngay1.setBackgroundColor(Color.RED);
                } else if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ngay1.setBackgroundColor(Color.BLUE);
                } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    ngay1.setBackgroundColor(Color.WHITE);
                }
                return false;
            }
            case R.id.btnDay2:
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    ngay2.setBackgroundColor(Color.RED);
                } else if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ngay2.setBackgroundColor(Color.BLUE);
                } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    ngay2.setBackgroundColor(Color.WHITE);
                }
                return false;
            case R.id.btnDay3:
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    ngay3.setBackgroundColor(Color.RED);
                } else if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ngay3.setBackgroundColor(Color.BLUE);
                } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    ngay3.setBackgroundColor(Color.WHITE);
                }
                return false;
        }
        return false;
    }
}