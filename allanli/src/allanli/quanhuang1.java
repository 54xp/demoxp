package allanli;

import java.util.Random;

public class quanhuang1 {
//名字
	private String name;
	//力量
	private int power;
	//生命值
	private int hp;
	
	//构造方法
	public quanhuang1(String name, int power, int hp) {
		super();
		this.name = name;
		this.power = power;
		this.hp = hp;
	}
	
	
	public void fight(quanhuang1 target){
		if(target==null){
			System.out.println("你让我打谁？");
			return;
		}
		if(target==this){
			System.out.println("你让我打自己？");
			return;
		}
		if(target.hp<0){
			System.out.println("凉凉");
			return;
		}
		//对方的生命=对方的生命-我的力量
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
