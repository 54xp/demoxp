package zy3;

public class qiuzhishu {
public static void main(String[] args) {
	int a;
    for (int i = 1; i < 1000; i++) {
      for (a = 2; a <= (int)i/2; a++) {
        if (i % a == 0) {
          break;
        }

      }
      if (a > (int)i/2 ) {
        System.out.println(i);
      }
    }
}
}
