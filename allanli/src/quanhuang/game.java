package quanhuang;

import java.util.ArrayList;
import java.util.Scanner;

public class game {
Scanner sui=new Scanner(System.in);
person f1=new person();
computer f2=new computer();
//��¼��������
int count=0;
int win_count=0;
int lose_count=0;
int peace_count=0;
ArrayList<Integer>list1=new ArrayList<Integer>();
ArrayList<Integer>list2=new ArrayList<Integer>();
public String show(){
	System.out.println("��ȭ��Ϸ");
	System.out.println("*****************"+"��Ϸ��ʼ"+"*****************");
	while(true){
	System.out.println("��ѡ���ɫ:(1.ϲ����2.��̫�� 3.�󲮲�):");	
	int num=sui.nextInt();
	switch(num){
	case 1:
		System.out.println("��ѡ�����ϲ����");
		return "ϲ����";
	case 2:
		System.out.println("��ѡ����ǻ�̫��");
		return "��̫��";
	case 3:
		System.out.println("��ѡ������󲮲�");
		return "�󲮲�";
		default:
			System.out.println("û��ѡ��");
			continue;
	  }
	}
}
public void start(String s){
	System.out.println("����y��ʼ:");
	while(true){
		String answer=sui.next();
		if(answer.equals("y")){
			int ps=f1.showSelect();
			int cs=f2.showSelect();
			if((ps == 1&&cs == 1)||(ps == 2&&cs ==2)||(ps == 3&&cs==3)){
				System.out.println("�;�\n");
				peace_count++;
			}else if((ps==1&&cs==2)||(ps==2&&cs==3)||(ps==3&&cs==1)){
				System.out.println("������\n");
				lose_count++;
			}else {
				System.out.println("��Ӯ��\n");
				win_count++;
			}
			list1.add(ps);//��ӵ���¼�˵�������
			list2.add(cs);//��ӵ���¼���Ե�������
			count++;
			System.out.println("�Ƿ�ʼ��һ��?(y/n)");
		}else{
			System.out.println("\n��ѡ����"+s+"�㹲ս����:"+count);
			System.out.println("�㹲��:"+person.score+"��");
			System.out.println("���Թ���:"+computer.scorce+"��");
			System.out.println("��Ӯ��"+win_count+"��");
			System.out.println("������"+lose_count+"��");
			System.out.println("�;�"+peace_count+"��");
		}
	}
}


}
