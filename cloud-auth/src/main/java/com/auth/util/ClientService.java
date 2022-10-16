package com.auth.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.auth.config.DataBaseConfig;
import com.auth.model.Client;




@Service
public class ClientService {


    public DataBaseConfig dataBaseConfig = new DataBaseConfig();


   
    public List<Client> refresh(String email){
        //search by email 
 	   Connection con = null;
       List<Client> p=new ArrayList<Client>();
       try {
           con = dataBaseConfig.getConnection();
           PreparedStatement ps = con.prepareStatement("select * from client p where p.email ="+"'"+email+"'" );
          // ps.setString(1,email);ps.setString(2,pass);
           System.out.println(ps);
           ResultSet result = ps.executeQuery();
          
           while(result.next()) {
              	p.add(new Client(Integer.parseInt(result.getString("id")),result.getString("first_name")
           			,result.getString("last_name"),result.getString("gender"),result.getString("email")
           			,Integer.parseInt(result.getString("phone_number")),result.getString("password"),
        			result.getDate("birthday")));
              }
              dataBaseConfig.closePreparedStatement(ps);
          }catch (Exception ex){
              ex.printStackTrace();
          }finally {
       	 
              dataBaseConfig.closeConnection(con);
              
          }
          return p;
           
           
      
    }
    public List<Client> login(String email,String pass){
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
           			,Integer.parseInt(result.getString("phone_number")),result.getString("password"),
        			result.getDate("birthday")));
              }
              dataBaseConfig.closePreparedStatement(ps);
          }catch (Exception ex){
              ex.printStackTrace();
          }finally {
       	 
              dataBaseConfig.closeConnection(con);
              
          }
          return p;
           
           
      
    }
    public boolean addClient(Client c){
        //update the 
        Connection con = null;
        try {
            con = dataBaseConfig.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from client where email="+"'"+c.getEmail()+"'");
            ResultSet result = ps.executeQuery();
            System.out.println(ps);
           
          
            
            if(result.next()==false) {
            	dataBaseConfig.closePreparedStatement(ps);
            	String pattern = "yyyy/MM/dd HH:mm:ss";
            	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            	String date = simpleDateFormat.format(c.getBirthday());
            	System.out.println(date);
            	PreparedStatement up = con.prepareStatement("insert into client(birthday,email,first_name,gender,last_name,password,phone_number) "
            			+ "	values('"+date+"',"+"'"+
            	               c.getEmail()+"',"+"'"+c.getFirstName()+"',"+"'"+c.getGender()+"',"+
            			"'"+c.getLastName()+"',"+"'"+c.getPassword()+"',"+"'"+c.getPhoneNumber()+"')");
            	 System.out.println(up);
            	int updateRowCount = up.executeUpdate();
            	 System.out.println(up);
            	 dataBaseConfig.closePreparedStatement(up);
            	
                
                //  System.out.println(res);
                if(updateRowCount>0) {
           
           // dataBaseConfig.closePreparedStatement(ps1);
            System.out.println(c);
            
            return true;}
            }
            
      
           
            	
            
        }catch (Exception ex){
           ex.printStackTrace();
        }finally {
            dataBaseConfig.closeConnection(con);
        }
        return false;
    }
}
