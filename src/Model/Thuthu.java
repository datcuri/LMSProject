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
public class Thuthu {

    private String maThuthu;
    private String tenThuthu;
    private Date ngaysinh;
    private int gioitinh;
    private String mail;
    private String sdt;
    private String maTaikhoan;

    public Thuthu(String maThuthu, String tenThuthu, Date ngaysinh, int gioitinh, String mail, String sdt, String maTaikhoan) {
        this.maThuthu = maThuthu;
        this.tenThuthu = tenThuthu;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.mail = mail;
        this.sdt = sdt;
        this.maTaikhoan = maTaikhoan;
    }

    public Thuthu() {
    }

    public String getMaThuthu() {
        return maThuthu;
    }

    public void setMaThuthu(String maThuthu) {
        this.maThuthu = maThuthu;
    }

    public String getTenThuthu() {
        return tenThuthu;
    }

    public void setTenThuthu(String tenThuthu) {
        this.tenThuthu = tenThuthu;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public int getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(int gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getMaTaikhoan() {
        return maTaikhoan;
    }

    public void setMaTaikhoan(String maTaikhoan) {
        this.maTaikhoan = maTaikhoan;
    }
    
    

}
