package com.example.demo11_11.dangky;

import android.support.annotation.NonNull;

public class TuVung {
    private String TuVung;
    private String DinhNghia;
    private String EmAil;
    private String MatKhau;
    private String NgaySinh;
    private String GioiTinh;

    public String getTuVung() {
        return TuVung;
    }

    public String getDinhNghia() {
        return DinhNghia;
    }

    public String getEmAil() {
        return EmAil;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }


    public void setTuVung(String tuVung) {
        this.TuVung = tuVung;
    }

    public void setDinhNghia(String dinhNghia) {
        this.DinhNghia = dinhNghia;
    }

    public void setEmAil(String emAil) { this.EmAil = emAil; }

    public void setMatKhau(String matKhau) {
        this.MatKhau = matKhau;
    }

    public void setNgaySinh(String ngaySinh) {
        this.NgaySinh = ngaySinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.GioiTinh = gioiTinh;
    }
    public TuVung(String TuVung,String DinhNghia,String EmAil,String MatKhau,String NgaySinh,String GioiTinh)
    {
        this.TuVung=TuVung;
        this.DinhNghia=DinhNghia;
        this.EmAil=EmAil;
        this.MatKhau=MatKhau;
        this.NgaySinh=NgaySinh;
        this.GioiTinh=GioiTinh;
    }

    public TuVung() {
        this.TuVung = "";
        this.DinhNghia = "";
        this.EmAil = "";
        this.MatKhau = "";
        this.NgaySinh = "";
        this.GioiTinh = "";
    }

    @NonNull
    @Override    public String toString() {
        return this.TuVung+ " "+ this.DinhNghia+ " "+ this.EmAil+ " "+ this.MatKhau+ " "+ this.NgaySinh+ " "+ this.GioiTinh;
    }



}