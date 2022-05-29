/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author UKiel
 */
public class Sach {
    private String maSach;
    private String tenSach;
    private String maDanhMuc;
    private String maTheLoai;
    private String tacgia;
    private String nhaXuatBan;
    private int namXuatBan;
    private int soluong;
    private String mota;

    public Sach(String maSach, String tenSach, String maDanhMuc, String maTheLoai, String tacgia, String nhaXuatBan, int namXuatBan, int soluong, String mota) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.maDanhMuc = maDanhMuc;
        this.maTheLoai = maTheLoai;
        this.tacgia = tacgia;
        this.nhaXuatBan = nhaXuatBan;
        this.namXuatBan = namXuatBan;
        this.soluong = soluong;
        this.mota = mota;
    }

    public Sach() {
    }

    @Override
    public String toString() {
        return "Sach{" + "maSach=" + maSach + ", tenSach=" + tenSach + ", maDanhMuc=" + maDanhMuc + ", maTheLoai=" + maTheLoai + ", tacgia=" + tacgia + ", nhaXuatBan=" + nhaXuatBan + ", namXuatBan=" + namXuatBan + ", soluong=" + soluong + ", mota=" + mota + '}';
    }
    
    
    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getMaDanhMuc() {
        return maDanhMuc;
    }

    public void setMaDanhMuc(String maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    }

    public String getMaTheLoai() {
        return maTheLoai;
    }

    public void setMaTheLoai(String maTheLoai) {
        this.maTheLoai = maTheLoai;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(int namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
       
}
