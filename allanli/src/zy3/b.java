package zy3;

import java.util.Random;
/*定义一个int型的一维数组，包含40个元素，用来存储每个学员的成绩，循环产生40个
*0~100之间的随机整数，将它们存储到一维数组中，然后统计成绩低于平均分的学员的
人数，并输出出来。*/

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
	System.out.println(); //换行 
	for(int i=0;i<a.length;i++){
		sum+=a[i];
	}
	int ave=0;
	ave=sum/40;
	System.out.print("平均数为:");
	System.out.println(ave);
	int t=0;
	for(int i=0;i<a.length;i++){
		if(a[i]<ave){
			t++;
			}
		}
	System.out.println("低于平均数的人数:"+t);	
	
	int count=0;
	System.out.println("低于平均分:");
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

	

