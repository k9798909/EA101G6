package Loginintest;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestMenberDAOImpl implements TestMenberDAO_interface  {
	private static String driver="oracle.jdbc.driver.OracleDriver";
	private String URL ="jdbc:oracle:thin:@localhost:1521:xe";
	private String name ="DAVID";
	private String psw ="123456";
	private String SQLADD="INSERT INTO TESTMENBER"
			+ "(USERID,USERACCOUNT,USERPASSWORD,USERNAME,USERGENDER,USERMAIL,USERADDRESS,USERIDCARD,USERPHONE,USERBIRTHDAY)"
			+ "VALUES(TESTAUTOUSERID.NEXTVAL,?,?,?,?,?,?,?,?,?)";
	
	private String SQLSELECT="SELECT * FROM TESTMENBER WHERE USERACCOUNT = ? ";
	private String SQLSELECTALL="SELECT * FROM TESTMENBER";
	private String SQLDELETE="DELETE FROM TESTMENBER WHERE USERACCOUNT = ?";
	private String SQLUPDATE="UPDATE TESTMENBER SET "
			+ "USERACCOUNT = ?,USERPASSWORD = ?,USERNAME = ?,USERGENDER = ?,USERMAIL = ?,USERADDRESS = ?,USERIDCARD = ?,USERPHONE = ?,USERBIRTHDAY = TO_DATE(?,'yyyy-mm-dd')"
			+ " WHERE USERACCOUNT = ?";
	

	static {
		//到時改連線池
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}
	
	@Override
	public String add(TestMenberVO TestMenber) {
		// TODO Auto-generated method stub
		
		Connection con = null;
		ResultSet res=null;
		PreparedStatement pst = null;
		
		try {
			con=DriverManager.getConnection(URL,name,psw);
			con.setAutoCommit(false);
			pst = con.prepareStatement(SQLADD);
			int i=1;
			for(String str : TestMenber.getAll()) {
				System.out.println(str);
				if(i==9 && !(str.equals(""))) {
					Date date =Date.valueOf(str);
					pst.setDate(i,date);
					break;
				}
				pst.setString(i,str);
				i++;
				
			}
			
			pst.executeUpdate();
			con.commit();
			return "新增成功";
		} catch (SQLException  | IllegalArgumentException |NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			try {
				con.rollback();
				return "新增失敗";
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}finally {
			try {
				con.setAutoCommit(true);
				if(pst!=null)
					pst.close();
				
				if(con!=null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "不會執行到這一行";
	}

	
	@Override
	public void update(TestMenberVO TestMenber) {
		// TODO Auto-generated method stub
		Connection con = null ;
		PreparedStatement pst = null;
		List<String> list = new ArrayList<String>();
		try{
			con=DriverManager.getConnection(URL,name,psw);
			con.setAutoCommit(false);
			pst=con.prepareStatement(SQLUPDATE);
			list = TestMenber.getAll();
			
			int i=1;
				for(String str : list) {
					pst.setString(i,str);
					i++;
				}
			
			
			pst.setString(10,TestMenber.getUseraccount());
			
			pst.executeUpdate();
			
			con.commit();
		}catch(SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.getMessage();
			e.getStackTrace();
		}finally {
			
			try{
				con.setAutoCommit(true);
				if(pst != null)
					pst.close();
				if(con!=null)
					con.close();
			}catch(SQLException e) {
				e.getStackTrace();
			}
			
		}
	}

	@Override
	public void delete(String userAccount) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con =DriverManager.getConnection(URL,name,psw);
			con.setAutoCommit(false);
			pst = con.prepareStatement(SQLDELETE);
			pst.setString(1,userAccount);
			pst.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				con.setAutoCommit(true);
				if(pst!=null)
					pst.close();
				if(con!=null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public TestMenberVO findByuserAccount(String userAccount) {
		// TODO Auto-generated method stub
		
		Connection con = null;
		ResultSet res=null;
		PreparedStatement pst = null;
		
		try {
			con=DriverManager.getConnection(URL,name,psw);
			
			pst = con.prepareStatement(SQLSELECT);
			pst.setString(1,userAccount);
			res = pst.executeQuery();
			String[] str = new String[9];
			while(res.next()) {
				for(int i=2 ; i<11 ; i++) {
					str[i-2]=res.getString(i);
				}
			}
			return new TestMenberVO(str);
		}catch(SQLException e){
			e.getStackTrace();
			e.getMessage();
			
		}finally {
			try {
				if(pst!=null)
					pst.close();
				if(con!=null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}							
		
		return null;
	}

	@Override
	public List<TestMenberVO> getAll() {
		// TODO Auto-generated method stub
		Connection con = null;
		ResultSet res=null;
		PreparedStatement pst = null;
		List<TestMenberVO> list = new ArrayList<TestMenberVO>() ;
		try {
			con=DriverManager.getConnection(URL,name,psw);
			
			pst = con.prepareStatement(SQLSELECTALL);
			res = pst.executeQuery();
			while(res.next()) {
				String[] str = new String[9];
				for(int i=2 ; i<11 ; i++) {
					str[i-2]=res.getString(i);
				}
				list.add(new TestMenberVO(str));
			}
			
			return list;
		}catch(SQLException e){
			e.getStackTrace();
			e.getMessage();
			
		}finally {
			try {
				
				if(pst!=null)
					pst.close();
				if(con!=null)
					con.close();
				return list;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;							
		
	}
	
//	public static void main(String[] args) {
//		TestMenberDAOImpl dao = new TestMenberDAOImpl();
//		/*TestMenberVO tst =dao.findByuserAccount("David");
//		System.out.println(tst.getUserpassword());*/
//		//dao.delete("1");
//		List<TestMenberVO> list=dao.getAll();
//		for(TestMenberVO vo : list ) {
//			List<String> liststr =vo.getAll();
//			for(String str : liststr ) {
//				System.out.print(str+" ");
//			}
//			System.out.println();
//		}
//		TestMenberVO vo = new TestMenberVO("ddd","654321","兮兮兮","男","123@dsakjdiasd","資策會","z789456","09188494","1996-10-03");
//		vo.setName("哈哈哈");
//		dao.update(vo);
//		//dao.add(vo);
//		
//		
//	}


}