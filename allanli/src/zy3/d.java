package zy3;

import java.util.Arrays;

/*编写程序，将一个数组中的元素倒排过来。例如原数组为1，2，3，4，5；
    则倒排后数组中的值为5，4，3，2，1。
*/
public class d {
public static void main(String[] args) {
	int []d=new int[5];
	System.out.println("五个数为:");
	for(int i=0;i<d.length;i++){
		d[i]=i+1;
		System.out.print(d[i]+"\t");
	}
	System.out.println();  //换行
	System.out.println("选择排序:");
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


