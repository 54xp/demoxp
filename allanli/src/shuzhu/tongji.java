package shuzhu;
import java.util.Random;
import java.util.Scanner;

/*��ά������⣺
1������һ��������200*300�Ķ�ά���飨200��300�У���
2����������ÿ��Ԫ�������ֵ�����ֵ�Ƿ�Χ�ǣ�100~200
3����ͳ�������ά�����У����ֵ�ÿ����ֵ�ĳ��ֵĸ�����
Ҫ����ʾ�����
123��3��
152��2��
165��8��
196��7��
*/
public class tongji {
public static void main(String[] args) {
	int [][]a=new int[200][300];
	int []hang=new int[200];
	int []lie=new int [300];
	Random b=new Random();
	for(int i=0;i<hang.length;i++){
		for(int j=0;j<lie.length;j++){
			a[i][j]=b.nextInt(101)+100;  //100-200֮��������
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
	
	//���Ҫͳ�Ƶ�ĳ�����ֳ��ֵĴ���
	Scanner c=new Scanner(System.in);
	System.out.println("������Ҫͳ�Ƶ���ֵ:");
	int k=0;
	int o=c.nextInt();
	for(int i=0;i<hang.length;i++)
		for(int j=0;j<lie.length;j++){
			if(a[i][j]==o){
				k++;
			}
		}System.out.println(o+"���ֵĴ���:"+k);	
}
}
