package com.example.demo11_11.thongtincaNhan;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.demo11_11.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.concurrent.ExecutionException;

public class thongtincanhan extends AppCompatActivity {

    RecyclerView recyclerView;
    static LinkedList<thongtin> lst_word ;
    thongtinAdapter adapter;
    EditText editSearch;
    Button btnSearch;
    String jsonString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongtincanhan);
        recyclerView= findViewById(R.id.recycleView);

        try {
            jsonString= new apishow(this).execute("1").get();

            if(get_lst_word(jsonString)){

                adapter= new thongtinAdapter(lst_word, this);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
            }
            else{
                recyclerView.setVisibility(View.INVISIBLE);
                editSearch.setVisibility(View.INVISIBLE);
                btnSearch.setVisibility(View.INVISIBLE);

            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public Boolean get_lst_word(String js){
        lst_word= new LinkedList<>();

        try {
            JSONArray jsonArray= new JSONArray(js);

            int num= jsonArray.length();
            for(int i=0; i<num; i++){
                JSONObject jsonObject= jsonArray.getJSONObject(i);
                thongtin tuVung= new thongtin();

                tuVung.setHoten(jsonObject.getString("hoten"));
                tuVung.setNoidung1(jsonObject.getString("sodienthoai"));
                tuVung.setNgaysinh(jsonObject.getString("email"));
                tuVung.setSodienthoai(jsonObject.getString("ngaysinh"));
                tuVung.setEmail(jsonObject.getString("gioitinh"));
                tuVung.setMatkhau(jsonObject.getString("matkhau"));

                lst_word.add(tuVung);
            }
            return  true;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

}