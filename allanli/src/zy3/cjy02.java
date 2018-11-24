package zy3;
//将二进制数转为十进制数
import java.util.Scanner;

public class cjy02 {
	/*public static void main(String args[]){
		String s = "1010";
		int x = 0;
		for(char c: s.toCharArray())
		x = x * 2 + (c == '1' ? 1 : 0);
		System.out.println(x);
		}*/
	
	
	/*public static void main(String[] args) {
		System.out.println("请输入二进制数:");
		Scanner t = new Scanner(System.in);
		//自动装箱
		Integer i = t.nextInt();
		String st = i.toString();
		int x = 0;
		char [] chars = st.toCharArray();
		for(int i1 =0;i1<chars.length;i1++){
			x= x *2 +(chars[i1] == '1' ? 1 : 0);
		}
		
		System.out.println("转成的十进制数为:"+x);
	}*/
	
	
	/*public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("请输入二进制数");
		Integer c = s.nextInt();
		String d = c+"";
		System.out.println(Integer.valueOf(d,2).toString());
	}
	*/
}
