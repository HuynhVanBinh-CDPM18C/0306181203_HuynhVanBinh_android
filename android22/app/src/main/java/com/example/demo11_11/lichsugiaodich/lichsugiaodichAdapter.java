package com.example.demo11_11.lichsugiaodich;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.demo11_11.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class lichsugiaodichAdapter extends RecyclerView.Adapter<lichsugiaodichAdapter.UserItemViewHolder>  {
    private List<lichsugiaodich> users;
    private Context context;


    public lichsugiaodichAdapter(List<lichsugiaodich> users, Context c) {
        this.users = users;
        this.context = c;
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    @Override
    public UserItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_lichsugiaodich, parent, false);

        return new UserItemViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull UserItemViewHolder holder, int position) {
        lichsugiaodich u = users.get(position);
        Picasso.with(context)
                .load(u.hinhanh)
                .into(holder.hinhanh);
        holder.tenphim.setText(u.tenphim);
        holder.ngay.setText(u.ngay);
        holder.gio.setText(u.gio);
        holder.rap.setText(u.rap);
        holder.khuvuc.setText(u.khuvuc);
        holder.ghe.setText(u.ghe);
        holder.tongtien.setText(u.tongtien);
    }

    public static class UserItemViewHolder extends RecyclerView.ViewHolder {
        public ImageView hinhanh;
        public TextView tenphim;
        public TextView ngay;
        public TextView gio;
        public TextView rap;
        public TextView khuvuc;
        public TextView ghe;
        public TextView tongtien;


        public UserItemViewHolder(View itemView) {
            super(itemView);
            hinhanh = (ImageView) itemView.findViewById(R.id.hinhAnhLichSu);
            tenphim = (TextView) itemView.findViewById(R.id.txtTenPhimNe);
            ngay = (TextView) itemView.findViewById(R.id.txtNgay);
            gio  = (TextView) itemView.findViewById(R.id.txtGio);
            rap  = (TextView) itemView.findViewById(R.id.txtRap);
            khuvuc = (TextView) itemView.findViewById(R.id.txtKhuVuc);
            ghe  = (TextView) itemView.findViewById(R.id.txtGhe);
            tongtien  = (TextView) itemView.findViewById(R.id.txtTongTien);
        }
    }
}
