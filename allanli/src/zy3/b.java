package zy3;

import java.util.Random;
/*����һ��int�͵�һά���飬����40��Ԫ�أ������洢ÿ��ѧԱ�ĳɼ���ѭ������40��
*0~100֮�����������������Ǵ洢��һά�����У�Ȼ��ͳ�Ƴɼ�����ƽ���ֵ�ѧԱ��
�����������������*/

public class b {
public static void main(String[] args) {
	int sum=0 ;
	int[] a=new int[40];
	Random b=new Random();
	for(int i=0;i<a.length;i++){
		a[i]=b.nextInt(100);
		System.out.print(a[i]+"\t");
		if((i+1)%10==0){
			System.out.println();
		}
	}
	System.out.println(); //���� 
	for(int i=0;i<a.length;i++){
		sum+=a[i];
	}
	int ave=0;
	ave=sum/40;
	System.out.print("ƽ����Ϊ:");
	System.out.println(ave);
	int t=0;
	for(int i=0;i<a.length;i++){
		if(a[i]<ave){
			t++;
			}
		}
	System.out.println("����ƽ����������:"+t);	
	
	int count=0;
	System.out.println("����ƽ����:");
	for(int i=0;i<a.length;i++){
		if(a[i]<ave){
			System.out.print(a[i]+"\t");
			count++;
			if(count%5==0){
				System.out.println();
			}
			}
		}
	}
}	

	

