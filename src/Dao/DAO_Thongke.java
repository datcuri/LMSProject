/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author UKiel
 */
public class DAO_Thongke {

    Connect ketnoi = new Connect();
    Connection conn = ketnoi.getConnection();

    // DG mượn quá hạn
    public ResultSet DGmuonquahan() {
        Statement sttm = null;
        ResultSet rs;
        try {
            String sSQL = "SELECT DG.tenDocgia, PM.soNgayMuon, CTPM.ngayMuon, CTPM.ngayTrathucte, ((DAY(CTPM.ngayTrathucte) - DAY(CTPM.ngayMuon)) - PM.soNgayMuon) AS 'Số ngày quá hạn' \n"
                    + "FROM PhieuMuon PM, ChiTietPhieuMuon  CTPM, TaiKhoan TK , Docgia DG \n"
                    + "WHERE PM.maPhieuMuon = CTPM.maPhieuMuon AND TK.maTaiKhoan = DG.maTaiKhoan \n"
                    + "AND DG.maDocgia = PM.maDocgia  \n"
                    + "AND DAY(CTPM.ngayTrathucte) - DAY(CTPM.ngayMuon) > PM.soNgaymuon \n"
                    + "AND not CTPM.Xetduyet in (N'Đã trả',N'Đền bù')";
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet DGchuatratienphat() {
        Statement sttm = null;
        ResultSet rs;
        try {
            String sSQL = "SELECT DISTINCT DG.maDocgia, tenDocgia , SUM(tienphat) as Tongtienphat\n"
                    + "FROM PhieuMuon PM, TaiKhoan TK , Docgia DG , Chitietphieumuon CTPM \n"
                    + "WHERE TK.maTaiKhoan = DG.maTaiKhoan and DG.maDocgia = PM.maDocgia  and PM.maPhieuMuon = CTPM.maPhieuMuon\n"
                    + "and CTPM.Xetduyet IN (N'Đền bù',N'Trả muộn')\n"
                    + "Group by DG.maDocgia, tenDocgia";
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // DG đang mượn sách
    public ResultSet DGdangmuon() {
        Statement sttm = null;
        ResultSet rs;
        try {
            String sSQL = "SELECT DISTINCT DG.maDocgia, tenDocgia\n"
                    + "FROM PhieuMuon PM, TaiKhoan TK , Docgia DG , Chitietphieumuon CTPM \n"
                    + "WHERE TK.maTaiKhoan = DG.maTaiKhoan and DG.maDocgia = PM.maDocgia  and PM.maPhieuMuon = CTPM.maPhieuMuon\n"
                    + "and CTPM.Xetduyet = N'Đang mượn' ";
            sttm = conn.createStatement();
            return sttm.executeQuery(sSQL);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // DG mượn nhiều nhất
    public ResultSet DGmuonnhieunhat() {
        Statement sttm = null;
        try {
            String sSQL = "SELECT DISTINCT tenDocgia, COUNT(PM.maDocgia) AS 'Số lần mượn'\n"
                    + "FROM PhieuMuon PM, TaiKhoan TK , Docgia DG\n"
                    + "WHERE TK.maTaiKhoan = DG.maTaiKhoan and DG.maDocgia = PM.maDocgia \n"
                    + "GROUP BY tenDocgia\n"
                    + "ORDER BY [Số lần mượn] DESC";
            sttm = conn.createStatement();
            return sttm.executeQuery(sSQL);
        } catch (Exception e) {

        }
        return null;
    }

    // 
    public ResultSet XephangSachdcmuonnhieunhat() {
        Statement sttm = null;
        try {
            String sSQL = "SELECT DISTINCT Sach.maSach, tenSach ,COUNT(Sach.maSach) AS 'Số lần mượn trong ngày', ngayMuon\n"
                    + "FROM ChiTietPhieuMuon CTPM, Sach\n"
                    + "WHERE CTPM.maSach = Sach.maSach\n"
                    + "GROUP BY Sach.maSach, Sach.tenSach, ngayMuon";
            sttm = conn.createStatement();
            return sttm.executeQuery(sSQL);
        } catch (Exception e) {

        }
        return null;
    }

    public static void main(String[] args) throws SQLException {
        DAO_Thongke TheDao = new DAO_Thongke();
        ResultSet rs = TheDao.DGmuonquahan();

    }
}
