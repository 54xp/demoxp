package shuzhu;

import java.util.Scanner;

public class scanner {
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	String names="张三，李四，王五";
	while(true){
		System.out.println("请输入姓名");
		String name=s.next();
		if(names.indexOf(name)==-1){
			names+=","+name;
		}else{
			System.out.println(name+"已经存在了！");
		}
	}
}
}
