package shuzhu;

public class shuzufuzhi {
public static void main(String[] args) {
	char[]c1={'a','b','c','d','e'};
	//�߼�����
	char []c2=new char[5];
	System.arraycopy(c1, 2, c2, 1, 3);;
	for(char c:c2){
		System.out.println(c);
	}
	//���ø���  ���Ƶ�ַ
	char[]c3=c1;
	for(char c:c3){
		System.out.print(c);
	}
	//��¡���� �������ݣ�����һ���µ�ַ
	char[]c4=c1.clone();
	for(char c:c4){
		System.out.println();
		System.out.println(c);
	}
}
}
