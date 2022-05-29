/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.DAO_Taikhoan;
import Dao.DAO_Thongke;
import java.sql.ResultSet;

/**
 *
 * @author UKiel
 */
public class ControllerThongke {

    DAO_Thongke TheDao;

    public ControllerThongke() {
        TheDao = new DAO_Thongke();
    }

    public ResultSet CtrDGmuonquahan() {
        return TheDao.DGmuonquahan();
    }

    public ResultSet CtrDGdangmuon() {
        return TheDao.DGdangmuon();
    }

    public ResultSet CtrDGchuatratienphat() {
        return TheDao.DGchuatratienphat();
    }

    public ResultSet CtrDGmuonnhieunhat() {
        return TheDao.DGmuonnhieunhat();
    }

    public ResultSet CtrXephangsachngay() {
        return TheDao.XephangSachdcmuonnhieunhat();
    }
}
