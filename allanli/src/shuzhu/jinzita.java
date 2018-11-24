package shuzhu;
//在屏幕上输出一个n行的金字塔图案，例如，若n=5,则图案如下： 
import java.util.Scanner;

public class jinzita {
	public static void main(String[] args) {
	  Scanner input=new Scanner(System.in);
      System.out.println("请输入一个值:");
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