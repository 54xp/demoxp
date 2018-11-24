package allanli;

import java.util.Random;

public class quanghuangTest1 {
public static void main(String[] args) {
	quanhuang1  f1=new quanhuang1 ("张飞",111,2480);
	quanhuang1 f2=new quanhuang1 ("小芬",120,2500);
	Random b=new Random();
	while(f1.getHp()>0&&f2.getHp()>0){
		if(b.nextInt(2)==1){
			f1.fight(f2);
		}else{
			f2.fight(f1);
		}
	}
	if(f1.getHp()>0){
		System.out.println(f1.getName()+"胜利");
	}else{
		System.out.println(f2.getName()+"胜利");
	}
}
}
