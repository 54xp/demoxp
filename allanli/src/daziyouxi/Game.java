package daziyouxi;

import java.util.Random;

/*String printStr()
 ����ַ����������ַ������ں��������Ƚϡ�
void printResult(String out,String in)
�Ƚ���Ϸ���out���������in�����ݱȽϽ�������Ӧ��Ϣ
*/
public class Game {
	 public Player player;
	    

	    public Player getPlayer() {
	        return player;
	    }

	    public void setPlayer(Player player) {
	        this.player = player;
	    }

	    public Game(Player player) {
	        this.player = player;
	    }
	    public Game(){
	        
	    }
	public String printStr(Player p){
		StringBuffer buffer = new StringBuffer();
		Random random = new Random();
		// 1��ͨ��ѭ������Ҫ������ַ���
		LevelParam l=new LevelParam();
		for (int i = 0; i <l.levels[p.getLevelNo()-1].getStrLength() ; i++) {
			// 1.1�����������
			int rand = random.nextInt(l.levels[p.getLevelNo()-1].getStrLength());
			// 1.2�����������ƴ���ַ���
			switch (rand) {
			case 0:
				buffer.append("*");
				break;
			case 1:
				buffer.append("&");
				break;
			case 2:
				buffer.append("@");
				break;
			case 3:
				buffer.append("#");
				break;
			case 4:
				buffer.append("%");
				break;
			case 5:
				buffer.append("$");
				break;
			case 6:
				buffer.append("^");
				break;
			}
		}
		String str=buffer.toString();
		System.out.println(str);
		return str;	
	}
	public void printResult(String out,String in){
		
	}
	
}
