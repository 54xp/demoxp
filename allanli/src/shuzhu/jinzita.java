package shuzhu;
//����Ļ�����һ��n�еĽ�����ͼ�������磬��n=5,��ͼ�����£� 
import java.util.Scanner;

public class jinzita {
	public static void main(String[] args) {
	  Scanner input=new Scanner(System.in);
      System.out.println("������һ��ֵ:");
      int n=input.nextInt();
      for(int i=1;i<=n;i++){
          for(int j=1;j<=n-i;j++){
             System.out.print(" ");
          }
          for(int z=1;z<=(i*2)-1;z++){
             System.out.print("*");
          }
          System.out.println();
      }
}
}