package allanli;
import java.util.Scanner;
//����
public class rili {
public static void main(String[] args) {
	Scanner t=new Scanner(System.in);
	System.out.println("���������:");
	int year=t.nextInt();
	System.out.println("�������·�:");
	int month=t.nextInt();
	int []monthDays={0,31,28,31,30,31,30,31,31,30,31,30,31};
    int	days=monthDays[month];
	if(month==2){
	if(year%400==0||year%4==0&&year%100!=0){
	days++;	
	}
	}
	
	//���1900�굽�������ǰһ���������
	int years=year-1900;
	int allDays=years*365;  //ƽ�������
	for(int i=1900;i<year;i++){     
		if((i%4==0&&i%100!=0)||i%400==0){
			allDays++;   //��������꣬allDays+1��
		}
	}

	//���ָ�����һ�µ�ָ����ָ���µ�ǰһ���������
	for(int i=1;i<month;i++){
		allDays+=monthDays[i];
		if(i==2){
		if(year%400==0||year%4==0&&year%100!=0){
		allDays++;
		}
		}
	}
   
	//��һ�������ڼ�
	int week=(allDays+1)%7;
	System.out.println("========================"+year+"��"+month+"��"+"========================");
	System.out.println("������\t����һ\t���ڶ�\t������\t������\t������\t������");
	//��ӡ����ǰ�Ŀո�
	for(int j=0;j<week;j++){
		System.out.print("\t");
	}
	for(int i=1;i<=days;i++){
		//��ӡ���ڣ������һ���Ʊ��
		System.out.print(i+"\t");
		//�����������6�ͻ���
		if(week%7==6){
			System.out.println();
		}week++;  //����+1
	}
	}
}



