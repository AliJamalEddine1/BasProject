package bas.Client.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Service;


import bas.Client.DBConstants.DBConstant;
import bas.Client.DataBaseConfig.DataBaseConfig;
import bas.Client.model.Client;

@Service
public class ClientService {


    public DataBaseConfig dataBaseConfig = new DataBaseConfig();

//This method is never used
    public boolean updateId(int id ,int past){
        //update id 
        Connection con = null;
        try {
            con = dataBaseConfig.getConnection();
            PreparedStatement ps = con.prepareStatement(DBConstant.UPDATE_CLIENT_ID);
            ps.setInt(1,id);ps.setInt(2, past);
            int updateRowCount = ps.executeUpdate();
            dataBaseConfig.closePreparedStatement(ps);
            return (updateRowCount == 1);
        }catch (Exception ex){
            return false;
        }finally {
            dataBaseConfig.closeConnection(con);
        }
    }

    public boolean updateGender(Integer id ,String gender){
        //update the 
        Connection con = null;
        try {
            con = dataBaseConfig.getConnection();
            PreparedStatement ps = con.prepareStatement("update client set gender="+"'"+gender+"'"
            		+ " where id="+"'"+id+"'");
          
            int updateRowCount = ps.executeUpdate();
            dataBaseConfig.closePreparedStatement(ps);
            return (updateRowCount == 1);
        }catch (Exception ex){
            return false;
        }finally {
            dataBaseConfig.closeConnection(con);
        }
    }
    public boolean updateFirstName(Integer id ,String fname){
        //update the 
        Connection con = null;
        try {
            con = dataBaseConfig.getConnection();
            PreparedStatement ps = con.prepareStatement(DBConstant.UPDATE_CLIENT_FIRST_NAME);
            ps.setString(1,fname); ps.setInt(2,id);
            int updateRowCount = ps.executeUpdate();
            dataBaseConfig.closePreparedStatement(ps);
            return (updateRowCount == 1);
        }catch (Exception ex){
            return false;
        }finally {
            dataBaseConfig.closeConnection(con);
        }
    }
    public boolean updateName(Integer id ,String fname,String lname){
        //update the 
        Connection con = null;
        try {
            con = dataBaseConfig.getConnection();
            PreparedStatement ps = con.prepareStatement("update client set first_name="+"'"+fname+"' ,"
            		+ " last_name=" +"'"+lname+"' where id="+"'"+id+"'");
          System.out.println(ps);
            int updateRowCount = ps.executeUpdate();
            dataBaseConfig.closePreparedStatement(ps);
            return (updateRowCount == 1);
        }catch (Exception ex){
            return false;
        }finally {
            dataBaseConfig.closeConnection(con);
        }
    }
    public boolean updatePhoneNumber(Integer id ,String phone){
        //update the 
        Connection con = null;
        try {
            con = dataBaseConfig.getConnection();
            PreparedStatement ps = con.prepareStatement("update client set phone_number="+"'"+phone+"'"+
            " where id="+"'"+id+"'");
          System.out.println(ps);
            int updateRowCount = ps.executeUpdate();
            dataBaseConfig.closePreparedStatement(ps);
            return (updateRowCount == 1);
        }catch (Exception ex){
            return false;
        }finally {
            dataBaseConfig.closeConnection(con);
        }
    }
    public boolean updatePassword(Integer id ,String oldpass,String newpass){
        //update the 
        Connection con = null;
        try {
            con = dataBaseConfig.getConnection();
            PreparedStatement ps = con.prepareStatement("update client set password="+"'"+newpass+"'"+
            " where id="+"'"+id+"' and password='"+ oldpass+"'");
          System.out.println(ps);
            int updateRowCount = ps.executeUpdate();
            dataBaseConfig.closePreparedStatement(ps);
            return (updateRowCount == 1);
        }catch (Exception ex){
            return false;
        }finally {
            dataBaseConfig.closeConnection(con);
        }
    }
    public Client updateEmail(int id,String email,String newEmail){
        //update the 
        Connection con = null;
        try {
            con = dataBaseConfig.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from client where email="+"'"+newEmail+"'");
            ResultSet result = ps.executeQuery();
            System.out.println(ps);
           
          
            
            if(result.next()==false) {
            	dataBaseConfig.closePreparedStatement(ps);
            	PreparedStatement up = con.prepareStatement("update client set email="+"'"+newEmail+"'"+""
            			+ " where id="+"'"+id+"'");
            	int updateRowCount = up.executeUpdate();
            	 System.out.println(up);
            	 dataBaseConfig.closePreparedStatement(up);
            	  PreparedStatement ps1 = con.prepareStatement("select * from client p where p.email ="+"'"+newEmail+"'");
                  ResultSet res = ps1.executeQuery(); 
                  System.out.println(ps1);
                //  System.out.println(res);
                if(res.next()) {
            Client c= new Client(Integer.parseInt(res.getString("id")),res.getString("first_name")
         			,res.getString("last_name"),res.getString("gender"),res.getString("email")
         			,Integer.parseInt(res.getString("phone_number")));
           // dataBaseConfig.closePreparedStatement(ps1);
            System.out.println(c);
            
            return c;}
            } else return null;
            
      
           
            	
            
        }catch (Exception ex){
           ex.printStackTrace();
        }finally {
            dataBaseConfig.closeConnection(con);
        }
        return null;
    }
}