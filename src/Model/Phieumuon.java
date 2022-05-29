/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author UKiel
 */
public class Phieumuon {

    private String maPhieumuon;
    private String maDocgia;
    private String maThuthu;
    private int Songaymuon;
    private String Ghichu;
    private String Trangthai;
    private Float TongTienphat;

    public Phieumuon() {
    }

    public String getMaPhieumuon() {
        return maPhieumuon;
    }

    public void setMaPhieumuon(String maPhieumuon) {
        this.maPhieumuon = maPhieumuon;
    }

    public String getMaDocgia() {
        return maDocgia;
    }

    public void setMaDocgia(String maDocgia) {
        this.maDocgia = maDocgia;
    }

    public String getMaThuthu() {
        return maThuthu;
    }

    public void setMaThuthu(String maThuthu) {
        this.maThuthu = maThuthu;
    }

    public int getSongaymuon() {
        return Songaymuon;
    }

    public void setSongaymuon(int Songaymuon) {
        this.Songaymuon = Songaymuon;
    }

    public String getGhichu() {
        return Ghichu;
    }

    public void setGhichu(String Ghichu) {
        this.Ghichu = Ghichu;
    }

    public String getTrangthai() {
        return Trangthai;
    }

    public void setTrangthai(String Trangthai) {
        this.Trangthai = Trangthai;
    }

    public Phieumuon(String maPhieumuon, String maDocgia, String maThuthu, int Songaymuon, String Ghichu, String Trangthai, Float tongtienphat) {
        this.maPhieumuon = maPhieumuon;
        this.maDocgia = maDocgia;
        this.maThuthu = maThuthu;
        this.Songaymuon = Songaymuon;
        this.Ghichu = Ghichu;
        this.Trangthai = Trangthai;
        this.TongTienphat = tongtienphat;
    }

    public Float getTongTienphat() {
        return TongTienphat;
    }

    public void setTongTienphat(Float TongTienphat) {
        this.TongTienphat = TongTienphat;
    }

    @Override
    public String toString() {
        return "Phieumuon{" + "maPhieumuon=" + maPhieumuon + ", maDocgia=" + maDocgia + ", maThuthu=" + maThuthu + ", Songaymuon=" + Songaymuon + ", Ghichu=" + Ghichu + ", Trangthai=" + Trangthai + '}';
    }

}
