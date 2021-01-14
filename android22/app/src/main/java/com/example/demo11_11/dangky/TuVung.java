package com.example.demo11_11.dangky;

import android.support.annotation.NonNull;

public class TuVung {
    private String TuVung;
    private String DinhNghia;

    public String getTuVung() {
        return TuVung;
    }

    public String getDinhNghia() {
        return DinhNghia;
    }


    public void setTuVung(String tuVung) {
        this.TuVung = tuVung;
    }

    public void setDinhNghia(String dinhNghia) {
        this.DinhNghia = dinhNghia;
    }
    public TuVung(String TuVung,String DinhNghia)
    {
        this.TuVung=TuVung;
        this.DinhNghia=DinhNghia;
    }

    public TuVung() {
        this.TuVung = "";
        this.DinhNghia = "";
    }

    @NonNull
    @Override    public String toString() {
        return this.TuVung+ " "+ this.DinhNghia;
    }



}