package com.example.demo11_11.thongtingiaodich1;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.demo11_11.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class giaodich11 extends AppCompatActivity {
    RecyclerView recyclerView;
    EditText edtDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giaodich11);
        recyclerView= findViewById(R.id.recycleView);
    }
    private void ChonNgay(){
        Calendar calendar=Calendar.getInstance();
        int Ngays=calendar.get(Calendar.DATE);
        int Thangs=calendar.get(Calendar.MONTH);
        int Nams=calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year,month,dayOfMonth);
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
                edtDate.setText(simpleDateFormat.format(calendar.getTime()));
            }
        },Nams,Thangs,Ngays);
        datePickerDialog.show();
    }
    public void chonngay(View view) {
        edtDate=(EditText)findViewById(R.id.ngays2);
        ChonNgay();
    }

    public void chonngays3(View view) {
        edtDate=(EditText)findViewById(R.id.ngays3);
        ChonNgay();
    }
}