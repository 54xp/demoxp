package allanli;

import java.util.Random;

public class quanhuang1 {
//����
	private String name;
	//����
	private int power;
	//����ֵ
	private int hp;
	
	//���췽��
	public quanhuang1(String name, int power, int hp) {
		super();
		this.name = name;
		this.power = power;
		this.hp = hp;
	}
	
	
	public void fight(quanhuang1 target){
		if(target==null){
			System.out.println("�����Ҵ�˭��");
			return;
		}
		if(target==this){
			System.out.println("�����Ҵ��Լ���");
			return;
		}
		if(target.hp<0){
			System.out.println("����");
			return;
		}
		//�Է�������=�Է�������-�ҵ�����
		Random a=new Random();
		target.hp-=this.power;
		if(target.hp<=0){
			System.out.println(target.name+"Game over");
		}
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public String getName() {
		return name;
	}

	public int getPower() {
		return power;
	}
	

	
	
}
