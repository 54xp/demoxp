package zy3;

import java.util.Random;

/*����һ��20*5�Ķ�ά���飬�����洢ĳ�༶20λѧԱ��5�ſεĳɼ�����5�ſ�
   ���洢˳������Ϊ��core C++��coreJava��Servlet��JSP��EJB��
   ��1��ѭ������ά�����ÿһ��Ԫ�ظ�0~100֮������������
   ��2�������б�ķ�ʽ�����ЩѧԱ��ÿ�ſγ̵ĳɼ���
   ��3��Ҫ���д������ÿ��ѧԱ���ܷ֣����䱣��������һ��һά�����С�
   ��4��Ҫ���д����������ѧԱ��ĳ�ſγ̵�ƽ���֡�
*/
public class f {
	public static void main(String[] args) {
		int[][] f = new int[20][5];
		int[] sum = new int[20];
		int[] total = new int[5];
		int i, j, k = 0;
		for (i = 0; i < sum.length; i++) {
			for (j = 0; j < total.length; j++) {
				f[i][j] = (int) (Math.random() * 100);
			}
		}
		// ���ѧ���ɼ�
		System.out.println("********ѧ���ɼ�********");
		System.out.println("       " + "core C++   coreJava   Servlet        JSP        EJB");
		for (i = 0; i < sum.length; i++) {
			System.out.print(i + "�� ");
			for (j = 0; j < total.length; j++) {
				System.out.print("       " + f[i][j] + "   "); // ������ݵļ��
			}
			System.out.println();
		}
		// ���ѧԱ�ܷ�
		for (i = 0; i < sum.length; i++) {
			for (j = 0; j < total.length; j++) {
				sum[i] += f[i][j];
			}
			System.out.println("��" + i + "��ѧ���ɼ��ܺ�Ϊ:" + sum[i]);
		}
		// ����ѧԱ��ĳ�ſγ̵�ƽ����
		System.out.println("core C++\tcoreJava\tServlet\t    JSP\t    EJB\t");
		for (j = 0; j < total.length; j++) {
			for (i = 0; i < sum.length; i++) {
				total[j] += f[i][j];
			}
			// System.out.println(total[j]);
			System.out.print(total[j] / 5 + "\t\t");

		}

	}
}
