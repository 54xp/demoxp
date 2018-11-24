package zy3;
/*求所有满足如下条件的四位数：
千位上的数字大于百位数字，百位数字大于十位数字，十位数字大于个位数字，并
且千位数字是其他三位数字的和。
*/
public class k {
public static void main(String[] args) {
	int qian=0,bai=0,shi=0,ge=0;
	for(int i=1000;i<9999;i++){
		qian=i/1000;
	    bai=i%1000/100;
		shi=i%100/10;
		ge=i%10;
		if(qian>bai&&bai>shi&&shi>ge&&(qian==bai+shi+ge)){
			System.out.print(i+"\t");
		}
	}
	}	
}

