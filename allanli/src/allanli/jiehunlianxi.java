package allanli;

import java.util.Random;

public class jiehunlianxi {
	public static void main(String[] args) {
		jiehun f1=new jiehun("С��",1,25);
		jiehun f2=new jiehun("����",0,25);
		f1.marry(f2);
	jiehun[]people= {
		new jiehun("����",0,28),
		new jiehun("��ʩ",0,28),
		new jiehun("֣��",0,18),
		new jiehun("���Ѿ�",0,38),
		new jiehun("С��",0,18),
		new jiehun("�ֳ�",1,38),
		new jiehun("����",1,38),
		new jiehun("�ŷ�",1,38),
		new jiehun("³��",1,38),
		new jiehun("����",1,38),
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