package allanli;

public class Poem {
	public  static  void printHeng(){
	 String []a={"床前明月光","疑是地上霜","举头望明月","低头思故乡"};
	for(int i=0;i<a.length;i++){
		System.out.println(a[i]);
	}
}
	public static void printHeng(String poem){
		String []s=poem.split("");
		for(int i=0;i<s.length;i++){
			System.out.print(s[i]);
			if(i%5==0){
				System.out.println();
			}
		}	
	}
	public static void printHeng(char[] poem){
		for(int i=0;i<poem.length;i++){
			System.out.print(poem[i]);
			if((i+1)%5==0){
				System.out.println();
			}
		}
	}
	public static void printShu(String[] poem){
		for(int i=0;i<poem[0].length();i++){
			for(int j=0;j<poem.length;j++){
				System.out.print(poem[j].substring(i, i+1));
			}System.out.println();
		}
	}
	public static void printShu(String poem){
		int length=poem.length()/4;
		for(int i=0;i<length;i++){
			for(int j=0;j<4;j++){
				int begin=j*length+i;
				System.out.print(poem.substring(begin,begin+1));
			}System.out.println();
		}  
	}
	public static void printShu(char[] poem){
		String o="";
		for(char p:poem){
			o+=p;
		}
		printShu(o);
	}
	public static void main(String[] args) {
		System.out.println("========第一次========");
		printHeng();
		System.out.println("=========第二次=======");
		printHeng("床前明月光疑是地上霜举头望明月低头思故乡");
		System.out.println("========第三次========");
		char[]b={'床','前','明','月','光','疑','是','地','上','霜','举','头','望','明','月','低','头','思','故','乡'};
		printHeng(b);
		System.out.println("========第四次========");
		String []a={"床前明月光","疑是地上霜","举头望明月","低头思故乡"};
		printShu(a);
		System.out.println("========第五次========");
		printShu("床前明月光疑是地上霜举头望明月低头思故乡");
		System.out.println("========第六次========");
		char[]ch={'床','前','明','月','光','疑','是','地','上','霜','举','头','望','明','月','低','头','思','故','乡'};
		printShu(ch);
	}
}
