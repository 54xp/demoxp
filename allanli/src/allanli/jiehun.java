package allanli;

public class jiehun {
private String name;
private int sex;
private int age;
//��ż
private jiehun spouse;
public boolean canMarry(){
	if(sex==0&&age>20||sex==1&&age>22){
		return true;
	}else{
		return false;
	}
}
public void marry(jiehun spouse){
	if(this.canMarry()==false){
		System.out.println(this.name+"��û���������䣬���ܽ��");
		return;
	}
	if(spouse==null){
		System.out.println("�Һ�˭��飿");
	    return;
	}
	if(spouse.canMarry()==false){
		System.out.println(spouse.name+"��û�������䣬���ܽ��");
		return;
	}
	if(this.spouse!=null){
		System.out.println(this.name+"�ػ�");
		return;
	}
	if(spouse.spouse!=null){
		System.out.println(this.name+"�ػ�");
		return;
	}
	if(spouse.sex==this.sex){
		System.out.println(this.name+spouse.name+"��֧��ͬ����");
		return;
	}
	this.spouse=spouse;
	System.out.println("ף��"+this.name+"��"+spouse.name+"����ú�");
}

public jiehun(String name, int sex, int age) {
	super();
	this.name = name;
	this.sex = sex;
	this.age = age;
	this.spouse = spouse;
}
public String getName() {
	return name;
}
public int getSex() {
	return sex;
}
public int getAge() {
	return age;
}

}
