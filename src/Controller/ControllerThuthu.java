/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.DAO_Thuthu;
import Model.Thuthu;

/**
 *
 * @author UKiel
 */
public class ControllerThuthu {
    DAO_Thuthu TheDao;

    public ControllerThuthu() {
        TheDao = new DAO_Thuthu();
    }
    
    public Thuthu CtrgetTTbymaDG(String maTT){
        return TheDao.getTTbymaTT(maTT);
    }
    
    public Thuthu CtrgetTTbymaTaikhoan(String maTaikhoan){
        return TheDao.getTTbymaTaikhoan(maTaikhoan);
    }
    
}
