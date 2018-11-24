package zy3;
/*编写程序求下列多项式的前50项的和：
   1-1/3+1/5-1/7+1/9-…… 
*/
public class m{
	public static void main(String[] args) {
		double x=1;
		double  y=1;
		double sum=0;
		int count=1;
		for(int i=1;i<=2;i++){
			if(count%2==0){
				sum-=x/y;
			}else{
				sum+=x/y;
			}
			y+=2;
			count++;
		}System.out.println(sum);
	}
}









