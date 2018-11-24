package zy3;

import java.util.Random;

public class zhipai {
	public static void main(String[] args) {
		int []cards=new int[52];
		int playerNum=4;
		int [][]players=new int[playerNum][cards.length/playerNum];
		for(int i=0;i<cards.length;i++){
			cards[i]=i;
		}
		show(cards);
		
		//洗牌
		Random a=new Random();
		for(int i=0;i<cards.length;i++){
			int index=a.nextInt(52);
			int temp=cards[i];
			cards[i]=cards[index];
			cards[index]=temp;
		}
		System.out.println("================================发牌==========================================");
		show(cards);
		
		//发牌 ，发到玩家手里的牌
		System.out.println("================================发牌==========================================");
		int cardIndex=0;
		for(int i=0;i<playerNum;i++){
			for(int j=0;j<players[i].length;j++){
				players[i][j]=cards[cardIndex];
				cardIndex++;
			}
		}
		//打印玩家手里的牌
				System.out.println("打印玩家手里的牌:");
				for(int i=0;i<players.length;i++){
					System.out.print("玩家"+i+"号手里的牌:");
					show(players[i]);
				}
				
		//对玩家手里的牌进行排序
		System.out.println("=====================整理牌==========================");	
		for(int i=0;i<players.length;i++){
			for(int j=0;j<players[i].length;j++){
				for(int k=j+1;k<players[i].length;k++){
					if(players[i][j]>players[i][k]){
						int t=players[i][j];
						players[i][j]=players[i][k];
						players[i][k]=t;
					}
				}
			}
		}
		System.out.println("======================按顺序打印玩家手中的牌=================");
		for(int i=0;i<players.length;i++){
			System.out.println("玩家"+i+"的牌:");
			show(players[i]);
		}
	}

	public static void show(int []cards){
		String []number={"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		String []flowers={"黑桃","红桃","梅花","方块"};
		for(int i=0;i<cards.length;i++){
			int a=cards[i]%13;
			int b=cards[i]/13;
			System.out.print(flowers[b]+number[a]+"\t");
			if((i+1)%13==0){
				System.out.println();
			}
		}
		
	}
}
