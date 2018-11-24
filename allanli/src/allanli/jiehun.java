package allanli;

public class jiehun {
private String name;
private int sex;
private int age;
//配偶
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
		System.out.println(this.name+"还没到法定年龄，不能结婚");
		return;
	}
	if(spouse==null){
		System.out.println("我和谁结婚？");
	    return;
	}
	if(spouse.canMarry()==false){
		System.out.println(spouse.name+"还没法定年龄，不能结婚");
		return;
	}
	if(this.spouse!=null){
		System.out.println(this.name+"重婚");
		return;
	}
	if(spouse.spouse!=null){
		System.out.println(this.name+"重婚");
		return;
	}
	if(spouse.sex==this.sex){
		System.out.println(this.name+spouse.name+"不支持同性恋");
		return;
	}
	this.spouse=spouse;
	System.out.println("祝福"+this.name+"和"+spouse.name+"百年好合");
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
