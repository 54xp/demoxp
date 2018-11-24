package allanli;

import java.util.Random;

public class GroupBuilder {	
		/**
		 * 请设计方法，实现随机组队
		 * 	要求：	1、每队人数由参数 num 设定
		 * 			2、每队中最多只能有一名女生
		 * 			3、生成每队人数之后，将队员打印出来，格式如下：
		 * 				第1队，董超、学霸、扈三娘
		 * 				第2队，张飞、关羽、王昭君
		 * 				....以此类推....
		 * @param students 学生数组
		 * @param num 每队的人数
		 */
	
	//定义常量
	 	public static final boolean 女生=true;
	 	public static final boolean 男生=false;
	 	
		    public static void printGroup(Student[] students,int num) {
			//计算组数
			int groupCount =students.length/num;
			groupCount+=students.length%num>0?1:0;
			//创建分组 一个二维数组
			Student[][]groups=new Student[groupCount][num];
			//打乱数组元素
			randomGroup(students);
			grouping(students,groups,女生);
			grouping(students,groups,男生);
			printGroups(groups);
		    }
			//打乱数组元素的方法
			public static void randomGroup(Student[] students){
				Random r=new Random();
				for(int i=0;i<students.length;i++){
				int	index=r.nextInt(students.length);
				Student temp=students[i];
				students[i]=students[index];
				students[index]=temp;
				}
			}
			
			private static void grouping(Student[] students,Student[][]groups,boolean girl){
				for(int i=0,j=0;i<students.length;i++){
					if(students[i].isSex()==girl){
						//当前要分配的小组下标
						g:while(true){
							int groupIndex=j%groups.length;
							j++;
							Student[]group=groups[groupIndex];
							for(int k=0;k<group.length;k++){
								if(group[k]==null){
									group[k]=students[i];
									break g;
								}
							}						
						}
					}
				}
			}
			
			private static void printGroups(Student[][]groups){
				int i=1;
				for(Student[] group:groups){
					System.out.print("第"+(i++)+"组");
					int j=0;
					for(Student stu:group){
						if(stu!=null){
							System.out.print((j++==0?":":",")+stu);
						}
					}
					System.out.println();
				}
			}
		
		
		
		
		public static void main(String[] args) {
			Student[] students = {
					new Student("董雅婷",true),
					new Student("覃金兰",true),
					new Student("熊鹏"),
					new Student("易军"),
					new Student("刘先伟"),
					new Student("苏晓峰"),
					new Student("刘忠洋"),
					new Student("周梦缘",true),
					new Student("曹梦楠",true),
					new Student("胡亚辉",true),
					new Student("吕球"),
					new Student("罗世鑫"),
					new Student("杨鑫虎"),
					new Student("吴军航"),
					new Student("周光勇"),
					new Student("娄宇"),
					new Student("申哲浩"),
					new Student("赵志彬"),
					new Student("王钊驰"),
					new Student("黄宏",true),
					new Student("冯滔滔"),
					new Student("许江红",true),
					new Student("贺银香",true),
					new Student("黄大林"),
					new Student("杨茜",true),
					new Student("申明"),
					new Student("王菅物"),
					new Student("陈成"),
					new Student("龙红江")
			};
			printGroup(students,3);
		}

	}

	/**
	 * 学生类
	 */
	class Student {
		private String name;
		private boolean sex; // false 男，true 女
		
		/**
		 * 构造方法，不带性别的默认性别为男
		 * @param name
		 */
		public Student(String name) {
			this.name = name;
		}
		
		/**
		 * 构造方法重载
		 * @param name
		 * @param sex
		 */
		public Student(String name, boolean sex) {
			this.name = name;
			this.sex = sex;
		}
		
		public String getName() {
			return name;
		}
		public boolean isSex() {
			return sex;
		}

		@Override
		public String toString() {
			return name;
		}
		
	}


