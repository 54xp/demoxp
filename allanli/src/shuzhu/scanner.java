package shuzhu;

import java.util.Scanner;

public class scanner {
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	String names="���������ģ�����";
	while(true){
		System.out.println("����������");
		String name=s.next();
		if(names.indexOf(name)==-1){
			names+=","+name;
		}else{
			System.out.println(name+"�Ѿ������ˣ�");
		}
	}
}
}
