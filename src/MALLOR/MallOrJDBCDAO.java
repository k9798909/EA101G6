package MALLOR;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MallOrJDBCDAO implements MallOrDAO_interface {

	private final String URL ="jdbc:oracle:thin:@localhost:1521:xe"; 
	private final String NAME ="EA101";
	private final String PSW ="123456";
	private final String SQLADD ="INSERT INTO MALLOR (MALLORNO,MBRNO,ORDATE,TAKE,ADDRESS,STATUS,PAYSTATUS,BOXSTATUS)"
			+ "VALUES(MALLORNO_SEQ.NEXTVAL,?,?,?,?,?,?,?)";
	private final String SQLUPDATE ="UPDATE MALLOR "
			+ "SET TAKE=?,ADDRESS=?,STATUS=?,PAYSTATUS=?,BOXSTATUS=?"
			+ "WHERE MALLORNO=?";
	private final String SQLDELETE="DELETE MALLOR WHERE MALLORNO=?";
	private final String SQLSELALL="SELECT * FROM MALLOR";
	private final String SQLSELBYMBR="SELECT * FROM MALLOR WHERE MBRNO=?";
	private final String SQLSELBYSTATUS="SELECT * FROM MALLOR WHERE STATUS=?";
	private final String SQLSELBYORNO="SELECT * FROM MALLOR WHERE MALLORNO=?";
	static{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void add(MallOrVO mallor) {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		PreparedStatement past = null;

		try {
			conn=DriverManager.getConnection(URL,NAME,PSW);
			
			conn.setAutoCommit(false);
			past=conn.prepareStatement(SQLADD);
			past.setInt(1,mallor.getMbrNo());
			past.setDate(2,mallor.getOrDate());
			past.setString(3,mallor.getTake());
			past.setString(4,mallor.getAddress());
			past.setInt(5,mallor.getStatus());
			past.setInt(6,mallor.getPayStatus());
			past.setInt(7,mallor.getBoxStatus());
			past.executeUpdate();
			conn.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			try {
				conn.setAutoCommit(true);
				if(past!=null)
					past.close();
				if(conn!=null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
		}
		
	}


	@Override
	public void update(MallOrVO mallor) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement past = null;
		
		try {
			conn = DriverManager.getConnection(URL,NAME,PSW);
			conn.setAutoCommit(false);
			past = conn.prepareStatement(SQLUPDATE);
			past.setString(1,mallor.getTake());
			past.setString(2,mallor.getAddress());
			past.setInt(3,mallor.getStatus());
			past.setInt(4,mallor.getPayStatus());
			past.setInt(5,mallor.getBoxStatus());
			past.setInt(6,mallor.getMallOrNo());
			past.executeUpdate();
			conn.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			try {
				conn.setAutoCommit(true);
				if(past!=null)
					past.close();
				if(conn!=null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
		
		
		
	}
	
	
	@Override
	public void delete(Integer mallOrNo) {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		PreparedStatement past = null;
		
		try {
			conn = DriverManager.getConnection(URL,NAME,PSW);
			conn.setAutoCommit(false);
			past = conn.prepareStatement(SQLDELETE);
			past.setInt(1,mallOrNo);
			past.executeUpdate();
			conn.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			try {
				conn.setAutoCommit(true);
				if(past!=null)
					past.close();
				if(conn!=null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
		
	}

	@Override
	public List<MallOrVO> getAll() {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		PreparedStatement past = null;
		ResultSet rs =null;
		List<MallOrVO> list =new ArrayList<MallOrVO>();
		try {
			conn = DriverManager.getConnection(URL,NAME,PSW);
			past = conn.prepareStatement(SQLSELALL);
			rs = past.executeQuery();
			
			while(rs.next()) {
				MallOrVO mallor = new MallOrVO();
				mallor.setMallOrNo(rs.getInt("MALLORNO"));
				mallor.setMbrNo(rs.getInt("MBRNO"));
				mallor.setOrDate(rs.getDate("ORDATE"));
				mallor.setTake(rs.getString("TAKE"));
				mallor.setAddress(rs.getString("ADDRESS"));
				mallor.setStatus(rs.getInt("STATUS"));
				mallor.setPayStatus(rs.getInt("PAYSTATUS"));
				mallor.setBoxStatus(rs.getInt("BOXSTATUS"));
				list.add(mallor);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				if(rs!=null)
					rs.close();
				if(past!=null)
					past.close();
				if(conn!=null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
		
		
		
	}

	@Override
	public List<MallOrVO> findByMbrNo(Integer mbrNo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement past = null;
		ResultSet rs =null;
		List<MallOrVO> list =new ArrayList<MallOrVO>();
		try {
			conn = DriverManager.getConnection(URL,NAME,PSW);
			past = conn.prepareStatement(SQLSELBYMBR);
			past.setInt(1, mbrNo);
			rs = past.executeQuery();
			
			while(rs.next()) {
				MallOrVO mallor = new MallOrVO();
				mallor.setMallOrNo(rs.getInt("MALLORNO"));
				mallor.setMbrNo(rs.getInt("MBRNO"));
				mallor.setOrDate(rs.getDate("ORDATE"));
				mallor.setTake(rs.getString("TAKE"));
				mallor.setAddress(rs.getString("ADDRESS"));
				mallor.setStatus(rs.getInt("STATUS"));
				mallor.setPayStatus(rs.getInt("PAYSTATUS"));
				mallor.setBoxStatus(rs.getInt("BOXSTATUS"));
				list.add(mallor);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				if(rs!=null)
					rs.close();
				if(past!=null)
					past.close();
				if(conn!=null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}

	@Override
	public List<MallOrVO> findByStatus(Integer status) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement past = null;
		ResultSet rs =null;
		List<MallOrVO> list =new ArrayList<MallOrVO>();
		try {
			conn = DriverManager.getConnection(URL,NAME,PSW);
			past = conn.prepareStatement(SQLSELBYSTATUS);
			past.setInt(1, status);
			rs = past.executeQuery();
			
			while(rs.next()) {
				MallOrVO mallor = new MallOrVO();
				mallor.setMallOrNo(rs.getInt("MALLORNO"));
				mallor.setMbrNo(rs.getInt("MBRNO"));
				mallor.setOrDate(rs.getDate("ORDATE"));
				mallor.setTake(rs.getString("TAKE"));
				mallor.setAddress(rs.getString("ADDRESS"));
				mallor.setStatus(rs.getInt("STATUS"));
				mallor.setPayStatus(rs.getInt("PAYSTATUS"));
				mallor.setBoxStatus(rs.getInt("BOXSTATUS"));
				list.add(mallor);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				if(rs!=null)
					rs.close();
				if(past!=null)
					past.close();
				if(conn!=null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}

	@Override
	public MallOrVO findByOrNo(Integer mallOrNo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement past = null;
		ResultSet rs =null;
		MallOrVO mallor=null;
		try {
			conn = DriverManager.getConnection(URL,NAME,PSW);
			past = conn.prepareStatement(SQLSELBYORNO);
			past.setInt(1, mallOrNo);
			rs = past.executeQuery();
			if(rs.next()) {
				mallor = new MallOrVO();
				mallor.setMallOrNo(rs.getInt("MALLORNO"));
				mallor.setMbrNo(rs.getInt("MBRNO"));
				mallor.setOrDate(rs.getDate("ORDATE"));
				mallor.setTake(rs.getString("TAKE"));
				mallor.setAddress(rs.getString("ADDRESS"));
				mallor.setStatus(rs.getInt("STATUS"));
				mallor.setPayStatus(rs.getInt("PAYSTATUS"));
				mallor.setBoxStatus(rs.getInt("BOXSTATUS"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				if(rs!=null)
					rs.close();
				if(past!=null)
					past.close();
				if(conn!=null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return mallor;
	}
	
	
	public static void main(String[] args) {
		MallOrVO mallor = new MallOrVO(0,1000,new java.sql.Date(new java.util.Date().getTime()),"便利商店","桃園市",0,
				0,0);
		MallOrVO mallor1 = new MallOrVO(1001,1000,new java.sql.Date(new java.util.Date().getTime()),"家","台北市",1,
				1,1);
		System.out.println(new java.sql.Date(new java.util.Date().getTime()));
		MallOrJDBCDAO mallordao = new MallOrJDBCDAO();
		mallordao.add(mallor);
		mallordao.update(mallor1);
		mallordao.delete(1005);
		System.out.println(mallordao.getAll());
		System.out.println(mallordao.findByMbrNo(1000));
		System.out.println(mallordao.findByStatus(0));
		System.out.println(mallordao.findByOrNo(1001).getTake());
		
	}
	
}
	
