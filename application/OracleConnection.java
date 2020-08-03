package LibraryManagementSystem;
import java.sql.*;  
class OracleCon{  
public static Connection connectOracle(){  
try{  
//step1 load the driver class  
Class.forName("oracle.jdbc.driver.OracleDriver");  
//step2 create  the connection object  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:xe","adna","adnatifa");  
return con;
}
catch(Exception e){ 
	System.out.println(e);
}  
  return null;
}
}  