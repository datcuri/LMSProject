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
public class DocGia {
    private String maDocgia;
    private String tenDocgia;
    private Date ngaysinh;
    private int gioitinh;
    private String mail;
    private String sdt;
    private String maTaikhoan;

    public DocGia() {
    }

    public DocGia(String maDocgia, String tenDocgia, Date ngaysinh, int gioitinh, String mail, String sdt, String maTaikhoan) {
        this.maDocgia = maDocgia;
        this.tenDocgia = tenDocgia;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.mail = mail;
        this.sdt = sdt;
        this.maTaikhoan = maTaikhoan;
    }

    public String getMaDocgia() {
        return maDocgia;
    }

    public void setMaDocgia(String maDocgia) {
        this.maDocgia = maDocgia;
    }

    public String getTenDocgia() {
        return tenDocgia;
    }

    public void setTenDocgia(String tenDocgia) {
        this.tenDocgia = tenDocgia;
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

    @Override
    public String toString() {
        return "DocGia{" + "maDocgia=" + maDocgia + ", tenDocgia=" + tenDocgia + ", ngaysinh=" + ngaysinh + ", gioitinh=" + gioitinh + ", mail=" + mail + ", sdt=" + sdt + ", maTaikhoan=" + maTaikhoan + '}';
    }
    
    
    
    
    
    
}   
