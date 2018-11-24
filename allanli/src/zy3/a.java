package zy3;
/*定义一个int型的一维数组，包含10个元素，分别赋一些随机整数，然后求出所有元素
    的最大值，最小值，平均值，和值，并输出出来。
*/
import java.util.Random;

public class a {
 public static void main(String[] args) {
	 int []b=new int[10];
	Random a=new Random();
	System.out.println("十个随机数为:");
	for(int i=0;i<b.length;i++){
		int o=a.nextInt(10);
     	b[i]=o;	
     	System.out.print(b[i]+"\t");
	}
	// 求和与平均数
	double sum=0;
	System.out.println();
	System.out.println("十个随机数的和为:");
	for(int i=0;i<b.length;i++){
		sum+=b[i];
	}
	System.out.print(sum+"\t");
	
	double ave;
	ave=sum/10;
	System.out.println(ave);
	
	//求最值
	int max=b[0];
	for(int i=0;i<b.length;i++){
		if(b[i]>max){
			max=b[i];
		}
	}System.out.println("最大值为:"+max);
	
	int min=b[0];
	for(int i=0;i<b.length;i++){
		if(b[i]<min){
			min=b[i];
		}
	}System.out.println("最小值为"+min);
   }
 }
