package allanli;

public class Poem {
	public  static  void printHeng(){
	 String []a={"��ǰ���¹�","���ǵ���˪","��ͷ������","��ͷ˼����"};
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
		System.out.println("========��һ��========");
		printHeng();
		System.out.println("=========�ڶ���=======");
		printHeng("��ǰ���¹����ǵ���˪��ͷ�����µ�ͷ˼����");
		System.out.println("========������========");
		char[]b={'��','ǰ','��','��','��','��','��','��','��','˪','��','ͷ','��','��','��','��','ͷ','˼','��','��'};
		printHeng(b);
		System.out.println("========���Ĵ�========");
		String []a={"��ǰ���¹�","���ǵ���˪","��ͷ������","��ͷ˼����"};
		printShu(a);
		System.out.println("========�����========");
		printShu("��ǰ���¹����ǵ���˪��ͷ�����µ�ͷ˼����");
		System.out.println("========������========");
		char[]ch={'��','ǰ','��','��','��','��','��','��','��','˪','��','ͷ','��','��','��','��','ͷ','˼','��','��'};
		printShu(ch);
	}
}
