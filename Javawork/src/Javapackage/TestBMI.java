package Javapackage;
import java.text.DecimalFormat;//加入四捨五入到小數點第二位套件
import java.util.Arrays;

public class TestBMI {
	
	 public int test1,test2;
	
	public static void main(String[] args){
	
		Integer x =new Integer(10);
		Integer y =new Integer(10);
		int z =10;
		TestBMI xxx =new TestBMI();
		TestBMI yyy =new TestBMI();
		xxx.test1=10;
		yyy.test1=10;
		System.out.println(xxx==yyy);
		System.out.println();
		
		
	}
	
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.out.println("垃圾車來瞜");
	}
	
}
