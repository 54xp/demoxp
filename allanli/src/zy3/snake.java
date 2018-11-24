package zy3;
//未完成
import java.util.Random;
import java.util.Scanner;

class Point { // 定义基础点类
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

class Food extends Point { // 定义食物类并且继承点类
	Random r = new Random();

	// 创建食物数组
	public void getPoint() // 创建食物的坐标（随机）的方法
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

class Border { // 定义边框类
	int bound; // 定义界面数组
	String border[][];

	public void CreatBorder() { // 给姐界面数组的边框赋值
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

	public void transValueBody(Body b) { // 给食物和蛇身的坐标点赋值赋值对应的符号

		
		for (int i = 1; i < b.len; i++) {
			border[b.bsBody[0].x][b.bsBody[0].y] = "  S";
			border[b.bsBody[i].x][b.bsBody[i].y] = "  #";			
		}
	}

	public void transValueFood(Food a) {
		border[a.GetX()][a.GetY()] = "  @";
	}

	public void show() { // 显示游戏界面，打印界面数组的内容
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
	Food food = new Food(); // 建造食物对象
	Border border1 = new Border();
	Body body = new Body(); // 建造蛇身对象
	boolean isLife = true; // 用于结束游戏的变量，如果isLife=false那么游戏结束
	// 创建临时存放蛇身的变量
	

	public void Move(String direction) {// 蛇移动的方法		
		System.out.println("w:上           " + "s:下         " + "a:左         " + "d:右         ");
		System.out.println();		
		
		if (direction.equals("w")) { // 如果输入w则蛇头的X坐标不变，Y增加1并且后面的数组坐标等于前面一个点的坐标值
			//System.arraycopy(vBody, 0, vBody, 1, vBody.length-1);
			for(int i=body.len;i>1;i--) {
				body.bsBody[i-1].x=body.bsBody[i-2].x;
				body.bsBody[i-1].y=body.bsBody[i-2].y;
			}
			body.bsBody[0].x = body.bsBody[0].x - 1;
			/*if (vBody[0].equals(vBody[1])) {
				return;
			}*/
			if (body.bsBody[0].x == 0) { // 如果蛇头坐标等于边界坐标则游戏结束
				isLife = false;
				return;
			}

			if (eat(body.bsBody[0], food)) { // 蛇头没有撞到边界，判断蛇头坐标是否等于食物坐标如果是则蛇身长度加1并且再创建一个食物
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

	public boolean eat(Body body, Food food) { // 判断是否吃到了食物
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
		// 定义运行方法

		food.getPoint();
		body.getbsBody();
		border1.CreatBorder();
		border1.transValueBody(body);
		border1.transValueFood(food);
		border1.show();
		while (isLife) {
			System.out.println("请输入方向：");
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
