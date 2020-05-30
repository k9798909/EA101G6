package xxx;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest {
	private static final String NAME ="oracle.jdbc.driver.OracleDriver";
	private static final String URL ="jdbc:oracle:thin:@localhost:1521:xe";
	private static final String  USER="DAVID";
	private static final String  PW="123456";
	private static final String SQL="SELECT ID,NAME,PASSWORD FROM MEMBER";
	private static final String SQLADD="INSERT INTO MEMBER (ID,NAME,PASSWORD) VALUES('3','321@ACC.COM','333') ";
	private static final String SQLDEL="DELETE FROM MEMBER WHERE ID = '4'";
	private static final String SQLD="INSERT INTO MEMBER (ID,NAME,PASSWORD) VALUES(?,?,?)";
	static{
		try {
		Class.forName(NAME);
		System.out.println("驅動載入成功");
	} catch (ClassNotFoundException e) {
		//驅動載入成功
		System.out.println("驅動載入失敗");
	}
		}
	
	public static void main(String[] args) {
		//建立連線--------------------------------------------------------
		Connection con = null;
		PreparedStatement pst = null;
		Statement sta = null; 
		
		try {
			con = DriverManager.getConnection(URL,USER,PW);
			System.out.println("建立連線成功");
		//---------------------------------------------------------------	
//			//先創建陳述
			sta=con.createStatement();
			pst = con.prepareStatement(SQLDEL);
//			pst.setInt(1,5);
//			pst.setString(2,"HAHA");
//			pst.setString(3,"YYY@");
//			System.out.println("成功更新"+sta.executeUpdate(SQLDEL)+"筆");
			System.out.println("成功更新"+pst.executeUpdate()+"筆");

			
			
			//查詢物件創立			用執行查詢方法
			ResultSet res = sta.executeQuery(SQL);
			while(res.next()) {
				System.out.println(res.getInt(1));
				System.out.println(res.getString(2));
				System.out.println(res.getString(3));
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				sta.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		
		
	}
}
