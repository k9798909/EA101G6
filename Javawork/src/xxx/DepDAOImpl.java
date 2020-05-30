package xxx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepDAOImpl implements DepDAO_interface {
	private static final String URL ="jdbc:oracle:thin:@localhost:1521:xe";
	private static final String  USER="DAVID";
	private static final String  PW="123456";
	private static final String NAME ="oracle.jdbc.driver.OracleDriver";	
	private static final String SQLADD="INSERT INTO DEPARTMENT(DEPTNO,DNAME,LOC) VALUES (?,?,?)";
	private static final String SQLUPDATE="UPDATE DEPARTMENT SET DNAME=?,LOC=? WHERE DEPTNO=?";
	private static final String SQLDELETE="DELETE FROM DEPARTMENT WHERE DEPTNO = ? ";
	private static final String SQLSELECT="SELECT * FROM DEPARTMENT WHERE DEPTNO = ?";
	private static final String SQLALL="SELECT * FROM DEPARTMENT";
	static {
		try {
			Class.forName(NAME);
			System.out.println("驅動載入成功");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("驅動載入失敗");
		}
	}
	
	@Override
	public void add(DepVO dep) {
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con = DriverManager.getConnection(URL,USER,PW);
			System.out.println("連線建立成功");
			con.setAutoCommit(false);
			pst = con.prepareStatement(SQLADD);
			pst.setInt(1,dep.getDEPTNO());
			pst.setString(2,dep.getDNAME());
			pst.setString(3,dep.getLOC());
			System.out.println("成功新增"+pst.executeUpdate()+"筆");
			con.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}finally {
			
			try {
				con.setAutoCommit(true);
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

	@Override
	public void update(DepVO dep) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con = DriverManager.getConnection(URL,USER,PW);
			System.out.println("連線建立成功");
			con.setAutoCommit(false);
			pst = con.prepareStatement(SQLUPDATE);
			pst.setString(1,dep.getDNAME());
			pst.setString(2,dep.getLOC());
			pst.setInt(3,dep.getDEPTNO());
			System.out.println("成功更改"+pst.executeUpdate()+"筆");
			con.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}finally {
			
			try {
				con.setAutoCommit(true);
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

	@Override
	public void delete(int DEPINO) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con = DriverManager.getConnection(URL,USER,PW);
			System.out.println("連線建立成功");
			con.setAutoCommit(false);
			pst = con.prepareStatement(SQLDELETE);
			pst.setInt(1,DEPINO);
			System.out.println("成功刪除"+pst.executeUpdate()+"筆");
			con.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}finally {
			
			try {
				con.setAutoCommit(true);
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

	@Override
	public void findbyDEPINO(int DEPINO) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(URL,USER,PW);
			System.out.println("連線建立成功");
			con.setAutoCommit(false);
			pst = con.prepareStatement(SQLSELECT);
			pst.setInt(1,DEPINO);
			rs = pst.executeQuery(); 
			if(rs.next())
				System.out.println(" DEPTNO: "+rs.getInt(1)+" DNAME: "+rs.getString(2)+" LOC: "+rs.getString(3));
			else System.out.println("查無資料");
				
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally {
			
			try {
				rs.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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

	@Override
	public List<DepVO> getAll() {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs = null;
		List<DepVO> all = new ArrayList<DepVO>(); 
		try {
			con = DriverManager.getConnection(URL,USER,PW);
			System.out.println("連線建立成功");
			con.setAutoCommit(false);
			pst = con.prepareStatement(SQLALL);
			rs = pst.executeQuery(); 
			while(rs.next()) {
			all.add(new DepVO(rs.getInt(1),rs.getString(2),rs.getString(3)));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
					
		}finally {
			
			try {
				rs.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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
		
		
		
		return all;
	}

}
