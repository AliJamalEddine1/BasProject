package bas.Product.service;

import java.sql.Connection;
import java.sql.PreparedStatement;


import org.springframework.stereotype.Service;


import bas.Product.DBConstants.DBConstat;
import bas.Product.DataBaseConfig.DataBaseConfig;

@Service
public class ProductService {


    public DataBaseConfig dataBaseConfig = new DataBaseConfig();


    public boolean updateId(int id ,int past){
        //update the 
        Connection con = null;
        try {
            con = dataBaseConfig.getConnection();
            PreparedStatement ps = con.prepareStatement(DBConstat.UPDATE_PRODUCT_ID);
            ps.setInt(1,id);ps.setInt(2,past);
            int updateRowCount = ps.executeUpdate();
            dataBaseConfig.closePreparedStatement(ps);
            return (updateRowCount == 1);
        }catch (Exception ex){
            return false;
        }finally {
            dataBaseConfig.closeConnection(con);
        }
    }
    public boolean updateClientId(Integer id ,int client){
        //update the 
        Connection con = null;
        try {
            con = dataBaseConfig.getConnection();
            PreparedStatement ps = con.prepareStatement(DBConstat.UPDATE_PRODUCT_CLIENTID);
            ps.setInt(1,client);ps.setInt(2,id);
            int updateRowCount = ps.executeUpdate();
            dataBaseConfig.closePreparedStatement(ps);
            return (updateRowCount == 1);
        }catch (Exception ex){
            return false;
        }finally {
            dataBaseConfig.closeConnection(con);
        }
    }
    public boolean updateType(Integer id ,String type){
        //update the 
        Connection con = null;
        try {
            con = dataBaseConfig.getConnection();
            PreparedStatement ps = con.prepareStatement("update product set type="+"'"+type+"'"
            		+ " where idP="+"'"+id+"'");
            //ps.setString(1,type);ps.setInt(2,id);
            int updateRowCount = ps.executeUpdate();
            dataBaseConfig.closePreparedStatement(ps);
            return (updateRowCount == 1);
        }catch (Exception ex){
            return false;
        }finally {
            dataBaseConfig.closeConnection(con);
        }
    }
    public boolean updatePrice(Integer id ,double price){
        //update the 
        Connection con = null;
        try {
            con = dataBaseConfig.getConnection();
            PreparedStatement ps = con.prepareStatement("update product set price="+"'"+price+"'"
            		+ " where idP="+"'"+id+"'");
            //ps.setDouble(1, price);ps.setInt(2,id);
            int updateRowCount = ps.executeUpdate();
            dataBaseConfig.closePreparedStatement(ps);
            return (updateRowCount == 1);
        }catch (Exception ex){
            return false;
        }finally {
            dataBaseConfig.closeConnection(con);
        }
    }
    public boolean updateQuantity(Integer id ,int qty){
        //update the 
        Connection con = null;
        try {
            con = dataBaseConfig.getConnection();
            PreparedStatement ps = con.prepareStatement("update product set quantity="+"'"+qty+"'"
            		+ " where idP="+"'"+id+"'");
            //ps.setDouble(1, qty);ps.setInt(2,id);
            int updateRowCount = ps.executeUpdate();
            dataBaseConfig.closePreparedStatement(ps);
            return (updateRowCount == 1);
        }catch (Exception ex){
            return false;
        }finally {
            dataBaseConfig.closeConnection(con);
        }
    }
    public boolean updateLocation(Integer id ,String loc){
        //update the 
        Connection con = null;
        try {
            con = dataBaseConfig.getConnection();
            PreparedStatement ps = con.prepareStatement("update product set location="+"'"+loc+"'"
            		+ " where idP="+"'"+id+"'");
          //  ps.setString(1, loc);ps.setInt(2,id);
            int updateRowCount = ps.executeUpdate();
            dataBaseConfig.closePreparedStatement(ps);
            return (updateRowCount == 1);
        }catch (Exception ex){
            return false;
        }finally {
            dataBaseConfig.closeConnection(con);
        }
    }
    public boolean updateImage(Integer id ,String img){
        //update the 
        Connection con = null;
        try {
            con = dataBaseConfig.getConnection();
            PreparedStatement ps = con.prepareStatement(DBConstat.UPDATE_PRODUCT_ID);
            ps.setString(1, img);ps.setInt(2,id);
            int updateRowCount = ps.executeUpdate();
            dataBaseConfig.closePreparedStatement(ps);
            return (updateRowCount == 1);
        }catch (Exception ex){
            return false;
        }finally {
            dataBaseConfig.closeConnection(con);
        }
    }
    public boolean updateDescription(Integer id ,String desc ){
        //update the 
        Connection con = null;
        try {
            con = dataBaseConfig.getConnection();
            PreparedStatement ps = con.prepareStatement("update product set description="+"'"+desc+"'"
            		+ " where idP="+"'"+id+"'");
           // ps.setString(1, desc);ps.setInt(2,id);
          int updateRowCount = ps.executeUpdate();
            dataBaseConfig.closePreparedStatement(ps);
            return (updateRowCount == 1);
        }catch (Exception ex){
            return false;
        }finally {
            dataBaseConfig.closeConnection(con);
        }
    }
    public boolean updateYear(Integer id ,String year ){
        //update the 
        Connection con = null;
        try {
            con = dataBaseConfig.getConnection();
            PreparedStatement ps = con.prepareStatement("update product set yearOf="+"'"+year+"'"
            		+ " where idP="+"'"+id+"'");
            ps.setString(1, year);ps.setInt(2,id);
            int updateRowCount = ps.executeUpdate();
            dataBaseConfig.closePreparedStatement(ps);
            return (updateRowCount == 1);
        }catch (Exception ex){
            return false;
        }finally {
            dataBaseConfig.closeConnection(con);
        }
    }
}
