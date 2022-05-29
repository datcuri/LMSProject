/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.DAO_Taikhoan;
import Model.Taikhoan;

/**
 *
 * @author UKiel
 */
public class ControllerDangnhap {
    public DAO_Taikhoan TheDao;

    public ControllerDangnhap() {
        TheDao = new DAO_Taikhoan();
    }
    public boolean CtrThemTaikhoan (Taikhoan Acc){
        return TheDao.Add_Account(Acc);
    }
    public boolean CtrSuaTaikhoan (Taikhoan Acc){
        return TheDao.Update_Account(Acc);
    }
    
    public Taikhoan CtrgetDangnhap(String Account, String Passwork){
        return TheDao.getDangnhap(Account, Passwork);
    }
    public Taikhoan CtrgetTaikhoanID(String maTaikhoan){
        return TheDao.getTaiKhoanID(maTaikhoan);
    }
    public int CtrCountTK(){
        return TheDao.count();
    }
    
    public boolean CtrCamormokhoa (String maTaikhoan, int cam){
        return TheDao.Camtaikhoanormokhoa(maTaikhoan, cam);
    }
}
