/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Thuthu;

import java.sql.*;

/**
 *
 * @author UKiel
 */
public class DAO_Thuthu {
    
        Connect ketnoi = new Connect();
    Connection conn = ketnoi.getConnection();
    
    public Thuthu getTTbymaTaikhoan(String maTaikhoan) {
        PreparedStatement sttm = null;
        String sSQL = "Select * from thuthu where mataikhoan = ? ";
        ResultSet rs;
        try {
            sttm = conn.prepareStatement(sSQL);

            sttm.setString(1, maTaikhoan);
            rs = sttm.executeQuery();
            if (rs.next()) {
                Thuthu DG = new Thuthu();
                DG.setMaThuthu(rs.getString(1));
                DG.setTenThuthu(rs.getString(2));
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
        } 
        return null;
    }
    
    public Thuthu getTTbymaTT(String maTT) {
        PreparedStatement sttm = null;
        String sSQL = "Select * from docgia where mathuthu = ? ";
        ResultSet rs;
        try {
            sttm = conn.prepareStatement(sSQL);

            sttm.setString(1, maTT);
            rs = sttm.executeQuery();
            if (rs.next()) {
                Thuthu DG = new Thuthu();
                DG.setMaThuthu(rs.getString(1));
                DG.setTenThuthu(rs.getString(2));
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
}
