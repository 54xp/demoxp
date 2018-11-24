package zy3;
//编写程序输出1-100之间的所有素数
public class o {
public static void main(String[] args) {
		for(int i=2;i<=100;i++){
			for(int k=2;k<=i;k++){
				if(i%k==0&&i!=k){
					break;
				}else if(i%k==0&&i==k){
					System.out.println(i);
				}
			}
		
	}
}
}
