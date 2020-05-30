package MALL;


import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MallJDBCDAO implements MallDAO_interface {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("載入驅動失敗");
		}
		
	}
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String NAME="EA101";
	private final String PSW="123456";
	private final String SQLADD="INSERT INTO MALL "
			+ "(COMMNO,COMMNAME,PRICE,QUANTITY,IMG,INTRO,AGE,PLAYER,STATUS) "
			+"VALUES(COMMNO_SEQ.NEXTVAL , ? , ? , ? , ? , ? , ? , ?, ?)";
	private final String SQLUPDATE="UPDATE MALL "
			+ "SET COMMNAME=?,PRICE=?,QUANTITY=?,IMG=?,INTRO=?,AGE=?,PLAYER=?,STATUS=? "
			+ "WHERE COMMNO=? ";
	private final String SQLDELETE="DELETE FROM MALL MALL WHERE COMMNO = ?";
	private final String SQLSELNAME="SELECT * FROM MALL WHERE COMMNAME LIKE ?";
	private final String SQLSELALL="SELECT * FROM MALL ORDER BY COMMNO";
	//查詢編號最後五筆等於最新五筆
	private final String SQLSELNEW="SELECT * FROM (SELECT * FROM MALL ORDER BY COMMNO DESC) WHERE ROWNUM <= 5";
	
	@Override
	public void add(MallVO mall) {
		// TODO Auto-generated method stub
		Connection conn =null;
		PreparedStatement past=null;
		try {
			conn=DriverManager.getConnection(URL,NAME,PSW);
			
			conn.setAutoCommit(false);
			past = conn.prepareStatement(SQLADD);
			past.setString(1,mall.getCommName());
			past.setInt(2,mall.getPrice());
			past.setInt(3,mall.getQuantity());
			past.setBytes(4,mall.getImg());
			past.setString(5,mall.getIntro());
			past.setString(6,mall.getAge());
			past.setString(7,mall.getPlayer());
			past.setInt(8,mall.getStatus());
			
			past.executeUpdate();
			conn.commit();
			
		}catch(SQLException e){
			e.getMessage();
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}finally {
			
			try {
				conn.setAutoCommit(true);
				if(past!=null)
					past.close();
				if(conn!=null)
					conn.close();
			}catch(SQLException e1){
				e1.printStackTrace();
			}
			
		}
		
	}
	

	@Override
  	public void update(MallVO mall) {
		// TODO Auto-generated method stub
		Connection conn = null ;
		PreparedStatement past = null;
		try {
			conn = DriverManager.getConnection(URL,NAME,PSW);
			
			conn.setAutoCommit(false);
			past =conn.prepareStatement(SQLUPDATE);
			past.setString(1,mall.getCommName());
			past.setInt(2,mall.getPrice());
			past.setInt(3,mall.getQuantity());
			past.setBytes(4,mall.getImg());
			past.setString(5,mall.getIntro());
			past.setString(6,mall.getAge());
			past.setString(7,mall.getPlayer());
			past.setInt(8,mall.getStatus());
			past.setInt(9,mall.getCommNo());
			
			past.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			
			try {
				conn.setAutoCommit(true);
				if(past!=null)
					past.close();
				if(conn!=null)
					conn.close();
			}catch(SQLException e1){
				e1.printStackTrace();
			}
			
		}
		
	}
	
	
	@Override
	public void delete(Integer commno) {
		// TODO Auto-generated method stub
		Connection conn = null ;
		PreparedStatement past = null ;
		try {
			conn = DriverManager.getConnection(URL,NAME,PSW);
			
			conn.setAutoCommit(false);
			past = conn.prepareStatement(SQLDELETE);
			past.setInt(1,commno);
			past.executeUpdate();
			
			conn.commit();
		}catch(SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			
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
	public List<MallVO> findByName(String name) {
		// TODO Auto-generated method stub
		List<MallVO> list = new ArrayList<MallVO>();
		Connection conn=null;
		PreparedStatement past =null;
		ResultSet rs = null;
		try {
			conn=DriverManager.getConnection(URL,NAME,PSW);
			past=conn.prepareStatement(SQLSELNAME);
			past.setString(1,"%"+name+"%");
			rs = past.executeQuery();
			while(rs.next()) {
			MallVO mall = new MallVO();	
			mall.setCommNo(rs.getInt("COMMNO"));
			mall.setCommName(rs.getString("COMMNAME"));
			mall.setPrice(rs.getInt("PRICE"));
			mall.setQuantity(rs.getInt("QUANTITY"));
			mall.setImg(rs.getBytes("IMG"));
			mall.setIntro(rs.getString("INTRO"));
			mall.setAge(rs.getString("AGE"));
			mall.setPlayer(rs.getString("PLAYER"));
			mall.setStatus(rs.getInt("STATUS"));
			list.add(mall);
			}
			 
		}catch(SQLException e) {
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
	public List<MallVO> getAll() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement past = null;		
		ResultSet rs = null;
		List<MallVO> list = new ArrayList<MallVO>();
		try {
			conn=DriverManager.getConnection(URL,NAME,PSW);
			past = conn.prepareStatement(SQLSELALL);
			rs=past.executeQuery();
			while(rs.next()) {
				MallVO mall = new MallVO();	
				mall.setCommNo(rs.getInt("COMMNO"));
				mall.setCommName(rs.getString("COMMNAME"));
				mall.setPrice(rs.getInt("PRICE"));
				mall.setQuantity(rs.getInt("QUANTITY"));
				mall.setImg(rs.getBytes("IMG"));
				mall.setIntro(rs.getString("INTRO"));
				mall.setAge(rs.getString("AGE"));
				mall.setPlayer(rs.getString("PLAYER"));
				mall.setStatus(rs.getInt("STATUS"));
				list.add(mall);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
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
	public List<MallVO> getNew() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement past = null;		
		ResultSet rs = null;
		List<MallVO> list = new ArrayList<MallVO>();
		try {
			conn=DriverManager.getConnection(URL,NAME,PSW);
			past = conn.prepareStatement(SQLSELNEW);
			rs=past.executeQuery();
			while(rs.next()) {
				MallVO mall = new MallVO();	
				mall.setCommNo(rs.getInt("COMMNO"));
				mall.setCommName(rs.getString("COMMNAME"));
				mall.setPrice(rs.getInt("PRICE"));
				mall.setQuantity(rs.getInt("QUANTITY"));
				mall.setImg(rs.getBytes("IMG"));
				mall.setIntro(rs.getString("INTRO"));
				mall.setAge(rs.getString("AGE"));
				mall.setPlayer(rs.getString("PLAYER"));
				mall.setStatus(rs.getInt("STATUS"));
				list.add(mall);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
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
	

	
	public static void main(String[] args) {
		byte[] img =null ;
		try {
			FileInputStream in =new FileInputStream(new File("img/dog.jpg"));
			BufferedInputStream bufin =new BufferedInputStream(in);
			byte[] buffer = new byte[2048];
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			
			while(bufin.read(buffer,0,2048)!=-1) 
				baos.write(buffer);
				
			img =baos.toByteArray();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		MallVO malladd = new MallVO(0,"狼人殺",5000,100,img,"超好玩超好玩","10歲以上" ,"4人",0);
		MallJDBCDAO malldao = new MallJDBCDAO();
//		malldao.add(malladd);
//		
//		MallVO mall2 = new MallVO(1001,"哈哈哈哈",5000,100,img,"超好玩超好玩","10歲以上" ,"4人",0);
//		malldao.update(mall2);
//		
//		malldao.delete(1003);
		
		List<MallVO> list =malldao.findByName("狼");
		for(MallVO mall : list) {
			System.out.print(mall.getCommNo()+" "+mall.getCommName()+" "+mall.getIntro()+" "+mall.getImg()+"\n");
			try {
				FileOutputStream file = new FileOutputStream("img/123.jpg");
				if(mall.getImg()!=null)
					file.write(mall.getImg());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	
	
}
