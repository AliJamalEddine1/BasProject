package bas.Product.DBConstants;

public class DBConstat {

public static final String SELECT_PRODUCT_ID = "select * from product p where p.idp = ?";
public static final String SELECT_PRODUCT_CLIENTID = "select * from product p where p.clientid = ? ";
public static final String SELECT_PRODUCT_TYPE = "select * from product p where p.type = ?";
public static final String SELECT_PRODUCT_QUANTITY = "select * from product p where p.qty = ?";
public static final String SELECT_PRODUCT_PRICE = "select * from product p where p.price between ? and ?";
public static final String SELECT_PRODUCT_LOCATION= "select * from product p where p.location = ?";
public static final String SELECT_PRODUCT_DESCRIPTION = "select * from product p where p.description like ?";
public static final String SELECT_PRODUCT_YEAR = "select * from product p where p.yearOf between ? and ?";
}