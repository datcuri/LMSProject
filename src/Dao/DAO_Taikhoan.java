/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.DocGia;
import Model.Taikhoan;
import java.sql.Connection;
import java.sql.*;

/**
 *
 * @author UKiel
 */
public class DAO_Taikhoan {

    Connect ketnoi = new Connect();
    Connection conn = ketnoi.getConnection();

    public Boolean Add_Account(Taikhoan Acc) {
        PreparedStatement sttm = null;
        try {
            String sSQL = "INSERT taikhoan  VALUES (?,?,?,?,?,3)";
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, Acc.getMaTaikhoan());
            sttm.setString(2, Acc.getTenDangnhap());
            sttm.setString(3, Acc.getMatkhau());
            sttm.setString(4, Acc.getChucvu());
            sttm.setInt(5, Acc.getCam());
            if (sttm.executeUpdate() > 0) {
                return true;
            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.print(e.toString());

        } finally {
            try {
                sttm.close();
            } catch (Exception e2) {
                // TODO: handle exception
            }

        }
        return false;
    }

    public Boolean Update_Account(Taikhoan Acc) {
        PreparedStatement sttm = null;

        try {
            String sSQL = "UPDATE taikhoan SET taikhoan = ? , matkhau = ? , chucvu = ?  WHERE maTaikhoan = ? ";
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, Acc.getTenDangnhap());
            sttm.setString(2, Acc.getMatkhau());
            sttm.setString(3, Acc.getChucvu());
            sttm.setString(4, Acc.getMaTaikhoan());
            if (sttm.executeUpdate() > 0) {
                return true;
            }

        } catch (Exception e) {

        } finally {
            try {
                sttm.close();
            } catch (Exception e2) {
                // TODO: handle exception
            }
        }

        return false;
    }

    public Boolean Camtaikhoanormokhoa(String maTaikhoan, int cam) {
        PreparedStatement sttm = null;

        try {
            String sSQL = "UPDATE ACCOUNT SET  cam = ?  WHERE maTaikhoan = ? ";
            sttm = conn.prepareStatement(sSQL);
            sttm.setInt(1, cam);
            sttm.setString(2, maTaikhoan);

            if (sttm.executeUpdate() > 0) {
                return true;
            }

        } catch (Exception e) {

        } finally {
            try {
                sttm.close();
            } catch (Exception e2) {
                // TODO: handle exception
            }
        }

        return false;
    }

    public Taikhoan getDangnhap(String Account, String Passwork) {
        PreparedStatement sttm = null;
        ResultSet rs = null;
        Taikhoan DN = new Taikhoan();
        try {
            String sSQL = "select * from Taikhoan where taikhoan = ? and matkhau = ?  ";
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, Account);
            sttm.setString(2, Passwork);
            rs = sttm.executeQuery();
            while (rs.next()) {
                DN.setMaTaikhoan(rs.getString(1));
                DN.setTenDangnhap(rs.getString(2));
                DN.setMatkhau(rs.getString(3));
                DN.setChucvu(rs.getString(4));
                DN.setCam(rs.getInt(5));
                DN.setSoluongmuon(rs.getInt(6));
                return DN;
            }
        } catch (Exception e) {
            System.out.println("Error select " + e.toString());
        } finally {
            try {
                rs.close();
                sttm.close();

            } catch (Exception e2) {
                // TODO: handle exception
            }

        }
        return null;
    }

    public Taikhoan getTaiKhoanID(String ID) {
        PreparedStatement sttm = null;
        ResultSet rs = null;
        Taikhoan DN = new Taikhoan();
        try {

            String sSQL = "SELECT * FROM Taikhoan where maTaikhoan = ?";
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, ID);
            rs = sttm.executeQuery();
            while (rs.next()) {
                DN.setMaTaikhoan(rs.getString(1));
                DN.setTenDangnhap(rs.getString(2));
                DN.setMatkhau(rs.getString(3));
                DN.setChucvu(rs.getString(4));
                DN.setCam(rs.getInt(5));
                DN.setSoluongmuon(rs.getInt(6));
                return DN;
            }
        } catch (Exception e) {
            System.out.println("Error select " + e.toString());
        } finally {
            try {
                rs.close();
                sttm.close();

            } catch (Exception e2) {
                // TODO: handle exception
            }

        }
        return null;
    }

    public int count() {
        int count = 1;
        Statement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "SELECT * FROM taikhoan";
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()) {
                count++;
            }
        } catch (Exception e) {
        }
        return count;
    }

    public static void main(String[] args) {
        DAO_Taikhoan DaoTK = new DAO_Taikhoan();
        System.out.println(DaoTK.getDangnhap("admin", "abc123").toString());

    }

}
