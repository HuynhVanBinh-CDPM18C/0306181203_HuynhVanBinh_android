package com.example.demo11_11;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demo11_11.chitietphim.chitietphimMain;
import com.example.demo11_11.lichsugiaodich.lichsugiaodich;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class datve extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {
    private Button btnA1, btnA2, btnA3, btnA4, btnA5, btnA6, btnB1, btnB2, btnB3, btnB4, btnB5, btnB6, btnC1, btnC2, btnC3, btnC4, btnC5, btnC6;
    ImageView chonngay;
    int year, month, day;
    TextView txtNgayduocchon;
    TextView TongTien = null;
    Calendar cal;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datve);
        Spinner spnkhuvuc = (Spinner) findViewById(R.id.spnKhuVuc);
        Spinner spnRap = (Spinner) findViewById(R.id.spnRap);
        Spinner spnGio = (Spinner) findViewById(R.id.spnGio);
        TongTien = findViewById(R.id.txtTongTien);
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

        btnA1 = findViewById(R.id.btnA1);
        btnA2 = findViewById(R.id.btnA2);
        btnA3 = findViewById(R.id.btnA3);
        btnA4 = findViewById(R.id.btnA4);
        btnA5 = findViewById(R.id.btnA5);
        btnA6 = findViewById(R.id.btnA6);
        btnA1.setOnClickListener(this);
        btnA2.setOnClickListener(this);
        btnA3.setOnClickListener(this);
        btnA4.setOnClickListener(this);
        btnA5.setOnClickListener(this);
        btnA6.setOnClickListener(this);

        btnB1 = findViewById(R.id.btnB1);
        btnB2 = findViewById(R.id.btnB2);
        btnB3 = findViewById(R.id.btnB3);
        btnB4 = findViewById(R.id.btnB4);
        btnB5 = findViewById(R.id.btnB5);
        btnB6 = findViewById(R.id.btnB6);
        btnB1.setOnClickListener(this);
        btnB2.setOnClickListener(this);
        btnB3.setOnClickListener(this);
        btnB4.setOnClickListener(this);
        btnB5.setOnClickListener(this);
        btnB6.setOnClickListener(this);

        btnC1 = findViewById(R.id.btnC1);
        btnC2 = findViewById(R.id.btnC2);
        btnC3 = findViewById(R.id.btnC3);
        btnC4 = findViewById(R.id.btnC4);
        btnC5 = findViewById(R.id.btnC5);
        btnC6 = findViewById(R.id.btnC6);
        btnC1.setOnClickListener(this);
        btnC2.setOnClickListener(this);
        btnC3.setOnClickListener(this);
        btnC4.setOnClickListener(this);
        btnC5.setOnClickListener(this);
        btnC6.setOnClickListener(this);

        btnA1.setOnTouchListener(this);
        btnA2.setOnTouchListener(this);
        btnA3.setOnTouchListener(this);
        btnA4.setOnTouchListener(this);
        btnA5.setOnTouchListener(this);
        btnA6.setOnTouchListener(this);
        btnB1.setOnTouchListener(this);
        btnB2.setOnTouchListener(this);
        btnB3.setOnTouchListener(this);
        btnB4.setOnTouchListener(this);
        btnB5.setOnTouchListener(this);
        btnB6.setOnTouchListener(this);
        btnC1.setOnTouchListener(this);
        btnC2.setOnTouchListener(this);
        btnC3.setOnTouchListener(this);
        btnC4.setOnTouchListener(this);
        btnC5.setOnTouchListener(this);
        btnC6.setOnTouchListener(this);

        chonngay = findViewById(R.id.img_lich);
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

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
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
    }
    //OnClick ghe
    int tongtien = 0;
    int i = 0;
    private void doClickCong(){
        i = i+1;
        tongtien += 60000;
        TongTien.setText(Integer.toString(tongtien));
    }

    private void doClickTru(){
        i = i-1;
        tongtien -= 60000;
        TongTien.setText(Integer.toString(tongtien));
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnA1:
                if(i==0)
                    doClickCong();
                else if (i==1)
                    doClickTru();
                else
                    break;
                break;
            case R.id.btnA2:
                if(i==0)
                    doClickCong();
                else if (i==1)
                    doClickTru();
                else
                    break;
                break;
            case R.id.btnA3:
                if(i==0)
                    doClickCong();
                else if (i==1)
                    doClickTru();
                else
                    break;
                break;
            case R.id.btnA4:
                if(i==0)
                    doClickCong();
                else if (i==1)
                    doClickTru();
                else
                    break;
                break;
            case R.id.btnA5:
                if(i==0)
                    doClickCong();
                else if (i==1)
                    doClickTru();
                else
                    break;
                break;
            case R.id.btnA6:
                if(i==0)
                    doClickCong();
                else if (i==1)
                    doClickTru();
                else
                    break;
                break;
            case R.id.btnB1:
                if(i==0)
                    doClickCong();
                else if (i==1)
                    doClickTru();
                else
                    break;
                break;
            case R.id.btnB2:
                if(i==0)
                    doClickCong();
                else if (i==1)
                    doClickTru();
                else
                    break;
                break;
            case R.id.btnB3:
                if(i==0)
                    doClickCong();
                else if (i==1)
                    doClickTru();
                else
                    break;
                break;
            case R.id.btnB4:
                if(i==0)
                    doClickCong();
                else if (i==1)
                    doClickTru();
                else
                    break;
                break;
            case R.id.btnB5:
                if(i==0)
                    doClickCong();
                else if (i==1)
                    doClickTru();
                else
                    break;
                break;
            case R.id.btnB6:
                if(i==0)
                    doClickCong();
                else if (i==1)
                    doClickTru();
                else
                    break;
                break;
            case R.id.btnC1:
                if(i==0)
                    doClickCong();
                else if (i==1)
                    doClickTru();
                else
                    break;
                break;
            case R.id.btnC2:
                if(i==0)
                    doClickCong();
                else if (i==1)
                    doClickTru();
                else
                    break;
                break;
            case R.id.btnC3:
                if(i==0)
                    doClickCong();
                else if (i==1)
                    doClickTru();
                else
                    break;
                break;
            case R.id.btnC4:
                if(i==0)
                    doClickCong();
                else if (i==1)
                    doClickTru();
                else
                    break;
                break;
            case R.id.btnC5:
                if(i==0)
                    doClickCong();
                else if (i==1)
                    doClickTru();
                else
                    break;
                break;
            case R.id.btnC6:
                if(i==0)
                    doClickCong();
                else if (i==1)
                    doClickTru();
                else
                    break;
                break;
        }
    }

    public void chuyentrang(View view) {
        Intent intent = new Intent(datve.this, lichsugiaodich.class);
        startActivity(intent);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()) {
            case R.id.btnA1: {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    btnA1.setBackgroundColor(Color.RED);
                } else if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    btnA1.setBackgroundColor(Color.BLUE);
                } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    btnA1.setBackgroundColor(Color.WHITE);
                }
                return false;
            }
            case R.id.btnA2:
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    btnA2.setBackgroundColor(Color.RED);
                } else if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    btnA2.setBackgroundColor(Color.BLUE);
                } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    btnA2.setBackgroundColor(Color.WHITE);
                }
                return false;
        }
        return false;
    }
}