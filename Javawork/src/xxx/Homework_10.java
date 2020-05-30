package xxx;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;



public class Homework_10 {
	public static void main(String[] args) {
		
		work1();
		System.out.println("------------------");
		//------------
		Scanner sc=null;
		
		while(true) {
			try {
				sc= new Scanner(System.in);
				System.out.println("請輸入數字:");
				double number = sc.nextDouble();
				System.out.println("選擇要用哪種表示方法，1千分位、2百分比、3科學記號 :");
				int showtype = sc.nextInt();
				if(showtype>3||showtype<1) {
					throw new InputMismatchException();
				}
				work2(number,showtype);
				break;
			}catch(InputMismatchException e) {
				System.out.println("格式輸入不正確");
			}
		}
		System.out.println("--------------");
		//------第3題------------
		while(true) {
			
			sc= new Scanner(System.in);
			
			System.out.println("請輸入日期例:20200329");
			String date=sc.next();
			//防呆沒有做很好
			if(date.matches("\\d{4}[01]\\d[0123]\\d")){
				
				System.out.println("要輸出格式(1)年/月/日(2)月/日/年(3)日/月/年三選一");
				String type=sc.next();
			
				if(type.matches("[123]")){ 
					//把各自要對應的東西取出來
					String year = date.substring(0,4);
					String month = date.substring(4,6);
					String day = date.substring(6,8);
					//把type轉乘int好用switch比較
					int ty = Integer.parseInt(type);
				
					switch(ty) {
					case 1 :			//%s字串
						System.out.printf("%s/%s/%s",year,month,day);
						break;
					case 2 :
						System.out.printf("%s/%s/%s",month,day,year);
						break;
					case 3 :
						System.out.printf("%s/%s/%s",day,month,year);
						break;	
					}
				
				break;
			   }
			}
			System.out.println("格式不正確請重新輸入");
		}
		sc.close();
	//------------------------------------------------	
		
	}
	
	public static void work1() {
		//TreeSet不重複由小到大
		Set<Integer> rannumber = new TreeSet<Integer>();
		//加入5個亂數
		while(rannumber.size()<5) {
			rannumber.add((int)(Math.random()*100+1));
		}
		//用加強行迴圈把值顯示出來，再用isPrime()判斷是不是質數
		for(int show : rannumber) {
			System.out.println(show+" "+(isPrime(show) ? "是質數":"不是質數"));
		}
	}
	
	
	
	public static boolean isPrime (int rannumber) {
		boolean re = true;
		//如果是1直接回傳false，不是質數
		if (rannumber==1) {
			return false;
		}
			//如果能被整除就把boolean改成false並結束迴圈，代表不是質數。
		for(int i=2;i<rannumber;i++) {
			if(rannumber%i==0) {
				re = false;
				break;
			}
		}
		
		return re;
		
	}

	
	public static void work2(double number , int showtype) {
		
		switch(showtype) {
			case 1 :
				//#一個任意數字
				Format form1 = new DecimalFormat("#,###.##");
				System.out.println(form1.format(number));
				break;
			case 2 :
				//#一個任意數字  %乘以100並顯示為百分比
				Format form2 = new DecimalFormat("#%");
				System.out.println(form2.format(number));
				break;
			case 3 ://%E科學記號表示
				System.out.printf("%E",number);
				break;	
		}
		
	}

	
	
}
