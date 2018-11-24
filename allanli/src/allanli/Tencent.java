package allanli;

import java.util.Random;
public class Tencent {
	private String name;
	private String password;
	private QQ[]qqs=new QQ[0];

	//构造方法
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
		System.out.println("新用户创建成功"+qq);
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
		System.out.println("登录qq账户:"+id);
		for(int i=0;i<qqs.length;i++){
			if(qqs[i].getId().equals(id)&&qqs[i].getPassword().equals(password)){
			return qqs[i];
			}
		}
		System.out.println("QQ号码或者密码错误!");
		return null;
	}
}
class QQ{
	private String id;
	private String name;
	private String password;
	private QQ[] friends=new QQ[0];

	
	//构造方法
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

	//添加好友
	public void addFreiends(QQ friend){
		System.out.println(this+"添加QQ好友:"+friend);
		if(friend==null){
			System.out.println("不能添加不存在的人为好友");
			return;
		}
		if(this.id==friend.id){
			System.out.println("不能添加自己为好友");
			return;
		}
		for(QQ qq:friends){
			if(qq==friend){
				System.out.println("你们已经是好友了");
				return;
			}
		}
		QQ[]newFriends=new QQ[friends.length+1];
		System.arraycopy(friends, 0, newFriends, 0, friends.length);
		friends=newFriends;
		friends[friends.length-1]=friend;
		friend.addFreiends(this);
		System.out.println("你们已经是好友了");
	}
	public void sendMsg(QQ friend,String msg){
		if(friend.id.equals(this.id)){
			System.out.println("不能给自己发信息");
			return;
		}
		for(int i=0;i<friends.length;i++){
			if(friends[i].id!=null&&friends[i].getId().equals(friend.id)){
				System.out.println(this.name+"对"+friend.name+"说:"+msg);
			}else{
				System.out.println("你们不是好友");
			}
		}
	}

	@Override
	public String toString() {
		return name+id;
	}

	
}