/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.ChitietPhieuMuon;


import java.sql.ResultSet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author UKiel
 */
public class DAO_ChitietPhieumuon {

    Connect ketnoi = new Connect();
    Connection conn = ketnoi.getConnection();

    public boolean Sualuotmuon(String maTaikhoan, int max) {
        PreparedStatement sttm = null;
        String sSQL;
        try {
            sSQL = "Update taikhoan set soluongmuon = ? where maTaikhoan = ?";
            sttm = conn.prepareStatement(sSQL);
            sttm.setInt(1, max);
            sttm.setString(2, maTaikhoan);
            if (sttm.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException e) {

        } finally {
            try {
                sttm.close();
                //conn.close();
            } catch (SQLException e2) {
                // TODO: handle exception
            }
        }
        return false;
    }

    public boolean ThemCTPM_Thuthu(ChitietPhieuMuon ctpm) {
        PreparedStatement sttm = null;
        try {
            String sSQL = "Insert into Chitietphieumuon values (?,?,?,?,?,?,?,?)";

            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, ctpm.getMaPhieumuon());
            sttm.setString(2, ctpm.getMaSach());
            sttm.setDate(3, ctpm.getNgaymuon());
            sttm.setDate(4, ctpm.getNgaytradukien());
            sttm.setDate(5, ctpm.getNgaytrathucte());
            sttm.setFloat(6, ctpm.getTienphat());
            sttm.setString(7, ctpm.getTinhtrang());
            sttm.setString(8, ctpm.getXetduyet());

            if (sttm.executeUpdate() > 0) {
                System.out.println("add thanh cong");
                return true;
            }
        } catch (SQLException e) {
            // TODO: handle exception
            System.out.print("Error Insert" + e.toString());
        }
        return false;
    }

    public boolean ThemCTPhieumuon(ChitietPhieuMuon ctpm) {
        PreparedStatement sttm = null;
        try {
            String sSQL = "Insert into Chitietphieumuon (maPhieumuon, maSach, xetduyet) values (?,?,?)";

            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, ctpm.getMaPhieumuon());
            sttm.setString(2, ctpm.getMaSach());
            sttm.setString(3, ctpm.getXetduyet());

            if (sttm.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            // TODO: handle exception
            System.out.print("Error Insert" + e.toString());
        }
        return false;
    }

    public boolean SuaCTPhieumuon(ChitietPhieuMuon ctpm) {
        PreparedStatement sttm = null;
        try {
            String sSQL = "Update Chitietphieumuon set ngayMuon = ? , ngayTradukien = ? , ngayTrathucte = ?  , tienphat = ?  , tinhtrang = ?, Xetduyet = ? where maPhieumuon = ? and maSach = ? ";

            sttm = conn.prepareStatement(sSQL);
            sttm.setDate(1, ctpm.getNgaymuon());
            sttm.setDate(2, ctpm.getNgaytradukien());
            sttm.setDate(3, ctpm.getNgaytrathucte());
            sttm.setFloat(4, ctpm.getTienphat());
            sttm.setString(5, ctpm.getTinhtrang());
            sttm.setString(6, ctpm.getXetduyet());
            sttm.setString(7, ctpm.getMaPhieumuon());
            sttm.setString(8, ctpm.getMaSach());

            if (sttm.executeUpdate() > 0) {
                System.out.println("add thanh cong");
                return true;
            }
        } catch (SQLException e) {
            // TODO: handle exception
            System.out.print("Error Insert" + e.toString());
        }
        return false;
    }

    public boolean CapnhatCTPM(ChitietPhieuMuon ctpm) {
        PreparedStatement sttm = null;
        try {
            String sSQL = "Update Chitietphieumuon set ngayMuon = ? , ngayTradukien = ?, xetduyet = ?  where maPhieumuon = ? ";

            sttm = conn.prepareStatement(sSQL);
            sttm.setDate(1, ctpm.getNgaymuon());
            sttm.setDate(2, ctpm.getNgaytradukien());
            sttm.setString(3, ctpm.getXetduyet());
            sttm.setString(4, ctpm.getMaPhieumuon());

            if (sttm.executeUpdate() > 0) {
                System.out.println("add thanh cong");
                return true;
            }
        } catch (SQLException e) {
            // TODO: handle exception
            System.out.print("Error Insert" + e.toString());
        } finally {
            try {
                sttm.close();
                //conn.close();
            } catch (SQLException e) {
                // TODO: handle exception

            }
        }
        return false;
    }

    public boolean XoaCTPMbymaSach_maPM(String maSach, String maPM) {
        PreparedStatement sttm = null;
        ResultSet rs;
        String sSQL = "Delete from Chitietphieumuon where maSach = ? and maPhieumuon = ?";
        try {
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, maSach);
            sttm.setString(2, maPM);
            if (sttm.executeUpdate() > 0) {
                return true;
            }

        } catch (Exception e) {
        }
        return false;
    }

    public ChitietPhieuMuon getCTPMbymaSach_maPM(String maSach, String maPM) {
        PreparedStatement sttm = null;
        ResultSet rs;
        String sSQL = "Select Sach.maSach, tenSach, ngayMuon, ngayTradukien, ngayTrathucte, tienphat, tinhtrang, Xetduyet from Sach,Chitietphieumuon where Sach.maSach = Chitietphieumuon.maSach and Sach.maSach = ? and Chitietphieumuon.maPhieumuon = ?";
        try {
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, maSach);
            sttm.setString(2, maPM);
            rs = sttm.executeQuery();
            if (rs.next()) {
                ChitietPhieuMuon ctpm = new ChitietPhieuMuon();
                ctpm.setMaPhieumuon(maPM);
                ctpm.setMaSach(rs.getString(1));
                ctpm.setTenSach(rs.getString(2));
                ctpm.setNgaymuon(rs.getDate(3));
                ctpm.setNgaytradukien(rs.getDate(4));
                ctpm.setNgaytrathucte(rs.getDate(5));
                ctpm.setTienphat(rs.getFloat(6));
                ctpm.setTinhtrang(rs.getString(7));
                ctpm.setXetduyet(rs.getString(8));

                return ctpm;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<ChitietPhieuMuon> getDSCTPMbymaDocgia(String maDocgia) {
        List<ChitietPhieuMuon> L = new ArrayList<ChitietPhieuMuon>();
        PreparedStatement sttm = null;
        ResultSet rs;
        String sSQL = "select  Sach.maSach, tenSach, ngayMuon , ngayTradukien, ngayTrathucte, tienphat , tinhtrang , xetduyet from Phieumuon,Sach,Chitietphieumuon, Docgia Where Docgia.maDocgia = ? and not Trangthai = N'Đã Trả' and Phieumuon.maPhieumuon = Chitietphieumuon.maPhieumuon and Chitietphieumuon.maSach = Sach.maSach and Phieumuon.maDocgia = Docgia.maDocgia ";
        try {
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, maDocgia);
            rs = sttm.executeQuery();
            while (rs.next()) {
                ChitietPhieuMuon ds = new ChitietPhieuMuon();
                ds.setMaSach(rs.getString(1));
                ds.setTenSach(rs.getString(2));
                ds.setNgaymuon(rs.getDate(3));
                ds.setNgaytradukien(rs.getDate(4));
                ds.setNgaytradukien(rs.getDate(5));
                ds.setTienphat(rs.getFloat(6));
                ds.setTinhtrang(rs.getString(7));
                ds.setXetduyet(rs.getString(8));
                L.add(ds);
            }

        } catch (Exception e) {

        }
        return L;
    }

    public List<ChitietPhieuMuon> getDSChitietphieumuon(String maPM) {
        List<ChitietPhieuMuon> L = new ArrayList<ChitietPhieuMuon>();
        PreparedStatement sttm = null;
        ResultSet rs;
        String sSQL = "select  Sach.maSach, tenSach, ngayMuon , ngayTradukien, ngayTrathucte, tienphat , tinhtrang, xetduyet from Phieumuon,Sach,Chitietphieumuon Where phieumuon.maphieumuon = ? and Phieumuon.maPhieumuon = Chitietphieumuon.maPhieumuon and Chitietphieumuon.maSach = Sach.maSach ";
        try {
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, maPM);
            rs = sttm.executeQuery();
            while (rs.next()) {
                ChitietPhieuMuon ds = new ChitietPhieuMuon();
                ds.setMaSach(rs.getString(1));
                ds.setTenSach(rs.getString(2));
                ds.setNgaymuon(rs.getDate(3));
                ds.setNgaytradukien(rs.getDate(4));
                ds.setNgaytrathucte(rs.getDate(5));
                ds.setTienphat(rs.getFloat(6));
                ds.setTinhtrang(rs.getString(7));
                ds.setXetduyet(rs.getString(8));
                L.add(ds);
            }

        } catch (Exception e) {

        }
        return L;
    }

    public int Soluongsachdangmuon(String maDocgia) {
        int count = 0;
        PreparedStatement sttm = null;
        ResultSet rs;
        String sSQL = "SELECT DG.maDocgia, tenDocgia\n"
                + "FROM PhieuMuon PM, TaiKhoan TK , Docgia DG , Chitietphieumuon CTPM \n"
                + "WHERE TK.maTaiKhoan = DG.maTaiKhoan and DG.maDocgia = PM.maDocgia  and PM.maPhieuMuon = CTPM.maPhieuMuon\n"
                + "and CTPM.Xetduyet = N'Đang mượn' and DG.maDocgia = ?";
        try {
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, maDocgia);
            rs = sttm.executeQuery();
            while (rs.next()) {
                count++;
            }

        } catch (Exception e) {

        }
        return count;
    }

}
