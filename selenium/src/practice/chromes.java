package practice;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;





public class chromes {

	public static void main(String[] args) throws SQLException  {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D://sel_workspace//chromedriver_win32//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in/?gfe_rd=cr&dcr=0&ei=RdnSWuHWFKOwX6OVhfgM");
		String host="localhost";

		String port= "3306";
		
		Connection con=DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/QADB", "root", "root");
		Statement s=con.createStatement();

		ResultSet rs=s.executeQuery("select * from Empinfo");

		while(rs.next())

		{

			System.out.println(rs.getString("name"));

		}
	
	}
}
