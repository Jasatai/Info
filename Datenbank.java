import Java.sql.Connection; 
import Java.sql.DriverManager; 
import Java.sql.ResultSet; 
import Java.sql.Statement;

public class DBConnection { 
	private final String url = "jdbc:mysql://localhost:3306";
	private String user = "root"; 
	private String password = ""; 
	private String db = "example"; 
	private String command; 

public DBConnection (String text) {
	this.setCommand("SELECT * FROM mainexamples WHERE Name LIKE '%"+text+"%'");
}