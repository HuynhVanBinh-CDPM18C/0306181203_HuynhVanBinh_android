package com.example.demo11_11.thongtincaNhan;

import android.support.annotation.NonNull;

public class thongtin {
    private String hoten;
    private String noidung1;
    private String ngaysinh;
    private String sodienthoai;
    private String email;
    private String matkhau;


    public String getHoten() {
        return hoten;
    }

    public String getNoidung1() { return noidung1; }

    public String getSodienthoai() { return sodienthoai; }

    public String getNgaysinh(){ return ngaysinh;}

    public String getEmail(){ return email;}

    public String getMatkhau(){ return matkhau;}




    public void setHoten(String hoTen) {
        this.hoten = hoTen;
    }

    public void setNgaysinh(String ngaySinh) {
        this.ngaysinh = ngaySinh;
    }

    public void setNoidung1(String noiDung1) {
        this.noidung1 = noiDung1;
    }

    public void setSodienthoai(String sodienthoai1) {
        this.sodienthoai = sodienthoai1;
    }

    public void setEmail(String email1) {
        this.email = email1;
    }

    public void setMatkhau(String matkhau1) {
        this.matkhau = matkhau1;
    }


    public thongtin(String hoten,String noidung1, String ngaysinh, String sodienthoai, String email, String matkhau)
    {
        this.hoten=hoten;
        this.noidung1=noidung1;
        this.ngaysinh=ngaysinh;
        this.sodienthoai=sodienthoai;
        this.email=email;
        this.matkhau=matkhau;

    }

    public thongtin() {
        this.hoten = "";
        this.noidung1 = "";
        this.ngaysinh="";
        this.sodienthoai="";
        this.email="";
        this.matkhau="";

    }

    @NonNull
    @Override    public String toString() {
        return this.hoten+ " "+ this.noidung1 +" "+this.ngaysinh+" "+this.sodienthoai+ " "+this.email+" "+this.matkhau;
    }
}
