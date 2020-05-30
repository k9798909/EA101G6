package xxx;

import java.io.Serializable;

public class DepVO implements Serializable {
	
	private int DEPTNO ;
	private String DNAME;
	private String LOC;
	
	public DepVO() {}
	
	public DepVO(int DEPTNO , String DNAME , String LOC ) {
		this.DEPTNO = DEPTNO ;
		this.DNAME = DNAME;
		this.LOC = LOC;
	}
	
	public void setDEPINO(int DEPINO) {
		this.DEPTNO = DEPTNO ;
	}
	
	public void DNAME(String DNAME) {
		this.DNAME = DNAME ;
	}
	
	public void setLOC(String LOC) {
		this.LOC = LOC ;
	}
	
	public int getDEPTNO() {
		return this.DEPTNO ;
	}
	
	public String getDNAME() {
		return this.DNAME ;
	}
	
	public String getLOC() {
		return this.LOC ;
	}
	
}
