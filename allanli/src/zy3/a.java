package zy3;
/*����һ��int�͵�һά���飬����10��Ԫ�أ��ֱ�һЩ���������Ȼ���������Ԫ��
    �����ֵ����Сֵ��ƽ��ֵ����ֵ�������������
*/
import java.util.Random;

public class a {
 public static void main(String[] args) {
	 int []b=new int[10];
	Random a=new Random();
	System.out.println("ʮ�������Ϊ:");
	for(int i=0;i<b.length;i++){
		int o=a.nextInt(10);
     	b[i]=o;	
     	System.out.print(b[i]+"\t");
	}
	// �����ƽ����
	double sum=0;
	System.out.println();
	System.out.println("ʮ��������ĺ�Ϊ:");
	for(int i=0;i<b.length;i++){
		sum+=b[i];
	}
	System.out.print(sum+"\t");
	
	double ave;
	ave=sum/10;
	System.out.println(ave);
	
	//����ֵ
	int max=b[0];
	for(int i=0;i<b.length;i++){
		if(b[i]>max){
			max=b[i];
		}
	}System.out.println("���ֵΪ:"+max);
	
	int min=b[0];
	for(int i=0;i<b.length;i++){
		if(b[i]<min){
			min=b[i];
		}
	}System.out.println("��СֵΪ"+min);
   }
 }
