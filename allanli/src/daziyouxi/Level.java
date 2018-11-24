package daziyouxi;

import java.util.Random;

/*各级别号（levelNo）
各级别一次输出字符串的长度（strLength）
各级别输出字符串的次数（strTime）
各级别闯关的时间限制（timeLimit）
各级别正确输入一次的得分（perScore）
*/
public class Level {
	private int levelNo;
	private int strLength;
	private int strTime;
	private int timeLimit;
	private int perScore;

	
	
	public int getLevelNo() {
		return levelNo;
	}
	public int getStrLength() {
		// TODO Auto-generated method stub
		return 0;
	}


	


	public Level(int levelNo, int strLength, int strTime, int timeLimit, int perScore) {
		this.levelNo = levelNo;
		this.strLength = strLength;
		this.strTime = strTime;
		this.timeLimit = timeLimit;
		this.perScore = perScore;
	}



	



	


}


