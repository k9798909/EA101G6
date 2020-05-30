package xxx;

import java.io.File;

public class Homework_01 {
	
	public static void main(String[] args)
	{	
		
		//---1
		int a=12 , b=6;
		int sum1=a+b,sum2=a*b;
		System.out.println("和:"+sum1 + "  積:" +sum2);
		//---2---------------------------------------
		int egg=200,dozen=12;
		System.out.println("雞蛋一共"+(egg/dozen)+"打"+(egg%dozen)+"顆");
		//---3------------------------------------
		int total=256559;
		int day,hour,minute,second ;
		day=total/(24*60*60);//算幾天
		hour=total%(24*60*60)/(60*60);//算小時用剩下的秒來算
		minute=total%(24*60*60)%(60*60)/60;//算分用剩下的秒來算
		second=total%(24*60*60)%(60*60)%60;//算剩下的秒
		System.out.println(day+"天 "+hour+"時"+minute+"分"+second+"秒");
	//-------4---------------------------------
		final double Pi=3.1415;
		double radius =5;//半徑
		System.out.println("圓周長="+ (radius*2*Pi) +"  圓面積="+(radius*radius*Pi));
	//-------5----------------------------------	
		double money=1500000; 
		double interest=0.02;
		for(int i=1 ; i<=10 ;i++)//
		{	money=money*(1+interest); 	
			//System.out.println("第"+i+"年"+money);
		}
		System.out.println("十年後本金+利息有"+money);
	//-------6-------------------1865061
		
		System.out.println(5+5);//單純的整數加減
		System.out.println(5+'5');//會把字元換算成十進位在做加減，而字元5的十進位為53
		System.out.println(5+"5");//數字+字串則會變成字串5在接上一個字串的5而不是做數字的加減
		
		
	}
	
	
}
