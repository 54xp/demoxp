package allanli;
import java.util.Random;

//�˿�����Ϸ
public class zhipai {
public static void main(String[] args) {
	int []cards=new int [52];
	int playerNum=4;
	int [][]players=new int[playerNum][cards.length/playerNum];
	for(int i=0;i<cards.length;i++){
		cards[i]=i;
	}
	//���ô�ӡ�˿˷���
	show(cards);
	
	//ϴ��:ѭ��==>ȡ����ǰ��==>�������
	Random r=new Random();
	for(int i=0;i<cards.length;i++){
		int index=r.nextInt(52);
		int temp=cards[i];
		cards[i]=cards[index];
		cards[index]=temp;
	}
	System.out.println("=====================ϴ��====================");
	show(cards);
	
	//����
	System.out.println("=====================����====================");
	//����ҷ���
	int cardsIndex=0;
	for(int i=0;i<players.length;i++){
		for(int j=0;j<players[i].length;j++){
			players[i][j]=cards[cardsIndex];
			cardsIndex++;
		}
	}
	
	//��ӡ����������
	System.out.println("��ӡ����������:");
	for(int i=0;i<players.length;i++){
		System.out.print("���"+(i+1)+"���������:");
		show(players[i]);
	}
	
	//�����������ƽ�������
	System.out.println("=====================������==========================");
	for(int i=0;i<players.length;i++){
		for(int j=0;j<players[i].length;j++){
			for(int k=j+1;k<players[i].length;k++){
				if(players[i][j]>players[i][k]){
					int t=players[i][k];
					players[i][k]=players[i][j];
					players[i][j]=t;
				}
			}
		}
	}
	System.out.println("======================��˳���ӡ������е���=================");
	for(int i=0;i<players.length;i++){
		System.out.println("���"+(i+1)+"����:");
		show(players[i]);
	}
}
	//��ӡ�˿���
	public static void show(int[] cards){
		String[]number={"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		String[]flower={"����","����","÷��","����"};
		for(int i=0;i<cards.length;i++){
			int a=cards[i]%13;
			int b=cards[i]/13;
			System.out.print(flower[b]+number[a]+"\t");
			if((i+1)%13==0){
				System.out.println();
			}
		} 
	}
	
	
}


