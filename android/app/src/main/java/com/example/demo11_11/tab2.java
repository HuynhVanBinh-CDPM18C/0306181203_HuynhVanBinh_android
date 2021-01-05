package com.example.demo11_11;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class tab2 extends Fragment {
    ArrayList<ImageMovie> dsAnh;
    RecyclerView recyclerView;
    RecyclerImageMovie adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab2, container, false);
        recyclerView = view.findViewById(R.id.tab2);
        dsAnh = new ArrayList<>();
        dsAnh.add(new ImageMovie(R.drawable.trang));

        LinearLayoutManager VuotNgang = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(VuotNgang);
        adapter = new RecyclerImageMovie(getActivity(),dsAnh);
        recyclerView.setAdapter(adapter);
        return view;
    }
}