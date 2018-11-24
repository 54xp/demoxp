package quanhuang;

import java.util.Scanner;

public class person {
Scanner input=new Scanner(System.in);
public static int score=0;
public  int showSelect(){
	while(true){
	System.out.println("你出拳:1.剪刀  2.石头  3.布(请输入对应的数字:)");
	int num=input.nextInt();
	switch(num){
	case 1:
	    System.out.println("你出拳:剪刀");
	    return 1;
	case 2:
		System.out.println("你出拳:石头");
		return 2;
	case 3:
		System.out.println("你出拳:布");
		return 3;
	default:
			System.out.println("输入有误，请重新输入。");
			continue;
	}
	}
	
}
	

}
