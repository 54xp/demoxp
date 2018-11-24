package zy3;
//δ���
import java.util.Random;
import java.util.Scanner;

class Point { // �����������
	int x;
	int y;

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int GetX() {
		return x;
	}

	public int GetY() {
		return y;
	}

}

class Food extends Point { // ����ʳ���ಢ�Ҽ̳е���
	Random r = new Random();

	// ����ʳ������
	public void getPoint() // ����ʳ������꣨������ķ���
	{
		setX(r.nextInt(9) + 1);
		setY(r.nextInt(9) + 1);
	}
}

class Body extends Point {
	Body bsBody[] = new Body[8];
	Random r = new Random();
	int len=3;
	public void getbsBody() {
		int X, Y;
		for (int i = 0; i < 8; i++) {
			bsBody[i] = new Body();
		}
		for(int i=len;i<bsBody.length;i++) {
			bsBody[i].x=0;
			bsBody[i].y=0;
		}
		X = r.nextInt(8) + 1;
		Y = r.nextInt(6) + 1;
		bsBody[0].x = X;
		bsBody[0].y = Y;

		bsBody[1].x = X;
		bsBody[1].y = (Y + 1);
		bsBody[2].x = (X);
		bsBody[2].y = (Y + 2);
		

	}
	/*
	 * public int getBsIX(int i) { return bsBody[i].GetX(); } public int getBsIY(int
	 * i) { return bsBody[i].GetX(); }
	 */
}

class Border { // ����߿���
	int bound; // �����������
	String border[][];

	public void CreatBorder() { // �����������ı߿�ֵ
		// this.bound=bound;
		border = new String[11][11];
		for (int i = 0; i < border.length; i++)
			for (int j = 0; j < border.length; j++) {
				border[i][j] = "   ";
			}
		for (int i = 0; i < 11; i++) {
			border[0][i] = "  -";
			border[i][0] = " |";
			border[10][i] = "  -";
			border[i][10] = "| ";
		}		
	}
	public void clearBorder(Food a,Body [] b) {
		border = new String[11][11];
		for (int i = 0; i < border.length; i++)
			for (int j = 0; j < border.length; j++) {
				border[i][j] = "   ";
			}
		
		border[a.GetX()][a.GetY()] = "  @";
		border[b[0].x][b[0].y] = "  S";
		for (int i = 1; i < b.length; i++) {
			border[b[i].x][b[i].y] = "  #";			
		}
		for (int i = 0; i < 11; i++) {
			border[0][i] = "  -";
			border[i][0] = " |";
			border[10][i] = "  -";
			border[i][10] = "| ";
		}
	}	

	public void transValueBody(Body b) { // ��ʳ������������㸳ֵ��ֵ��Ӧ�ķ���

		
		for (int i = 1; i < b.len; i++) {
			border[b.bsBody[0].x][b.bsBody[0].y] = "  S";
			border[b.bsBody[i].x][b.bsBody[i].y] = "  #";			
		}
	}

	public void transValueFood(Food a) {
		border[a.GetX()][a.GetY()] = "  @";
	}

	public void show() { // ��ʾ��Ϸ���棬��ӡ�������������
		for (int i = 0; i < border.length; i++) {
			System.out.println();
			for (int j = 0; j < border.length; j++) {
				System.out.print(border[i][j]);

			}                                                                                                                      
		}
	}
}

class Control {

	Scanner s = new Scanner(System.in);
	Food food = new Food(); // ����ʳ�����
	Border border1 = new Border();
	Body body = new Body(); // �����������
	boolean isLife = true; // ���ڽ�����Ϸ�ı��������isLife=false��ô��Ϸ����
	// ������ʱ�������ı���
	

	public void Move(String direction) {// ���ƶ��ķ���		
		System.out.println("w:��           " + "s:��         " + "a:��         " + "d:��         ");
		System.out.println();		
		
		if (direction.equals("w")) { // �������w����ͷ��X���겻�䣬Y����1���Һ���������������ǰ��һ���������ֵ
			//System.arraycopy(vBody, 0, vBody, 1, vBody.length-1);
			for(int i=body.len;i>1;i--) {
				body.bsBody[i-1].x=body.bsBody[i-2].x;
				body.bsBody[i-1].y=body.bsBody[i-2].y;
			}
			body.bsBody[0].x = body.bsBody[0].x - 1;
			/*if (vBody[0].equals(vBody[1])) {
				return;
			}*/
			if (body.bsBody[0].x == 0) { // �����ͷ������ڱ߽���������Ϸ����
				isLife = false;
				return;
			}

			if (eat(body.bsBody[0], food)) { // ��ͷû��ײ���߽磬�ж���ͷ�����Ƿ����ʳ������������������ȼ�1�����ٴ���һ��ʳ��
				/*Body tepBody[] = new Body[body.bsBody.length];
				System.arraycopy(body.bsBody, 0, tepBody, 1, body.len-1);
				for(int i=0;i<tepBody.length;i++) {
					tepBody[i]=
				}*/
				for(int i=body.len;i>0;i--){
					body.bsBody[i].x=body.bsBody[i-1].x;
					body.bsBody[i].y=body.bsBody[i-1].y;
				}
				body.bsBody[0].x = food.x;
				body.bsBody[0].y = food.y;
				body.len++;
				
				food.getPoint();
				border1.transValueFood(food);
				border1.transValueBody(body);
				border1.show();
				return;
			}
			
			//border1.clearBorder(food,body.bsBody);
			border1.clearBorder(food,body.bsBody);
			
			border1.transValueBody(body);
			border1.show();
			return;
		}

		if (direction.equals("a")) {
			for(int i=body.len;i>1;i--) {
				body.bsBody[i-1].x=body.bsBody[i-2].x;
				body.bsBody[i-1].y=body.bsBody[i-2].y;
			}
			body.bsBody[0].y = body.bsBody[0].y - 1;
		
			
		/*	if (vBody[0].equals(vBody[1])) {
				return;
			}*/
			if (body.bsBody[0].y == 0) {
				isLife = false;
				return;
			}

			if (eat(body.bsBody[0], food)) {
				/*System.arraycopy(body.bsBody, 0, body.bsBody, 1,body.len-1);
				body.bsBody[0].x = food.x;
				body.bsBody[0].y = food.y;
				for(int i=body.bsBody.length;i>0;i--){
					body.bsBody[i].x=body.bsBody[i-1].x;
					body.bsBody[i].y=body.bsBody[i-1].y;
				}
				body.bsBody[0].x = food.x;
				body.bsBody[0].y = food.y;
				body.len++;
			
				food.getPoint();
				body.bsBody = body.bsBody;
				border1.transValueBody(body);
				border1.transValueFood(food);
				border1.show();
				return;*/
				for(int i=body.len;i>0;i--){
					body.bsBody[i].x=body.bsBody[i-1].x;
					body.bsBody[i].y=body.bsBody[i-1].y;
				}
				body.bsBody[0].x = food.x;
				body.bsBody[0].y = food.y;
				body.len++;
				
				food.getPoint();
				border1.transValueFood(food);
				border1.transValueBody(body);
				border1.show();
				return;
			}

			border1.clearBorder(food,body.bsBody);
			border1.transValueBody(body);
			border1.show();
			return;
		}

		if (direction.equals("s")) {					
			for(int i=body.len;i>1;i--) {
				body.bsBody[i-1].x=body.bsBody[i-2].x;
				body.bsBody[i-1].y=body.bsBody[i-2].y;
			}
			body.bsBody[0].x = body.bsBody[0].x + 1;
			/*if (vBody[0].equals(vBody[1])) {	
				return;
			}*/
			if (body.bsBody[0].x == 10) {
				isLife = false;
				return;
			}

			if (eat(body.bsBody[0], food)) {
				/*System.arraycopy(body.bsBody, 0, body.bsBody, 1,body.len-1);
				body.bsBody[0].x = food.x;
				body.bsBody[0].y = food.y;
				for(int i=body.bsBody.length;i>0;i--){
					body.bsBody[i].x=body.bsBody[i-1].x;
					body.bsBody[i].y=body.bsBody[i-1].y;
				}
				body.bsBody[0].x = food.x;
				body.bsBody[0].y = food.y;
				body.len++;
				food.getPoint();
				border1.transValueBody(body);
				border1.transValueFood(food);
				border1.show();
				return;*/
				for(int i=body.len;i>0;i--){
					body.bsBody[i].x=body.bsBody[i-1].x;
					body.bsBody[i].y=body.bsBody[i-1].y;
				}
				body.bsBody[0].x = food.x;
				body.bsBody[0].y = food.y;
				body.len++;
				
				food.getPoint();
				border1.transValueFood(food);
				border1.transValueBody(body);
				border1.show();
				return;
			}
			border1.clearBorder(food,body.bsBody);
			border1.transValueBody(body);
			border1.show();
			return;

		}
		if (direction.equals("d")) {
			
			for(int i=body.len;i>1;i--) {
				body.bsBody[i-1].x=body.bsBody[i-2].x;
				body.bsBody[i-1].y=body.bsBody[i-2].y;
			}
			body.bsBody[0].y = body.bsBody[0].y + 1;
		/*	if (vBody[0].equals(vBody[1])) {
				return;
			}*/
			if (body.bsBody[0].y == 10) {
				isLife = false;
				return;
			}

			if (eat(body.bsBody[0], food)) {
				/*System.arraycopy(body.bsBody, 0, body.bsBody, 1,body.len);
				
				body.bsBody[0].x = food.x;
				body.bsBody[0].y = food.y;
				
				//body.bsBody = tepBody;
				for(int i=body.bsBody.length;i>0;i--){
					body.bsBody[i].x=body.bsBody[i-1].x;
					body.bsBody[i].y=body.bsBody[i-1].y;
				}
				body.bsBody[0].x = food.x;
				body.bsBody[0].y = food.y;
				body.len++;
				food.getPoint();
				border1.transValueBody(body);
				border1.transValueFood(food);
				border1.show();
				return;*/
				for(int i=body.len;i>0;i--){
					body.bsBody[i].x=body.bsBody[i-1].x;
					body.bsBody[i].y=body.bsBody[i-1].y;
				}
				body.bsBody[0].x = food.x;
				body.bsBody[0].y = food.y;
				body.len++;
				
				food.getPoint();
				border1.transValueFood(food);
				border1.transValueBody(body);
				border1.show();
				return;
			}
			border1.clearBorder(food,body.bsBody);
			border1.transValueBody(body);
			border1.show();
			return;
		}

	}

	/*
	 * food.getPoint(); body.getbsBody(); border1.CreatBorder();
	 * border1.transValue(food, body); border1.show();
	 */

	public boolean eat(Body body, Food food) { // �ж��Ƿ�Ե���ʳ��
		return body.x==food.x&&body.y==food.y;
		/*
		int x1 = food.GetX();
		int y1 = food.GetY();
		int x2 = body.GetX();
		int y2 = body.GetY();

		if (x1 == x2 && y1 == y2) {
			return true;
		}

		return false;
		*/
	}

	public void run() {
		// �������з���

		food.getPoint();
		body.getbsBody();
		border1.CreatBorder();
		border1.transValueBody(body);
		border1.transValueFood(food);
		border1.show();
		while (isLife) {
			System.out.println("�����뷽��");
			String dir = s.next();
			Move(dir);
		}
			System.out.println("GAME OVER!");
	}

}

public class snake {
	public static void main(String[] args) {
		Control c = new Control();
		c.run();
	}
}
