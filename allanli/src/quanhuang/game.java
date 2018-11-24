package quanhuang;

import java.util.ArrayList;
import java.util.Scanner;

public class game {
Scanner sui=new Scanner(System.in);
person f1=new person();
computer f2=new computer();
//记录比赛次数
int count=0;
int win_count=0;
int lose_count=0;
int peace_count=0;
ArrayList<Integer>list1=new ArrayList<Integer>();
ArrayList<Integer>list2=new ArrayList<Integer>();
public String show(){
	System.out.println("猜拳游戏");
	System.out.println("*****************"+"游戏开始"+"*****************");
	while(true){
	System.out.println("请选择角色:(1.喜羊羊2.灰太狼 3.象伯伯):");	
	int num=sui.nextInt();
	switch(num){
	case 1:
		System.out.println("你选择的是喜羊羊");
		return "喜羊羊";
	case 2:
		System.out.println("你选择的是灰太狼");
		return "灰太狼";
	case 3:
		System.out.println("你选择的是象伯伯");
		return "象伯伯";
		default:
			System.out.println("没有选人");
			continue;
	  }
	}
}
public void start(String s){
	System.out.println("输入y开始:");
	while(true){
		String answer=sui.next();
		if(answer.equals("y")){
			int ps=f1.showSelect();
			int cs=f2.showSelect();
			if((ps == 1&&cs == 1)||(ps == 2&&cs ==2)||(ps == 3&&cs==3)){
				System.out.println("和局\n");
				peace_count++;
			}else if((ps==1&&cs==2)||(ps==2&&cs==3)||(ps==3&&cs==1)){
				System.out.println("你输了\n");
				lose_count++;
			}else {
				System.out.println("你赢了\n");
				win_count++;
			}
			list1.add(ps);//添加到记录人的数组中
			list2.add(cs);//添加到记录电脑的数组中
			count++;
			System.out.println("是否开始下一轮?(y/n)");
		}else{
			System.out.println("\n你选的是"+s+"你共战局数:"+count);
			System.out.println("你共得:"+person.score+"分");
			System.out.println("电脑共得:"+computer.scorce+"分");
			System.out.println("你赢了"+win_count+"分");
			System.out.println("你输了"+lose_count+"分");
			System.out.println("和局"+peace_count+"分");
		}
	}
}


}
