package allanli;
public class TecentTest {
public static void main(String[] args) {
	QQ p1=new QQ("92730965", "С��", "123");
	QQ p2=new QQ("2519782504","С��","321");
	p1.addFreiends(p2);
	p1.sendMsg(p2, "С��");
}
}
