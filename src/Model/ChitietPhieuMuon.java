/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;
/**
 *
 * @author UKiel
 */
public class ChitietPhieuMuon {
    private String maPhieumuon;
    private String maSach;
    private String tenSach;
    private Date ngaymuon;
    private Date ngaytradukien;
    private Date ngaytrathucte;
    private float tienphat;
    private String tinhtrang;
    private String Xetduyet;

    public ChitietPhieuMuon(String maPM, String maSach, String xetduyet) {
        this.maPhieumuon = maPM;
        this.maSach = maSach;
        this.Xetduyet = xetduyet;
    }

    public String getXetduyet() {
        return Xetduyet;
    }

    public void setXetduyet(String Xetduyet) {
        this.Xetduyet = Xetduyet;
    }
    
    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }
    
    
    public String getMaPhieumuon() {
        return maPhieumuon;
    }

    public void setMaPhieumuon(String maPhieumuon) {
        this.maPhieumuon = maPhieumuon;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public Date getNgaymuon() {
        return ngaymuon;
    }

    public void setNgaymuon(Date ngaymuon) {
        this.ngaymuon = ngaymuon;
    }

    public Date getNgaytradukien() {
        return ngaytradukien;
    }

    public void setNgaytradukien(Date ngaytradukien) {
        this.ngaytradukien = ngaytradukien;
    }

    public Date getNgaytrathucte() {
        return ngaytrathucte;
    }

    public void setNgaytrathucte(Date ngaytrathucte) {
        this.ngaytrathucte = ngaytrathucte;
    }

    public float getTienphat() {
        return tienphat;
    }

    public void setTienphat(float tienphat) {
        this.tienphat = tienphat;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public ChitietPhieuMuon(String maPhieumuon, String maSach, String tenSach, Date ngaymuon, Date ngaytradukien, Date ngaytrathucte, float tienphat, String tinhtrang, String xetduyet) {
        this.maPhieumuon = maPhieumuon;
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.ngaymuon = ngaymuon;
        this.ngaytradukien = ngaytradukien;
        this.ngaytrathucte = ngaytrathucte;
        this.tienphat = tienphat;
        this.tinhtrang = tinhtrang;
        this.Xetduyet = xetduyet;
    }

    public ChitietPhieuMuon() {
    }
    

    @Override
    public String toString() {
        return "ChitietPhieuMuon{" + "maPhieumuon=" + maPhieumuon + ", maSach=" + maSach + ", ngaymuon=" + ngaymuon + ", ngaytradukien=" + ngaytradukien + ", ngaytrathucte=" + ngaytrathucte + ", tienphat=" + tienphat + ", tinhtrang=" + tinhtrang + '}';
    }
    
    
    
    
}
