package zy3;

import java.util.Scanner;

/*�������������������,������֮���������ȫƽ��������ȫƽ������ָ������� 
ĳ��������ƽ�������� 16��25��36�ȶ�����ȫƽ������
*/
public class l {
public static void main(String[] args) {
	  Scanner l=new Scanner(System.in);
	  System.out.println("������A:");
	  int a=l.nextInt();
	  System.out.println("������B:");
	  int b=l.nextInt();
	  for(int i=a;i<b;i++){
		  for(int j=0;j<b;j++){
			  if(i==j*j){
				  System.out.println(i);
			  }
		  }
	  }
	  
}
}



