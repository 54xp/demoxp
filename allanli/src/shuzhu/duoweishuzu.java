package shuzhu;

import java.util.Random;

public class duoweishuzu {
public static void main(String[] args) {
	int[][]arr1=new int[5][3];
	Random r=new Random();
	for(int i=0;i<5;i++){
		for(int j=0;j<3;j++){
			arr1[i][j]=r.nextInt(6);
		}
	}
	for(int i=0;i<5;i++){
		for(int j=0;j<3;j++){
			System.out.println(arr1[i][j]+"\t");
		}
		System.out.println();
	}
}
}
