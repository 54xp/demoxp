package zy3;

/*
  定义一个int型的一维数组，包含10个元素，分别赋值为1~10， 然后将数组中的元素
   都向前移一个位置，即，a[0]=a[1],a[1]=a[2],…最后一个元素的值是原来第一个元素
   的值，然后输出这个数组。

*/
public class c {
public static void main(String[] args) {
	int[] a = new int[10];
	System.out.println("十个数:");
	for(int i=0;i<10;i++){
		a[i]=i+1;
		System.out.print(a[i]+"\t");
	}
	System.out.println();  //换行
	System.out.println("排列后的十位数:");
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
System.out.println("排列后位置："+a[i]);
}
a[9]=temp;
System.out.println("排列后位置："+a[9]);
*/

