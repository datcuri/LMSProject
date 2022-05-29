/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Sach;
import java.awt.print.Book;

import java.sql.Connection;
import java.sql.Date;
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
public class DAO_Sach {

    Connect ketnoi = new Connect();
    Connection conn = ketnoi.getConnection();

    public boolean ThemSach(Sach BK) {
        PreparedStatement sttm = null;
        try {
            String sSQL = "INSERT INTO Sach (maSach, tenSach, maDanhMuc, maTheLoai, tacgia, nhaXuatBan, namXuatBan, soluong, mota) VALUES (?,?,?,?,?,?,?,?,?)";
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, BK.getMaSach());
            sttm.setString(2, BK.getTenSach());
            sttm.setString(3, BK.getMaDanhMuc());
            sttm.setString(4, BK.getMaTheLoai());
            sttm.setString(5, BK.getTacgia());
            sttm.setString(6, BK.getNhaXuatBan());
            sttm.setInt(7, BK.getNamXuatBan());
            sttm.setInt(8, BK.getSoluong());
            sttm.setString(9, BK.getMota());
            if (sttm.executeUpdate() > 0) {
                System.out.println("add thanh cong");
                return true;
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.print("Error Insert" + e.toString());
        } finally {
            try {
                sttm.close();
                //conn.close();
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean SuaSach(Sach BK) {
        PreparedStatement sttm = null;
        try {
            String sSQL = " UPDATE Sach SET tenSach = ? , maDanhMuc = ? , maTheLoai = ? , tacgia = ? , nhaXuatBan = ? ,  namXuatBan = ? , soluong = ? , mota = ? WHERE maSach = ?";
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, BK.getTenSach());
            sttm.setString(2, BK.getMaDanhMuc());
            sttm.setString(3, BK.getMaTheLoai());
            sttm.setString(4, BK.getTacgia());
            sttm.setString(5, BK.getNhaXuatBan());
            sttm.setInt(6, BK.getNamXuatBan());
            sttm.setInt(7, BK.getSoluong());
            sttm.setString(8, BK.getMota());
            sttm.setString(9, BK.getMaSach());
            if (sttm.executeUpdate() > 0) {
                System.out.print("update thanh cong");
                return true;
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.print("Error Update" + e.toString());
        } finally {
            try {
                sttm.close();
                //conn.close();
            } catch (Exception e2) {
                // TODO: handle exception
            }
        }
        return false;
    }

    public boolean Capnhatsoluongsach(Sach BK, int i) {
        PreparedStatement sttm = null;
        try {
            String sSQL = " UPDATE Sach SET soluong = ? WHERE maSach = ?";
            sttm = conn.prepareStatement(sSQL);

            sttm.setInt(1, BK.getSoluong() + i);
            sttm.setString(2, BK.getMaSach());
            if (sttm.executeUpdate() > 0) {
                System.out.print("update thanh cong");
                return true;
            }
        } catch (SQLException e) {
            // TODO: handle exception
            System.out.print("Error Update" + e.toString());
        }
        return false;
    }

    // Xóa  1 Cuốn Sách
    public boolean XoaSach(String maSach) {
        //Câu lệnh SQL
        PreparedStatement sttm = null;
        String sSQL = "DELETE FROM Sach WHERE maSach = ? ";
        try {

            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, maSach);

            // Nếu thêm thành công
            if (sttm.executeUpdate() > 0) {
                System.out.println("delete thanh cong");
                return true;
            }

        } catch (SQLException e) {
            // Nếu thêm thất bại
            System.out.println("Error delete BOOK " + maSach);
        } finally {
            try {
                // Dóng SQL
                //conn.close();
                sttm.close();
            } catch (SQLException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
        return true;
    }

    public Sach LaymaSach(String maSach) {
        PreparedStatement sttm = null;
        ResultSet rs = null;

        try {
            String sSQL = "SELECT * FROM Sach WHERE maSach = ? ";
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, maSach);
            rs = sttm.executeQuery();
            while (rs.next()) {
                Sach BK = new Sach();
                BK.setMaSach(rs.getString(1));
                BK.setTenSach(rs.getString(2));
                BK.setMaDanhMuc(rs.getString(3));
                BK.setMaTheLoai(rs.getString(4));
                BK.setTacgia(rs.getString(5));
                BK.setNhaXuatBan(rs.getString(6));
                BK.setNamXuatBan(rs.getInt(7));
                BK.setSoluong(rs.getInt(8));
                BK.setMota(rs.getString(9));
                return BK;
            }

        } catch (Exception e) {
            System.out.println("Error select " + e.toString());
        } finally {
            try {
                rs.close();
                sttm.close();
                //conn.close();
            } catch (Exception e2) {
                // TODO: handle exception
            }

        }
        return null;
    }

    public Sach getBooklikeName(String Name) {

        Statement sttm = null;
        ResultSet rs = null;

        try {
            String sSQL = "SELECT * FROM Sach WHERE tenSach LIKE N'%" + Name + "%' ";
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            if (rs.next()) {
                Sach BK = new Sach();
                BK.setMaSach(rs.getString(1));
                BK.setTenSach(rs.getString(2));
                BK.setMaDanhMuc(rs.getString(3));
                BK.setMaTheLoai(rs.getString(4));
                BK.setTacgia(rs.getString(5));
                BK.setNhaXuatBan(rs.getString(6));
                BK.setNamXuatBan(rs.getInt(7));
                BK.setSoluong(rs.getInt(8));
                BK.setMota(rs.getString(9));

                return BK;
            }
        } catch (Exception e) {
            System.out.println("Error select " + e.toString());
        } finally {
            try {
                rs.close();
                sttm.close();
                //SQL_D.getCon().close();
            } catch (Exception e2) {
                // TODO: handle exception
            }

        }
        return null;
    }

    public List<Sach> getallBook() {
        List<Sach> LBK = new ArrayList<Sach>();
        Statement sttm = null;
        ResultSet rs = null;

        try {
            String sSQL = "SELECT * FROM Sach ";
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()) {
                Sach BK = new Sach();
                BK.setMaSach(rs.getString(1));
                BK.setTenSach(rs.getString(2));
                BK.setMaDanhMuc(rs.getString(3));
                BK.setMaTheLoai(rs.getString(4));
                BK.setTacgia(rs.getString(5));
                BK.setNhaXuatBan(rs.getString(6));
                BK.setNamXuatBan(rs.getInt(7));
                BK.setSoluong(rs.getInt(8));

                LBK.add(BK);
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
        return LBK;
    }

    public List<Sach> getSachbySort(String ten, String loai) {
        List<Sach> LBK = new ArrayList<Sach>();
        Statement sttm = null;
        ResultSet rs = null;
        String sSQL = null;
        sSQL = "select * from Sach, Danhmuc where tenDanhmuc = N'" + ten + "' and Sach.maDanhmuc = DanhMuc.maDanhmuc";
        if (loai.equalsIgnoreCase("theloai")) {
            sSQL = "select * from Sach, TheLoai where tenTheLoai = N'" + ten + "' and Sach.maTheLoai = TheLoai.maTheLoai";
        }
        try {

            sttm = conn.createStatement();
//            sttm.setString(1, ten);
            rs = sttm.executeQuery(sSQL);
            while (rs.next()) {
                Sach BK = new Sach();
                BK.setMaSach(rs.getString(1));
                BK.setTenSach(rs.getString(2));
                BK.setMaDanhMuc(rs.getString(3));
                BK.setMaTheLoai(rs.getString(4));
                BK.setTacgia(rs.getString(5));
                BK.setNhaXuatBan(rs.getString(6));
                BK.setNamXuatBan(rs.getInt(7));
                BK.setSoluong(rs.getInt(8));

                LBK.add(BK);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                rs.close();
                sttm.close();

            } catch (Exception e2) {
                // TODO: handle exception
            }

        }
        return LBK;
    }

    public List<Sach> getSachSortBoth(String danhmuc, String theloai) {
        List<Sach> LBK = new ArrayList<Sach>();

        String sql = "select maSach, tenSach, DM.maDanhmuc, TL.maTheLoai, tacgia, nhaXuatBan, namxuatban, soluong  from Sach, DanhMuc DM, TheLoai TL where tenDanhmuc = N'" + danhmuc + "' and tenTheLoai = N'" + theloai + "'  and Sach.maDanhmuc = DM.maDanhmuc and Sach.maTheLoai = TL.maTheLoai";
        try {
            Statement sttm = conn.createStatement();

            ResultSet rs = sttm.executeQuery(sql);
            while (rs.next()) {
                Sach BK = new Sach();
                BK.setMaSach(rs.getString(1));
                BK.setTenSach(rs.getString(2));
                BK.setMaDanhMuc(rs.getString(3));
                BK.setMaTheLoai(rs.getString(4));
                BK.setTacgia(rs.getString(5));
                BK.setNhaXuatBan(rs.getString(6));
                BK.setNamXuatBan(rs.getInt(7));
                BK.setSoluong(rs.getInt(8));

                LBK.add(BK);
            }
            return LBK;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public String maTheLoai(String maTheloai) {
        String sql = "SELECT tentheloai FROM Theloai where matheloai = ?";
        try {
            PreparedStatement sttm = conn.prepareStatement(sql);
            sttm.setString(1,maTheloai);
            ResultSet rs = sttm.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (SQLException e) {

        }
        return null;
    }

    public String maDanhMuc(String maDanhmuc) {
        String sql = "SELECT tenDanhmuc FROM Danhmuc where maDanhmuc = ?";
        try {
            PreparedStatement sttm = conn.prepareStatement(sql);
            sttm.setString(1,maDanhmuc);
            ResultSet rs = sttm.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (SQLException e) {
  
        }
        return null;
    }
    
    public int getSLSach(){
        Statement sttm = null;
        ResultSet rs = null;
        int count = 0;
        try {
            String sSQL = "SELECT * FROM Sach ";
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()) {
                count++;
            }
            return count;
        } catch (Exception e) {

        } 
        return count;
    }

//    public static void main(String[] args) {
//        DAO_Sach sach = new DAO_Sach();
////        Sach BK = new Sach("1", "10002", "2", "2", "tacgia", "nhaxuatban", 1900, 60, "Something not write");
////        sach.SuaSach(BK);
//        
//        List<Sach> l = sach.getSachbySort("Kỹ năng sống", "danhmuc");
//        System.out.println(l.isEmpty() + " " + l.size());
//        for (Sach BK : l){
//            System.out.println(BK.toString());
//        }
//        
//
//    }
}
