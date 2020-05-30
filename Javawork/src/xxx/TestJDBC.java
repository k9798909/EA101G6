package xxx;

import java.util.List;
import java.util.Scanner;

public class TestJDBC {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("請選擇要的動作 1:增 2:改 3:刪 4:查 5:查全部");
		int se = sc.nextInt();
		switch(se){
		case 1 :
		System.out.println("請輸入DEPTNO");
		int DEPTNO=sc.nextInt();
		sc.nextLine();
		System.out.println("請輸入DNAME");
		String DNAME=sc.nextLine();
		
		System.out.println("請輸入LOC");
		String LOC=sc.nextLine();
		
		DepVO dep = new DepVO(DEPTNO,DNAME,LOC);
		DepDAO_interface depdao = new DepDAOImpl();
		
		depdao.add(dep);
		sc.close();
		dep=null;
		depdao=null;
		break;
		
		case 2 :
			System.out.println("請輸入要改的DEPTNO");
			int DEPTNO2=sc.nextInt();
			sc.nextLine();
			System.out.println("請輸入DNAME要改的值");
			String DNAME2=sc.nextLine();
			
			System.out.println("請輸入LOC要改的值");
			String LOC2=sc.nextLine();
			
			DepVO dep2 = new DepVO(DEPTNO2,DNAME2,LOC2);
			DepDAO_interface depdao2 = new DepDAOImpl();
			
			depdao2.update(dep2);
			sc.close();
			dep2=null;
			depdao2=null;
			break;
			
		case 3 :
			System.out.println("請輸入要刪除的DEPTNO");
			int DEPTNO3=sc.nextInt();
			
			DepVO dep3 = new DepVO(DEPTNO3,"0","0");
			DepDAO_interface depdao3 = new DepDAOImpl();
			
			depdao3.delete(dep3.getDEPTNO());
			sc.close();
			dep3=null;
			depdao3=null;
			break;
			
		case 4 :
			System.out.println("請輸入要查詢的DEPTNO");
			int DEPTNO4=sc.nextInt();
			
			DepVO dep4 = new DepVO(DEPTNO4,"0","0");
			DepDAO_interface depdao4 = new DepDAOImpl();
			
			depdao4.findbyDEPINO(dep4.getDEPTNO());
			sc.close();
			dep4=null;
			depdao4=null;
			break;
			
		case  5:
			List<DepVO> all =null;
			DepDAO_interface depdao5 = new DepDAOImpl();
			all = depdao5.getAll();
			for(DepVO show : all) {
				System.out.println("DEPTNO:"+show.getDEPTNO());
				System.out.println("DNAME:"+show.getDNAME());
				System.out.println("LOC:"+show.getLOC());
				System.out.println();
			}
			break;
		
		
		
		}
	}
}
