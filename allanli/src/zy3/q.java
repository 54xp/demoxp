package zy3;
/*쳲���������ǰn��ĺ�ֵ,쳲������������£� 
       1��1��2��3��5��8��13��21����
*/
public class q {
public static void main(String[] args) {
	  int num1 = 1, num2 = 1;
      int num = num1 + num2;
      System.out.print("  " + num1 + "  " + num2 + "  " + num);
      for (int i = 3; i < 20; i++) {
          int num3 = num + num2;
          num2 = num;
          num = num3;
          System.out.print("  " + num3);
      }
}
}
