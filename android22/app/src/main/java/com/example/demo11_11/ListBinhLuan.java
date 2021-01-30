package com.example.demo11_11;

public class ListBinhLuan {
    public ListBinhLuan(String nd, String dg) {
        this.noi_dung_binhluan = nd;
        this.danh_gia_phim = dg;
    }

    public String getNoi_dung_binhluan() {
        return noi_dung_binhluan;
    }

    public void setNoi_dung_binhluan(String noi_dung_binhluan) {
        this.noi_dung_binhluan = noi_dung_binhluan;
    }

    public String getDanh_gia_phim() {
        return danh_gia_phim;
    }

    public void setDanh_gia_phim(String danh_gia_phim) {
        this.danh_gia_phim = danh_gia_phim;
    }

    private String noi_dung_binhluan;
    private String danh_gia_phim;
}
