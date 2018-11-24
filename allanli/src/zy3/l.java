package zy3;

import java.util.Scanner;

/*给定两个任意的正整数,求它们之间的所有完全平方数，完全平方数是指这个数是 
某个整数的平方，例如 16，25，36等都是完全平方数。
*/
public class l {
public static void main(String[] args) {
	  Scanner l=new Scanner(System.in);
	  System.out.println("请输入A:");
	  int a=l.nextInt();
	  System.out.println("请输入B:");
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



