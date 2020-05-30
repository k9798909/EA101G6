package xxx;

//------------------------------以下為work01的class----------------------
class Man{
		
	private String name;
	
	public Man() {}
	public Man(String name) {
			this.name=name;
		}
	public void setname(String name) {
		this.name=name;
	}
	
	public String getname() {
		return this.name;
	}
	
	public void eatrice(int bowl)  {
		try {
			Thread.sleep((int)(Math.random()*3001+500));
		System.out.println(this.name+"吃第"+bowl+"碗飯");
		}catch(Exception e) {
			System.out.println("時間程式執行不到");
		}
	}
	
	
}
					//多執行緒要繼承thread
class Line extends Thread{
	private Man man;
	public Line() {}
	public Line(Man man) {
		this.man=man;
	}
	@Override//overriderun
	public void run() {
		// TODO Auto-generated method stub
		
		for(int i=1; i<=10 ; i++)
			man.eatrice(i);
		System.out.println(man.getname()+"吃完了");
	}
	
}
//------------------------------以上為work01的class------------------
//-----------------------------以下為work02的class-------------------------


class Account{
	
	static int deposit =0;
	
	
	synchronized public void monsave(int money,Thread line) {
		//如果熊大那條直行緒結束這邊也不會在顯示東西
	
		
			//因為wait會停在當前位置如果用if判斷會少一次，用while
			while(this.deposit>3000){
				System.out.println("媽媽看到餘額在3000以上，暫停匯款");
				try {	
						wait();
						Thread.sleep(1000);//給他一點時間讓他確定另一條直行緒還在嘛
							if(!line.isAlive())//怕無窮迴圈家一個判斷式;
								break;
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
			}	//如果另一條直行緒存在才執行
			if(line.isAlive()) {
			deposit+=money;
			System.out.println("媽媽存了"+money+"，"+"帳戶共有"+deposit);
			notify();
			}
		
	
	}
	//synchonized不會同時做
	synchronized public void bear(int money,Thread line) {
		//跟存錢的一樣預防無窮迴圈和死結加入判斷式
			while(this.deposit==0) {
				System.out.println("熊大看到帳戶沒錢，暫停提款");
				try {
						wait(); 
						Thread.sleep(1000);
					if(!line.isAlive())
						break;
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			
			}
			if(line.isAlive()) {
				this.deposit-=money;
				System.out.println("熊大領了"+money+"，"+"帳戶共有:"+this.deposit);
				if(this.deposit<=1000)
					System.out.println("熊大看到帳戶餘額在1000元以下，要求匯款");
				notify();
			}
		
	}
	
}

//以上是帳戶金錢加減的類別--------------------------------------------------
//下面是執行緒創建
class Linewk1 extends Thread{
	Account account;
	int money;
	Thread line;
	public  Linewk1() {
		
	}
	public  Linewk1(Account account,int money) {
		this.account = account;
		this.money=money;
	}
	//得到另一條直行緒做判斷
	public void getline(Thread line) {
		this.line=line;
	}
	
	@Override
	
	public void run() {
		//如果另一條直行緒還在才執行
		for(int i=1 ; i<=10 ; i++) {
			if(line.isAlive()) 
			this.account.monsave(this.money,this.line);
		}
	}
}

class Linewk2 extends Thread{
	Account account;
	int money;
	Thread line;
	public  Linewk2() {
		
	}
	public  Linewk2(Account account,int money) {
		this.account = account;
		this.money=money;
	}
	//得到另一條直行緒做判斷
	public void getline(Thread line) {
		this.line=line;
	}
	
	@Override
	
	public void run() {
		//如果另一條直行緒還在才執行
		for(int i=1 ; i<=10 ; i++) {
			if(line.isAlive()) 
			this.account.bear(this.money,this.line);
		}
		
	}
}
	
	
//-----------------------------以上為work02的class-------------------------




public class Homework_09 {
	public static void main(String[] args) {
		work01();
		work02();
	}
	
	
//作業1------------------------------	
	 public static void work01() {
		 
		 Man breadman =  new Man("饅頭人");
			Man james =  new Man("詹姆士");
			
			Line line1 = new Line(breadman);
			Line line2 = new Line(james);
			
			line1.start();
			line2.start();
			System.out.println("---------大胃王快食比賽開始-----------");
			try {
			line1.join();
			line2.join();
			}catch(Exception e) {
				System.out.println("join錯誤");
			}
			System.out.println("---------大胃王快食比賽結束-----------");
		 
	 }
	 
	//作業2------------------------------		 
	 public static void work02() {
		 Account account = new Account();
		 	
		 Linewk1 mon =new Linewk1(account,3000); 
		 Linewk2 bear =new Linewk2(account,1000); 
		 
		 mon.getline(bear);
		 bear.getline(mon);
		 
		 mon.start();
		 bear.start();
		 
		 
		 
	 }
	
	
}
