package shuzhu;
import java.util.Random;
import java.util.Scanner;

/*二维数组的题：
1、定义一个整数型200*300的二维数组（200行300列），
2、请给数组的每个元素随机赋值，随机值是范围是：100~200
3、请统计这个二维数组中，出现的每个数值的出现的个数。
要求显示结果：
123：3个
152：2个
165：8个
196：7个
*/
public class tongji {
public static void main(String[] args) {
	int [][]a=new int[200][300];
	int []hang=new int[200];
	int []lie=new int [300];
	Random b=new Random();
	for(int i=0;i<hang.length;i++){
		for(int j=0;j<lie.length;j++){
			a[i][j]=b.nextInt(101)+100;  //100-200之间的随机数
		}
		}
	for(int i=0;i<hang.length;i++){
		for(int j=0;j<lie.length;j++){
			System.out.print(a[i][j]+"\t");
			if((j+1)%300==0){
				System.out.println();
			}
		}
		}
	
	//输出要统计的某个数字出现的次数
	Scanner c=new Scanner(System.in);
	System.out.println("请输入要统计的数值:");
	int k=0;
	int o=c.nextInt();
	for(int i=0;i<hang.length;i++)
		for(int j=0;j<lie.length;j++){
			if(a[i][j]==o){
				k++;
			}
		}System.out.println(o+"出现的次数:"+k);	
}
}
