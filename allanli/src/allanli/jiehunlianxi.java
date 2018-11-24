package allanli;

import java.util.Random;

public class jiehunlianxi {
	public static void main(String[] args) {
		jiehun f1=new jiehun("小芬",1,25);
		jiehun f2=new jiehun("张三",0,25);
		f1.marry(f2);
	jiehun[]people= {
		new jiehun("貂蝉",0,28),
		new jiehun("西施",0,28),
		new jiehun("郑旦",0,18),
		new jiehun("王昭君",0,38),
		new jiehun("小芬",0,18),
		new jiehun("林冲",1,38),
		new jiehun("关羽",1,38),
		new jiehun("张飞",1,38),
		new jiehun("鲁达",1,38),
		new jiehun("燕青",1,38),
	};
	Random a=new Random();
		for(int i=0;i<10;i++){
			jiehun p1=people[a.nextInt(people.length)];
			jiehun p2=people[a.nextInt(people.length)];
			p1.marry(p2);
			System.out.println();
		}

}
}