package zy3;

/*
  ����һ��int�͵�һά���飬����10��Ԫ�أ��ֱ�ֵΪ1~10�� Ȼ�������е�Ԫ��
   ����ǰ��һ��λ�ã�����a[0]=a[1],a[1]=a[2],�����һ��Ԫ�ص�ֵ��ԭ����һ��Ԫ��
   ��ֵ��Ȼ�����������顣

*/
public class c {
public static void main(String[] args) {
	int[] a = new int[10];
	System.out.println("ʮ����:");
	for(int i=0;i<10;i++){
		a[i]=i+1;
		System.out.print(a[i]+"\t");
	}
	System.out.println();  //����
	System.out.println("���к��ʮλ��:");
	int temp=a[0];
	for(int i=0;i<9;i++){
		a[i]=a[i+1];
		System.out.print(a[i]+"\t");
	}
	a[9]=temp;
	System.out.println(a[9]);
	}
}

	
/*int[] a = new int[10];

for(int i=0;i<10;i++){
int j=(int)(Math.random()*10);
a[i]= j;
System.out.println(a[i]);
}
int temp = a[0];
for(int i=0;i<9;i++){

a[i]=a[i+1];
System.out.println("���к�λ�ã�"+a[i]);
}
a[9]=temp;
System.out.println("���к�λ�ã�"+a[9]);
*/

