package xxx;

import java.util.Scanner;

public class Homework_04 {
	public static void main(String[] args) {
		work01();
	System.out.println("---------------------------------------");
		work02();
	System.out.println("----------------------------------------");
		work03();
	System.out.println("---------------------------------------");
		Scanner scanf = new Scanner(System.in);
	System.out.println("請輸入要借的金錢");
		int inmoney=scanf.nextInt();
		work04(inmoney);
	System.out.println("---------------------------------------");
		//以下迴圈判斷輸入的2月是否有超過29天
		while(true) {
			System.out.println("請輸入西元年 月 日");
			int year=scanf.nextInt(),month=scanf.nextInt(),day=scanf.nextInt();
			if(month==2&&day>29)
				System.out.println("2月請不要輸入超過29天");
			else {
				work05(year,month,day);
			break;
			}
		}
	System.out.println("----------------------------------------");
		work06();
		
	
	}
	static void work01() {
		int[] number = {29,100,39,41,50,8,66,7,95,15};
		int sum=0;float average=0f;
		//算出總數
		for(int i=0 ; i<number.length;i++) {
			sum+=number[i];
		}
		average=sum/number.length;//算出平均值
		System.out.println("平均值:"+average);
		System.out.print("大於平均值的數:");
		//找出比平均值大的數
		for(int i=0 ; i<number.length;i++) {
			if(number[i]>average) 
				System.out.print(+number[i]+" ");
		}
		System.out.println("");
	}
	static void work02() {
		String helloworld ="Hello World";
		String answer=""; 
		//將字串重後面一個一個抓出來做存取
		for(int i=helloworld.length()-1 ;i>=0;i--) {
			
			answer+=helloworld.charAt(i);
		}
		System.out.println(answer);
	}
	
	static void work03() {
		String[] plant={"mercury", "venus", "earth","mars"
				, "jupiter", "saturn", "uranus", "neptune"};
		char[] a= {'a','e','i','o','u'};
		String sumplant="";
		int[] sum=new int[5];
		//把字串陣列都加起來成一個字串
		for(int i=0;i<plant.length;i++) {
			sumplant+=plant[i];
		}
		//以下這個迴圈功用是抓出相同字元的索引值，總數+1，再用找出的索引值+1，繼續找出下個索引值
		//直到找不到字元索引值會小於0迴圈結束
		for(int j=0 ;j<a.length;j++) {
			for(int i=sumplant.indexOf(a[j]);i>0;i=sumplant.indexOf(a[j],i+1)) {
					sum[j]+=1;
			}
		System.out.print(a[j]+"="+sum[j]+" ");//印出所有計算出來值
		}
		System.out.println();
	}
	
	static void work04(int inmoney) {
		int[][] money = {  {25,  32,  8,  19,  27},
		                   {2500,800,500,1000,1200}
		               					          };
		int sum=0;  
		System.out.print("有錢可借的員工編號:");
		//判斷員工的錢夠嗎
		for(int i=0;i<money[1].length;i++){
			if(inmoney<=money[1][i]) {
				System.out.print(money[0][i]+" ");
				sum++;
			}
		}
		System.out.println();
		System.out.println("共"+sum+"人");
	}

	
	
	
	static void work05(int year,int month,int day) {
		int[] monthday= {31,0,31,30,31,30,31,31,30,31,30,31};
		int totalday=0;
		String february="平年";
			//判斷是否為閏月如果是為29天
		if(year%100==0&&year%400!=0)		//  公元年分非4的倍數，為平年。
			monthday[1]=28;					//公元年分為4的的倍數但非100的倍數，為閏年。
		else if(year%4==0&&year%100!=0) {	//公元年分為100的倍數但非400的倍數，為平年。		
			monthday[1]=29;					//公元年分為400的倍數，為閏年。
			february="閏年";	}
		else  
			monthday[1]=28;
			for(int i=0; i<month-1;i++) {	//把要的月份找出來做家減
				totalday+=monthday[i];		//因為當月份沒過完所以month要減1
			}
			totalday+=day;
			
			System.out.println("西元"+year+"年"+february+"第"+totalday+"天");
	}
	
	static void work06() {	
		int[][] studenttest= {		{10,35,40,100,90,85,75,70},			
									{37,75,77,89,64,75,70,95},			
									{100,70,79,90,75,70,79,90},			
									{77,95,70,89,60,75,85,89},			
									{98,70,89,90,75,90,89,90},			
									{90,80,100,75,50,20,99,75}			};
		int[] max=new int[6];
		int[] highest = {1,1,1,1,1,1}; //因為號碼是從1開始所以初始值設1
		int[] student=new int[8];
			//以下陣列比大小把最大的找出來，如果不設初始值如果1號最大會顯示0
		for(int i=0; i<studenttest.length;i++) {
			max[i]=studenttest[i][0];		//max分數最大值初始值先設1號後面會再比較
			for(int j=0;j<studenttest[i].length-1;j++) {
				if(max[i]<studenttest[i][j+1]) {
				max[i]=studenttest[i][j+1];	//如果比max大就替換掉
				highest[i]=j+2;				//找出分數最高的號碼，因為迴圈是0開始
											//要找出號碼從1開始所以+1
				}							//而替換的數是後面一個所以再+1
			}								//j=+2
			
			int x = highest[i];		//x值=考最高分的號碼	，考最高分的號碼+1，因為之前號碼有+1的關係
			student[x-1]+=1;		//故這裡要陣列從0開始所以陣列內x要減-1
		}													
		for(int i=0;i<student.length;i++) {
		System.out.println(i+1+"號最高分考"+student[i]+"次");
		}
		
	}
	
	
	
	
	
}