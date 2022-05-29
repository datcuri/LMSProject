package Controller;


import Dao.DAO_Docgia;
import Model.DocGia;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author UKiel
 */
public class ControllerDocgia {
    DAO_Docgia TheDao;

    public ControllerDocgia() {
        TheDao = new DAO_Docgia();
    }
    public boolean CtrThemDocGia(DocGia DG){
        return TheDao.Add_DocGia(DG);
    }
    public boolean CtrSuaDocGia(DocGia DG){
        return TheDao.Update_DocGia(DG);
    }
    
    public DocGia CtrgetDGbymaTaikhoan(String maTaikhoan){
        return TheDao.getDGbymaTaikhoan(maTaikhoan);
    }
    
    public DocGia CtrgetDGlikeName(String tenDocgia){
        return TheDao.getDGlikeName(tenDocgia);
    }
    public DocGia CtrgetDGbymaDG(String maDG){
        return TheDao.getDGbymaDG(maDG);
    }
    
    public List<DocGia> CtrgetallDG(){
        return TheDao.getAllDocGia();
    }
    public int CtrCountDG(){
        return TheDao.Count();
    }
}
