package quanhuang;

import java.util.Scanner;

public class computer {
Scanner s=new Scanner(System.in);
public static int scorce;
public int showSelect(){
	int num=(int)(Math.random()*3+1);
	switch(num){
	case 1:
		System.out.println("���Գ�ȭ:����");
		return 1;
	case 2:
		System.out.println("���Գ�ȭ:ʯͷ");
		return 2;
	case 3:
		System.out.println("���Գ�ȭ:��");
		return 3;
		default:
			System.out.println("��������");
			return 0;
	}
}
}
