package allanli;

import java.util.Random;



public class Bank {
	
		//��������
	private String name;
	//���п���ǰ��λ�����̶��ģ�
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
		System.out.println(this.name+"������!!!");
	}
	/*���������˻�
	 * name �˻�����
	 * money ��ʼ���
	 * return ���ؿ���0
	 */
	public String creatAccount(String name,double money){
		String id=createId();
		for(int i=0;i<accounts.length;i++){
			if(accounts[i]==null){
				accounts[i]=new Account(id,name,money);
				System.out.println("�����˻��ɹ�:"+accounts[i]);
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
	//ע�������˻�
	public void closeAccount(String id){
		for(int i=0;i<accounts.length;i++){
			if(accounts[i]!=null&&accounts[i].getId().equals(id)){
				accounts[i]=null;
				System.out.println("ע���ɹ�"+id);
				return;
			}
		}
		System.out.println("û���ҵ��ÿ���:"+id);
	}
	//���
	public void deposit(String id ,double money){
		System.out.println("�򿨺�"+id+"����"+money+"Ԫ");
		for(int i=0;i<accounts.length;i++){
			if(accounts[i]!=null&&accounts[i].getId().equals(id)){
				money+=accounts[i].getMoney();
				accounts[i].setMoney(money);
				System.out.println("���ҵ��ɹ�:"+accounts[i]);
				return;
			}
		}
		System.out.println("���ҵ��ʧ��:û�иÿ���:"+id);
	}
	//ȡ��
	public void withdraw(String id,double money){
		System.out.println("�򿨺�"+id+"ȡ��"+money+"Ԫ");
		for(int i=0;i<accounts.length;i++){
			if(accounts[i]!=null&&accounts[i].getId().equals(id)){
				if(accounts[i].getMoney()>=money){
					money=accounts[i].getMoney()-money;
					accounts[i].setMoney(money);
					System.out.println("ȡ��ҵ�����ɹ�"+accounts[i]);
				}else{
					System.out.println("����");
				}return;
			}
		}
		System.out.println("����ȡ��ҵ��ʧ��"+id);
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
		return "����:"+id+",����:"+name+",���"+money;
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
