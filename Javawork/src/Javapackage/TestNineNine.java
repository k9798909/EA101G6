package Javapackage;

public class TestNineNine {
	public static void main(String[] args) {
	
		for(int x=1;x<=9;x++)
		{   int y=1;
			while(y<=9)
			{
				System.out.print(y+"*"+x+"="+x*y+" ");
				
				if(x*y<10)
				{System.out.print(" ");}//排版
				
				y++;
			}
			System.out.println("");
		}
		
		System.out.println("----------------------------");
//-----------------------------------------------------------------------
		for(int x=1;x<=9;x++)
		{   int y=1;
			
			do {
				System.out.print(y+"*"+x+"="+x*y+" ");
				
				if(x*y<10)
				{System.out.print(" ");}//排版
				
				y++;
			}
			while(y<=9);
			
			System.out.println("");
		}
		System.out.println("---------------------------");
//----------------------------------------------------------------------
		int x1=1;
		while(x1<=9)
		{	
			int y1=1;
			do {
				System.out.print(y1+"*"+x1+"="+x1*y1+" ");
		
				if(x1*y1<10)
				{System.out.print(" ");}
				y1++;
			}while(y1<=9);
			System.out.println("");
			x1++;
			
		}
	
	
	
	}

}
