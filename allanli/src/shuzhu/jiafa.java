package shuzhu;

//1000���ڵ�����֮��
public class jiafa {
public static void main(String[] args) {
	int a=0;
	for(int i=2;i<1000;i++){
		int b=0;
		for(int j=i;j>0;j--){
			if(i%j==0){
				b++;
			}
		}
		if(b==2){
			a=a+i;
		}
	}
	System.out.println("1000���ڵ�������:"+a);
}
}
