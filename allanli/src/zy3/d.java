package zy3;

import java.util.Arrays;

/*��д���򣬽�һ�������е�Ԫ�ص��Ź���������ԭ����Ϊ1��2��3��4��5��
    ���ź������е�ֵΪ5��4��3��2��1��
*/
public class d {
public static void main(String[] args) {
	int []d=new int[5];
	System.out.println("�����Ϊ:");
	for(int i=0;i<d.length;i++){
		d[i]=i+1;
		System.out.print(d[i]+"\t");
	}
	System.out.println();  //����
	System.out.println("ѡ������:");
	for(int i=0;i<d.length-1;i++){
		for(int j=i+1;j<d.length;j++)
			if(d[i]<d[j]){
				int t=d[i];
				d[i]=d[j];
				d[j]=t;
			}
	}for(int k:d){
		System.out.print(k+"\t");
	}
	}
}


