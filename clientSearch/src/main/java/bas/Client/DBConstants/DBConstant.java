package bas.Client.DBConstants;

public class DBConstant {


    public static final String SELECT_CLIENT_ID = "select * from client p where id = ? ";
    public static final String SELECT_CLIENT_FIRST_NAME = "select * from client p where first_name = ?";
    public static final String SELECT_CLIENT_LAST_NAME = "select * from client p where last_name = ?";
    public static final String SELECT_CLIENT_GENDER = "select * from client p where gender = ?";
    public static final String SELECT_CLIENT_PHONE_NUMBER= "select * from client p where phone_number = ? ";
    public static final String SELECT_CLIENT_EMAIL = "select * from client p where p.email = ? and p.password=? ";
}
