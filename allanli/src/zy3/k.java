package zy3;
/*����������������������λ����
ǧλ�ϵ����ִ��ڰ�λ���֣���λ���ִ���ʮλ���֣�ʮλ���ִ��ڸ�λ���֣���
��ǧλ������������λ���ֵĺ͡�
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

