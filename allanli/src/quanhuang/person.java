package quanhuang;

import java.util.Scanner;

public class person {
Scanner input=new Scanner(System.in);
public static int score=0;
public  int showSelect(){
	while(true){
	System.out.println("���ȭ:1.����  2.ʯͷ  3.��(�������Ӧ������:)");
	int num=input.nextInt();
	switch(num){
	case 1:
	    System.out.println("���ȭ:����");
	    return 1;
	case 2:
		System.out.println("���ȭ:ʯͷ");
		return 2;
	case 3:
		System.out.println("���ȭ:��");
		return 3;
	default:
			System.out.println("�����������������롣");
			continue;
	}
	}
	
}
	

}
