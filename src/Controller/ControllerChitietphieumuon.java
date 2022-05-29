/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.DAO_ChitietPhieumuon;
import Model.ChitietPhieuMuon;

import java.util.List;

/**
 *
 * @author UKiel
 */
public class ControllerChitietphieumuon {

    DAO_ChitietPhieumuon TheDao;

    public ControllerChitietphieumuon() {
        TheDao = new DAO_ChitietPhieumuon();
    }
    // Vut qua DAO tai khoan

    public boolean CtrSuasoluongmuon(String maTaikhoan, int max) {
        return TheDao.Sualuotmuon(maTaikhoan, max);
    }

    //
    public boolean CtrThemCTPhieumuon(ChitietPhieuMuon ctpm) {
        return TheDao.ThemCTPhieumuon(ctpm);
    }

    public boolean CtrThemCTPhieumuon_Thuthu(ChitietPhieuMuon ctpm) {
        return TheDao.ThemCTPM_Thuthu(ctpm);
    }

    public boolean CtrSuaCTPhieumuon(ChitietPhieuMuon ctpm) {
        return TheDao.SuaCTPhieumuon(ctpm);
    }

    public boolean CtrXoaCTPMbymaSach_maPM(String maSach, String maPM) {
        return TheDao.XoaCTPMbymaSach_maPM(maSach, maPM);
    }

    //
    public ChitietPhieuMuon CtrgetCTPMbymaSach_maPM(String maSach, String maPM) {
        return TheDao.getCTPMbymaSach_maPM(maSach, maPM);
    }

    public List<ChitietPhieuMuon> CtrgetCTPMbymaDocgia(String maDocgia) {
        return TheDao.getDSCTPMbymaDocgia(maDocgia);
    }

    public List<ChitietPhieuMuon> CtrDSChitietPhieumuon(String maPM) {
        return TheDao.getDSChitietphieumuon(maPM);
    }
    public int CtrSoluongsachdangmuon(String maDocgia){
        return TheDao.Soluongsachdangmuon(maDocgia);
    }

}
