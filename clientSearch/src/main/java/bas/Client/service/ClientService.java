package bas.Client.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


import bas.Client.DBConstants.DBConstant;
import bas.Client.DataBaseConfig.DataBaseConfig;
import bas.Client.model.Client;


@Service
public class ClientService {


    public DataBaseConfig dataBaseConfig = new DataBaseConfig();


    public Client searchId(int id){
        //search By ID
        Connection con = null;
        try {
            con = dataBaseConfig.getConnection();
            PreparedStatement ps = con.prepareStatement(DBConstant.SELECT_CLIENT_ID);
            ps.setInt(1, id);
            System.out.println(ps);
            ResultSet result = ps.executeQuery();
            System.out.println(result);
            if(result.next()) {
            	
            	return new Client(Integer.parseInt(result.getString("id")),result.getString("first_name")
            			,result.getString("last_name"),result.getString("gender"),result.getString("email")
            			,Integer.parseInt(result.getString("phone_number")));
            }
            dataBaseConfig.closePreparedStatement(ps);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            dataBaseConfig.closeConnection(con);
        }
        return null;
    }
  
    public List<Client> searchFirstName(String fname){
        //search by fname 
    	   Connection con = null;
           List<Client> p=new ArrayList<Client>();
           try {
               con = dataBaseConfig.getConnection();
               PreparedStatement ps = con.prepareStatement(DBConstant.SELECT_CLIENT_FIRST_NAME);
               ps.setString(1,fname);
               ResultSet result = ps.executeQuery();
               dataBaseConfig.closePreparedStatement(ps);
               
               while(result.next()) {
               	p.add(new Client(Integer.parseInt(result.getString("id")),result.getString("first_name")
            			,result.getString("last_name"),result.getString("gender"),result.getString("email")
            			,Integer.parseInt(result.getString("phone_number"))));
               }
           }catch (Exception ex){
               ex.printStackTrace();
           }finally {
               dataBaseConfig.closeConnection(con);
               
           }
           return p;
    }
  
  
    
    public List<Client> searchLastName(String lname){
        //search by lname
 	   Connection con = null;
       List<Client> p=new ArrayList<Client>();
       try {
           con = dataBaseConfig.getConnection();
           PreparedStatement ps = con.prepareStatement(DBConstant.SELECT_CLIENT_LAST_NAME);
           ps.setString(1,lname);
           ResultSet result = ps.executeQuery();
           dataBaseConfig.closePreparedStatement(ps);
        
           while(result.next()) {
           	p.add(new Client(Integer.parseInt(result.getString("id")),result.getString("first_name")
        			,result.getString("last_name"),result.getString("gender"),result.getString("email")
        			,Integer.parseInt(result.getString("phone_number"))));
           }
       }catch (Exception ex){
           ex.printStackTrace();
       }finally {
           dataBaseConfig.closeConnection(con);
           
       }
       return p;
    }
    public List<Client> searchGender(String gender ){
        //search by gender 
 	   Connection con = null;
       List<Client> p=new ArrayList<Client>();
       try {
           con = dataBaseConfig.getConnection();
           PreparedStatement ps = con.prepareStatement(DBConstant.SELECT_CLIENT_GENDER);
           ps.setString(1,gender);
           ResultSet result = ps.executeQuery();
           dataBaseConfig.closePreparedStatement(ps);

           while(result.next()) {
           	p.add(new Client(Integer.parseInt(result.getString("id")),result.getString("first_name")
        			,result.getString("last_name"),result.getString("gender"),result.getString("email")
        			,Integer.parseInt(result.getString("phone_number"))));
           }
       }catch (Exception ex){
           ex.printStackTrace();
       }finally {
           dataBaseConfig.closeConnection(con);
           
       }
       return p;
       
    }
    public List<Client> searchEmail(String email){
        //search by email 
 	   Connection con = null;
       List<Client> p=new ArrayList<Client>();
       try {
           con = dataBaseConfig.getConnection();
           PreparedStatement ps = con.prepareStatement("select * from client p where p.email ="+"'"+email+"'");
          // ps.setString(1,email);ps.setString(2,pass);
           System.out.println(ps);
           ResultSet result = ps.executeQuery();
          
     
           while(result.next()) {
           	p.add(new Client(Integer.parseInt(result.getString("id")),result.getString("first_name")
        			,result.getString("last_name"),result.getString("gender"),result.getString("email")
        			,Integer.parseInt(result.getString("phone_number"))));
           }
           dataBaseConfig.closePreparedStatement(ps);
       }catch (Exception ex){
           ex.printStackTrace();
       }finally {
    	 
           dataBaseConfig.closeConnection(con);
           
       }
       return p;
    }
    public List<Client> searchEmail(String email,String pass){
        //search by email 
 	   Connection con = null;
       List<Client> p=new ArrayList<Client>();
       try {
           con = dataBaseConfig.getConnection();
           PreparedStatement ps = con.prepareStatement("select * from client p where p.email ="+"'"+email+"'" +" and p.password="+"'"+pass+"'");
          // ps.setString(1,email);ps.setString(2,pass);
           System.out.println(ps);
           ResultSet result = ps.executeQuery();
          
     
           while(result.next()) {
           	p.add(new Client(Integer.parseInt(result.getString("id")),result.getString("first_name")
        			,result.getString("last_name"),result.getString("gender"),result.getString("email")
        			,Integer.parseInt(result.getString("phone_number"))));
           }
           dataBaseConfig.closePreparedStatement(ps);
       }catch (Exception ex){
           ex.printStackTrace();
       }finally {
    	 
           dataBaseConfig.closeConnection(con);
           
       }
       return p;
    }
    public Integer searchPhoneNumber(int id){
        //search phone
 	   Connection con = null;
       //List<Client> p=new ArrayList<Client>();
       try {
           con = dataBaseConfig.getConnection();
           PreparedStatement ps = con.prepareStatement("select phone_number from client p where p.id ="+"'"+id);
           
           ResultSet result = ps.executeQuery();
           dataBaseConfig.closePreparedStatement(ps);
     
          return Integer.parseInt(result.getString("phone_number"));
           
       }catch (Exception ex){
           ex.printStackTrace();
       }finally {
           dataBaseConfig.closeConnection(con);
           
       }
       return 0;
    }
}