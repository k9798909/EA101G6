package xxx;

import java.util.Scanner;

public class Homework_05 {
	public static void main(String[] args) {
		System.out.println("第一題請輸入寬與高");
		Scanner scanf =new Scanner(System.in);
		int width=scanf.nextInt();
		int height=scanf.nextInt();
		starSquare(width,height);
	//第一題--------------------------------------------------------	
		System.out.println("第二題本次亂數結果");
		randAvg();
	//第二題--------------------------------------------------------
		int[][] intnumber = {	{10,20,40,30,50},
				                {1,200,20,100,500} };
		double[][] doublenumber = {	{10.3,10.2,10.5,11.2,12.5},
                					{12.3,11.3,11.2,12.7,12.6}   };
		Homework_05 x =new Homework_05();
		System.out.println(x.maxElement(doublenumber));
		System.out.println(x.maxElement(intnumber));
	//第三題--------------------------------------------------------	
		
		
		
	}
	
	public static void starSquare(int width,int height) {
		for(int i=0 ; i<height ; i++) {
			for(int j=0 ; j<width ; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void randAvg() {
		int[] randnumber = new int[10];
		int sum=0; float avg=0f;
		for(int i=0;i<10;i++) {
			randnumber[i]=(int)(Math.random()*101);
			System.out.print(randnumber[i]+" ");
			sum+=randnumber[i];
		}
		avg=sum/randnumber.length;
		System.out.println("\n"+"平均數");
		System.out.println(avg);
		
	}

	public	static int maxElement(int[][] intarray) {
		int max=0;
		for(int i=0;i<intarray.length;i++) {
			for(int j=0;j<intarray[i].length;j++) {
				if(max<intarray[i][j])
					max=intarray[i][j];
			}
		}
		return max;
	}
	
	public static double maxElement(double[][] doublearray) {
		double max=0;
		for(int i=0;i<doublearray.length;i++) {
			for(int j=0;j<doublearray[i].length;j++) {
				if(max<doublearray[i][j])
					max=doublearray[i][j];
			}
		}
		return max;
	}
}

