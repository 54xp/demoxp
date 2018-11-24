package allanli;

import java.util.Random;

public class GroupBuilder {	
		/**
		 * ����Ʒ�����ʵ��������
		 * 	Ҫ��	1��ÿ�������ɲ��� num �趨
		 * 			2��ÿ�������ֻ����һ��Ů��
		 * 			3������ÿ������֮�󣬽���Ա��ӡ��������ʽ���£�
		 * 				��1�ӣ�������ѧ�ԡ�������
		 * 				��2�ӣ��ŷɡ��������Ѿ�
		 * 				....�Դ�����....
		 * @param students ѧ������
		 * @param num ÿ�ӵ�����
		 */
	
	//���峣��
	 	public static final boolean Ů��=true;
	 	public static final boolean ����=false;
	 	
		    public static void printGroup(Student[] students,int num) {
			//��������
			int groupCount =students.length/num;
			groupCount+=students.length%num>0?1:0;
			//�������� һ����ά����
			Student[][]groups=new Student[groupCount][num];
			//��������Ԫ��
			randomGroup(students);
			grouping(students,groups,Ů��);
			grouping(students,groups,����);
			printGroups(groups);
		    }
			//��������Ԫ�صķ���
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
						//��ǰҪ�����С���±�
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
					System.out.print("��"+(i++)+"��");
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
					new Student("������",true),
					new Student("������",true),
					new Student("����"),
					new Student("�׾�"),
					new Student("����ΰ"),
					new Student("������"),
					new Student("������"),
					new Student("����Ե",true),
					new Student("�����",true),
					new Student("���ǻ�",true),
					new Student("����"),
					new Student("������"),
					new Student("���λ�"),
					new Student("�����"),
					new Student("�ܹ���"),
					new Student("¦��"),
					new Student("���ܺ�"),
					new Student("��־��"),
					new Student("���ȳ�"),
					new Student("�ƺ�",true),
					new Student("������"),
					new Student("����",true),
					new Student("������",true),
					new Student("�ƴ���"),
					new Student("����",true),
					new Student("����"),
					new Student("������"),
					new Student("�³�"),
					new Student("���콭")
			};
			printGroup(students,3);
		}

	}

	/**
	 * ѧ����
	 */
	class Student {
		private String name;
		private boolean sex; // false �У�true Ů
		
		/**
		 * ���췽���������Ա��Ĭ���Ա�Ϊ��
		 * @param name
		 */
		public Student(String name) {
			this.name = name;
		}
		
		/**
		 * ���췽������
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


