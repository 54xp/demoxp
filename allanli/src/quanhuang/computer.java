package quanhuang;

import java.util.Scanner;

public class computer {
Scanner s=new Scanner(System.in);
public static int scorce;
public int showSelect(){
	int num=(int)(Math.random()*3+1);
	switch(num){
	case 1:
		System.out.println("电脑出拳:剪刀");
		return 1;
	case 2:
		System.out.println("电脑出拳:石头");
		return 2;
	case 3:
		System.out.println("电脑出拳:布");
		return 3;
		default:
			System.out.println("输入有误");
			return 0;
	}
}
}
