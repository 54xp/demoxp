package allanli;

import java.util.Random;
public class Tencent {
	private String name;
	private String password;
	private QQ[]qqs=new QQ[0];

	//���췽��
	public Tencent(String name, String password, QQ[] qqs) {
		this.name = name;
		this.password = password;
		this.qqs = qqs;
	}
	public String register(String name,String password){
		String id=createID();
		QQ qq=new QQ(id,name,password);
		QQ []newQqs=new QQ[qqs.length+1];
		System.arraycopy(qqs, 0, newQqs, 0, qqs.length);
		qqs=newQqs;
		qqs[qqs.length-1]=qq;
		System.out.println("���û������ɹ�"+qq);
		return null;
		}
	private String createID() {
		String id="";
		Random r=new Random();
		for(int i=0;i<10;i++){
			id+=r.nextInt(10);
		}
		return id;
	}
	public QQ login(String id,String password){
		System.out.println("��¼qq�˻�:"+id);
		for(int i=0;i<qqs.length;i++){
			if(qqs[i].getId().equals(id)&&qqs[i].getPassword().equals(password)){
			return qqs[i];
			}
		}
		System.out.println("QQ��������������!");
		return null;
	}
}
class QQ{
	private String id;
	private String name;
	private String password;
	private QQ[] friends=new QQ[0];

	
	//���췽��
	public QQ(String id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public QQ[] getFriends() {
		return friends;
	}

	//��Ӻ���
	public void addFreiends(QQ friend){
		System.out.println(this+"���QQ����:"+friend);
		if(friend==null){
			System.out.println("������Ӳ����ڵ���Ϊ����");
			return;
		}
		if(this.id==friend.id){
			System.out.println("��������Լ�Ϊ����");
			return;
		}
		for(QQ qq:friends){
			if(qq==friend){
				System.out.println("�����Ѿ��Ǻ�����");
				return;
			}
		}
		QQ[]newFriends=new QQ[friends.length+1];
		System.arraycopy(friends, 0, newFriends, 0, friends.length);
		friends=newFriends;
		friends[friends.length-1]=friend;
		friend.addFreiends(this);
		System.out.println("�����Ѿ��Ǻ�����");
	}
	public void sendMsg(QQ friend,String msg){
		if(friend.id.equals(this.id)){
			System.out.println("���ܸ��Լ�����Ϣ");
			return;
		}
		for(int i=0;i<friends.length;i++){
			if(friends[i].id!=null&&friends[i].getId().equals(friend.id)){
				System.out.println(this.name+"��"+friend.name+"˵:"+msg);
			}else{
				System.out.println("���ǲ��Ǻ���");
			}
		}
	}

	@Override
	public String toString() {
		return name+id;
	}

	
}