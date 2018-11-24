package allanli;

public class BankTest {
public static void main(String[] args) {
	Bank a=new Bank("½¨ÐÐ","4396");
	String id=a.creatAccount("Â··É",154465);
	a.deposit(id, 5000);
	a.withdraw(id, 3000);
	a.withdraw(id, 3000);
	a.withdraw(id, 1116000);
}
}
