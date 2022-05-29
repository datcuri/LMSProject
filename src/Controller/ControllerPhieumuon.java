/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.DAO_PhieuMuon;
import Model.Phieumuon;
import java.util.List;

/**
 *
 * @author UKiel
 */
public class ControllerPhieumuon {

    DAO_PhieuMuon TheDao;

    public ControllerPhieumuon() {
        TheDao = new DAO_PhieuMuon();
    }

    public boolean CtrThemPhieumuon(Phieumuon PM) {
        return TheDao.ThemPhieumuon(PM);
    }

    public boolean CtrSuaPhieumuon(Phieumuon PM) {
        return TheDao.SuaPhieumuon(PM);
    }

    public boolean CtrXoaPhieumuon(String maPhieumuon) {
        return TheDao.XoaPhieumuon(maPhieumuon);
    }

    public int CtrDemSoPM() {
        return TheDao.DemSoPM();
    }

    public List<Phieumuon> CtrgetallPM() {
        return TheDao.getallPhieumuon();
    }

    public List<Phieumuon> CtrgetallPMcotongtien() {
        return TheDao.getallPhieumuonCoTongtien();
    }

    public Phieumuon CtrgetPMbymaPM(String maPM) {
        return TheDao.getPMbymaPM(maPM);
    }

}
