package allanli;
import java.util.Scanner;
//日历
public class rili {
public static void main(String[] args) {
	Scanner t=new Scanner(System.in);
	System.out.println("请输入年份:");
	int year=t.nextInt();
	System.out.println("请输入月份:");
	int month=t.nextInt();
	int []monthDays={0,31,28,31,30,31,30,31,31,30,31,30,31};
    int	days=monthDays[month];
	if(month==2){
	if(year%400==0||year%4==0&&year%100!=0){
	days++;	
	}
	}
	
	//求从1900年到输入年的前一年的总天数
	int years=year-1900;
	int allDays=years*365;  //平年的天数
	for(int i=1900;i<year;i++){     
		if((i%4==0&&i%100!=0)||i%400==0){
			allDays++;   //如果是闰年，allDays+1；
		}
	}

	//求从指定年的一月到指定年指定月的前一天的总天数
	for(int i=1;i<month;i++){
		allDays+=monthDays[i];
		if(i==2){
		if(year%400==0||year%4==0&&year%100!=0){
		allDays++;
		}
		}
	}
   
	//求一号是星期几
	int week=(allDays+1)%7;
	System.out.println("========================"+year+"年"+month+"月"+"========================");
	System.out.println("星期日\t星期一\t星期二\t星期三\t星期四\t星期五\t星期六");
	//打印星期前的空格
	for(int j=0;j<week;j++){
		System.out.print("\t");
	}
	for(int i=1;i<=days;i++){
		//打印日期，后面带一个制表符
		System.out.print(i+"\t");
		//如果除以七余6就换行
		if(week%7==6){
			System.out.println();
		}week++;  //星期+1
	}
	}
}



