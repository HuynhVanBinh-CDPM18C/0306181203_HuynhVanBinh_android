package com.example.demo11_11.thongtincaNhan;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.demo11_11.R;

import java.util.LinkedList;

public class thongtinAdapter extends RecyclerView.Adapter<thongtinAdapter.WordViewHolder> {
    LinkedList<thongtin> lst_word;
    LayoutInflater inflater;
    Context context;
    private int limit=100;

    public thongtinAdapter(LinkedList<thongtin> lst_word, Context context) {
        this.lst_word = lst_word;
        this.context = context;
        inflater= LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= inflater.inflate(R.layout.thongtin_item, parent, false);
        return new WordViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {

        thongtin word= lst_word.get(position);

        holder.tvTu.setText(word.getHoten());
        holder.tvDinhNghia.setText(word.getNoidung1());
        holder.txtngaysinh.setText(word.getNgaysinh());
        holder.sodienthoai.setText(word.getSodienthoai());
        holder.email.setText(word.getEmail());
        holder.matkhau.setText(word.getMatkhau());
        holder.diachi.setText(word.getDiachi());
    }


    @Override
    public int getItemCount() {
//        if(lst_word.size()>limit)
//            return limit;
//        else
        return lst_word.size();
    }

    public class WordViewHolder extends RecyclerView.ViewHolder {
        thongtinAdapter adapter;
        TextView tvTu, tvDinhNghia, txtngaysinh,sodienthoai,email,matkhau,diachi;
        public WordViewHolder(@NonNull View itemView, thongtinAdapter wordListAdapter) {
            super(itemView);

            tvTu= itemView.findViewById(R.id.hoten);
            tvDinhNghia= itemView.findViewById(R.id.noidung1);
            txtngaysinh=itemView.findViewById(R.id.ngaysinh);
            sodienthoai=itemView.findViewById(R.id.sodienthoai);
            email=itemView.findViewById(R.id.email);
            matkhau=itemView.findViewById(R.id.matkhau);
            diachi=itemView.findViewById(R.id.diachi);
            adapter= wordListAdapter;
        }
    }
}
