package zy3;

abstract class Figure
{
protected abstract double area();
}
public class Circle extends Figure{
private double radius;
public Circle(double r){
	radius=r;
	}
	public double area(){
		return radius*radius*Math.PI;
	}
	public static void main(String[] args){
		Figure f=new Circle(2.5);
		System.out.println(""+f.area());
		}
}

class zhengfx extends Figure {
	private double radius;
	public zhengfx(double r){
		radius=r;
		}
	protected double area() {
		return radius*radius;
	}	
}
