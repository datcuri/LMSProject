/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.DocGia;
import Model.Phieumuon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author UKiel
 */
public class DAO_Docgia {

    Connect ketnoi = new Connect();
    Connection conn = ketnoi.getConnection();

    public Boolean Add_DocGia(DocGia DG) {
        PreparedStatement sttm = null;

        try {
            String sSQL = "INSERT INTO DOCGIA VALUES (?,?,?,?,?,?,?)";
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, DG.getMaDocgia());
            sttm.setString(2, DG.getMaTaikhoan());
            sttm.setDate(3, DG.getNgaysinh());
            sttm.setInt(4, DG.getGioitinh());
            sttm.setString(5, DG.getMail());
            sttm.setString(6, DG.getSdt());
            sttm.setString(7, DG.getMaTaikhoan());

            if (sttm.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.print(e.toString());
        }
        return false;
    }

    public Boolean Update_DocGia(DocGia DG) {
        PreparedStatement sttm = null;

        try {
            String sSQL = "UPDATE DOCGIA SET tenDocgia = ?, ngaysinh = ? , gioitinh = ? , Email= ? , sdt = ? , maTaikhoan = ? WHERE maDocgia = ? ";
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, DG.getTenDocgia());
            sttm.setDate(2, DG.getNgaysinh());
            sttm.setInt(3, DG.getGioitinh());
            sttm.setString(4, DG.getMail());
            sttm.setString(5, DG.getSdt());
            sttm.setString(6, DG.getMaTaikhoan());
            sttm.setString(7, DG.getMaDocgia());
            if (sttm.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
        return false;
    }

    public DocGia getDGbymaTaikhoan(String maTaikhoan) {
        PreparedStatement sttm = null;
        String sSQL = "Select * from docgia where mataikhoan = ? ";
        ResultSet rs;
        try {
            sttm = conn.prepareStatement(sSQL);

            sttm.setString(1, maTaikhoan);
            rs = sttm.executeQuery();
            if (rs.next()) {
                DocGia DG = new DocGia();
                DG.setMaDocgia(rs.getString(1));
                DG.setTenDocgia(rs.getString(2));
                DG.setNgaysinh(rs.getDate(3));
                DG.setGioitinh(rs.getInt(4));
                DG.setMail(rs.getString(5));
                DG.setSdt(rs.getString(6));
                DG.setMaTaikhoan(rs.getString(7));
//                System.out.println(DG.toString());
                return DG;
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
        return null;
    }

    public DocGia getDGbymaDG(String maDG) {
        PreparedStatement sttm = null;
        String sSQL = "Select * from docgia where madocgia = ? ";
        ResultSet rs;
        try {
            sttm = conn.prepareStatement(sSQL);

            sttm.setString(1, maDG);
            rs = sttm.executeQuery();
            if (rs.next()) {
                DocGia DG = new DocGia();
                DG.setMaDocgia(rs.getString(1));
                DG.setTenDocgia(rs.getString(2));
                DG.setNgaysinh(rs.getDate(3));
                DG.setGioitinh(rs.getInt(4));
                DG.setMail(rs.getString(5));
                DG.setSdt(rs.getString(6));
                DG.setMaTaikhoan(rs.getString(7));
//                System.out.println(DG.toString());
                return DG;
            }

        } catch (SQLException e) {
        }
        return null;
    }

    public DocGia getDGlikeName(String tenDocgia) {
        Statement sttm = null;
        String sSQL = null;
        ResultSet rs;

        try {
            sSQL = "Select * from Docgia where tenDocgia like N'%" + tenDocgia + "%' ";
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            if (rs.next()) {
                DocGia dg = new DocGia();
                dg.setMaDocgia(rs.getString(1));
                dg.setTenDocgia(rs.getString(2));
                dg.setNgaysinh(rs.getDate(3));
                dg.setGioitinh(rs.getInt(4));
                dg.setMail(rs.getString(5));
                dg.setSdt(rs.getString(6));
                dg.setMaTaikhoan(rs.getString(7));

                return dg;
            }

        } catch (Exception e) {
        }
        return null;
    }

    public List<DocGia> getAllDocGia() {
        Statement sttm = null;
        List<DocGia> LDG = new ArrayList<DocGia>();
        ResultSet rs = null;

        try {
            String sSQL = "Select * from Docgia";
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()) {
                DocGia DG = new DocGia();
                DG.setMaDocgia(rs.getString(1));
                DG.setTenDocgia(rs.getString(2));
                DG.setNgaysinh(rs.getDate(3));
                DG.setGioitinh(rs.getInt(4));
                DG.setMail(rs.getString(5));
                DG.setSdt(rs.getString(6));
                DG.setMaTaikhoan(rs.getString(7));
                LDG.add(DG);
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
        return LDG;
    }

    public int Count() {
        Statement sttm = null;
        ResultSet rs = null;
        int count = 1;
        try {
            String sSQL = "SELECT * FROM docgia ";
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()) {
                count++;
            }
        } catch (Exception e) {
            // TODO: handle exception
        } 
        return count;
    }

}
