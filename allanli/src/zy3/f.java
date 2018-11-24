package zy3;

import java.util.Random;

/*定义一个20*5的二维数组，用来存储某班级20位学员的5门课的成绩；这5门课
   按存储顺序依次为：core C++，coreJava，Servlet，JSP和EJB。
   （1）循环给二维数组的每一个元素赋0~100之间的随机整数。
   （2）按照列表的方式输出这些学员的每门课程的成绩。
   （3）要求编写程序求每个学员的总分，将其保留在另外一个一维数组中。
   （4）要求编写程序求所有学员的某门课程的平均分。
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
		// 输出学生成绩
		System.out.println("********学生成绩********");
		System.out.println("       " + "core C++   coreJava   Servlet        JSP        EJB");
		for (i = 0; i < sum.length; i++) {
			System.out.print(i + "号 ");
			for (j = 0; j < total.length; j++) {
				System.out.print("       " + f[i][j] + "   "); // 输出数据的间距
			}
			System.out.println();
		}
		// 输出学员总分
		for (i = 0; i < sum.length; i++) {
			for (j = 0; j < total.length; j++) {
				sum[i] += f[i][j];
			}
			System.out.println("第" + i + "号学生成绩总和为:" + sum[i]);
		}
		// 所有学员的某门课程的平均分
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
