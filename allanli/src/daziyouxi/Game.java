package daziyouxi;

import java.util.Random;

/*String printStr()
 输出字符串，返回字符串用于和玩家输入比较。
void printResult(String out,String in)
比较游戏输出out和玩家输入in，根据比较结果输出相应信息
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
		// 1、通过循环生成要输出的字符串
		LevelParam l=new LevelParam();
		for (int i = 0; i <l.levels[p.getLevelNo()-1].getStrLength() ; i++) {
			// 1.1、产生随机数
			int rand = random.nextInt(l.levels[p.getLevelNo()-1].getStrLength());
			// 1.2、根据随机数拼接字符串
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
