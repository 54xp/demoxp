package allanli;

import java.util.Random;



public class Bank {
	
		//银行名称
	private String name;
	//银行卡的前四位数（固定的）
	private String prefix;
	private Account[] accounts=new Account[1000];
	private double money;
	public String newAccount(String name,double money){
		return null;
	} 
	public Bank(String name, String prefix) {
		super();
		this.name = name;
		this.prefix = prefix;
		System.out.println(this.name+"成立了!!!");
	}
	/*创建银行账户
	 * name 账户姓名
	 * money 初始金额
	 * return 返回卡号0
	 */
	public String creatAccount(String name,double money){
		String id=createId();
		for(int i=0;i<accounts.length;i++){
			if(accounts[i]==null){
				accounts[i]=new Account(id,name,money);
				System.out.println("创建账户成功:"+accounts[i]);
				break;
			}
		}
		return id;
	}
	private String createId() {
		String id="";
		Random r=new Random();
		for(int i=0;i<12;i++){
			id+=r.nextInt(10);
		}
		return prefix+id;
	}
	//注销银行账户
	public void closeAccount(String id){
		for(int i=0;i<accounts.length;i++){
			if(accounts[i]!=null&&accounts[i].getId().equals(id)){
				accounts[i]=null;
				System.out.println("注销成功"+id);
				return;
			}
		}
		System.out.println("没有找到该卡号:"+id);
	}
	//存款
	public void deposit(String id ,double money){
		System.out.println("向卡号"+id+"存入"+money+"元");
		for(int i=0;i<accounts.length;i++){
			if(accounts[i]!=null&&accounts[i].getId().equals(id)){
				money+=accounts[i].getMoney();
				accounts[i].setMoney(money);
				System.out.println("存款业务成功:"+accounts[i]);
				return;
			}
		}
		System.out.println("存款业务失败:没有该卡号:"+id);
	}
	//取款
	public void withdraw(String id,double money){
		System.out.println("向卡号"+id+"取出"+money+"元");
		for(int i=0;i<accounts.length;i++){
			if(accounts[i]!=null&&accounts[i].getId().equals(id)){
				if(accounts[i].getMoney()>=money){
					money=accounts[i].getMoney()-money;
					accounts[i].setMoney(money);
					System.out.println("取款业务办理成功"+accounts[i]);
				}else{
					System.out.println("余额不足");
				}return;
			}
		}
		System.out.println("办理取款业务失败"+id);
	}
}


class Account {
	 private String name;
	 private String id;
	 private double money;
	public Account(String id,  String name, double money) {
		super();
		this.id=id;
		this.name = name;
		this.money = money;
	}
	public String toString(){
		return "卡号:"+id+",姓名:"+name+",余额"+money;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}

	}
