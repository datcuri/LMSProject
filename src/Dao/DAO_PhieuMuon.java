 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Phieumuon;
import Model.Sach;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author UKiel
 */
public class DAO_PhieuMuon {

    Connect ketnoi = new Connect();
    Connection conn = ketnoi.getConnection();

    public boolean ThemPhieumuon(Phieumuon PB) {
        PreparedStatement sttm = null;
        String sSQL = "Insert into Phieumuon values (?,?,?,?,?,?)";
        try {
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, PB.getMaPhieumuon());
            sttm.setString(2, PB.getMaDocgia());
            sttm.setString(3, PB.getMaThuthu());
            sttm.setInt(4, PB.getSongaymuon());
            sttm.setString(5, PB.getGhichu());
            sttm.setString(6, PB.getTrangthai());
            if (sttm.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                sttm.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return false;
    }

    public boolean SuaPhieumuon(Phieumuon PB) {
        PreparedStatement sttm = null;
        String sSQL = "Update Phieumuon set madocgia = ? , maThuthu = ? , soNgaymuon = ? , Ghichu = ? , Trangthai = ? where maPhieumuon = ?";
        try {
            sttm = conn.prepareStatement(sSQL);

            sttm.setString(1, PB.getMaDocgia());
            sttm.setString(2, PB.getMaThuthu());
            sttm.setInt(3, PB.getSongaymuon());
            sttm.setString(4, PB.getGhichu());
            sttm.setString(5, PB.getTrangthai());
            sttm.setString(6, PB.getMaPhieumuon());
            if (sttm.executeUpdate() > 0) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                sttm.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return false;
    }

    public boolean XoaPhieumuon(String maPhieumuon) {
        PreparedStatement sttm = null;
        String sSQL = "Delete from Phieumuon where maPhieumuon = ? ";
        try {
            sttm = conn.prepareStatement(sSQL);

            sttm.setString(1, maPhieumuon);

            if (sttm.executeUpdate() > 0) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                sttm.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return false;
    }
    public Phieumuon getPMbymaPM(String maPM){
        PreparedStatement sttm = null;
        ResultSet rs;
        String sSQL=  "Select PM.maPhieumuon, PM.maDocgia,PM.maThuthu,PM.soNgaymuon,PM.Ghichu,PM.Trangthai , SUM(tienphat) as Tongtienphat from Chitietphieumuon CTPM ,Phieumuon PM where PM.maPhieumuon = ? and CTPM.maPhieumuon = PM.maPhieumuon group by PM.maPhieumuon, PM.maDocgia,PM.maThuthu,PM.soNgaymuon,PM.Ghichu,PM.Trangthai";
        try {
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, maPM);
            rs = sttm.executeQuery();
            if (rs.next()){
                Phieumuon pm = new Phieumuon();
                pm.setMaPhieumuon(rs.getString(1));
                pm.setMaDocgia(rs.getString(2));
                pm.setMaThuthu(rs.getString(3));
                pm.setSongaymuon(rs.getInt(4));
                pm.setGhichu(rs.getString(5));
                pm.setTrangthai(rs.getString(6));
                pm.setTongTienphat(rs.getFloat(7));
                return pm;
            }
        } catch (Exception e) {
        }
        return null;
    }
    public List<Phieumuon> getallPhieumuon(){
        List<Phieumuon> Lpm = new ArrayList<Phieumuon>();
        Statement sttm = null;
        ResultSet rs;

        try {
            String sSQL = "Select *  from Phieumuon";
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()) {;
                Phieumuon pm = new Phieumuon();
                pm.setMaPhieumuon(rs.getString(1));
                pm.setMaDocgia(rs.getString(2));
                pm.setMaThuthu(rs.getString(3));
                pm.setSongaymuon(rs.getInt(4));
                pm.setGhichu(rs.getString(5));
                pm.setTrangthai(rs.getString(6));
                
                Lpm.add(pm);
                
            }
            return Lpm;

        } catch (Exception e) {
            e.printStackTrace();
        } 
        return null;
    }
    
    public List<Phieumuon> getallPhieumuonCoTongtien(){
        List<Phieumuon> Lpm = new ArrayList<Phieumuon>();
        Statement sttm = null;
        ResultSet rs;

        try {
            String sSQL = "Select PM.maPhieumuon, PM.maDocgia,PM.maThuthu,PM.soNgaymuon,PM.Ghichu,PM.Trangthai , SUM(tienphat) as Tongtienphat from Chitietphieumuon CTPM ,Phieumuon PM where CTPM.maPhieumuon = PM.maPhieumuon group by PM.maPhieumuon, PM.maDocgia,PM.maThuthu,PM.soNgaymuon,PM.Ghichu,PM.Trangthai";
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()) {;
                Phieumuon pm = new Phieumuon();
                pm.setMaPhieumuon(rs.getString(1));
                pm.setMaDocgia(rs.getString(2));
                pm.setMaThuthu(rs.getString(3));
                pm.setSongaymuon(rs.getInt(4));
                pm.setGhichu(rs.getString(5));
                pm.setTrangthai(rs.getString(6));
                pm.setTongTienphat(rs.getFloat(7));
                
                Lpm.add(pm);
                
            }
            return Lpm;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                sttm.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    public int DemSoPM() {
        Statement sttm = null;
        int count = 1;
        ResultSet rs;

        try {
            String sSQL = "Select * from Phieumuon";
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()) {
                count++;
            }
            return count;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                sttm.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return -1;
    }
    
        public List<Phieumuon> getallPM() {
        List<Phieumuon> L = new ArrayList<Phieumuon>();
        Statement sttm = null;
        ResultSet rs = null;

        try {
            String sSQL = "SELECT * FROM PHIEUMUON WHERE NOT Trangthai = 'Đã Trả' ";
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()) {
                Phieumuon pm = new Phieumuon();
                pm.setMaPhieumuon(rs.getString(1));
                pm.setMaDocgia(rs.getString(2));
                pm.setMaThuthu(rs.getString(3));
                pm.setSongaymuon(rs.getInt(4));
                pm.setGhichu(rs.getString(5));
                pm.setTrangthai(rs.getString(6));

                L.add(pm);
            }
        } catch (Exception e) {
            System.out.println("Error update " + e.toString());
        } finally {
            try {
                rs.close();
                sttm.close();

            } catch (Exception e2) {
                // TODO: handle exception
            }

        }
        return L;
    }
}
