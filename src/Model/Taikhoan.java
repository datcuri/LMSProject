/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author UKiel
 */
public class Taikhoan {
    private String maTaikhoan;
    private String tenDangnhap;
    private String Matkhau;
    private String Chucvu;
    private int cam;
    private int soluongmuon;

    public Taikhoan() {
    }

    @Override
    public String toString() {
        return "Taikhoan{" + "maTaikhoan=" + maTaikhoan + ", tenDangnhap=" + tenDangnhap + ", Matkhau=" + Matkhau + ", Chucvu=" + Chucvu + ", cam=" + cam + ", soluongmuon=" + soluongmuon + '}';
    }
    
    public Taikhoan(String maTaikhoan, String tenDangnhap, String Matkhau, String Chucvu, int cam, int soluongmuon) {
        this.maTaikhoan = maTaikhoan;
        this.tenDangnhap = tenDangnhap;
        this.Matkhau = Matkhau;
        this.Chucvu = Chucvu;
        this.cam = cam;
        this.soluongmuon = soluongmuon;
    }

    public String getMaTaikhoan() {
        return maTaikhoan;
    }

    public void setMaTaikhoan(String maTaikhoan) {
        this.maTaikhoan = maTaikhoan;
    }

    public String getTenDangnhap() {
        return tenDangnhap;
    }

    public void setTenDangnhap(String tenDangnhap) {
        this.tenDangnhap = tenDangnhap;
    }

    public String getMatkhau() {
        return Matkhau;
    }

    public void setMatkhau(String Matkhau) {
        this.Matkhau = Matkhau;
    }

    public String getChucvu() {
        return Chucvu;
    }

    public void setChucvu(String Chucvu) {
        this.Chucvu = Chucvu;
    }

    public int getCam() {
        return cam;
    }

    public void setCam(int cam) {
        this.cam = cam;
    }

    public int getSoluongmuon() {
        return soluongmuon;
    }

    public void setSoluongmuon(int soluongmuon) {
        this.soluongmuon = soluongmuon;
    }
    
    
}
