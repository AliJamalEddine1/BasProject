package bas.Product.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import bas.Product.DBConstants.DBConstat;
import bas.Product.DataBaseConfig.DataBaseConfig;
import bas.Product.model.Product;

@Service
public class ProductService {


    public DataBaseConfig dataBaseConfig = new DataBaseConfig();


    public Product searchId(int id){
        //search By ID
        Connection con = null;
        try {
            con = dataBaseConfig.getConnection();
            PreparedStatement ps = con.prepareStatement(DBConstat.SELECT_PRODUCT_ID);
            ps.setInt(1, id);
            System.out.println(ps);
            ResultSet result = ps.executeQuery();
            System.out.println(result);
            if(result.next()) {
            	
            	return new Product(Integer.parseInt(result.getString("idp")),Integer.parseInt(result.getString("client_id"))
            			,result.getString("description"),result.getString("image"),result.getString("location")
            			,Double.parseDouble(result.getString("price")),Integer.parseInt(result.getString("quantity")),
            			result.getString("type"),result.getString("year_of"));
            }
            dataBaseConfig.closePreparedStatement(ps);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            dataBaseConfig.closeConnection(con);
        }
        return null;
    }
    public List<Product> searchClientId(int client){
        //search by client id 
        Connection con = null;
        List<Product> p=new ArrayList<Product>();
        try {
            con = dataBaseConfig.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from product where client_id="+"'"+client+"'");
           
            ResultSet result = ps.executeQuery();
           
            while(result.next()) {
            	p.add(new Product(Integer.parseInt(result.getString("idp")),Integer.parseInt(result.getString("client_id"))
            			,result.getString("description"),result.getString("image"),result.getString("location")
            			,Double.parseDouble(result.getString("price")),Integer.parseInt(result.getString("quantity")),
            			result.getString("type"),result.getString("year_of")));
            }
            dataBaseConfig.closePreparedStatement(ps);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            dataBaseConfig.closeConnection(con);
            
        }
        return p;
    }
    public List<Product> searchType(String type){
        //search by type 
    	   Connection con = null;
           List<Product> p=new ArrayList<Product>();
           try {
               con = dataBaseConfig.getConnection();
               PreparedStatement ps = con.prepareStatement(DBConstat.SELECT_PRODUCT_TYPE);
               ps.setString(1,type);
               ResultSet result = ps.executeQuery();
               dataBaseConfig.closePreparedStatement(ps);
               
               while(result.next()) {
               	p.add(new Product(Integer.parseInt(result.getString("idp")),Integer.parseInt(result.getString("client_id"))
            			,result.getString("description"),result.getString("image"),result.getString("location")
            			,Double.parseDouble(result.getString("price")),Integer.parseInt(result.getString("quantity")),
            			result.getString("type"),result.getString("year_of")));
               }
           }catch (Exception ex){
               ex.printStackTrace();
           }finally {
               dataBaseConfig.closeConnection(con);
               
           }
           return p;
    }
    public List<Product> searchPrice(double price1,double price2){
        //search by price 
  	   Connection con = null;
       List<Product> p=new ArrayList<Product>();
       try {
           con = dataBaseConfig.getConnection();
           PreparedStatement ps = con.prepareStatement(DBConstat.SELECT_PRODUCT_PRICE);
           ps.setDouble(1,price1);ps.setDouble(2, price2);
           ResultSet result = ps.executeQuery();
           dataBaseConfig.closePreparedStatement(ps);
          
           while(result.next()) {
           	p.add(new Product(Integer.parseInt(result.getString("idp")),Integer.parseInt(result.getString("client_id"))
        			,result.getString("description"),result.getString("image"),result.getString("location")
        			,Double.parseDouble(result.getString("price")),Integer.parseInt(result.getString("quantity")),
        			result.getString("type"),result.getString("year_of")));
           }
       }catch (Exception ex){
           ex.printStackTrace();
       }finally {
           dataBaseConfig.closeConnection(con);
           
       }
       return p;
    }
    public List<Product> searchQuantity(int qty){
        //search by quantity 
        Connection con = null;
        List<Product> p=new ArrayList<Product>();
        try {
            con = dataBaseConfig.getConnection();
            PreparedStatement ps = con.prepareStatement(DBConstat.SELECT_PRODUCT_QUANTITY);
            ps.setInt(1,qty);
            ResultSet result = ps.executeQuery();
            dataBaseConfig.closePreparedStatement(ps);
       
            while(result.next()) {
            	p.add((new Product(Integer.parseInt(result.getString("idp")),Integer.parseInt(result.getString("client_id"))
            			,result.getString("description"),result.getString("image"),result.getString("location")
            			,Double.parseDouble(result.getString("price")),Integer.parseInt(result.getString("quantity")),
            			result.getString("type"),result.getString("year_of"))));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            dataBaseConfig.closeConnection(con);
            
        }
        return p;
    }
    public List<Product> searchLocation(String loc){
        //search by location
 	   Connection con = null;
       List<Product> p=new ArrayList<Product>();
       try {
           con = dataBaseConfig.getConnection();
           PreparedStatement ps = con.prepareStatement(DBConstat.SELECT_PRODUCT_LOCATION);
           ps.setString(1,loc);
           ResultSet result = ps.executeQuery();
           dataBaseConfig.closePreparedStatement(ps);
        
           while(result.next()) {
           	p.add(new Product(Integer.parseInt(result.getString("idp")),Integer.parseInt(result.getString("client_id"))
        			,result.getString("description"),result.getString("image"),result.getString("location")
        			,Double.parseDouble(result.getString("price")),Integer.parseInt(result.getString("quantity")),
        			result.getString("type"),result.getString("year_of")));
           }
       }catch (Exception ex){
           ex.printStackTrace();
       }finally {
           dataBaseConfig.closeConnection(con);
           
       }
       return p;
    }
    public List<Product> searchDescription(String desc ){
        //search by description 
 	   Connection con = null;
       List<Product> p=new ArrayList<Product>();
       try {
           con = dataBaseConfig.getConnection();
           PreparedStatement ps = con.prepareStatement(DBConstat.SELECT_PRODUCT_DESCRIPTION);
           ps.setString(1,desc);
           ResultSet result = ps.executeQuery();
           dataBaseConfig.closePreparedStatement(ps);

           while(result.next()) {
           	p.add(new Product(Integer.parseInt(result.getString("idp")),Integer.parseInt(result.getString("client_id"))
        			,result.getString("description"),result.getString("image"),result.getString("location")
        			,Double.parseDouble(result.getString("price")),Integer.parseInt(result.getString("quantity")),
        			result.getString("type"),result.getString("year_of")));
           }
       }catch (Exception ex){
           ex.printStackTrace();
       }finally {
           dataBaseConfig.closeConnection(con);
           
       }
       return p;
       
    }
    public List<Product> searchYear(String year ,String year1){
        //search by year 
 	   Connection con = null;
       List<Product> p=new ArrayList<Product>();
       try {
           con = dataBaseConfig.getConnection();
           PreparedStatement ps = con.prepareStatement(DBConstat.SELECT_PRODUCT_YEAR);
           ps.setString(1,year);ps.setString(2,year1);
           ResultSet result = ps.executeQuery();
           dataBaseConfig.closePreparedStatement(ps);
     
           while(result.next()) {
           	p.add(new Product(Integer.parseInt(result.getString("idp")),Integer.parseInt(result.getString("client_id"))
        			,result.getString("description"),result.getString("image"),result.getString("location")
        			,Double.parseDouble(result.getString("price")),Integer.parseInt(result.getString("quantity")),
        			result.getString("type"),result.getString("year_of")));
           }
       }catch (Exception ex){
           ex.printStackTrace();
       }finally {
           dataBaseConfig.closeConnection(con);
           
       }
       return p;
    }
    public List<Product> search(String s){
        //search 
 	   Connection con = null;
       List<Product> p=new ArrayList<Product>();
       try {
           con = dataBaseConfig.getConnection();
           PreparedStatement ps = con.prepareStatement("select * from product where forSerach LIKE %"+s+"% INNER JOIN attachment ON product.idP = attachment.productId");
           ResultSet result = ps.executeQuery();
           dataBaseConfig.closePreparedStatement(ps);
     
           while(result.next()) {
           	p.add(new Product(Integer.parseInt(result.getString("idp")),Integer.parseInt(result.getString("client_id"))
        			,result.getString("description"),result.getString("image"),result.getString("location")
        			,Double.parseDouble(result.getString("price")),Integer.parseInt(result.getString("quantity")),
        			result.getString("type"),result.getString("year_of")));
           }
       }catch (Exception ex){
           ex.printStackTrace();
       }finally {
           dataBaseConfig.closeConnection(con);
           
       }
       return p;
    }
}
