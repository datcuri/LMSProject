/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.DAO_Sach;
import Model.Sach;
import java.util.List;

/**
 *
 * @author UKiel
 */
public class ControllerSach {

    public DAO_Sach TheDao;

    public ControllerSach() {
        TheDao = new DAO_Sach();

    }

    // Thêm, Sửa, Xóa Trong Sach
    public boolean CtrInsertSach(Sach BK) {
        return TheDao.ThemSach(BK);
    }

    public boolean CtrUpdateSach(Sach BK) {
        return TheDao.SuaSach(BK);
    }

    public boolean CtrDeleteSach(String maSach) {
        return TheDao.XoaSach(maSach);
    }

    public boolean CtrCapnhatsoluongsach(Sach BK, int i) {
        return TheDao.Capnhatsoluongsach(BK, i);
    }

    //
    public Sach ctrgetSachtheoten(String tenSach) {
        return TheDao.getBooklikeName(tenSach);
    }

    public Sach CtrgetIDSach(String maSach) {
        return TheDao.LaymaSach(maSach);
    }

    public List<Sach> CtrgetAllSach() {
        return TheDao.getallBook();
    }

    public List<Sach> CtrgetSachbySort(String ten, String loai) {
        return TheDao.getSachbySort(ten, loai);
    }

    public List<Sach> CtrgetSachbyBoth(String danhmuc, String theloai) {
        return TheDao.getSachSortBoth(danhmuc, theloai);
    }

    //
    public String CtrmaTheloai(String maTheloai) {
        return TheDao.maTheLoai(maTheloai);
    }

    public String CtrmaDanhMuc(String maDanhmuc) {
        return TheDao.maDanhMuc(maDanhmuc);
    }
    
    public int CtrgetSLSach(){
        return TheDao.getSLSach();
    }
}
